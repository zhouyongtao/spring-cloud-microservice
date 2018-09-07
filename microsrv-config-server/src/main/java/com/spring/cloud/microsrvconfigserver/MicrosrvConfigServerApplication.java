package com.spring.cloud.microsrvconfigserver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MicrosrvConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicrosrvConfigServerApplication.class, args);
    }
}