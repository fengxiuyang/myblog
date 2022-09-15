package com.lee.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.blog.dao.ArticleDao;
import com.lee.blog.dto.ArchiveDTO;
import com.lee.blog.entity.Article;
import com.lee.blog.service.ArticleService;
import com.lee.blog.util.BeanCopyUtils;
import com.lee.blog.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public PageResult<ArchiveDTO> listArchives(Integer pageNum, Integer pageSize) {
        // 查询条件
        LambdaQueryWrapper<Article> lambdaQueryWrapper = new LambdaQueryWrapper<Article>().
                select(Article::getId, Article::getArticleTitle, Article::getCreateTime)
                .eq(Article::getStatus, PUBLIC.getStatus())
                .orderByDesc(Article::getCreateTime);

        // 分页查询
        Page<Article> page = new Page<>(pageNum, pageSize);
        page(page, lambdaQueryWrapper);
        List<Article> articles = page.getRecords();

        // 封装为DTO
        List<ArchiveDTO> archiveDTOList = BeanCopyUtils.copyList(articles, ArchiveDTO.class);

        return new PageResult<>(archiveDTOList, (int)page.getTotal());
    }

}
