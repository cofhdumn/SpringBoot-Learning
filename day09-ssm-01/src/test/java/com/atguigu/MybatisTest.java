package com.atguigu;

import com.atguigu.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: MybatisTest
 * Package: com.atguigu
 * Description:
 *
 * @Author Duwei
 * @Create 2023/9/7 18:18
 * @Version 1.0
 */
@SpringJUnitConfig(locations = {"classpath:spring/spring-service.xml"})
public class MybatisTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testFindAll(){
        System.out.println(userMapper.findAll());
    }

    @Test
    public void testSaveUser2(){
        Map<String,Object> map = new HashMap<>();
        map.put("age",33);
        map.put("address","三潘");
        userMapper.saveUser2(map,"美国人");
    }


    @Test
    public void testFindById2(){
        userMapper.findUserById2("t_user","31");
    }
}
