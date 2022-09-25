package com.lee.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.blog.constants.SystemConstants;
import com.lee.blog.entity.Link;
import com.lee.blog.mapper.LinkMapper;
import com.lee.blog.service.LinkService;
import com.lee.blog.util.BeanCopyUtils;
import com.lee.blog.vo.LinkVo;
import com.lee.blog.vo.ResponseResult;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 友链
 *
 * @author: zhicheng lee
 * @date: 2022/9/25 14:53
 */

@Service
public class LinkServiceImpl extends ServiceImpl<LinkMapper, Link> implements LinkService {
    @Override
    public ResponseResult getAllLink() {
        // 查询条件
        LambdaQueryWrapper<Link> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Link::getStatus, SystemConstants.LINK_STATUS_NORMAL);

        // 查询，并封装为VO
        List<Link> linkList = list(queryWrapper);
        List<LinkVo> linkVoList = BeanCopyUtils.copyBeanList(linkList, LinkVo.class);

        return ResponseResult.okResult(linkVoList);
    }
}
