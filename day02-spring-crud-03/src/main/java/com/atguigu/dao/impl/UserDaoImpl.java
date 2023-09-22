package com.atguigu.dao.impl;

import com.atguigu.dao.UserDao;
import com.atguigu.pojos.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
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
    private QueryRunner queryRunner;

    //public void setQueryRunner(QueryRunner queryRunner){this.queryRunner = queryRunner;}

    public List<User> findAll() {

        String sql = "select * from t_user";
        try {

            List<User> query = queryRunner.query(sql, new BeanListHandler<>(User.class));

            System.out.println("query = " + query);
            //return queryRunner.query(sql,new BeanListHandler<>(User.class));

    
            return query;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
