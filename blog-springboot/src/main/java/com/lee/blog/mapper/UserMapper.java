package com.lee.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lee.blog.entity.User;
import org.springframework.stereotype.Repository;

/**
 * 用户
 *
 * @author: zhicheng lee
 * @date: 2022/9/17 10:28
 */

@Repository
public interface UserMapper extends BaseMapper<User> {
}

