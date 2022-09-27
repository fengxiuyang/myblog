package com.lee.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lee.blog.entity.Article;
import com.lee.blog.vo.ResponseResult;

/**
 * 文章
 *
 * @author: zhicheng lee
 * @date: 2022/9/17 9:24
 */

public interface ArticleService extends IService<Article> {
    ResponseResult hotArticleList();

    ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId);

    ResponseResult getArticleDetail(Long id);
}
