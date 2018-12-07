package com.spring.cloud.microsrvoauth2server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Demo class  https://docs.spring.io/spring-security/site/docs/current/guides/html5/form-javaconfig.html
 *
 * @author: irving
 * @date: 2018/12/7 18:02
 * @version: v1.0
 */
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //自定义的登陆页面
        registry.addViewController("/login").setViewName("login");
        //自定义的授权页面
        registry.addViewController("/oauth/confirm_access").setViewName("confirm_access");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }
}