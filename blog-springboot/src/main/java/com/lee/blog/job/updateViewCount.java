package com.lee.blog.job;

import com.lee.blog.entity.Article;
import com.lee.blog.service.ArticleService;
import com.lee.blog.util.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 定时任务：每隔10分钟把Redis中的浏览量更新到数据库中
 *
 * @author: zhicheng lee
 * @date: 2022/9/27 23:13
 */

@Component
public class updateViewCount {

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private ArticleService articleService;

    @Scheduled(cron = "0/5 * * * * ?")
    public void updateViewCount(){
        // 获取redis中的浏览量
        Map<String, Integer> viewCountMap = redisCache.getCacheMap("article:viewCount");

        List<Article> articles = viewCountMap.entrySet()
                .stream()
                .map(entry -> new Article(Long.valueOf(entry.getKey()), entry.getValue().longValue()))
                .collect(Collectors.toList());
        // 更新到数据库中
        articleService.updateBatchById(articles);
        System.out.println("定时任务");
    }

}
