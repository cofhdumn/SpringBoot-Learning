package com.atguigu.service.impl;

import com.atguigu.mapper.UserMapper;
import com.atguigu.pojos.User;
import com.atguigu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName: ServiceImpl
 * Package: com.atguigu.service.impl
 * Description:
 *
 * @Author Duwei
 * @Create 2023/9/7 19:09
 * @Version 1.0
 */
@Service
public class ServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public void saveUser(User user) {
        userMapper.saveUser(user);
    }

    @Override
    public void deleteById(Integer id) {

        userMapper.deleteById(id);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);
    }
}
