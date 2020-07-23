package com.znzz.equ.config;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


//异常处理
@ControllerAdvice
public class GlobalExceptionHandler {

    //1.统一异常处理
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R error(Exception e){
        e.printStackTrace();
        return R.error().message("出问题了");
    }


    //自定义异常

    @ExceptionHandler(PlmException.class)
    @ResponseBody
    public  R error(PlmException e){
        e.printStackTrace();
        return R.error().message(e.getMessage()).code(e.getCode());
    }
}