package com.atguigu.configuration;


import com.alibaba.druid.pool.DruidDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

//声明为配置类
@Configuration
@ComponentScan(basePackages = "com.atguigu")
@PropertySource("classpath:jdbc.properties")
public class AtguiguSpringConfiguration {


    @Value("${datasource.username}")
    private String username;


    @Value("${datasource.password}")
    private String password;


    @Value("${datasource.url}")
    private String url;


    @Value("${datasource.driverClassName}")
    private String driverClassName;


    @Bean
    public DataSource dataSource() {
        //1. 创建DataSource对象

        DruidDataSource dataSource = new DruidDataSource();
        //2. 设置属性
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driverClassName);
        return dataSource;

    }

    @Bean //dicates that a method produces a bean to be managed by the Spring container.
    public QueryRunner queryRunner(@Autowired DataSource dataSource){

        //1. 创建QueryRunner对象
            return new QueryRunner(dataSource);
    }
}
