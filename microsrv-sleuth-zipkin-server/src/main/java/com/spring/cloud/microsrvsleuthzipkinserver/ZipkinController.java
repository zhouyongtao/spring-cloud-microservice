package com.spring.cloud.microsrvsleuthzipkinserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

//https://howtodoinjava.com/spring/spring-cloud/spring-cloud-zipkin-sleuth-tutorial/
@RestController
public class ZipkinController {

    @Autowired
    RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @GetMapping(value="/zipkin")
    public String zipkinService1()
    {
        String response = (String) restTemplate.exchange("http://localhost:8082/zipkin2",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}).getBody();
        return "Hi...";
    }
}