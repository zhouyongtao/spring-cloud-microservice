package com.spring.cloud.microsrvconfigclient.controller;
import com.spring.cloud.microsrvconfigclient.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private Config config;

    @GetMapping("/username")
    public String getUserName(){
        return "my name is  " + config.getUsername() +"  and i'am " +config.getAge() +" years old.";
    }
}