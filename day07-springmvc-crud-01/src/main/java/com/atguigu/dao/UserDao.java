package com.atguigu.dao;

import com.atguigu.pojos.User;

import java.util.List;

/**
 * 包名:com.atguigu.dao
 *
 * @author Leevi
 * 日期2023-08-25  15:35
 */
public interface UserDao {
    List<User> findAll();

    void saveUser(User user);

    void deleteUserById(Integer id);

    User findUserById(Integer id);

    void updateUser(User user);
}
