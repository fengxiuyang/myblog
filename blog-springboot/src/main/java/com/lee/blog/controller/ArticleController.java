package com.lee.blog.controller;


import com.lee.blog.dto.AddArticleDto;
import com.lee.blog.entity.Article;
import com.lee.blog.service.ArticleService;
import com.lee.blog.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 文章
 *
 * @author zhicheng lee
 * @date 2022-09-11 19:27:33
 */

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 热门文章列表
     */
    @GetMapping("/hotArticleList")
    public ResponseResult hotArticleList() {

        ResponseResult result = articleService.hotArticleList();
        return result;
    }

    /**
     * 分类文章列表
     */
    @GetMapping("/articleList")
    public ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId) {
        return articleService.articleList(pageNum, pageSize, categoryId);
    }

    /**
     * 获取文章详细信息
     */
    @GetMapping("/{id}")
    public ResponseResult getArticleDetail(@PathVariable("id") Long id) {
        return articleService.getArticleDetail(id);
    }

    /**
     * 更新文章浏览量
     */
    @PutMapping("/updateViewCount/{id}")
    public ResponseResult updateViewCount(@PathVariable("id") Long id) {
        return articleService.updateViewCount(id);
    }

    /**
     * 新增文章
     */
    @PostMapping
    public ResponseResult add(@RequestBody AddArticleDto article) {
        return articleService.add(article);
    }

    /**
     * 分页查询文章
     */
    @GetMapping("/list")
    public ResponseResult list(Article article, Integer pageNum, Integer pageSize) {
        return articleService.selectArticlePage(article, pageNum, pageSize);
    }

}
