package com.lee.blog.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登陆信息
 *
 * @author: zhicheng lee
 * @date: 2022/9/17 21:31
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginVO {

    private String token;
    private UserInfoVO userInfo;
}
