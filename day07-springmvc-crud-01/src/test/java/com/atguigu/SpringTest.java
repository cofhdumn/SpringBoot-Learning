package com.atguigu;

import com.atguigu.controller.UserController;
import com.atguigu.pojos.Department;
import com.atguigu.pojos.User;
import com.atguigu.service.DepartmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import javax.sql.DataSource;
import java.util.List;

/**
 * 包名:com.atguigu
 *
 * @author Leevi
 * 日期2023-08-26  09:13
 */
@SpringJUnitConfig(locations = "classpath:springmvc.xml")
public class SpringTest {
    @Autowired
    private UserController userController;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private DepartmentService departmentService;
    @Test
    public void testFindAll(){
        System.out.println(userController.findAll());
    }

    @Test
    public void testFindById(){
        //System.out.println(userController.findUserById(3));
    }

    @Test
    public void testDeleteById(){
        userController.deleteUser(5);
    }

    @Test
    public void testSaveUser(){
        User user = new User(null, "张三", "深圳", 29);
        userController.addUser(user);
    }

    @Test
    public void test01(){
        //使用JDBCTemplate执行查询所有
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT * FROM t_user";
        List<User> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        System.out.println(userList);
    }

    @Test
    public void test02(){
        //使用JDBCTemplate执行查询一行数据
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT * FROM t_user WHERE id=?";
        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), 4);
        System.out.println(user);
    }

    @Test
    public void test03(){
        //使用JDBCTemplate执行增删改的SQL
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "INSERT INTO t_user VALUES (null,?,?,?)";
        jdbcTemplate.update(sql,"广州",29,"李四");
    }

    @Test
    public void testAddDepartment(){
        departmentService.addDepartment(new Department(null,"IT部","写代码"));
    }
}
