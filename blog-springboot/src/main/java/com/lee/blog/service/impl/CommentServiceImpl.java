package com.lee.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.blog.entity.Comment;
import com.lee.blog.enums.AppHttpCodeEnum;
import com.lee.blog.exception.SystemException;
import com.lee.blog.mapper.CommentMapper;
import com.lee.blog.service.CommentService;
import com.lee.blog.service.UserService;
import com.lee.blog.util.BeanCopyUtils;
import com.lee.blog.vo.CommentVo;
import com.lee.blog.vo.PageVo;
import com.lee.blog.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 评论
 *
 * @author: zhicheng lee
 * @date: 2022/9/24 16:50
 */

@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Autowired
    UserService userService;

    @Override
    public ResponseResult commentList(String commentType, Long articleId, Integer pageNum, Integer pageSize) {
        // 查询条件
        LambdaQueryWrapper<Comment> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Comment::getRootId, -1)
                .eq(Comment::getArticleId, articleId)
                .eq(Comment::getType, commentType);

        // 分页查询
        Page<Comment> page = new Page<>(pageNum, pageSize);
        page(page, queryWrapper);

        List<CommentVo> commentVoList = toCommentVoList(page.getRecords());

        // 查询子评论
        for (CommentVo commentVo : commentVoList) {
            commentVo.setChildren(getChildren(commentVo.getId()));
        }

        // 封装为VO并返回
        return ResponseResult.okResult(new PageVo(commentVoList, page.getTotal()));
    }

    @Override
    public ResponseResult addComment(Comment comment) {
        //评论内容不能为空
        if(!StringUtils.hasText(comment.getContent())){
            throw new SystemException(AppHttpCodeEnum.CONTENT_NOT_NULL);
        }
        save(comment);
        return ResponseResult.okResult();
    }

    /**
     * 根据评论id查询子评论
     */
    private List<CommentVo> getChildren(Long id) {
        // 查询条件
        LambdaQueryWrapper<Comment> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Comment::getRootId, id)
                .orderByAsc(Comment::getCreateTime);

        // 查询子评论
        List<Comment> commentList = list(queryWrapper);
        List<CommentVo> commentVoList = toCommentVoList(commentList);

        return commentVoList;
    }

    /**
     * 将评论列表封装为VO
     */
    private List<CommentVo> toCommentVoList(List<Comment> list) {
        List<CommentVo> commentVoList = BeanCopyUtils.copyBeanList(list, CommentVo.class);

        for (CommentVo commentVo : commentVoList) {
            // 查询nickname
            String nickname = userService.getById(commentVo.getCreateBy()).getNickName();
            commentVo.setUsername(nickname);

            // 若本评论为子评论，查询回复评论的nickname
            if (commentVo.getToCommentUserId() != -1) {
                String toCommentUserName = userService.getById(commentVo.getToCommentUserId()).getNickName();
                commentVo.setToCommentUserName(toCommentUserName);
            }

            // 查询子评论
            // 不能在此处查询子评论，子评论只查询一层即可，写在此处会导致循环查询子评论
            // commentVo.setChildren(getChildren(commentVo.getId()));
        }

        return commentVoList;
    }
}
