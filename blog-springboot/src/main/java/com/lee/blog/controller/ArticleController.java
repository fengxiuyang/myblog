package com.lee.blog.controller;

import com.lee.blog.dto.ArchiveDTO;
import com.lee.blog.service.ArticleService;
import com.lee.blog.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 文章
 *
 * @author zhicheng lee
 * @date 2022-09-11 19:27:33
 */

@RestController
@RequestMapping("/articles")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    /**
     * 查看文章归档
     *
     * @return {@link Result<ArchiveDTO>} 文章归档列表
     */
    @ApiOperation(value = "查看文章归档")
    @GetMapping("archives")
    public Result<List<ArchiveDTO>> listArchives(Integer pageNum, Integer pageSize) {
        return Result.ok(articleService.listArchives(pageNum, pageSize));
    }
}

