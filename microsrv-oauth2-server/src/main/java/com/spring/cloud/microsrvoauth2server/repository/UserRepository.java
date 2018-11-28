package com.spring.cloud.microsrvoauth2server.repository;

import com.spring.cloud.microsrvoauth2server.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户仓储接口
 *
 * @author: irving
 * @date: 2018/9/26 17:43
 * @version: v1.0
 */
public interface UserRepository extends JpaRepository<Users, Integer> {

    /**
     * 根据用户名查询单个用户信息
     *
     * @param userName 用户名
     * @return
     */
    Users findByUsername(String userName);
}