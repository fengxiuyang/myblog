package com.lee.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lee.blog.entity.Comment;
import com.lee.blog.vo.ResponseResult;

/**
 * 评论
 *
 * @author: zhicheng lee
 * @date: 2022/9/24 16:48
 */

public interface CommentService extends IService<Comment> {

    ResponseResult commentList(String commentType, Long articleId, Integer pageNum, Integer pageSize);

    ResponseResult addComment(Comment comment);
}
