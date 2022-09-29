package com.lee.blog.controller;

import com.lee.blog.entity.User;
import com.lee.blog.enums.AppHttpCodeEnum;
import com.lee.blog.exception.SystemException;
import com.lee.blog.service.LoginService;
import com.lee.blog.vo.ResponseResult;
import com.lee.blog.vo.RoutersVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 后台登陆
 *
 * @author: zhicheng lee
 * @date: 2022/9/17 15:52
 */

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    /**
     * 登陆
     */
    @PostMapping("/user/login")
    public ResponseResult login(@RequestBody User user) {
        if (!StringUtils.hasText(user.getUserName())) {
            //提示 必须要传用户名
            throw new SystemException(AppHttpCodeEnum.REQUIRE_USERNAME);
        }
        return loginService.login(user);
    }

    /**
     * 获取用户权限信息
     */
    @GetMapping("/getInfo")
    public ResponseResult getInfo(){
        return loginService.getInfo();
    }

    /**
     * 返回用户可访问的菜单信息
     */
    @GetMapping("/getRouters")
    public ResponseResult<RoutersVo> getRouters(){
        return loginService.getRouters();
    }

}
