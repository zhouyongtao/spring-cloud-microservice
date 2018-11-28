package com.spring.cloud.microsrvoauth2server.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

public class TokenEnhancerConfiguration implements TokenEnhancer {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        final Map<String, Object> additionalInfo = new HashMap<>();
        additionalInfo.put("ext_client_name", authentication.getName());
//        User user = (User) authentication.getUserAuthentication().getPrincipal();
//        additionalInfo.put("username", user.getUsername());
//        additionalInfo.put("authorities", user.getAuthorities());
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
        accessToken.getAdditionalInformation().put("hotelcd","021040");
        return accessToken;
    }
}
