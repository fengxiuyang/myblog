package com.lee.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.lee.blog.dao.UserAuthDao;
import com.lee.blog.dto.UserDetailDTO;
import com.lee.blog.entity.UserAuth;
import com.lee.blog.exception.BizException;
import com.lee.blog.util.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @author: zhicheng lee
 * @date: 2022/9/17 22:07
 */

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    UserAuthDao userAuthDao;
    @Resource
    private HttpServletRequest request;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 用户名不能为空
        if (StringUtils.isBlank(username)) {
            throw new BizException("用户名不能为空！");
        }

        // 查询账号是否存在
        UserAuth userAuth = userAuthDao.selectOne(new LambdaQueryWrapper<UserAuth>()
                .select(UserAuth::getId, UserAuth::getUserInfoId, UserAuth::getUsername, UserAuth::getPassword, UserAuth::getLoginType)
                .eq(UserAuth::getUsername, username));

        // 若账号不存在，抛出异常
        if (Objects.isNull(userAuth)) {
            throw new BizException("用户名不存在！");
        }

        // 封装登陆信息
        return convertUserDetail(userAuth, request);
    }

    /**
     * 封装用户登录信息
     */
    public UserDetailDTO convertUserDetail(UserAuth user, HttpServletRequest request) {
        // TODO：目前只强转类型，等后期添加其它相关类之后再做补充
        return BeanCopyUtils.copyObject(user,UserDetailDTO.class);
    }
}
