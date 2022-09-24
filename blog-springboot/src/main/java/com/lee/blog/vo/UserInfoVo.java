package com.lee.blog.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 用户信息接口
 *
 * @author: zhicheng lee
 * @date: 2022/9/17 9:24
 */

@Data
@Accessors(chain = true)
public class UserInfoVo {
    /**
     * 主键
     */
    private Long id;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 头像
     */
    private String avatar;

    private String sex;

    private String email;


}