package com.atguigu;

import com.atguigu.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SpringTest {




    @Test
    public void testFindAll(){
        //1. 创建IOC容器对象，并且加载配置文件
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("spring.xml");
        //2. 从IOC容器中获取对象
        //根据类型获取对象
        //UserController userController = ioc.getBean(UserController.class);
        //System.out.println("userController = " + userController);

        UserController userController = ioc.getBean("userController", UserController.class);

        System.out.println(userController.findAll());


    }
}
