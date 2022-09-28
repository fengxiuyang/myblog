package com.lee.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.blog.entity.Tag;
import com.lee.blog.mapper.TagMapper;
import com.lee.blog.service.TagService;
import org.springframework.stereotype.Service;

/**
 * 标签
 *
 * @author: zhicheng lee
 * @date: 2022/9/28 21:12
 */

@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {
}
