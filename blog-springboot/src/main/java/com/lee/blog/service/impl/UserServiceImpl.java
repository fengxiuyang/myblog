package com.lee.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.blog.entity.User;
import com.lee.blog.mapper.UserMapper;
import com.lee.blog.service.UserService;
import com.lee.blog.util.BeanCopyUtils;
import com.lee.blog.util.SecurityUtils;
import com.lee.blog.vo.ResponseResult;
import com.lee.blog.vo.UserInfoVo;
import org.springframework.stereotype.Service;

/**
 * 用户
 *
 * @author: zhicheng lee
 * @date: 2022/9/17 9:24
 */

@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public ResponseResult userInfo() {
        // 获取用户id
        Long userId = SecurityUtils.getUserId();

        // 查询用户信息并封装
        User user = getById(userId);
        UserInfoVo userInfoVo = BeanCopyUtils.copyBean(user, UserInfoVo.class);

        return ResponseResult.okResult(userInfoVo);
    }

    @Override
    public ResponseResult updateUserInfo(User user) {
        updateById(user);
        return ResponseResult.okResult();
    }

}

