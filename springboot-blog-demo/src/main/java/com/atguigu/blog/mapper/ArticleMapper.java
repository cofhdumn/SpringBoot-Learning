package com.atguigu.blog.mapper;

import com.atguigu.blog.pojos.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ClassName: ArticeMapper
 * Package: com.atguigu.blog.mapper
 * Description:
 *
 * @Author Duwei
 * @Create 2023/9/20 18:25
 * @Version 1.0
 */
@Mapper
public interface ArticleMapper {
    /**
     * 根据文章的分类id查询文章列表
     * @param cid
     * @return
     */
    List<Article> findArticleList(Integer cid);

    /**
     * 根据文章的id查询文章详情
     * @param id
     * @return
     */

    Article findArticleById(Integer id);
    /**
     * 添加文章
     * @param article
     */
    void addArticle(Article article);

    /**
     * 根据文章的id删除文章
     * @param id
     */
    void deleteArticleById(Integer id);
}
