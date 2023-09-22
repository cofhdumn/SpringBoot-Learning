package com.atguigu.dao.impl;

import com.atguigu.dao.UserDao;
import com.atguigu.pojos.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDaoImpl  implements UserDao {

    /*
    声明成员变量queryRunner
     */
    //private QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());


   @Autowired
    private JdbcTemplate jdbcTemplate;

    //public void setQueryRunner(QueryRunner queryRunner){this.queryRunner = queryRunner;}

    public List<User> findAll() {

        String sql = "select * from t_user";


            List<User> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));

            System.out.println("query = " + query);
            //return queryRunner.query(sql,new BeanListHandler<>(User.class));

    
            return query;


    }


    @Override
    public void saveUser(User user) {
        String sql  = "INSERT INTO t_user VALUES(null,?,?,?)";


            jdbcTemplate.update(sql,user.getAddress(),user.getAge(),user.getUsername());

    }

    @Override
    public void deleteUserById(Integer id) {

        String sql = "DELETE FROM t_user WHERE id=?";


            jdbcTemplate.update(sql,id);

    }

    @Override
    public User findUserById(Integer id) {

        String sql = "SELECT * FROM t_user WHERE id = ?";


            return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(User.class),id);

    }

    @Override
    public void updateUser(User user) {

        String sql = "UPDATE t_user SET username = ? ,address = ? , age = ? WHERE id = ? ";

            jdbcTemplate.update(sql,user.getUsername(),user.getAddress(),user.getAge());

    }
}
