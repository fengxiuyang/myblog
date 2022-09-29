package com.lee.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lee.blog.entity.Menu;

import java.util.List;

/**
 * 菜单
 *
 * @author: zhicheng lee
 * @date: 2022/9/29 20:52
 */

public interface MenuService extends IService<Menu> {

    List<String> selectPermsByUserId(Long id);

    List<Menu> selectRouterMenuTreeByUserId(Long userId);
}
