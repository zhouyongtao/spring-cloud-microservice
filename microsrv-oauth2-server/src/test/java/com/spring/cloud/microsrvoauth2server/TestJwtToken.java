package com.spring.cloud.microsrvoauth2server;
import org.junit.Test;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;

public class TestJwtToken {

    @Test
    public void testJwt() {
        String token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzY29wZSI6WyJhbGwiXSwiZXh0X25hbWUiOiJpcnZpbmciLCJleHAiOjE1MzM1NjQwMzQsImNsaWVudF9uYW1lIjoiY2xpZW50XzEiLCJhdXRob3JpdGllcyI6WyJjbGllbnRfY3JlZGVudGlhbHMiXSwianRpIjoiMzgyMTJjNzktMDdmOS00ZGIzLTg0ZDUtNWIwNzY2ZTA4M2Y5IiwiY2xpZW50X2lkIjoiY2xpZW50XzEifQ.LzDGv2YvWWyK9x4Ks88PjvYNVzjOu3Ofce8ipWv9sUdqzRHA1vX0kYltw4tDh6sSCuSDMXXLZVnq6VvHunQpLm2B51hm33C0HX31UqpYKOqM_QKeQabRWZlSrVy5CSS3wpXlF032eM2WIKwnFnFNajVoegCF_ddWuqiyuvlu7gpbsYsQTfSev8HIrRN7xmFL6UKX-FAB---MMBIaLeURCYEmPe9e-o2elxo6B1Y0PdOxBQQp6GCXT8z30iD015v7hgtnIYhu-0r5PE001qGP2DVPnJ2k7rzEhxdRIcFZwOm5bxie3MQMI53yEi6_1a3Vi2XiAGtU1OrMU1ddfjisDQ";
//        Jwt jwt = JwtHelper.decode(token);
//        System.out.println(jwt.toString());
        String publicKey  = "-----BEGIN PUBLIC KEY-----\n" +
                "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAm4irSNcR7CSSfXconxL4\n" +
                "g4M4j34wTWdTv93ocMn4VmdB7rCBU/BlxXtBUf/cgLIgQhQrAPszSZSmxiEXCOkG\n" +
                "Pr4aQBQuPgmNIR95Dhbzw/ZN0BnecAt3ZfkkDBHv8kH3kR/jYGTdwrxKeDgXGljN\n" +
                "sTRhbjuASxPG/Z6gU1yRPCsgc2r8NYnztWGcDWqaobqjG3/yzFmusoAboyV7asIp\n" +
                "o4yk378LmonDNwxnOOTb2Peg5PeelwfOwJPbftK1VOOt18zA0cchw6dHUzq9NlB8\n" +
                "clps/VdBap9BxU3/0YoFXRIc18nyzrWo2BcY2KQqX//AJC3OAfrfDmo+BGK8E0mp\n" +
                "8wIDAQAB\n" +
                "-----END PUBLIC KEY-----";
        System.out.println(JwtHelper.decodeAndVerify(token, new RsaVerifier(publicKey)));
    }
}
