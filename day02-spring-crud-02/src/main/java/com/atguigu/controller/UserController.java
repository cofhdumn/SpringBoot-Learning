package com.atguigu.controller;

import com.atguigu.pojos.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;

import java.util.List;

public class UserController {

    private UserService userService;

    public void setUserService(UserService userService){
        this.userService = userService;
    }


    public List<User> findAll(){
       return userService.findAll();
    }
}
