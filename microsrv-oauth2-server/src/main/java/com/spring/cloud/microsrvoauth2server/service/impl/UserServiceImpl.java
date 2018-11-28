package com.spring.cloud.microsrvoauth2server.service.impl;

import com.spring.cloud.microsrvoauth2server.entity.Users;
import com.spring.cloud.microsrvoauth2server.repository.UserRepository;
import com.spring.cloud.microsrvoauth2server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserRepository userRepository;

    /**
     * 根据用户名查询单个用户信息
     *
     * @param userName
     * @return
     */
    @Override
    public Users findByUsername(String userName) {
        Users user = userRepository.findByUsername(userName);
        if (user == null) {
            //throw new UserFriendlyException("用户不存在!");
        }
        return user;
    }
}
