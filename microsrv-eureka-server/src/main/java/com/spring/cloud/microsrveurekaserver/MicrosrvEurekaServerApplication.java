package com.spring.cloud.microsrveurekaserver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MicrosrvEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicrosrvEurekaServerApplication.class, args);
    }
}