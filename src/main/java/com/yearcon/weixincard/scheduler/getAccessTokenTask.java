package com.yearcon.weixincard.scheduler;

import com.alibaba.fastjson.JSONPath;
import com.yearcon.weixincard.config.WXProperties;
import com.yearcon.weixincard.consts.WxCardUrl;
import com.yearcon.weixincard.enums.ResultEnum;
import com.yearcon.weixincard.exception.MyException;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

/**
 * @author itguang
 * @create 2017-12-18 16:21
 **/
@Controller
@Slf4j
public class getAccessTokenTask {



    @Autowired
    private WxMpService wxMpService;


    /**
     * 每小时刷新一次
     */
   // @Scheduled(fixedDelay = 1000*60*60)
    public void   getTokenTask(){

        String now = LocalDateTime.now().toString();

        String access_token = null;
        try {
            access_token = wxMpService.getAccessToken(true);
            log.info("[定时任务:] {} 刷新了access_token = {}",now,access_token);
        } catch (WxErrorException e) {
            e.printStackTrace();
            log.info("[定时任务异常:] {} 刷新了access_token = {}",now,access_token);
            throw new MyException(ResultEnum.ACCESSTOKENERROR);
        }





    }

}
