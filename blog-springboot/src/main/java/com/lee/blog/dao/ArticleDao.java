package com.lee.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lee.blog.entity.Article;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 文章
 *
 * @author zhicheng lee
 * @date 2022-09-11 19:27:37
 */
public interface ArticleDao extends BaseMapper<Article> {

}

