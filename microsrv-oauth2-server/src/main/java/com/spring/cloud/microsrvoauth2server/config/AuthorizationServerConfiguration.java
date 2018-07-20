package com.spring.cloud.microsrvoauth2server.config;
import java.security.KeyPair;
import com.spring.cloud.microsrvoauth2server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;
import javax.sql.DataSource;

/*
[/oauth/authorize]
[/oauth/token]
[/oauth/check_token]
[/oauth/confirm_access]
[/oauth/token_key]
[/oauth/error]
*/
@Configuration
@EnableAuthorizationServer
//@Order(2)
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


/*
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


    @Bean("jdbcTokenStore")
    public JdbcTokenStore getJdbcTokenStore() {
        return new JdbcTokenStore(dataSource);
    }

//    @Bean
//    public UserDetailsService userDetailsService(){
//        return new UserService();
//    }


    /*
    * 配置客户端详情信息(内存或JDBC来实现)
    *
    * */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //初始化 Client 数据到 DB
        clients.jdbc(dataSource)
       // clients.inMemory()
                .withClient("client_1")
                .authorizedGrantTypes("client_credentials")
                .scopes("all","read", "write")
                .authorities("client_credentials")
                .accessTokenValiditySeconds(7200)
                .secret(passwordEncoder.encode("123456"))

                .and().withClient("client_2")
                .authorizedGrantTypes("password", "refresh_token")
                .scopes("all","read", "write")
                .accessTokenValiditySeconds(7200)
                .refreshTokenValiditySeconds(10000)
                .authorities("password")
                .secret(passwordEncoder.encode("123456"))

                .and().withClient("client_3").authorities("authorization_code","refresh_token")
                .secret(passwordEncoder.encode("123456"))
                .authorizedGrantTypes("authorization_code")
                .scopes("all","read", "write")
                .accessTokenValiditySeconds(7200)
                .refreshTokenValiditySeconds(10000)
                .redirectUris("http://localhost:8080/callback","http://localhost:8080/signin")

                .and().withClient("client_test")
                .secret(passwordEncoder.encode("123456"))
                .authorizedGrantTypes("all flow")
                .authorizedGrantTypes("authorization_code", "client_credentials", "refresh_token","password", "implicit")
                .redirectUris("http://localhost:8080/callback","http://localhost:8080/signin")
                .scopes("all","read", "write")
                .accessTokenValiditySeconds(7200)
                .refreshTokenValiditySeconds(10000);

            //https://github.com/spring-projects/spring-security-oauth/blob/master/spring-security-oauth2/src/test/resources/schema.sql
           // clients.withClientDetails(new JdbcClientDetailsService(dataSource));
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

//        endpoints
//                .tokenStore(new RedisTokenStore(redisConnectionFactory))
//                .authenticationManager(authenticationManager);

           endpoints.authenticationManager(authenticationManager)
                     //配置 JwtAccessToken 转换器
                  //  .accessTokenConverter(jwtAccessTokenConverter())
                     //refresh_token 需要 UserDetailsService is required
                 //   .userDetailsService(userDetailsService)
                    .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST)
                    .tokenStore(getJdbcTokenStore());
    }


    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) {
        //curl -i -X POST -H "Accept: application/json" -u "client_1:123456" http://localhost:5000/oauth/check_token?token=a1478d56-ebb8-4f21-b4b6-8a9602df24ec
        oauthServer.tokenKeyAccess("permitAll()")         //url:/oauth/token_key,exposes public key for token verification if using JWT tokens
                   .checkTokenAccess("isAuthenticated()") //url:/oauth/check_token allow check token
                   .allowFormAuthenticationForClients();
    }

    /**
     * 使用非对称加密算法来对Token进行签名
     * @return
     */
    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        KeyPair keyPair = new KeyStoreKeyFactory(
                new ClassPathResource("keystore.jks"), "foobar".toCharArray())
                .getKeyPair("test");
        converter.setKeyPair(keyPair);
        return converter;
    }
}