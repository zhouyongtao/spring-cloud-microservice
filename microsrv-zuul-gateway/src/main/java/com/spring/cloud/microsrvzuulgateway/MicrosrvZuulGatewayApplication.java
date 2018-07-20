package com.spring.cloud.microsrvzuulgateway;
import com.spring.cloud.microsrvzuulgateway.Filter.OAuth2TokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
@EnableOAuth2Sso
public class MicrosrvZuulGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicrosrvZuulGatewayApplication.class, args);
    }

//    @Bean
//    public OAuth2TokenFilter tokenFilter() {
//        return new OAuth2TokenFilter();
//    }
}