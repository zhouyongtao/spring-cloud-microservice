package com.spring.cloud.microsrvoauth2server.service.impl;

import com.spring.cloud.microsrvoauth2server.entity.Users;
import com.spring.cloud.microsrvoauth2server.service.UserService;
import org.springframework.stereotype.Service;

/**
 * Demo class
 *
 * @author: irving
 * @date: 2018/10/12 16:12
 * @version: v1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public Users findOneByusername(String username) {
        return null;
    }
}
