package com.atguigu.blog.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * ClassName: PageResult
 * Package: com.atguigu.blog.result
 * Description:
 *
 * @Author Duwei
 * @Create 2023/9/21 16:55
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult <T>{
    private List<T> list;
    private Long totalCount;
}
