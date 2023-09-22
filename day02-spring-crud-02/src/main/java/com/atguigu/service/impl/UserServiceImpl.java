package com.atguigu.service.impl;

import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.pojos.User;
import com.atguigu.service.UserService;

import java.util.List;

public class UserServiceImpl  implements UserService {


//声明成员变量 userDao返回类型是UserDao  用UserDaoImpl实现类赋值给成员变量userDao ,产生了耦合
    private UserDao userDao ;

    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }
    public List<User> findAll() {


        return userDao.findAll();
    }
}
