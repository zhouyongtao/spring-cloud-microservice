package com.spring.cloud.microsrvoauth2server.service;
import com.spring.cloud.microsrvoauth2server.entity.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import java.util.Set;

/**
 * 用户服务接口
 *
 * @author：  ytzhou
 * @date：    2018/9/19 14:17
 * @version:  v1.0
 */
public interface UserService {

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    Users findByUsername(String username);
}