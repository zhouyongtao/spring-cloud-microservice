package com.spring.cloud.microsrvoauth2server.config;

import java.security.KeyPair;
import java.util.Arrays;

import com.spring.cloud.microsrvoauth2server.service.UserService;
import com.spring.cloud.microsrvoauth2server.service.impl.UserDetailsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import javax.sql.DataSource;

/*
spring.security.oauth2.client.authorization-uri=/oauth/authorize
spring.security.oauth2.client.token-uri=/oauth/token

/oauth/authorize
/oauth/token
/oauth/check_token
/oauth/confirm_access
/oauth/error
/oauth/token_key
*/
@Configuration
@EnableAuthorizationServer
//@Order(2)
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //RSA配置
    @Value("${config.oauth2.privateKey}")
    private String privateKey;
    @Value("${config.oauth2.publicKey}")
    private String publicKey;

    //认证管理器
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

/*
   // redis 连接工厂
    @Autowired
    private RedisConnectionFactory connectionFactory;

    @Bean
    public RedisTokenStore tokenStore() {
        return new RedisTokenStore(connectionFactory);
    }
 */

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

//    @Bean(name = "dataSource")
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource dataSource() {
//        return DataSourceBuilder.create().build();
//    }

    /**
     * 令牌存储
     *
     * @return Jdbc 令牌存储对象
     */
    @Bean("jdbcTokenStore")
    public JdbcTokenStore jdbcTokenStore() {
        return new JdbcTokenStore(dataSource);
    }


    /**
     * 自定义用户信息
     * @return
     */
    @Bean
    public UserDetailsService userDetailsService(){
        return new UserDetailsServiceImpl();
    }

    @Bean
    public TokenEnhancer tokenEnhancer() {
        return new TokenEnhancerConfiguration();
    }

    /*
     * 配置客户端详情信息(内存或JDBC来实现)
     *
     * */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //初始化 Client 数据到 DB
        // clients.jdbc(dataSource)
        // clients.withClientDetails(new JdbcClientDetailsService(dataSource));

        clients.inMemory()
                .withClient("client_1")
                .authorizedGrantTypes("client_credentials")
                .scopes("all", "read", "write")
                .authorities("client_credentials")
                .accessTokenValiditySeconds(7200)
                .secret(passwordEncoder.encode("123456"))

                .and().withClient("client_2")
                .authorizedGrantTypes("password", "refresh_token")
                .scopes("all", "read", "write")
                .accessTokenValiditySeconds(7200)
                .refreshTokenValiditySeconds(10000)
                .authorities("password")
                .secret(passwordEncoder.encode("123456"))

                .and().withClient("client_3").authorities("authorization_code", "refresh_token")
                .secret(passwordEncoder.encode("123456"))
                .authorizedGrantTypes("authorization_code")
                .scopes("all", "read", "write")
                .accessTokenValiditySeconds(7200)
                .refreshTokenValiditySeconds(10000)
                .redirectUris("http://localhost:8080/callback", "http://localhost:8080/signin")

                .and().withClient("client_test")
                .secret(passwordEncoder.encode("123456"))
                .authorizedGrantTypes("all flow")
                .authorizedGrantTypes("authorization_code", "client_credentials", "refresh_token", "password", "implicit")
                .redirectUris("http://localhost:8080/callback", "http://localhost:8080/signin")
                .scopes("all", "read", "write")
                .accessTokenValiditySeconds(7200)
                .refreshTokenValiditySeconds(10000);

        //https://github.com/spring-projects/spring-security-oauth/blob/master/spring-security-oauth2/src/test/resources/schema.sql
        // clients.withClientDetails(new JdbcClientDetailsService(dataSource));
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(tokenEnhancer(), jwtAccessTokenConverter()));

        endpoints.authenticationManager(authenticationManager)
                .tokenStore(jdbcTokenStore())
                //.tokenStore(new RedisTokenStore(redisConnectionFactory))
                .tokenEnhancer(tokenEnhancerChain)
                .accessTokenConverter(jwtAccessTokenConverter())
                //refresh_token 需要 UserDetailsService is required
                //.userDetailsService(userDetailsService)
                .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);
    }


    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {

//        //curl -i -X POST -H "Accept: application/json" -u "client_1:123456" http://localhost:5000/oauth/check_token?token=a1478d56-ebb8-4f21-b4b6-8a9602df24ec
        security.tokenKeyAccess("permitAll()")         //url:/oauth/token_key,exposes public key for token verification if using JWT tokens
                .checkTokenAccess("isAuthenticated()") //url:/oauth/check_token allow check token
                .allowFormAuthenticationForClients();

        //受信任的资源服务能够获取到公有密匙
//        oauthServer.tokenKeyAccess("isAnonymous() || hasAuthority('ROLE_TRUSTED_CLIENT')")
//                   .checkTokenAccess("hasAuthority('ROLE_TRUSTED_CLIENT')");
    }


    /**
     * 定义token 签名的方式(非对称加密算法来对 Token 进行签名,也可以使用对称加密方式)
     *
     * @return
     */
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        logger.info("Initializing JWT with public key:\n" + publicKey);
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        //对称加密方式
        //converter.setSigningKey("micosrv_signing_key");
        //非对称加密方式
        converter.setSigningKey(privateKey);
        converter.setVerifierKey(publicKey);
        return converter;

//        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//        KeyPair keyPair = new KeyStoreKeyFactory(
//                new ClassPathResource("keystore.jks"), "foobar".toCharArray())
//                .getKeyPair("test");
//        converter.setKeyPair(keyPair);
//        return converter;
    }
}