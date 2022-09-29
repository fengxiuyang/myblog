package com.lee.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lee.blog.dto.TagListDto;
import com.lee.blog.entity.Tag;
import com.lee.blog.vo.PageVo;
import com.lee.blog.vo.ResponseResult;

/**
 * 标签
 *
 * @author: zhicheng lee
 * @date: 2022/9/28 21:11
 */

public interface TagService extends IService<Tag> {
    ResponseResult<PageVo> pageTagList(Integer pageNum, Integer pageSize, TagListDto tagListDto);
}
