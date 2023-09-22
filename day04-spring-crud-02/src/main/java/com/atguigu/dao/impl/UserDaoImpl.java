package com.atguigu.dao.impl;

import com.atguigu.dao.UserDao;
import com.atguigu.pojos.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl  implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<User> findAll() {
        //准备sql
        String sql = "SELECT * FROM t_user";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(User.class));
    }

    @Override
    public void saveUser(User user) {

        String sql = "INSERT INTO t_user VALUES (null,?,?,?)";
        jdbcTemplate.update(sql,user.getAddress(),user.getAge(),user.getUsername());
    }

    @Override
    public void deleteUserById(Integer id) {
        String sql = " DELETE FROM t_user WHERE id =";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public void updateUser(User user) {

        String sql ="UPDATE t_user set username =？ ，address = ? ,age =? WHERE id =?";
        jdbcTemplate.update(sql,user.getUsername(),user.getAddress(),user.getAge(),user.getId());
    }

    @Override
    public User findUserById(Integer id) {
        String sql ="SELECT * FROM t_user where id=?";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
        return user;
    }
}
