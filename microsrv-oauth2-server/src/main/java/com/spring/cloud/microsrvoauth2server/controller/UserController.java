package com.spring.cloud.microsrvoauth2server.controller;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping("/me")
    public Principal user(Principal principal) {
        return principal;
    }

    @GetMapping("/{name}")
    public String getBlogById(@PathVariable String name) {
        return "hello,"+ name;
    }
}