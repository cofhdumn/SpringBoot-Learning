package com.atguigu;

import com.atguigu.pojos.User;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.map.repository.config.EnableMapRepositories;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class SpringbootRedisDemoApplicationTests {


    //字符串用这个对象方法
    @Autowired
    private RedisTemplate redisTemplate;

    //集合用这个对象方法

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testString() {
        //测试操作字符串: redisTemplate.opsForValue()表示操作字符串
        //1. 往redis中存储字符串
        redisTemplate.opsForValue().set("name","zhangsan");

        //2. 往redis中存储字符串，并且要求只有当key不存在时才往redis中存储
        //redisTemplate.opsForValue().setIfAbsent("name", "你好");
        //3. 往redis中存储字符串，并且要求只有当key存在时才往redis中存储
        //redisTemplate.opsForValue().setIfPresent("name", "wangwu");
        //4. 往redis中存储字符串，并且设置过期时间
        //redisTemplate.opsForValue().set("name","zhaoliu",10, TimeUnit.MINUTES);
        //2. 从redis中获取字符串
        System.out.println(redisTemplate.opsForValue().get("name"));
        //3. 从redis中获取字符串的长度
        //System.out.println(redisTemplate.opsForValue().size("name"));

    }

    @Test
    public void test01(){
    stringRedisTemplate.opsForValue().set("info","hello");

        System.out.println(stringRedisTemplate.opsForValue().get("info"));
        System.out.println(stringRedisTemplate.opsForValue().size("info"));
    }


    @Test
    public void testList(){
        //测试操作list列表: redisTemplate.opsForList()表示操作list列表
       // redisTemplate.opsForList().leftPushAll("List1","zhangsan","lisi","wangwu","zhaoliu","tianqi");


        //在tianqi的左边，添加一个元素wangba
        redisTemplate.opsForList().leftPushAll("List1","tianqi","wangbo");

        //System.out.println(redisTemplate.opsForList().range("List1", 0, -1));

        //打印list1中的所有元素
        //System.out.println(redisTemplate.opsForList().range("list1",0,-1));

        System.out.println(redisTemplate.opsForList().leftPop("List1"));
    }


    @Test
    public void testSet(){
        //测试操作set集合: redisTemplate.opsForSet()表示操作set集合
        redisTemplate.opsForSet().add("set1","zhangsan","lisi","wangwu","zhaoliu","tianqi");
        redisTemplate.opsForSet().add("set2","zhangsan","aolafu","aolianna","zhaoliu","tianqi");
        redisTemplate.opsForSet().add("set3","zhangsan","lisi","aobama","zs","tianqi");
        //打印set1中的所有元素
        System.out.println(redisTemplate.opsForSet().members("set1"));
        System.out.println(redisTemplate.opsForSet().pop("set1"));
        System.out.println(redisTemplate.opsForSet().size("set1"));

        ArrayList<String> keys = new ArrayList<>();
        keys.add("set1");
        keys.add("set2");
        System.out.println(redisTemplate.opsForSet().intersect("set2", keys));
    }



    @Test
    public void test03(){
        User user = (User) redisTemplate.opsForValue().get("user");
        System.out.println("user = " + user);
    }


    @Test
    public void test04(){
        redisTemplate.opsForValue().set("skill:1",100);
    }
    @Test
    public void test05(){
        System.out.println(redisTemplate.opsForValue().get("skill:1"));
    }




}
