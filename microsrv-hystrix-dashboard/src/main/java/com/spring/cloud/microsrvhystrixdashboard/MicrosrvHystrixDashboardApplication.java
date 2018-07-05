package com.spring.cloud.microsrvhystrixdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;


@EnableHystrixDashboard
@EnableCircuitBreaker
@SpringBootApplication
public class MicrosrvHystrixDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicrosrvHystrixDashboardApplication.class, args);
    }
}