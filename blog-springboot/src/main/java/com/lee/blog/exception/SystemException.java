package com.lee.blog.exception;

import com.lee.blog.enums.AppHttpCodeEnum;

/**
 * 系统异常
 *
 * @author: zhicheng lee
 * @date: 2022/9/17 22:11
 */

public class SystemException extends RuntimeException {

    /**
     * 错误码
     */
    private int code;

    /**
     * 错误信息
     */
    private String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public SystemException(AppHttpCodeEnum httpCodeEnum) {
        super(httpCodeEnum.getMsg());
        this.code = httpCodeEnum.getCode();
        this.msg = httpCodeEnum.getMsg();
    }

}
