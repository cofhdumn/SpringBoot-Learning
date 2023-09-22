package com.atguigu.blog;

import com.atguigu.blog.mapper.ArticleMapper;
import com.atguigu.blog.mapper.CategoryMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootBlogDemoApplicationTests {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private ArticleMapper articleMapper;


    @Test
    public void  testFindCategoryList(){
        //使用断言判断查询结果是否是4条数据
        Assertions.assertEquals(3,categoryMapper.findCategoryList().size());
    }


    @Test
    public void testFindArticleList(){
        Assertions.assertEquals(2,articleMapper.findArticleList(2).size());
    }

}
