package com.spring.cloud.microsrvoauth2server.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/me")
    public Principal user(Principal principal) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return principal;
    }

    @GetMapping(value = "/authentication")
    public Object currentUserName(Authentication authentication) {
        return authentication;
    }

    @GetMapping("/info")
    public Object info() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return principal;
    }
}