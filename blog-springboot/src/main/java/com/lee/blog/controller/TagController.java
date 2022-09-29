package com.lee.blog.controller;

import com.lee.blog.dto.AddTagDto;
import com.lee.blog.dto.TagListDto;
import com.lee.blog.service.TagService;
import com.lee.blog.vo.PageVo;
import com.lee.blog.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 标签
 *
 * @author: zhicheng lee
 * @date: 2022/9/28 21:13
 */

@RestController
@RequestMapping("/content/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    /**
     * 查询标签
     */
    @GetMapping("/list")
    public ResponseResult<PageVo> list(Integer pageNum, Integer pageSize, TagListDto tagListDto) {
        return tagService.pageTagList(pageNum, pageSize, tagListDto);
    }

    /**
     * 新增标签
     */
    @PostMapping
    public ResponseResult add(@RequestBody AddTagDto tagDto) {
        return tagService.add(tagDto);
    }

}
