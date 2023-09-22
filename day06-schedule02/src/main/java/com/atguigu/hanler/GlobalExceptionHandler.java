package com.atguigu.hanler;

import com.atguigu.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;


public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public Result handException(Exception e){
        //打印异常
        logger.error(e.getMessage());
        return Result.error();
    }


    @ExceptionHandler(BindException.class)
    public Result handleBindException(BindException bindException){
        logger.error(bindException.getMessage());

        //1. 获取异常信息
        List<FieldError> fieldErrors = bindException.getFieldErrors();
        return Result.error(fieldErrors);

    }
}
