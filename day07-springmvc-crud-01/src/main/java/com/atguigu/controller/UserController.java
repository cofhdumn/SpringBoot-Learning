package com.atguigu.controller;

import com.atguigu.pojos.User;
import com.atguigu.result.Result;
import com.atguigu.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 包名:com.atguigu.controller
 * @author Leevi
 * 日期2023-08-26  09:12
 * 请求方式: 总共有八种，分别是GET、POST、PUT、DELETE、HEAD、OPTIONS、TRACE、CONNECT
 * 常用的是GET、POST、PUT、DELETE
 * GET请求: 常用语查询数据,GET请求携带参数都是在url后拼接 ?参数名=参数值&参数名=参数值
 * POST请求: 常用语新增数据,POST请求携带参数都是在请求体中，通过请求体携带参数又有两种方式: 1. application/x-www-form-urlencoded 2. application/json
 * PUT请求: 常用语修改数据,PUT请求携带参数都是在请求体中，通过请求体携带参数又有两种方式: 1. application/x-www-form-urlencoded 2. application/json
 * DELETE请求: 常用语删除数据,DELETE请求携带参数都是在url后拼接 ?参数名=参数值&参数名=参数值
 *
 * 目标: 要求后端接收请求的时候遵循上述规范
 * 方式一: 通过RequestMapping注解的method属性来指定请求方式
 * 方式二: 通过GetMapping、PostMapping、PutMapping、DeleteMapping注解来指定请求方式
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public Result<User> findAll(){
        return Result.ok(userService.findAll());
    }

    @PostMapping
    public Result<User> addUser(@RequestBody User user){
        userService.saveUser(user);
        return Result.ok();
    }

    @PutMapping
    public Result<User> updateUser(@RequestBody User user){
        userService.updateUser(user);
        return Result.ok();
    }

    @DeleteMapping("/{userId}")
    public Result<User> deleteUser(@PathVariable("userId") Integer id){
        userService.deleteUserById(id);
        return Result.ok();
    }

    @GetMapping("/{userId}")
    public Result<User> findUserById(@PathVariable("userId") Integer id, HttpServletRequest request){
        System.out.println(request.getRequestURL().toString());
        return Result.ok(userService.findUserById(id));
    }
}
