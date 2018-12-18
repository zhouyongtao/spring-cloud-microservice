package com.spring.cloud.microsrvflowable.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.nio.charset.StandardCharsets;

/**
 * Demo class
 *
 * @author: irving
 * @date: 2018/12/18 16:01
 * @version: v1.0
 */
@Configuration
public class MessageSourceConfig {

    //https://developer.mozilla.org/zh-CN/docs/Web/HTTP/Headers/Accept-Language
    //https://blog.csdn.net/nthack5730/article/details/82870368

    @Bean(name = "messageSource")
    public ResourceBundleMessageSource getMessageSource() throws Exception {
        ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
        resourceBundleMessageSource.setDefaultEncoding(StandardCharsets.UTF_8.name());
        resourceBundleMessageSource.setBasenames("messages");
        return resourceBundleMessageSource;
    }
}