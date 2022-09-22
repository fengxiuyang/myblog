package com.lee.blog.handler;

import com.lee.blog.exception.BizException;
import com.lee.blog.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

import static com.lee.blog.enums.StatusCodeEnum.SYSTEM_ERROR;
import static com.lee.blog.enums.StatusCodeEnum.VALID_ERROR;

/**
 * 全局异常处理
 *
 * @author: zhicheng lee
 * @date: 2022/9/21 21:47
 */

@Slf4j
@RestControllerAdvice
public class ControllerAdviceHandler {
    /**
     * 处理服务异常
     */
    @ExceptionHandler(value = BizException.class)
    public Result<?> errorHandler(BizException e) {
        //打印异常信息
        log.error("出现了服务异常！ {}",e);
        //从异常对象中获取提示信息封装返回
        return Result.fail(e.getCode(), e.getMessage());
    }

    /**
     * 处理参数校验异常
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result<?> errorHandler(MethodArgumentNotValidException e) {
        //打印异常信息
        log.error("出现了参数校验异常！ {}",e);
        //从异常对象中获取提示信息封装返回
        return Result.fail(VALID_ERROR.getCode(), Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage());
    }

    /**
     * 处理系统异常
     */
    @ExceptionHandler(value = Exception.class)
    public Result<?> errorHandler(Exception e) {
        //打印异常信息
        log.error("出现了系统异常！ {}",e);
        //从异常对象中获取提示信息封装返回
        return Result.fail(SYSTEM_ERROR.getCode(), SYSTEM_ERROR.getDesc());
    }
}
