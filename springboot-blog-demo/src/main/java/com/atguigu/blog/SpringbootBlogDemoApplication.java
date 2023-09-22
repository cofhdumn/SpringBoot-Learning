package com.atguigu.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.atguigu.blog.mapper")
public class SpringbootBlogDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootBlogDemoApplication.class, args);
    }



}
