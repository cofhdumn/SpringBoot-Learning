package com.atguigu;

import com.atguigu.configuration.AtguiguSpringConfiguration;
import com.atguigu.controller.UserController;
import com.atguigu.pojos.User;
import com.atguigu.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import javax.sql.DataSource;
import java.util.List;


//@SpringJUnitConfig(locations = "classpath:spring1.xml")
@SpringJUnitConfig(classes = AtguiguSpringConfiguration.class)
public class SpringTest {


    @Autowired
    private UserController userController;


    @Autowired
    private UserService userService;
    @Autowired
    private DataSource dataSource;
/*
    @Test
    public void testFindAll(){
        //1. 创建IOC容器对象，并且加载配置文件
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("spring1.xml");
        //2. 从IOC容器中获取对象
        //根据类型获取对象
        //UserController userController = ioc.getBean(UserController.class);
        //System.out.println("userController = " + userController);

        UserController userController = ioc.getBean("userController", UserController.class);

        System.out.println(userController.findAll());


    }


 */

    @Test
    public void testFindAll() {
        //System.out.println(userController.findAll());

        System.out.println(userController.findUserById(3));

    }

    @Test
    public void test01() {
        //使用JDBCTemplate执行查询所有
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "SELECT * FROM t_user";

        List<User> userlist = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        System.out.println("userlist = " + userlist);


    }

    @Test
    public void test02() {
        //使用JDBCTemplate执行查询一行数据

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT * FROM t_user WHERE id=?";

        User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), 4);
        System.out.println("user = " + user);


    }

    @Test
    public void test03() {
        //使用JDBCTemplate执行增删改的SQL
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql ="INSERT INTO t_user VALUES(null,?,?,?)";

        jdbcTemplate.update(sql,"广州",29,"李斯");

    }

    @Test
    public void test04(){
        userService.deleteUserById(3);
    }
}
