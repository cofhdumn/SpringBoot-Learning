package com.atguigu;


import com.atguigu.configuration.AtguiguSpringConfiguration;
import com.atguigu.controller.UserController;
import com.atguigu.pojos.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

//需要传入配置类
@SpringJUnitConfig(classes= AtguiguSpringConfiguration.class)
public class SpringTest {

   @Autowired
    private UserController userController;


    @Test
    public void test01(){
        System.out.println(userController.findAll());
    }

    @Test
    public void test02(){
        User user = new User(null, "张三", "深圳", 29);
        userController.addUser(user);

    }
}
