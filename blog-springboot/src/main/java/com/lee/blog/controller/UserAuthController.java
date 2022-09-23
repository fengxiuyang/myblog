package com.lee.blog.controller;

import com.lee.blog.entity.UserAuth;
import com.lee.blog.service.UserAuthService;
import com.lee.blog.vo.LoginVO;
import com.lee.blog.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户账号控制器
 *
 * @author: zhicheng lee
 * @date: 2022/9/17 15:52
 */

@RestController
public class UserAuthController {
    @Autowired
    private UserAuthService userAuthService;

    @PostMapping("/login")
    public Result<LoginVO> login(@RequestBody UserAuth userAuth){
        return  Result.ok(userAuthService.login(userAuth));
    }

    @PostMapping("/logout")
    public Result<?> logout(){
        return Result.ok(userAuthService.logout());
    }

}
