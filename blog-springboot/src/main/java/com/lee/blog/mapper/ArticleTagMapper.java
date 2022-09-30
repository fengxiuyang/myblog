package com.lee.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lee.blog.entity.ArticleTag;
import org.springframework.stereotype.Repository;

/**
 * 文章标签关联
 *
 * @author: zhicheng lee
 * @date: 2022/9/30 20:33
 */

@Repository
public interface ArticleTagMapper extends BaseMapper<ArticleTag> {
}
