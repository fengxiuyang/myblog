package com.lee.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lee.blog.entity.Tag;
import org.springframework.stereotype.Repository;

/**
 * 标签
 *
 * @author: zhicheng lee
 * @date: 2022/9/28 21:10
 */

@Repository
public interface TagMapper extends BaseMapper<Tag> {
}
