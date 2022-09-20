package com.lee.blog.handler;

import com.alibaba.fastjson.JSON;
import com.lee.blog.vo.Result;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.lee.blog.constant.CommonConst.APPLICATION_JSON;
import static com.lee.blog.enums.StatusCodeEnum.AUTHORIZED;

/**
 * 用户权限处理
 *
 * @author: zhicheng lee
 * @date: 2022/9/20 22:54
 */

@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setContentType(APPLICATION_JSON);
        response.getWriter().write(JSON.toJSONString(Result.fail(AUTHORIZED)));
    }
}
