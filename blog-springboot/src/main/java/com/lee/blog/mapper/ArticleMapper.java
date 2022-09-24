package com.lee.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lee.blog.entity.Article;
import org.springframework.stereotype.Repository;

/**
 * 文章
 *
 * @author zhicheng lee
 * @date 2022-09-11 20:07:42
 */

@Repository
public interface ArticleMapper extends BaseMapper<Article> {
}
