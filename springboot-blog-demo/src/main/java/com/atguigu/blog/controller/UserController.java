package com.atguigu.blog.controller;

import com.atguigu.blog.pojos.User;
import com.atguigu.blog.result.Result;
import com.atguigu.blog.service.UserService;
import com.atguigu.blog.vos.LoginResultVo;
import com.atguigu.blog.vos.LoginVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName: UserController
 * Package: com.atguigu.blog.controller
 * Description:
 *
 * @Author Duwei
 * @Create 2023/9/20 21:01
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
@Tag(name="用户模块的接口")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    @Operation(summary = "用户登录的接口")
    public Result<LoginResultVo> login(@RequestBody LoginVo loginVo){
        //1. 调用service层的方法进行登录
        LoginResultVo loginResultVo = userService.doLogin(loginVo);

        //2. 使用session或者其它技术保存用户的登录状态
        return Result.ok(loginResultVo);


    }

    @GetMapping("/getUser/{uid}")
    public Result<User> getUser(@PathVariable("uid") Integer id){
        //1. 调用service层的方法根据uid查询用户
        User user = userService.findUserById(id);
        return Result.ok(user);
    }


    @PutMapping("/updateUser")
    public Result updateUser(@RequestBody User user){
        userService.updateUser(user);
        return Result.ok();
    }

}
