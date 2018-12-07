package com.spring.cloud.microsrvoauth2server.utils;

import com.spring.cloud.microsrvoauth2server.exception.UserFriendlyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.codec.Base64;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Demo class
 *
 * @author: irving
 * @date: 2018/12/3 15:36
 * @version: v1.0
 */
@Slf4j
public class AuthUtils {
    private static final String BASIC_ = "Basic ";

    /**
     * 从header 请求中的clientId/clientsecect
     *
     * @param header header中的参数
     * @throws UserFriendlyException if the Basic header is not present or is not valid
     *                               Base64
     */
    public static String[] extractAndDecodeHeader(String header)
            throws IOException {

        byte[] base64Token = header.substring(6).getBytes("UTF-8");
        byte[] decoded;
        try {
            decoded = Base64.decode(base64Token);
        } catch (IllegalArgumentException e) {
            throw new UserFriendlyException(
                    "Failed to decode basic authentication token");
        }
        String token = new String(decoded, "UTF-8");
        int delim = token.indexOf(":");
        if (delim == -1) {
            throw new UserFriendlyException("Invalid basic authentication token");
        }
        return new String[]{token.substring(0, delim), token.substring(delim + 1)};
    }

    /**
     * *从header 请求中的clientId/clientsecect
     *
     * @param request
     * @return
     * @throws IOException
     */
    public static String[] extractAndDecodeHeader(HttpServletRequest request)
            throws IOException {
        String header = request.getHeader("Authorization");

        if (header == null || !header.startsWith(BASIC_)) {
            throw new UserFriendlyException("请求头中client信息为空");
        }
        return extractAndDecodeHeader(header);
    }
}
