package com.spring.cloud.microsrveurekaprovider;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String index()
    {
        return "hello eureka service provider";
    }
}