package com.atguigu.blog.service.impl;

import com.atguigu.blog.exception.PasswordErrorException;
import com.atguigu.blog.exception.UsernameErrorException;
import com.atguigu.blog.mapper.UserMapper;
import com.atguigu.blog.pojos.User;
import com.atguigu.blog.service.UserService;
import com.atguigu.blog.vos.LoginResultVo;
import com.atguigu.blog.vos.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName: UserServiceImpl
 * Package: com.atguigu.blog.service.impl
 * Description:
 *
 * @Author Duwei
 * @Create 2023/9/20 21:02
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public LoginResultVo doLogin(LoginVo loginVo) {
        //1. 根据用户名查询用户
        User dbUser = userMapper.findUserByUsername(loginVo.getUsername());
        //2. 判断用户是否存在
        if (dbUser ==null){
            throw new UsernameErrorException("用户名不存在");
        }

        //3. 如果用户存在，则判断密码是否正确
        if (!dbUser.getPassword().equals(loginVo.getPassword())){
            //说明密码错了
            throw new PasswordErrorException("密码错误");
        }
        //4. 如果密码正确，将用户的uid和name封装到LoginResultVo中返回
        LoginResultVo loginResultVo = new LoginResultVo(dbUser.getUid(),dbUser.getUsername());
        return loginResultVo;
    }

    @Override
    public User findUserById(Integer id) {
        User user = userMapper.findUserByUid(id);
        return user;
    }

    @Override
    public void updateUser(User user) {
         userMapper.updateUser(user);
    }
}
