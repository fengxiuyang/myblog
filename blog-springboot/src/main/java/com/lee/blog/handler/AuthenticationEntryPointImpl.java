package com.lee.blog.handler;

import com.alibaba.fastjson.JSON;
import com.lee.blog.vo.Result;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.lee.blog.constant.CommonConst.APPLICATION_JSON;
import static com.lee.blog.enums.StatusCodeEnum.NO_LOGIN;

/**
 * 用户权限处理
 *
 * @author: zhicheng lee
 * @date: 2022/9/20 22:59
 */

@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setContentType(APPLICATION_JSON);
        response.getWriter().write(JSON.toJSONString(Result.fail(NO_LOGIN)));
    }
}
