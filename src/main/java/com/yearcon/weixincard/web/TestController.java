package com.yearcon.weixincard.web;

import com.yearcon.weixincard.config.WXProperties;
import com.yearcon.weixincard.enums.ResultEnum;
import com.yearcon.weixincard.exception.MyException;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpCardService;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author itguang
 * @create 2017-12-18 8:18
 **/

@Controller
@Slf4j
public class TestController {

//    @Autowired
//    private WXProperties wxProperties;
//
//
//    @Autowired
//    private WxMpService wxMpService;
//
//
//    @Autowired
//    private WxMpInMemoryConfigStorage wxMpInMemoryConfigStorage;
//
//
//    @RequestMapping("/authorize")
//    public String authorize(HttpServletRequest request) {
//
//        //1.得到请求的 服务器域名
//        String serverName = request.getServerName();
//
//        //构造微信网页授权url
//        String appid = wxProperties.getAppid();
//        String appsecret = wxProperties.getAppsecret();
//        String redirectUrl = "http://" + serverName + "/card/getAccessToken";
//
//        wxMpInMemoryConfigStorage.setAppId(appid);
//        wxMpInMemoryConfigStorage.setSecret(appsecret);
//
//        wxMpService.setWxMpConfigStorage(wxMpInMemoryConfigStorage);
//        //得到微信网页授权 url
//        String url = wxMpService.oauth2buildAuthorizationUrl(redirectUrl, WxConsts.OAUTH2_SCOPE_BASE, null);
//
//
//        log.info("url={}", url);
//
//        return "redirect:" + url;
//
//    }
//
//
////    @RequestMapping("/getAccessToken")
//    public String getOpenid(@RequestParam("code") String code,
//                            HttpServletResponse response,
//                            HttpServletRequest request) {
//        //1.得到请求的 服务器域名
//        String serverName = request.getServerName();
//
//        String accessToken;
//        try {
//
//            //网页授权后的信息封装在此对象中
//            WxMpOAuth2AccessToken wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
//
//            // 获取  accessToken
//            accessToken = wxMpOAuth2AccessToken.getAccessToken();
//
//            // 刷新access token
//            wxMpOAuth2AccessToken = wxMpService.oauth2refreshAccessToken(wxMpOAuth2AccessToken.getRefreshToken());
//
//            // 得到卡券相关接口
//            WxMpCardService cardService = wxMpService.getCardService();
//
//
//        } catch (WxErrorException e) {
//            log.error("[微信网页授权] 授权失败:={}", e.getError().getErrorMsg());
//            throw new MyException(ResultEnum.WECHATERROR);
//        }
//
//
//        return "redirect:http://" + serverName + "/card/create/" + accessToken;
//    }


}
