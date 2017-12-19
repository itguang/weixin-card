package com.yearcon.weixincard.exception;

import com.yearcon.weixincard.enums.ResultEnum;
import lombok.Data;

/**
 * @author itguang
 * @create 2017-12-18 14:17
 **/
@Data
public class MyException extends RuntimeException {


    /**
     * 自定义状态码
     */
    private Integer code;

    public MyException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        code = resultEnum.getCode();
    }
}
