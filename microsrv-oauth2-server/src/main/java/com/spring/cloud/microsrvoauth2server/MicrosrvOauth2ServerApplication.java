package com.spring.cloud.microsrvoauth2server;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

@SpringCloudApplication // @SpringBootApplication、@EnableDiscoveryClient、@EnableCircuitBreaker
public class MicrosrvOauth2ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicrosrvOauth2ServerApplication.class, args);
    }
}