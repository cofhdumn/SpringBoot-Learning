package com.atguigu.service;

import com.atguigu.pojos.User;

import java.util.List;

/**
 * ClassName: UserService
 * Package: com.atguigu.service
 * Description:
 *
 * @Author Duwei
 * @Create 2023/9/7 18:51
 * @Version 1.0
 */
public interface UserService {

    List<User> findAll();

    void saveUser(User user);

    void deleteById(Integer id);

    void updateUser(User user);

    User findById(Integer id);

}
