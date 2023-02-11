package com.servicebase.handler;

import com.service.base.result.R;
import com.service.base.utils.ExceptionUtils;
import com.servicebase.exception.JavaException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 处理所有的异常
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public R error(Exception e){
        //控制台打印异常
        //e.printStackTrace();
        //log.error(e.getMessage());
        log.error(ExceptionUtils.getMessage(e));
        //返回异常
        return R.error();
    }

    /**
     * 处理数学异常
     */
    @ResponseBody
    @ExceptionHandler(ArithmeticException.class)
    public R arithmeticException(Exception e){
        //控制台打印异常
        //e.printStackTrace();
        //log.error(e.getMessage());
        log.error(ExceptionUtils.getMessage(e));
        //返回异常
        return R.error().message("数学异常");
    }

    /**
     * 自定义异常异常
     */
    @ResponseBody
    @ExceptionHandler(JavaException.class)
    public R JavaException(JavaException e){
        //控制台打印异常
        //e.printStackTrace();
        //log.error(e.getMessage());
        log.error(ExceptionUtils.getMessage(e));
        //返回异常
        return R.error().message(e.getMessage()).code(e.getCode());
    }

}