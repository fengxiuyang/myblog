package com.lee.blog.filter;

import com.alibaba.fastjson.JSON;
import com.lee.blog.dto.UserDetailDTO;
import com.lee.blog.enums.StatusCodeEnum;
import com.lee.blog.service.RedisService;
import com.lee.blog.util.JwtUtils;
import com.lee.blog.vo.Result;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

import static com.lee.blog.constant.CommonConst.APPLICATION_JSON;

/**
 * @author: zhicheng lee
 * @date: 2022/9/20 21:33
 */

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    RedisService redisService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 获取请求头中的token
        String token = request.getHeader("token");

        // 若没有token，则放行，交给security后边的filter处理
        if(!StringUtils.hasText(token)){
            filterChain.doFilter(request,response);
            return ;
        }
        
        // 解析并获取userid
        Claims claims=null;

        try{
            claims= JwtUtils.parseJWT(token);
        }catch (Exception e){
            // token超时、非法等
            // 前端需要重新登陆
            response.setContentType(APPLICATION_JSON);
            response.getWriter().write(JSON.toJSONString(Result.fail(StatusCodeEnum.NO_LOGIN)));
            return ;
        }

        // 根据userid，从redis中获取用户信息
        String userId=claims.getSubject();
        UserDetailDTO userDetailDTO= (UserDetailDTO) redisService.get("bloglogin:"+userId);
        
        // 如果获取不到，说明登陆过期
        if(Objects.isNull(userDetailDTO)){
            response.setContentType(APPLICATION_JSON);
            response.getWriter().write(JSON.toJSONString(Result.fail(StatusCodeEnum.NO_LOGIN)));
            return ;
        }

        // 如果可以获取，则存入SecurityContextHolder
        UsernamePasswordAuthenticationToken authenticationToken=new UsernamePasswordAuthenticationToken(userDetailDTO,null,null);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        // 放行
        filterChain.doFilter(request,response);
    }
}
