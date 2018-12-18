package com.spring.cloud.microsrvoauth2server.endpoint;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import netscape.security.Principal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.provider.endpoint.FrameworkEndpoint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.misc.BASE64Decoder;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Map;

/**
 *  https://docs.spring.io/spring-security-oauth2-boot/docs/current-SNAPSHOT/reference/htmlsingle/#oauth2-boot-authorization-server-spring-security-oauth2-resource-server-jwk
 *  https://connect2id.com/products/nimbus-jose-jwt
 *  https://connect2id.com/learn/oauth-2
 *
 * https://github.com/spring-projects/spring-security/blob/master/samples/boot/oauth2authorizationserver/src/main/java/sample/JwkSetConfiguration.java
 * Legacy Authorization Server (spring-security-oauth2) does not support any
 * <a href target="_blank" href="https://tools.ietf.org/html/rfc7517#section-5">JWK Set</a> endpoint.
 * <p>
 * This class adds ad-hoc support in order to better support the other samples in the repo.
 *
 * @author: irving
 * @date: 2018/12/12 16:19
 * @version: v1.0
 */
@FrameworkEndpoint
public class JwkSetEndpoint {

    /**
     * 公钥
     */
    @Value("${config.oauth2.publicKey}")
    private String publicKey;


    /**
     * 访问 http://localhost:5000/.well-known/jwks.json
     *
     * @param principal
     * @return
     * @throws Exception
     */
    @GetMapping("/.well-known/jwks.json")
    @ResponseBody
    public Map<String, Object> getKey(Principal principal) throws Exception {
        //RSAPublicKey rsaPublicKey = (RSAPublicKey) getPublicKey(publicKey);
        RSAPublicKey rsaPublicKey = (RSAPublicKey) loadPublicKey(publicKey);
        RSAKey key = new RSAKey.Builder(rsaPublicKey).build();
        return new JWKSet(key).toJSONObject();
    }

    /**
     * http://xueliang.org/article/detail/20170807222857437
     *
     * @param public_Key
     * @return
     * @throws Exception
     */
    public PublicKey loadPublicKey(String public_Key) throws Exception {
        String publicKeyPEM = public_Key; //FileUtils.readFileToString(new File("publickey.pem"), StandardCharsets.UTF_8);
        // strip of header, footer, newlines, whitespaces
        publicKeyPEM = publicKeyPEM
                .replace("-----BEGIN PUBLIC KEY-----", "")
                .replace("-----END PUBLIC KEY-----", "")
                .replaceAll("\\s", "");

        // decode to get the binary DER representation
        byte[] publicKeyDER = Base64.getDecoder().decode(publicKeyPEM);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(new X509EncodedKeySpec(publicKeyDER));
        return publicKey;
    }

    /**
     * 得到公钥
     *
     * @param key 密钥字符串（经过base64编码）
     * @throws Exception
     */
    public PublicKey getPublicKey(String key) throws Exception {
        byte[] keyBytes;
        keyBytes = (new BASE64Decoder()).decodeBuffer(key);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(keySpec);
        return publicKey;
    }
}