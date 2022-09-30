package com.lee.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.blog.entity.ArticleTag;
import com.lee.blog.mapper.ArticleTagMapper;
import com.lee.blog.service.ArticleTagService;
import org.springframework.stereotype.Service;

/**
 * 文章标签关联
 *
 * @author: zhicheng lee
 * @date: 2022/9/30 20:35
 */

@Service
public class ArticleTagServiceImpl extends ServiceImpl<ArticleTagMapper, ArticleTag> implements ArticleTagService {
}
