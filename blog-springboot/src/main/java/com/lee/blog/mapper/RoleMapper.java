package com.lee.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lee.blog.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 角色
 *
 * @author: zhicheng lee
 * @date: 2022/9/29 20:55
 */

@Repository
public interface RoleMapper extends BaseMapper<Role> {
    List<String> selectRoleKeyByUserId(Long id);
}
