package com.atguigu.blog.pojos;

import lombok.Data;

import java.util.Date;

/**
 * ClassName: Category
 * Package: com.atguigu.blog.pojos
 * Description:
 *
 * @Author Duwei
 * @Create 2023/9/20 16:04
 * @Version 1.0
 */
@Data
public class Category {
    private Integer cid;
    private String cname;
    private Date createTime;
    private Date updateTime;

}
