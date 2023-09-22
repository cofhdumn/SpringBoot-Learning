package com.atguigu.blog.controller;

import com.atguigu.blog.pojos.Article;
import com.atguigu.blog.result.Result;
import com.atguigu.blog.service.ArticleService;
import com.atguigu.blog.vos.QueryArticleVo;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName: ArticeController
 * Package: com.atguigu.blog.controller
 * Description:
 *
 * @Author Duwei
 * @Create 2023/9/20 18:32
 * @Version 1.0
 */
@RestController
@RequestMapping("/article")
public class ArticeController {

    @Autowired
    private ArticleService articleService;


    @RequestMapping("/queryList")
    public Result<List<Article>> findArticeList(QueryArticleVo queryArticleVo) {

        return Result.ok(articleService.findArticleList(queryArticleVo));
    }


    @GetMapping("getArticle/{id}")
    public Result<Article> getArticle(@PathVariable ("id") Integer id){
        return Result.ok(articleService.findArticleById(id));
    }

    @PostMapping("/addArticle")
    public Result addArticle(@RequestBody Article article){
        articleService.saveArticle(article);
        return Result.ok();
    }

    @DeleteMapping("/deleteArticle/{id}")
    public Result deleteArticle(@PathVariable("id")Integer id){
        System.out.println("id = " + id);
        articleService.deleteArticleById(id);
        return Result.ok();
    }
}
