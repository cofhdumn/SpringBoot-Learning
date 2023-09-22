package com.atguigu.blog.service.impl;

import com.atguigu.blog.mapper.ArticleMapper;
import com.atguigu.blog.pojos.Article;
import com.atguigu.blog.service.ArticleService;
import com.atguigu.blog.vos.QueryArticleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * ClassName: ArticeServiceImpl
 * Package: com.atguigu.blog.service.impl
 * Description:
 *
 * @Author Duwei
 * @Create 2023/9/20 18:31
 * @Version 1.0
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    @RequestMapping("/queryList")
    public List<Article> findArticleList(@RequestBody QueryArticleVo queryArticleVo) {
        return articleMapper.findArticleList(queryArticleVo.getCid());
    }

    @Override
    public Article findArticleById(Integer id) {
        return articleMapper.findArticleById(id);
    }

    @Override
    public void saveArticle(Article article) {
        articleMapper.addArticle(article);
    }

    @Override
    public void deleteArticleById(Integer id) {
        articleMapper.deleteArticleById(id);
    }
}
