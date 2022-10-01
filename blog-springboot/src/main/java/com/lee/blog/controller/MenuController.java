package com.lee.blog.controller;

import com.lee.blog.entity.Menu;
import com.lee.blog.service.MenuService;
import com.lee.blog.util.SystemConverter;
import com.lee.blog.vo.MenuTreeVo;
import com.lee.blog.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 菜单
 *
 * @author: zhicheng lee
 * @date: 2022/10/1 14:47
 */

@RestController
@RequestMapping("/system/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    /**
     * 获取菜单下拉树列表
     */
    @GetMapping("/treeselect")
    public ResponseResult treeselect() {
        List<Menu> menus = menuService.selectMenuList(new Menu());
        List<MenuTreeVo> options = SystemConverter.buildMenuSelectTree(menus);
        return ResponseResult.okResult(options);
    }
}
