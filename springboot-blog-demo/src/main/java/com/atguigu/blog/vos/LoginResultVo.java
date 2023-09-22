package com.atguigu.blog.vos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: loginResultVo
 * Package: com.atguigu.blog.vos
 * Description:
 *
 * @Author Duwei
 * @Create 2023/9/20 21:18
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResultVo {
    private Integer uid;
    private String name;
}
