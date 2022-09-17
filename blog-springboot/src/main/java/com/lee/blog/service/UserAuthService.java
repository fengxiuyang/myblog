package com.lee.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lee.blog.entity.UserAuth;
import com.lee.blog.vo.LoginVO;

/**
 * 用户账号
 *
 * @author: zhicheng lee
 * @date: 2022/9/17 15:58
 */

public interface UserAuthService extends IService<UserAuth> {
    public LoginVO login(UserAuth userAuth);
}
