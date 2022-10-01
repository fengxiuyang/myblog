package com.lee.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.blog.entity.RoleMenu;
import com.lee.blog.mapper.RoleMenuMapper;
import com.lee.blog.service.RoleMenuService;
import org.springframework.stereotype.Service;

/**
 * 角色菜单
 *
 * @author: zhicheng lee
 * @date: 2022/10/1 22:19
 */

@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements RoleMenuService {
    @Override
    public void deleteRoleMenuByRoleId(Long id) {
        LambdaQueryWrapper<RoleMenu> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(RoleMenu::getRoleId, id);
        remove(queryWrapper);
    }
}
