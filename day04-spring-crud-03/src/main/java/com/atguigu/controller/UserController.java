package com.atguigu.controller;

import com.atguigu.pojos.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * 包名:com.atguigu.controller
 * @author Leevi
 * 日期2023-08-26  09:12
 * 给一个对象的属性赋值有哪些方式:
 * 1. 通过构造器
 * 2. 通过set方法
 * 3. 通过暴力反射
 */

@Controller
public class UserController {


    //注入到IOC容器中
    @Autowired
    private UserService userService;

    //public void setUserService(UserService userService){this.userService = userService;}


    public List<User> findAll(){
       return userService.findAll();
    }


    public void addUser(User user){
        userService.saveUser(user);
    }

    public void updateUser(User user){
        userService.updateUser(user);
    }

    public void deleteUser(Integer id){
        userService.deleteUserById(id);
    }

    public User findUserById(Integer id){


        return userService.findUserById(id);
    }
}
