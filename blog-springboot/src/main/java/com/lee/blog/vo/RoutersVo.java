package com.lee.blog.vo;

import com.lee.blog.entity.Menu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 用户可访问菜单信息
 *
 * @author: zhicheng lee
 * @date: 2022/9/29 21:35
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoutersVo {

    private List<Menu> menus;
}
