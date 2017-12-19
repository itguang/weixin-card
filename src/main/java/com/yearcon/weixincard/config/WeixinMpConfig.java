package com.yearcon.weixincard.config;

import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author itguang
 * @create 2017-12-18 8:29
 **/
@Component
public class WeixinMpConfig {

    @Autowired
    private WXProperties wxProperties;


    @Bean
    public WxMpService wxMpService() {
        WxMpServiceImpl wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxMpInMemoryConfigStorage());
        return wxMpService;
    }

    @Bean
    public WxMpInMemoryConfigStorage wxMpInMemoryConfigStorage() {
        WxMpInMemoryConfigStorage wxMpInMemoryConfigStorage = new WxMpInMemoryConfigStorage();
        wxMpInMemoryConfigStorage.setAppId(wxProperties.getAppid());
        wxMpInMemoryConfigStorage.setSecret(wxProperties.getAppsecret());

        return wxMpInMemoryConfigStorage;
    }


}
