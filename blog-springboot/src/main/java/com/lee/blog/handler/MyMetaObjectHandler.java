package com.lee.blog.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.lee.blog.util.SecurityUtils;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 配置 mybatis plus 自动填充
 *
 * @author: zhicheng lee
 * @date: 2022/9/30 20:46
 */

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        Long userId = SecurityUtils.getUserId();

        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("createBy", userId, metaObject);
        this.setFieldValByName("updateTime", new Date(), metaObject);
        this.setFieldValByName("updateBy", userId, metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", new Date(), metaObject);
        // this.setFieldValByName("updateBy", SecurityUtils.getUserId(), metaObject);
    }
}
