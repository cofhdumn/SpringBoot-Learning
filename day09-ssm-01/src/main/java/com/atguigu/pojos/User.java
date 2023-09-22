package com.atguigu.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: User
 * Package: com.atguigu.pojos
 * Description:
 *
 * @Author Duwei
 * @Create 2023/9/7 15:40
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String userName;
    private String address;
    private Integer age;
}
