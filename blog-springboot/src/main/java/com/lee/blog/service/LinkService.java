package com.lee.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lee.blog.entity.Link;
import com.lee.blog.vo.ResponseResult;

/**
 * 友链
 *
 * @author: zhicheng lee
 * @date: 2022/9/25 14:48
 */

public interface LinkService extends IService<Link> {
    ResponseResult getAllLink();
}
