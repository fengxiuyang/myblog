package com.lee.blog.controller;

import com.lee.blog.dto.AddArticleDto;
import com.lee.blog.dto.ArticleDto;
import com.lee.blog.entity.Article;
import com.lee.blog.service.ArticleService;
import com.lee.blog.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 后台文章
 *
 * @author: zhicheng lee
 * @date: 2022/10/1 14:31
 */

@RestController
@RequestMapping("/content/article")
public class BackArticleController {

    @Autowired
    private ArticleService articleService;

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

    /**
     * 修改文章
     */
    @PutMapping
    public ResponseResult edit(@RequestBody ArticleDto articleDto){
        return articleService.edit(articleDto);
    }

    /**
     * 删除文章
     */
    @DeleteMapping("/{id}")
    public ResponseResult delete(@PathVariable Long id){
        articleService.removeById(id);
        return ResponseResult.okResult();
    }

    /**
     * 获取文章信息
     */
    @GetMapping(value = "/{id}")
    public ResponseResult getInfo(@PathVariable(value = "id")Long id){
        return articleService.getInfo(id);
    }

}
