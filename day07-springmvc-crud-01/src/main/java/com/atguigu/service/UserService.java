package com.atguigu.service;

import com.atguigu.pojos.User;

import java.util.List;

/**
 * 包名:com.atguigu.service
 *
 * @author Leevi
 * 日期2023-08-25  15:42
 */
public interface UserService {
    List<User> findAll();
    void saveUser(User user);
    void deleteUserById(Integer id);
    User findUserById(Integer id);
    void updateUser(User user);
}
