package com.lee.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lee.blog.dto.ArchiveDTO;
import com.lee.blog.entity.Article;

import java.util.List;

/**
 * 文章
 *
 * @author zhicheng lee
 * @date 2022-09-11 19:27:40
 */
public interface ArticleService extends IService<Article> {

    List<ArchiveDTO> listArchives(Integer pageNum, Integer pageSize);
}
