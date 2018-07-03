package com.spring.cloud.microsrvzuul;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class MicrosrvZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicrosrvZuulApplication.class, args);
    }
}
