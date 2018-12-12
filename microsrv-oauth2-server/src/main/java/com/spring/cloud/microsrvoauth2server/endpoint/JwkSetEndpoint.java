package com.spring.cloud.microsrvoauth2server.endpoint;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import org.springframework.security.oauth2.provider.endpoint.FrameworkEndpoint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.KeyPair;
import java.security.Principal;
import java.security.interfaces.RSAPublicKey;
import java.util.Map;

/**
 *  https://docs.spring.io/spring-security-oauth2-boot/docs/current-SNAPSHOT/reference/htmlsingle/#oauth2-boot-authorization-server-spring-security-oauth2-resource-server-jwk
 *  https://connect2id.com/products/nimbus-jose-jwt
 *  https://connect2id.com/learn/oauth-2
 *
 * @author: irving
 * @date: 2018/12/12 16:19
 * @version: v1.0
 */
@FrameworkEndpoint
public class JwkSetEndpoint {

//    KeyPair keyPair;
//
//    public JwkSetEndpoint(KeyPair keyPair) {
//        this.keyPair = keyPair;
//    }
//
//    @GetMapping("/.well-known/jwks.json")
//    @ResponseBody
//    public Map<String, Object> getKey(Principal principal) {
//        RSAPublicKey publicKey = (RSAPublicKey) this.keyPair.getPublic();
//        RSAKey key = new RSAKey.Builder(publicKey).build();
//        return new JWKSet(key).toJSONObject();
//    }
}