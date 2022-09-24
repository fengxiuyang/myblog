package com.lee.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lee.blog.entity.Category;
import com.lee.blog.vo.ResponseResult;

/**
 * 分类
 *
 * @author: zhicheng lee
 * @date: 2022/9/17 9:24
 */

public interface CategoryService extends IService<Category> {


    ResponseResult getCategoryList();

}

