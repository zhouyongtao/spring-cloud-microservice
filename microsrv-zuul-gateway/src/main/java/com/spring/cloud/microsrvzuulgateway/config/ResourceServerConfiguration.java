package com.spring.cloud.microsrvzuulgateway.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests().antMatchers("/v2/api-docs","/oauth/**").permitAll();
            http.csrf().disable()
                .exceptionHandling()
                .and()
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .httpBasic();
    }
}