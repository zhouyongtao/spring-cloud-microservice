package com.spring.cloud.microsrvoauth2server.config;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Demo class
 *
 * @author: irving
 * @date: 2018/12/3 16:54
 * @version: v1.0
 */
public class CustomAuthenticationToken extends UsernamePasswordAuthenticationToken {

    private String hotelId;

    public CustomAuthenticationToken(Object principal, Object credentials, String domain) {
        super(principal, credentials);
        this.hotelId = domain;
        super.setAuthenticated(false);
    }

    public CustomAuthenticationToken(Object principal, Object credentials, String hotelId,
                                     Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
        this.hotelId = hotelId;
        super.setAuthenticated(true); // must use super, as we override
    }

    public String getHotelId() {
        return this.hotelId;
    }
}
