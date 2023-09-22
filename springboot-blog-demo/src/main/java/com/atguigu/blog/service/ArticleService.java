package com.atguigu.blog.service;

import com.atguigu.blog.pojos.Article;
import com.atguigu.blog.vos.QueryArticleVo;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

/**
 * ClassName: ArticeService
 * Package: com.atguigu.blog.service
 * Description:
 *
 * @Author Duwei
 * @Create 2023/9/20 18:30
 * @Version 1.0
 */
@Mapper
public interface ArticleService {
    /**
     * 查询文章列表
     * @param queryArticleVo
     * @return
     */
    List<Article> findArticleList(QueryArticleVo queryArticleVo);

    /**
     * 根据id查询文章
     * @param id
     * @return
     */
    Article findArticleById(Integer id);
    /**
     * 保存文章
     * @param article
     */
    void saveArticle(Article article);

    /**
     * 删除文章
     * @param id
     */
    void deleteArticleById(Integer id);
}
