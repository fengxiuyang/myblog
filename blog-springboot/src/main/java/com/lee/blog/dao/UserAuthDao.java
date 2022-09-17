package com.lee.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lee.blog.entity.UserAuth;
import org.springframework.stereotype.Repository;

/**
 * @author: zhicheng lee
 * @date: 2022/9/17 10:36
 */

@Repository
public interface UserAuthDao extends BaseMapper<UserAuth> {
}
