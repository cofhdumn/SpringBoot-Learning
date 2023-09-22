package com.atguigu;

import com.atguigu.controller.UserController;
import org.junit.Test;

public class SpringTest {



    @Test
    public void testFindAll(){

        UserController userController = new UserController();
        System.out.println(userController.findAll());

    }
}
