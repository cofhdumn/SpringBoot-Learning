package com.atguigu.controller;

import com.atguigu.pojos.User;
import com.atguigu.result.Result;
import com.atguigu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: UserController
 * Package: com.atguigu.controller
 * Description:
 *
 * @Author Duwei
 * @Create 2023/9/7 19:12
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping
    public Result<User> findAll() {
       return Result.ok(userService.findAll());
    }
}
