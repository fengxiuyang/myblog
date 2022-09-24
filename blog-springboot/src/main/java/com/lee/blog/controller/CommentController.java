package com.lee.blog.controller;

import com.lee.blog.constants.SystemConstants;
import com.lee.blog.dto.AddCommentDto;
import com.lee.blog.entity.Comment;
import com.lee.blog.service.CommentService;
import com.lee.blog.util.BeanCopyUtils;
import com.lee.blog.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 评论
 *
 * @author: zhicheng lee
 * @date: 2022/9/24 16:47
 */

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    /**
     * 查询评论
     */
    @GetMapping("/commentList")
    public ResponseResult commentList(Long articleId, Integer pageNum, Integer pageSize){
        return commentService.commentList(SystemConstants.ARTICLE_COMMENT,articleId,pageNum,pageSize);
    }

    /**
     * 发表评论
     */
    @PostMapping
    public ResponseResult addComment(@RequestBody AddCommentDto addCommentDto){
        Comment comment = BeanCopyUtils.copyBean(addCommentDto, Comment.class);
        return commentService.addComment(comment);
    }

}
