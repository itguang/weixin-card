package com.yearcon.weixincard.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {

    SUCCESS(1,"成功"),
    WECHATERROR(100,"微信网页授权出错,请检查appid和secret"),
    ACCESSTOKENERROR(101,"强制刷新accessToken 出现异常"),
    CREATE_CARD_ERR(102,"创建卡券失败,请联系管理员查看日志"),
    GET_ACCESSTOKEN_ERR(103,"获取access_token失败"),
    IMPORT_CODE_ERR(104,"导入code失败,请联系管理员查看日志")
    ;

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
