package com.lee.blog.config;

import com.lee.blog.filter.JwtAuthenticationTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * spring security配置类
 *
 * @author: zhicheng lee
 * @date: 2022/9/17 17:32
 */

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Autowired
    AccessDeniedHandler accessDeniedHandler;

    @Autowired
    AuthenticationEntryPoint authenticationEntryPoint;

    /**
     * 配置加密方式
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 配置权限
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // 关闭csrf，防止csrf攻击
                .csrf().disable()
                // 使用token认证，不使用session，因此关闭session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                // 配置请求相关的认证
                .authorizeRequests()
                // 登陆接口允许匿名访问
                .antMatchers("/login").anonymous()
                .antMatchers("/user/login").anonymous()
                // 退出接口需要有认证才可以访问
                .antMatchers("/logout").authenticated()
                .antMatchers("/user/logout").authenticated()
                .antMatchers("/user/userInfo").authenticated()
                .antMatchers("/getInfo").authenticated()
                .antMatchers("/getRouters").authenticated()
                .antMatchers("/article").authenticated()
                .antMatchers("/upload").authenticated()
                // 其它全部请求，不需要认证即可访问
                .anyRequest().permitAll();

        // 添加过滤器
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

        // 配置异常处理器
        http.exceptionHandling()
                // 配置认证失败处理器
                .authenticationEntryPoint(authenticationEntryPoint)
                // 配置权限不足处理器
                .accessDeniedHandler(accessDeniedHandler);

        //关闭默认的注销功能
        http.logout().disable();

        // 允许跨域
        http.cors();
    }

    /**
     * 引入AuthenticationManager接口，用于认证Authentication的方法
     */
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
