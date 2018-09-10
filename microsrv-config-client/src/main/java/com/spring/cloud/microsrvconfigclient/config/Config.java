package com.spring.cloud.microsrvconfigclient.config;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Data
@Component
@ConfigurationProperties("config")
public class Config {
    public String username;
    public Integer age;
}