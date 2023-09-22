package com.atguigu.service.impl;

import com.atguigu.dao.UserDao;
import com.atguigu.pojos.User;
import com.atguigu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;



    @Override
    @Transactional
    public List<User> findAll() {




        return userDao.findAll();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDao.saveUser(user);
        //System.out.println(10 / 0);
    }

    @Override
    public void deleteUserById(Integer id) {
        userDao.deleteUserById(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public User findUserById(Integer id) {
        return userDao.findUserById(id);
    }
}
