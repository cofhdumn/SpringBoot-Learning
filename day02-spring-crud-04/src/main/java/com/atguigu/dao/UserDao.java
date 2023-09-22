package com.atguigu.dao;

import com.atguigu.pojos.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
}
