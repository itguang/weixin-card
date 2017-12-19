package com.yearcon.weixincard.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author itguang
 * @create 2017-12-18 8:23
 **/
@ConfigurationProperties(prefix = "weixin")
@Data
@Component
public class WXProperties {

    private String appid;

    private String appsecret;




}
