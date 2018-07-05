package com.spring.cloud.microsrveurekaserviceconsumer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@EnableCircuitBreaker
@SpringBootApplication
public class MicrosrvEurekaServiceConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicrosrvEurekaServiceConsumerApplication.class, args);
    }
}
