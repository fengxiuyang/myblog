package com.lee.blog.util;

import com.lee.blog.dto.UserDetailsDto;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * security工具类
 *
 * @author: zhicheng lee
 * @date: 2022/9/17 9:24
 */

public class SecurityUtils {

    /**
     * 获取用户
     **/
    public static UserDetailsDto getLoginUser() {
        return (UserDetailsDto) getAuthentication().getPrincipal();
    }

    /**
     * 获取Authentication
     */
    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public static Boolean isAdmin() {
        Long id = getLoginUser().getUser().getId();
        return id != null && id.equals(1L);
    }

    public static Long getUserId() {
        return getLoginUser().getUser().getId();
    }
}