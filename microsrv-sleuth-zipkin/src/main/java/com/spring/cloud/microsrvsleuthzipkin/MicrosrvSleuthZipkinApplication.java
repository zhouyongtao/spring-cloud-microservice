package com.spring.cloud.microsrvsleuthzipkin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.client.RestTemplate;
import zipkin2.Span;
import zipkin2.reporter.Reporter;

/*
*
* https://github.com/spring-cloud/spring-cloud-sleuth
* https://windmt.com/2018/04/24/spring-cloud-12-sleuth-zipkin/
* */

@SpringBootApplication
@EnableEurekaClient
public class MicrosrvSleuthZipkinApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicrosrvSleuthZipkinApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    // Use this for debugging (or if there is no Zipkin server running on port 9411)
    @Bean
    @ConditionalOnProperty(value = "sample.zipkin.enabled", havingValue = "false")
    public Reporter<Span> spanReporter() {
        return Reporter.CONSOLE;
    }
}