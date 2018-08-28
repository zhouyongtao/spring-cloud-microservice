package com.spring.cloud.microsrvzuulgateway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableDiscoveryClient
@EnableOAuth2Sso
@EnableZuulProxy
public class MicrosrvZuulGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicrosrvZuulGatewayApplication.class, args);
    }

//    @Bean
//    public OAuth2TokenFilter tokenFilter() {
//        return new OAuth2TokenFilter();
//    }
}