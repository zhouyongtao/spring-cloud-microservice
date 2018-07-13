package com.spring.cloud.microsrvzuulgateway;
import com.spring.cloud.microsrvzuulgateway.Filter.OAuth2TokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

//@SpringBootApplication
@SpringCloudApplication
@EnableOAuth2Sso
@EnableZuulProxy
public class MicrosrvZuulGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicrosrvZuulGatewayApplication.class, args);
    }

    @Bean
    public OAuth2TokenFilter tokenFilter() {
        return new OAuth2TokenFilter();
    }
}