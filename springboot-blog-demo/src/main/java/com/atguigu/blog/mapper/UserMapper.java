package com.atguigu.blog.mapper;

import com.atguigu.blog.pojos.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ClassName: UserMapper
 * Package: com.atguigu.blog.mapper
 * Description:
 *
 * @Author Duwei
 * @Create 2023/9/20 20:56
 * @Version 1.0
 */
@Mapper
public interface UserMapper {
    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */

    User findUserByUsername(String username);
    /**
     * 根据uid查询用户
     * @param uid
     * @return
     */
    User findUserByUid(Integer uid);
    /**
     * 修改用户信息
     * @param user
     */
    void updateUser( User user);
}
