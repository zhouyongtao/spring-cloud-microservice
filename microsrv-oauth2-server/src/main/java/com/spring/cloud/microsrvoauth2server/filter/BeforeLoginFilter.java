package com.spring.cloud.microsrvoauth2server.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * Demo class [http://docs.spring.io/spring-security/site/docs/5.0.0.M1/reference/htmlsingle/#ns-custom-filters]
 *
 * @author: irving
 * @date: 2018/12/7 20:26
 * @version: v1.0
 */
@Slf4j
public class BeforeLoginFilter  extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException, IOException, ServletException {
        log.info("This is a filter before UsernamePasswordAuthenticationFilter.");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}