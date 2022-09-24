package com.lee.blog.controller;

import com.lee.blog.entity.User;
import com.lee.blog.enums.AppHttpCodeEnum;
import com.lee.blog.exception.SystemException;
import com.lee.blog.service.BlogLoginService;
import com.lee.blog.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 博客登陆
 *
 * @author: zhicheng lee
 * @date: 2022/9/17 15:52
 */

@RestController
public class BlogLoginController {
    @Autowired
    private BlogLoginService blogLoginService;

    /**
     * 登陆
     */
    @PostMapping("/login")
    public ResponseResult login(@RequestBody User user) {
        if (!StringUtils.hasText(user.getUserName())) {
            //提示 必须要传用户名
            throw new SystemException(AppHttpCodeEnum.REQUIRE_USERNAME);
        }
        return blogLoginService.login(user);
    }

    /**
     * 退出
     */
    @PostMapping("/logout")
    public ResponseResult logout() {
        return blogLoginService.logout();
    }
}
