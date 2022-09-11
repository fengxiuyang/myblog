package com.lee.blog.controller;

import com.lee.blog.entity.Article;
import com.lee.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 文章
 *
 * @author zhicheng lee
 * @date 2022-09-11 19:27:33
 */

@RestController
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("/articles")
    public List<Article> ArticleList(){
        return articleService.list();
    }
}

