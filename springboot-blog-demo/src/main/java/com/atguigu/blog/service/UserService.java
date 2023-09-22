package com.atguigu.blog.service;

import com.atguigu.blog.pojos.User;
import com.atguigu.blog.vos.LoginResultVo;
import com.atguigu.blog.vos.LoginVo;

/**
 * ClassName: UserService
 * Package: com.atguigu.blog.service
 * Description:
 *
 * @Author Duwei
 * @Create 2023/9/20 21:00
 * @Version 1.0
 */
public interface UserService {

    /**
     * 处理登录
     * @param loginVo
     * @return
     */
    LoginResultVo doLogin(LoginVo loginVo);

    /**
     * 根据uid查询用户
     * @param uid
     * @return
     */

    User findUserById(Integer uid);


    /**
     * 修改用户信息
     * @param user
     */
    void updateUser(User user);
}
