package com.yearcon.weixincard.consts;

/**
 *
 * 创建微信卡券的接口
 * @author itguang
 * @create 2017-12-18 14:32
 **/
public class WxCardUrl {


    /**
     * 上传LOGO接口
     *
     * 接口调用请求说明:
     *HTTP请求方式: POST/FROMURL:https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=ACCESS_TOKEN
     *
     * 参数	        是否必须	说明
       buffer	     是	    文件的数据流
       access_token	 是	    调用接口凭证
     */
    public static String UPLOADLOGO = "https://api.weixin.qq.com/cgi-bin/media/uploadimg";

    /**
     * 创建卡券接口
     *
     * 接口调用请求说明
     *  HTTP请求方式: POSTURL: https://api.weixin.qq.com/card/create?access_token=ACCESS_TOKEN
     *
     *  参数	           是否必须	说明
        access_token	是	    调用接口凭证
         POST数据	   是	    Json数据
     *
     */
    public static String CREATE = "https://api.weixin.qq.com/card/create";

    /**
     * http://api.weixin.qq.com/card/code/deposit?access_token=ACCESS_TOKEN
     */
    public static String importCode = "http://api.weixin.qq.com/card/code/deposit";








}
