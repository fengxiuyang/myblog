package com.lee.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.blog.dto.AddTagDto;
import com.lee.blog.dto.TagListDto;
import com.lee.blog.entity.Tag;
import com.lee.blog.mapper.TagMapper;
import com.lee.blog.service.TagService;
import com.lee.blog.util.BeanCopyUtils;
import com.lee.blog.vo.PageVo;
import com.lee.blog.vo.ResponseResult;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * 标签
 *
 * @author: zhicheng lee
 * @date: 2022/9/28 21:12
 */

@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

    @Override
    public ResponseResult<PageVo> pageTagList(Integer pageNum, Integer pageSize, TagListDto tagListDto) {
        // 分页查询
        LambdaQueryWrapper<Tag> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(StringUtils.hasText(tagListDto.getName()),Tag::getName,tagListDto.getName());
        queryWrapper.eq(StringUtils.hasText(tagListDto.getRemark()),Tag::getRemark,tagListDto.getRemark());

        Page<Tag> page = new Page<>();
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        page(page, queryWrapper);

        // 封装数据返回
        PageVo pageVo = new PageVo(page.getRecords(),page.getTotal());
        return ResponseResult.okResult(pageVo);
    }

    @Override
    public ResponseResult add(AddTagDto tagDto) {
        Tag tag = BeanCopyUtils.copyBean(tagDto, Tag.class);
        save(tag);
        return ResponseResult.okResult();
    }
}
