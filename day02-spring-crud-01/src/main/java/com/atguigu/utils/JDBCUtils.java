package com.atguigu.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

/**  
 * 管理数据库连接的工具类  
 * 功能1：从数据源中获取数据库连接  
 * 功能2：把数据库连接放回数据源  
 */  
public class JDBCUtils {

    // 数据源对象声明为成员变量
    private static DataSource dataSource;

    static {
        try {
            // 1、创建 Properties 对象
            Properties properties = new Properties();

            // 2、加载外部属性文件
            InputStream inputStream = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");

            // 3、加载外部属性文件
            properties.load(inputStream);

            // 4、给数据源成员变量赋值
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static DataSource getDataSource() {
        return dataSource;
    }
}