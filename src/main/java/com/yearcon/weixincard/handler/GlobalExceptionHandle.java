package com.yearcon.weixincard.handler;

import com.yearcon.weixincard.exception.MyException;
import com.yearcon.weixincard.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author itguang
 * @create 2017-12-18 14:23
 **/

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandle {


    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public Result handleSportException(MyException e) {

        log.error("[自定义全局异常:MyException=]:" + e.getCode() + ":" + e.getMessage());
        return new Result(e.getCode(), e.getMessage());
    }
}
