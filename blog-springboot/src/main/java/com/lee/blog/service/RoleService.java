package com.lee.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lee.blog.entity.Role;

import java.util.List;

/**
 * 角色
 *
 * @author: zhicheng lee
 * @date: 2022/9/29 20:53
 */

public interface RoleService extends IService<Role> {
    List<String> selectRoleKeyByUserId(Long id);

    List<Role> selectRoleAll();

    void updateRole(Role role);

    void insertRole(Role role);
}
