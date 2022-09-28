package com.lee.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lee.blog.entity.Comment;
import org.springframework.stereotype.Repository;

/**
 * 评论
 *
 * @author: zhicheng lee
 * @date: 2022/9/24 16:51
 */

@Repository
public interface CommentMapper extends BaseMapper<Comment> {
}
