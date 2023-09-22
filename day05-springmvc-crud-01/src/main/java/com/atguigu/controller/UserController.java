package com.atguigu.controller;

import com.atguigu.pojos.User;
import com.atguigu.result.Result;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 包名:com.atguigu.controller
 *
 * @author Leevi
 * 日期2023-08-26  09:12
 * 给一个对象的属性赋值有哪些方式:
 * 1. 通过构造器
 * 2. 通过set方法
 * 3. 通过暴力反射
 */

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

//@Controller
//@RestController  包含    @Controller  和@ResponseBody
@RestController
@RequestMapping("/user")
public class UserController {


    //注入到IOC容器中
    @Autowired
    private UserService userService;



    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
//    返回类型是Result泛型设定为User型
    public Result<User> findAll() {

        return Result.ok(userService.findAll()) ;
    }


   // @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    //@RequestBody User user 接收 json请求传过来的参数
   @PostMapping("/addUser")
    public Result<User> addUser(@RequestBody User user) {
        userService.saveUser(user);
        return Result.ok();
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
    public Result<User> updateUser(User user) {
        userService.updateUser(user);
        return Result.ok();
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.DELETE)
//如果前端传过来的是userId 后端形参定义的是 id 需要用@RequestParam注解 进行转译
    public Result<User> deleteUser(@RequestParam("userId") Integer id) {
        userService.deleteUserById(id);
        return Result.ok();
    }

    @RequestMapping(value = "/findUserById",method =RequestMethod.GET)
    public Result<User> findUserById(@RequestParam(value = "userId",required = false) Integer id) {

        System.out.println("-----------------------------");
        return Result.ok(userService.findUserById(id));
    }
}
