package com.spring.cloud.microsrvoauth2server;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringCloudApplication // @SpringBootApplication、@EnableDiscoveryClient、@EnableCircuitBreaker
@EnableAuthorizationServer
public class MicrosrvOauth2ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicrosrvOauth2ServerApplication.class, args);
    }
}