package com.atguigu.blog.pojos;

import lombok.Data;

import java.util.Date;

/**
 * ClassName: Artice
 * Package: com.atguigu.blog.pojos
 * Description:
 *
 * @Author Duwei
 * @Create 2023/9/20 16:01
 * @Version 1.0
 */
@Data
public class Article {
    private Integer id;
    private String title;
    private String content;
    private Integer cid;
    private Integer uid;
    private String createTime;
    private String updateTime;
}
