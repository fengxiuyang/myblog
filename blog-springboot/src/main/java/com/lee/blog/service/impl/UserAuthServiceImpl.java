package com.lee.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.blog.dao.UserAuthDao;
import com.lee.blog.dto.UserDetailDTO;
import com.lee.blog.entity.UserAuth;
import com.lee.blog.service.RedisService;
import com.lee.blog.service.UserAuthService;
import com.lee.blog.util.BeanCopyUtils;
import com.lee.blog.util.JwtUtils;
import com.lee.blog.vo.LoginVO;
import com.lee.blog.vo.UserInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * 用户账号
 *
 * @author: zhicheng lee
 * @date: 2022/9/17 15:58
 */

@Service
public class UserAuthServiceImpl extends ServiceImpl<UserAuthDao, UserAuth> implements UserAuthService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisService redisService;

    @Override
    public LoginVO login(UserAuth userAuth) {
        // 封装authenticationToken，通过authenticationManager验证后，获取authentication对象
        UsernamePasswordAuthenticationToken authenticationToken = new
                UsernamePasswordAuthenticationToken(userAuth.getUsername(), userAuth.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);

        // 判断认证是否通过
        if (Objects.isNull(authentication)) {
            throw new RuntimeException("用户名或密码错误");
        }

        // 获取userid生成的token
        UserDetailDTO userDetailDTO = (UserDetailDTO) authentication.getPrincipal();
        String userId = userDetailDTO.getId().toString();
        String jwt = JwtUtils.createJWT(userId);

        // 把用户信息存入redis
        redisService.set("bloglogin:" + userId, userDetailDTO);

        // 封装 jwt 和 userDetailDTO
        UserInfoVO userInfoVO = BeanCopyUtils.copyObject(userDetailDTO, UserInfoVO.class);
        LoginVO loginVO=new LoginVO(jwt,userInfoVO);
        return loginVO;
    }
}
