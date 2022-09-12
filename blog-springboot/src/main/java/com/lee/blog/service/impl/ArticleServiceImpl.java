package com.lee.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.blog.dto.ArchiveDTO;
import com.lee.blog.entity.Article;
import com.lee.blog.dao.ArticleDao;
import com.lee.blog.service.ArticleService;
import com.lee.blog.util.BeanCopyUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.lee.blog.enums.ArticleStatusEnum.PUBLIC;

/**
 * 文章
 *
 * @author zhicheng lee
 * @date 2022-09-11 19:27:40
 */

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleDao, Article> implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Override
    public List<ArchiveDTO> listArchives() {
        // 获取分页数据
        List<Article> articles = articleDao.selectList(new LambdaQueryWrapper<Article>().
                select(Article::getId, Article::getArticleTitle, Article::getCreateTime)
                .eq(Article::getStatus, PUBLIC.getStatus())
                .orderByDesc(Article::getCreateTime));

        // 封装为DTO
        // ArrayList<ArchiveDTO> archiveDTOS = new ArrayList<>();
        // for (Article article : articles) {
        //     ArchiveDTO archiveDTO = new ArchiveDTO();
        //     BeanUtils.copyProperties(article,archiveDTO);
        //     archiveDTOS.add(archiveDTO);
        // }
        List<ArchiveDTO> archiveDTOS = BeanCopyUtils.copyList(articles, ArchiveDTO.class);

        return archiveDTOS;
    }

}
