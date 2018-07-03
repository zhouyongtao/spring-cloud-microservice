package com.spring.cloud.microsrvapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicrosrvApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicrosrvApiGatewayApplication.class, args);
    }
}