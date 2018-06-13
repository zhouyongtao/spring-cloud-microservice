package com.spring.cloud.microsrveurekaserviceprovider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicrosrvEurekaServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicrosrvEurekaServiceProviderApplication.class, args);
    }
}