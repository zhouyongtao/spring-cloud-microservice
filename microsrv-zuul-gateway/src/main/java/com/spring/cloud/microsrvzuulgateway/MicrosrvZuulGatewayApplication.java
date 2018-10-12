package com.spring.cloud.microsrvzuulgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableOAuth2Sso
@EnableZuulProxy
public class MicrosrvZuulGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicrosrvZuulGatewayApplication.class, args);
    }

    @GetMapping("/")
    public String index() {
        return "hello zuul service";
    }

//    @Bean
//    public OAuth2TokenFilter tokenFilter() {
//        return new OAuth2TokenFilter();
//    }
}