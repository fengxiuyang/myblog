package com.lee.blog.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 评论
 *
 * @author: zhicheng lee
 * @date: 2022/9/24 16:42
 */

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sg_comment")
public class Comment  {
    @TableId
    private Long id;

    //评论类型（0代表文章评论，1代表友链评论）
    private String type;

    //文章id
    private Long articleId;

    //根评论id
    private Long rootId;

    //评论内容
    private String content;

    //所回复的目标评论的userid，若为-1，代表为根评论
    private Long toCommentUserId;

    //回复目标评论id
    private Long toCommentId;

    @TableField(fill = FieldFill.INSERT)
    private Long createBy;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateBy;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    //删除标志（0代表未删除，1代表已删除）
    private Integer delFlag;

}
