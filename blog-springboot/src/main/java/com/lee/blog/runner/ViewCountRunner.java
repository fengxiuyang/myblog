package com.lee.blog.runner;

import com.lee.blog.entity.Article;
import com.lee.blog.mapper.ArticleMapper;
import com.lee.blog.util.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 应用启动时初始化缓存
 *
 * @author: zhicheng lee
 * @date: 2022/9/27 22:59
 */

@Component
public class ViewCountRunner implements CommandLineRunner {

    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    RedisCache redisCache;

    @Override
    public void run(String... args) throws Exception {
        // 查询所有博客信息
        List<Article> articleList = articleMapper.selectList(null);

        // 提取所有浏览量信息
        Map<String, Integer> viewCountMap = articleList.stream()
                .collect(Collectors.toMap(article -> article.getId().toString(),
                        article -> article.getViewCount().intValue()));

        // 缓存到redis中
        redisCache.setCacheMap("article:viewCount", viewCountMap);
        // System.out.println(viewCountMap.toString());
    }
}
