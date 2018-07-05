package com.spring.cloud.microsrvspringbootadminserver;
import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//http://codecentric.github.io/spring-boot-admin/2.0.1/

@Configuration
@EnableAutoConfiguration
@EnableDiscoveryClient
@EnableAdminServer
public class MicrosrvSpringBootAdminServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicrosrvSpringBootAdminServerApplication.class, args);
    }
}