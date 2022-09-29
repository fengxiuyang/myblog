package com.lee.blog.service.impl;

import com.lee.blog.dto.UserDetailsDto;
import com.lee.blog.entity.Menu;
import com.lee.blog.entity.User;
import com.lee.blog.service.LoginService;
import com.lee.blog.service.MenuService;
import com.lee.blog.service.RoleService;
import com.lee.blog.util.BeanCopyUtils;
import com.lee.blog.util.JwtUtils;
import com.lee.blog.util.RedisCache;
import com.lee.blog.util.SecurityUtils;
import com.lee.blog.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * 后台登陆
 *
 * @author: zhicheng lee
 * @date: 2022/9/17 9:24
 */

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private MenuService menuService;

    @Autowired
    private RoleService roleService;

    @Override
    public ResponseResult login(User user) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        //判断是否认证通过
        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("用户名或密码错误");
        }
        //获取userid 生成token
        UserDetailsDto userDetailsDto = (UserDetailsDto) authenticate.getPrincipal();
        String userId = userDetailsDto.getUser().getId().toString();
        String jwt = JwtUtils.createJWT(userId);
        //把用户信息存入redis
        redisCache.setCacheObject("login:" + userId, userDetailsDto);

        //把token和userinfo封装 返回
        //把User转换成UserInfoVo
        UserInfoVo userInfoVo = BeanCopyUtils.copyBean(userDetailsDto.getUser(), UserInfoVo.class);
        BlogUserLoginVo vo = new BlogUserLoginVo(jwt, userInfoVo);
        return ResponseResult.okResult(vo);
    }

    @Override
    public ResponseResult getInfo() {
        // 获取当前登陆的用户
        UserDetailsDto userDetailsDto = SecurityUtils.getLoginUser();

        // 根据用户id查询权限信息
        List<String> perms = menuService.selectPermsByUserId(userDetailsDto.getUser().getId());

        // 根据用户id查询角色信息
        List<String> roleKeyList = roleService.selectRoleKeyByUserId(userDetailsDto.getUser().getId());

        // 获取用户信息
        User user = userDetailsDto.getUser();
        UserInfoVo userInfoVo = BeanCopyUtils.copyBean(user, UserInfoVo.class);

        // 封装数据返回
        AdminUserInfoVo adminUserInfoVo = new AdminUserInfoVo(perms, roleKeyList, userInfoVo);
        return ResponseResult.okResult(adminUserInfoVo);
    }

    @Override
    public ResponseResult<RoutersVo> getRouters() {
        Long userId = SecurityUtils.getUserId();
        //查询menu 结果是tree的形式
        List<Menu> menus = menuService.selectRouterMenuTreeByUserId(userId);
        //封装数据返回
        return ResponseResult.okResult(new RoutersVo(menus));
    }

    @Override
    public ResponseResult logout() {
        //获取当前登录的用户id
        Long userId = SecurityUtils.getUserId();
        //删除redis中对应的值
        redisCache.deleteObject("login:" + userId);
        return ResponseResult.okResult();
    }
}
