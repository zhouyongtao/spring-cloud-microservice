package com.spring.cloud.microsrvflowable.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

/**
 * Demo class
 *
 * @author: irving
 * @date: 2018/10/15 14:53
 * @version: v1.0
 */
@RestController
public class HomeController {

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/")
    public Object list() {
        Locale locale = LocaleContextHolder.getLocale();
        String name = messageSource.getMessage("name", null, locale);
        return name;
    }
}