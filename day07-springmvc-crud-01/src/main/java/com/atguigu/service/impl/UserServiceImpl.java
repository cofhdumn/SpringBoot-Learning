package com.atguigu.service.impl;

import com.atguigu.dao.UserDao;
import com.atguigu.pojos.User;
import com.atguigu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * 包名:com.atguigu.service.impl
 *
 * @author Leevi
 * 日期2023-08-25  15:43
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }



    @Transactional(timeout = 3,rollbackFor = Exception.class)
    @Override
    public void deleteUserById(Integer id) {
        //1. 开启事务:connection.setAutoCommit(false);
        userDao.deleteUserById(id);
        //int num = 10/0;
        //2. 如果没有异常,则提交事务:connection.commit();
        //3. 如果出现异常,则在catch中回滚事务:connection.rollback()
        //4. 在finally中清理资源
    }

    @Override
    public User findUserById(Integer id) {
        return userDao.findUserById(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
}
