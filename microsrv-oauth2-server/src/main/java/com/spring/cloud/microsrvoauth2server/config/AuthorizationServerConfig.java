package com.spring.cloud.microsrvoauth2server.config;
import java.security.KeyPair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

//@Configuration
//@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

//    @Autowired
//    private AuthenticationManager authenticationManager;

//    /**
//     * 使用非对称加密算法来对Token进行签名
//     * @return
//     */
//    @Bean
//    public JwtAccessTokenConverter jwtAccessTokenConverter() {
//        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//        KeyPair keyPair = new KeyStoreKeyFactory(
//                new ClassPathResource("keystore.jks"), "foobar".toCharArray())
//                .getKeyPair("test");
//        converter.setKeyPair(keyPair);
//        return converter;
//    }
//
//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients.inMemory()
//                .withClient("irving")
//                .secret("123456")
//                .authorizedGrantTypes("authorization_code", "refresh_token",
//                        "password").scopes("openid");
//
//        //clients.withClientDetails(new JdbcClientDetailsService(dataSource));
//    }

//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        endpoints.authenticationManager(authenticationManager)
//                // 配置JwtAccessToken转换器
//                .accessTokenConverter(jwtAccessTokenConverter());
//                // refresh_token需要userDetailsService
//               // .reuseRefreshTokens(false).userDetailsService(userDetailsService);
//        //.tokenStore(getJdbcTokenStore());
//    }

//    @Override
//    public void configure(AuthorizationServerSecurityConfigurer oauthServer)
//            throws Exception {
//        oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess(
//                "isAuthenticated()");
//    }
}