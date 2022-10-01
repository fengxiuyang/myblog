package com.lee.blog.controller;

import com.lee.blog.entity.Menu;
import com.lee.blog.service.MenuService;
import com.lee.blog.util.BeanCopyUtils;
import com.lee.blog.util.SystemConverter;
import com.lee.blog.vo.MenuTreeVo;
import com.lee.blog.vo.MenuVo;
import com.lee.blog.vo.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
     * 条件查询菜单列表
     */
    @GetMapping("/list")
    public ResponseResult list(Menu menu) {
        List<Menu> menus = menuService.selectMenuList(menu);
        List<MenuVo> menuVos = BeanCopyUtils.copyBeanList(menus, MenuVo.class);
        return ResponseResult.okResult(menuVos);
    }

    /**
     * 新增菜单
     */
    @PostMapping
    public ResponseResult add(@RequestBody Menu menu) {
        menuService.save(menu);
        return ResponseResult.okResult();
    }

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
