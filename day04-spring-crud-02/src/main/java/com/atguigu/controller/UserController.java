package com.atguigu.controller;

import com.atguigu.pojos.User;
import com.atguigu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

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
