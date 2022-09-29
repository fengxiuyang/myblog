package com.lee.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lee.blog.entity.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 菜单
 *
 * @author: zhicheng lee
 * @date: 2022/9/29 20:54
 */

@Repository
public interface MenuMapper extends BaseMapper<Menu> {
    List<String> selectPermsByUserId(Long userId);

    List<Menu> selectAllRouterMenu();

    List<Menu> selectRouterMenuTreeByUserId(Long userId);
}
