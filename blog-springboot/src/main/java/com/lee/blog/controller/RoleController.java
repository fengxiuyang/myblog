package com.lee.blog.controller;

import com.lee.blog.entity.Role;
import com.lee.blog.service.RoleService;
import com.lee.blog.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 角色
 *
 * @author: zhicheng lee
 * @date: 2022/10/1 22:02
 */

@RestController
@RequestMapping("/system/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 角色列表
     */
    @GetMapping("/listAllRole")
    public ResponseResult listAllRole() {
        List<Role> roles = roleService.selectRoleAll();
        return ResponseResult.okResult(roles);
    }

    /**
     * 获取角色信息
     */
    @GetMapping(value = "/{roleId}")
    public ResponseResult getInfo(@PathVariable Long roleId) {
        Role role = roleService.getById(roleId);
        return ResponseResult.okResult(role);
    }

    /**
     * 修改角色
     */
    @PutMapping
    public ResponseResult edit(@RequestBody Role role) {
        roleService.updateRole(role);
        return ResponseResult.okResult();
    }

}
