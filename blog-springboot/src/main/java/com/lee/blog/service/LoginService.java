package com.lee.blog.service;

import com.lee.blog.entity.User;
import com.lee.blog.vo.ResponseResult;
import com.lee.blog.vo.RoutersVo;

/**
 * 后台登陆
 *
 * @author: zhicheng lee
 * @date: 2022/9/17 9:24
 */

public interface LoginService {
    ResponseResult login(User user);

    ResponseResult getInfo();

    ResponseResult<RoutersVo> getRouters();

}
