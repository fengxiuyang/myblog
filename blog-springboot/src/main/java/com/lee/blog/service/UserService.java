package com.lee.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lee.blog.entity.User;
import com.lee.blog.vo.ResponseResult;

/**
 * 用户
 *
 * @author: zhicheng lee
 * @date: 2022/9/17 9:24
 */

public interface UserService extends IService<User> {

    ResponseResult userInfo();

    ResponseResult updateUserInfo(User user);
}

