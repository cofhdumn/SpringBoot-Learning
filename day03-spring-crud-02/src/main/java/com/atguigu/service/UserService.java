package com.atguigu.service;

import com.atguigu.pojos.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    void saveUser(User user);

    void deleteUserById(Integer id);

    User findUserById(Integer id);

    void updateUser(User user);
}
