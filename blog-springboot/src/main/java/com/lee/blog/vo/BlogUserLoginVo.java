package com.lee.blog.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 博客登陆
 *
 * @author: zhicheng lee
 * @date: 2022/9/17 9:24
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogUserLoginVo {

    private String token;
    private com.lee.blog.vo.UserInfoVo userInfo;
}