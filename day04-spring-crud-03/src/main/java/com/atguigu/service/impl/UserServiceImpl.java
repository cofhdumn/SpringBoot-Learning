package com.atguigu.service.impl;

import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.pojos.User;
import com.atguigu.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {





//声明成员变量 userDao返回类型是UserDao  用UserDaoImpl实现类赋值给成员变量userDao ,产生了耦合

    @Autowired
    private UserDao userDao;

    //public void setUserDao(UserDao userDao){this.userDao = userDao;}
    public List<User> findAll() {

        return userDao.findAll();
    }

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public void deleteUserById(Integer id) {

        userDao.deleteUserById(id);
    }

    @Override
    public User findUserById(Integer id) {
        //System.out.println(10/0);
        return userDao.findUserById(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
}
