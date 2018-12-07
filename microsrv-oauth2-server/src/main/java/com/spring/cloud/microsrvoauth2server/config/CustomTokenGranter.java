package com.spring.cloud.microsrvoauth2server.config;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.common.util.OAuth2Utils;
import org.springframework.security.oauth2.provider.*;
import org.springframework.security.oauth2.provider.token.AbstractTokenGranter;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;

import java.util.List;
import java.util.Map;

/**
 * 自定义模式 (https://github.com/spring-projects/spring-security-oauth/blob/master/spring-security-oauth2/src/main/java/org/springframework/security/oauth2/provider/password/ResourceOwnerPasswordTokenGranter.java)
 *
 * @author: irving
 * @date: 2018/12/7 16:28
 * @version: v1.0
 */
public class CustomTokenGranter extends AbstractTokenGranter {

    CustomTokenGranter(AuthorizationServerTokenServices tokenServices, ClientDetailsService clientDetailsService,
                       OAuth2RequestFactory requestFactory, String grantType) {
        super(tokenServices, clientDetailsService, requestFactory, grantType);
    }

    @Override
    protected OAuth2Authentication getOAuth2Authentication(ClientDetails client, TokenRequest tokenRequest) {
        Map<String, String> params = tokenRequest.getRequestParameters();
        String username = params.containsKey("username") ? params.get("username") : "guest";
        List<GrantedAuthority> authorities = params.containsKey("authorities") ? AuthorityUtils
                .createAuthorityList(OAuth2Utils.parseParameterList(params.get("authorities")).toArray(new String[0]))
                : AuthorityUtils.NO_AUTHORITIES;
        Authentication user = new UsernamePasswordAuthenticationToken(username, "N/A", authorities);
        OAuth2Authentication authentication = new OAuth2Authentication(tokenRequest.createOAuth2Request(client), user);
        return authentication;
    }
}