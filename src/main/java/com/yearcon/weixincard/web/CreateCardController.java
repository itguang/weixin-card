package com.yearcon.weixincard.web;

import com.alibaba.fastjson.JSONPath;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.yearcon.weixincard.consts.WxCardUrl;
import com.yearcon.weixincard.enums.ResultEnum;
import com.yearcon.weixincard.exception.MyException;
import com.yearcon.weixincard.weixinEntity.BaseInfoEntity;
import com.yearcon.weixincard.weixinEntity.CreateCardEntity;
import com.yearcon.weixincard.weixinEntity.WXCodeEntity;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

/**
 * @author itguang
 * @create 2017-12-18 15:01
 **/
@RestController
@Slf4j
public class CreateCardController {



    @Autowired
    private WxMpService wxMpService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;


    /**
     * 创建非预存卡券,
     * @return
     */
//    @RequestMapping("/create")
//    public Map<String,CreateCardEntity> createCard(){
//
//
//
//        CreateCardEntity createCardEntity = new CreateCardEntity();
//
//        //设置 卡券类型为 优惠券
//        createCardEntity.setCard_type("GENERAL_COUPON");
//
//        //设置 BaseInfo
//        CreateCardEntity.GeneralCoupon generalCoupon = createCardEntity.new GeneralCoupon();
//        BaseInfoEntity baseInfoEntity = new BaseInfoEntity();
//        baseInfoEntity.setLogo_url("http://mmbiz.qpic.cn/mmbiz/iaL1LJM1mF9aRKPZJkmG8xXhiaHqkKSVMMWeN3hLut7X7hicFNjakmxibMLGWpXrEXB33367o7zHN0CwngnQY7zb7g/0");
//        baseInfoEntity.setBrand_name("意尔康");
//        baseInfoEntity.setCode_type("CODE_TYPE_QRCODE");
//        baseInfoEntity.setTitle("意尔康新年优惠券");
//        baseInfoEntity.setColor("Color090");
//        baseInfoEntity.setNotice("使用时向服务员出示此券");
//        baseInfoEntity.setService_phone("0371-65732233");
//        baseInfoEntity.setDescription("不可与其他优惠同享");
//
//        BaseInfoEntity.Sku sku = baseInfoEntity.new Sku();
//        sku.setQuantity(5000);
//        baseInfoEntity.setSku(sku);
//
//        BaseInfoEntity.DateInfoEntity dateInfoEntity = new BaseInfoEntity.DateInfoEntity();
//        dateInfoEntity.setBegin_time_stamp(1513566778);
//        dateInfoEntity.setEnd_time_stamp(1613566778);
//        dateInfoEntity.setType("DATE_TYPE_FIX_TIME_RANGE");
//        baseInfoEntity.setDate_info(dateInfoEntity);
//
//        baseInfoEntity.setUse_limit(1);
//        baseInfoEntity.setGet_limit(1);
//
//
//        generalCoupon.setBaseInfoEntity(baseInfoEntity);
//
//        //设置卡券信息
//        generalCoupon.setDefault_detail("满200减50");
//
//        createCardEntity.setGeneralCoupon(generalCoupon);
//
//
//        HashMap<String, CreateCardEntity> map = new HashMap<>();
//        map.put("card",createCardEntity);
//
//        return map;
//    }

    /**
     * 创建预存卡券
     * 将库存quantity初始值设置为0，
     * 并填入get_custom_code_mode字段
     * @return 返回创建的卡券id
     */
    @RequestMapping("/createPrestoreCard")
    public String createPrestoreCard(){



        CreateCardEntity createCardEntity = new CreateCardEntity();

        //设置 卡券类型为 优惠券
        createCardEntity.setCard_type("GENERAL_COUPON");

        //设置 BaseInfo
        CreateCardEntity.GeneralCoupon generalCoupon = createCardEntity.new GeneralCoupon();
        BaseInfoEntity baseInfoEntity = new BaseInfoEntity();

        // 并填入get_custom_code_mode字段
        baseInfoEntity.setGet_custom_code_mode("GET_CUSTOM_CODE_MODE_DEPOSIT");

        baseInfoEntity.setLogo_url("http://mmbiz.qpic.cn/mmbiz/iaL1LJM1mF9aRKPZJkmG8xXhiaHqkKSVMMWeN3hLut7X7hicFNjakmxibMLGWpXrEXB33367o7zHN0CwngnQY7zb7g/0");
        baseInfoEntity.setBrand_name("意尔康");
        baseInfoEntity.setCode_type("CODE_TYPE_BARCODE");
        baseInfoEntity.setTitle("意尔康新年优惠券");
        baseInfoEntity.setColor("Color090");
        baseInfoEntity.setNotice("使用时向服务员出示此券");
        baseInfoEntity.setService_phone("0371-65732233");
        baseInfoEntity.setDescription("不可与其他优惠同享");

        BaseInfoEntity.Sku sku = baseInfoEntity.new Sku();
        // 将库存quantity初始值设置为0
        sku.setQuantity(0);
        baseInfoEntity.setSku(sku);

        BaseInfoEntity.DateInfoEntity dateInfoEntity = new BaseInfoEntity.DateInfoEntity();
        dateInfoEntity.setBegin_time_stamp(1513566778);
        dateInfoEntity.setEnd_time_stamp(1613566778);
        dateInfoEntity.setType("DATE_TYPE_FIX_TIME_RANGE");
        baseInfoEntity.setDate_info(dateInfoEntity);

        baseInfoEntity.setUse_limit(1);
        baseInfoEntity.setGet_limit(1);


        generalCoupon.setBaseInfoEntity(baseInfoEntity);

        //设置卡券信息
        generalCoupon.setDefault_detail("满200减50");

        createCardEntity.setGeneralCoupon(generalCoupon);


        HashMap<String, CreateCardEntity> map = new HashMap<>();
        map.put("card",createCardEntity);


        String requestBody ="";
        try {
             requestBody = objectMapper.writeValueAsString(map);
             log.info("[创建卡券的json字符串:] requestBody ={}",requestBody);
        } catch (JsonProcessingException e) {
            log.error("[创建卡券失败:] 实体类转JSON 字符串异常: ={}",e.getMessage());
            e.printStackTrace();
        }

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(
                "https://api.weixin.qq.com/card/create?access_token={accessToken}",
                requestBody,
                String.class,
                getToken());

        Integer errcode = (Integer) JSONPath.read(responseEntity.getBody(), "$.errcode");

        if (0!=errcode){
            String errmsg = (String) JSONPath.read(responseEntity.getBody(), "$.errmsg");
            log.error("[创建卡券失败:]errcode={}, errmsg={}",errcode,errmsg);
           throw new MyException(ResultEnum.CREATE_CARD_ERR);

        }

        //如果创建卡券成功,会返回创建的 卡券id 即:card_id
        String card_id = (String) JSONPath.read(responseEntity.getBody(), "$.card_id");
        log.info("[创建卡券成功] card_id={}",card_id);


        return card_id;
    }

    /**
     * 获取access_token
     * @return access_token
     */
    @RequestMapping("/getAccessToken")
    public String getToken(){

        String accessToken = null;
        try {
             accessToken = wxMpService.getAccessToken();
             log.info("[获取access_token 成功]:accessToken={}",accessToken);
        } catch (WxErrorException e) {
            log.error("[获取access_token 失败] 异常信息={}",e.getMessage());
            e.printStackTrace();
            throw new MyException(ResultEnum.GET_ACCESSTOKEN_ERR);
        }


        return accessToken;


    }


    @RequestMapping("/importCode/{card_id}")
    public String importCode(@PathVariable("card_id") String card_id){



        WXCodeEntity wxCodeEntity = new WXCodeEntity();
        wxCodeEntity.setCard_id(card_id);

        String[] codes = new String[]{"111111111","222222222"};
//        for (int i=0;i<100;i++){
//            codes[i] = String.valueOf(i);
//        }

        wxCodeEntity.setCode(codes);

        String requestBody = "";
        try {
             requestBody =objectMapper.writeValueAsString(wxCodeEntity);
             log.info("[导入自定义code的JSON数据] requestBody={}",requestBody);
        } catch (JsonProcessingException e) {
            log.error("[导入自定义code失败:] 实体类转JSON 字符串异常: ={}",e.getMessage());
            e.printStackTrace();
        }
        String url = WxCardUrl.importCode;
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(
                url + "?access_token={accessToken}",
                requestBody,
                String.class,
                getToken()
        );
        Integer errcode = (Integer) JSONPath.read(responseEntity.getBody(), "$.errcode");

        if (0!=errcode){
            String errmsg = (String) JSONPath.read(responseEntity.getBody(), "$.errmsg");
            log.error("[导入自定义code失败:]errcode={}, errmsg={}",errcode,errmsg);
            throw new MyException(ResultEnum.IMPORT_CODE_ERR);
        }

        //成功个数
        Integer succ_code = (Integer) JSONPath.read(responseEntity.getBody(), "$.succ_code");

        //重复导入的code会自动被过滤。
//        String[] duplicate_codes = (String[]) JSONPath.read(responseEntity.getBody(), "$.duplicate_code");

        //失败个数
        Integer fail_code = (Integer) JSONPath.read(responseEntity.getBody(), "$.fail_code");


        return "成功个数:"+succ_code+"失败个数:"+fail_code;

    }





}
