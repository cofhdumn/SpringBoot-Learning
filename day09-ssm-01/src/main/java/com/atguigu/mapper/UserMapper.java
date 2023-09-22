package com.atguigu.mapper;

import com.atguigu.pojos.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * ClassName: UserMapper
 * Package: com.atguigu.mapper
 * Description:
 *
 * @Author Duwei
 * @Create 2023/9/7 16:33
 * @Version 1.0
 */
public interface UserMapper {
    List<User> findAll();

    void saveUser(User user);

    void deleteById(Integer id);

    void updateUser(User user);

    User findById(Integer id);

    //@Param是设置别名的注解
    void saveUser2(@Param("userMap")Map<String, Object> map,@Param("username") String name);

    User findUserById2(@Param("tableName") String tableName,@Param("id") String id);
}
