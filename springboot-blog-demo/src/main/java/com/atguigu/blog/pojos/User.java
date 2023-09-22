package com.atguigu.blog.pojos;

import lombok.Data;

import java.util.Date;

/**
 * ClassName: User
 * Package: com.atguigu.blog.pojos
 * Description:
 *
 * @Author Duwei
 * @Create 2023/9/20 16:06
 * @Version 1.0
 */
@Data
public class User {
    private Integer uid;
    private String username;
    private String password;
    private String phone;
    private String introduction;
    private Date createTime;
    private Date updateTime;

}
