package com.yearcon.weixincard.vo;

import com.yearcon.weixincard.enums.ResultEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * 结果集封装
 *
 * @author itguang
 * @create 2017-12-04 13:45
 **/
@Data

public class Result<T> implements Serializable{

    private Integer code;
    private String msg;
    private T data;


    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(ResultEnum resultEnum, T data) {
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
        this.data = data;
    }

    public Result(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
    }

    public static Result success(Object data){
      return   new Result(ResultEnum.SUCCESS,data);
    }

}
