package com.atguigu.dao;

import com.atguigu.pojos.User;

import java.util.List;

public interface UserDao {

    //查询所有的方法
    List<User> findAll();

    //新增的方法
    void saveUser(User user);

    //根据id删除
    void deleteUserById(Integer id);

    //修改的方法
    void updateUser(User user);

    //根据id查询
    User findUserById(Integer id);









}
