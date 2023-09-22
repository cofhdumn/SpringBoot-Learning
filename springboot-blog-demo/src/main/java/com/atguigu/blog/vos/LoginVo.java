package com.atguigu.blog.vos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: LoginVo
 * Package: com.atguigu.blog.vos
 * Description:
 *
 * @Author Duwei
 * @Create 2023/9/20 21:07
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginVo {
    private String username;
    private String password;
}
