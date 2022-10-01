package com.lee.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lee.blog.entity.RoleMenu;

/**
 * 角色菜单
 *
 * @author: zhicheng lee
 * @date: 2022/10/1 22:18
 */

public interface RoleMenuService extends IService<RoleMenu> {
    public void deleteRoleMenuByRoleId(Long id);

}
