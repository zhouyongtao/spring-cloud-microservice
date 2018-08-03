package com.spring.cloud.microsrvoauth2server.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/userinfo")
    public Principal user(Principal principal) {
        return principal;
    }

    @GetMapping("/me")
    public Map<String, Object> me(OAuth2Authentication user) {
        Map<String, Object> userInfo = new HashMap<String, Object>();
        userInfo.put("user", user.getUserAuthentication().getPrincipal());
        logger.debug("me:" + user.getUserAuthentication().getPrincipal().toString());
        userInfo.put("authorities", AuthorityUtils.authorityListToSet(user.getUserAuthentication().getAuthorities()));
        return userInfo;
    }


    @GetMapping("/{name}")
    public String getBlogById(@PathVariable String name) {
        return "hello,"+ name;
    }
}