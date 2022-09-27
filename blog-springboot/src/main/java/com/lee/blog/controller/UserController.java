package com.lee.blog.controller;

import com.lee.blog.entity.User;
import com.lee.blog.service.UserService;
import com.lee.blog.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户
 *
 * @author: zhicheng lee
 * @date: 2022/9/25 16:17
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 查询用户信息
     */
    @GetMapping("/userInfo")
    public ResponseResult userInfo(){
        return userService.userInfo();
    }

    /**
     * 更新用户信息
     */
    @PutMapping("/userInfo")
    public ResponseResult updateUserInfo(@RequestBody User user){
        return userService.updateUserInfo(user);
    }

    /**
     * 注册用户信息
     */
    @PostMapping("/register")
    public ResponseResult register(@RequestBody User user){
        return userService.register(user);
    }

}
