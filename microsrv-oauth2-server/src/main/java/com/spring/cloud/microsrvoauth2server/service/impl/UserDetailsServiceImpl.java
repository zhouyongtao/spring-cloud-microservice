package com.spring.cloud.microsrvoauth2server.service.impl;

import com.spring.cloud.microsrvoauth2server.entity.Users;
import com.spring.cloud.microsrvoauth2server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 重写用户服务
 *
 * @author： ytzhou
 * @date： 2018/9/19 14:17
 * @version: v1.0
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String userName) {
        Users user = userService.findByUsername(userName);
        if (null == user) {
            throw new UsernameNotFoundException(userName);
        }

        // List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//        for (SysRole role : sysUser.getRoleList()) {
//            for (SysPermission permission : role.getPermissionList()) {
//                authorities.add(new SimpleGrantedAuthority(permission.getCode()));
//            }
//        }
        return new User(user.getUsername(), user.getPassword(), getAuthority());
    }

    private List getAuthority() {
        return Arrays.asList(
                new SimpleGrantedAuthority("ROLE_ADMIN"),
                new SimpleGrantedAuthority("021098"),
                new SimpleGrantedAuthority("021040"));
    }
}