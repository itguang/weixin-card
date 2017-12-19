package com.yearcon.weixincard.weixinEntity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author itguang
 * @create 2017-12-18 10:43
 **/
@Data
public class BaseInfoEntity {

//=================base_info（卡券基础信息）字段-必填字段=============================

    /**
     * logo Url 必填
     */
    private String logo_url;


    /**
     * 码型： "CODE_TYPE_TEXT"文 本 ；
     * "CODE_TYPE_BARCODE"一维码
     * "CODE_TYPE_QRCODE"二维码
     * "CODE_TYPE_ONLY_QRCODE",二维码无code显示；
     * "CODE_TYPE_ONLY_BARCODE",一维码无code显示；
     * CODE_TYPE_NONE， 不显示code和条形码类型
     */
    private String code_type;

    /**
     * 商户名字,字数上限为12个汉字。
     */
    private String brand_name = "意尔康";

    /**
     * 卡券名，字数上限为9个汉字。(建议涵盖卡券属性、服务及金额)。
     */
    private String title;

    /**
     * 券颜色。按色彩规范标注填写Color010-Color100。
     */
    private String color;

    /**
     * 卡券使用提醒，字数上限为16个汉字。
     */
    private String notice;

    /**
     * 卡券使用说明，字数上限为1024个汉字
     */
    private String description;


    /**
     * 商品信息。
     */
    private Sku sku;

    /**
     * JSON结构	见上述示例。	使用日期，有效期的信息.
     */
    private DateInfoEntity date_info;

    /**
     * type为DATE_TYPE_FIX_TERM时专用，表示自领取后多少天内有效，不支持填写0。
     */
    private String fixed_term;

    /**
     * type为DATE_TYPE_FIX_TERM时专用，表示自领取后多少天开始生效，领取后当天生效填写0。（单位为天）
     */
    private String fixed_begin_term;

    /**
     * 可用于DATE_TYPE_FIX_TERM时间类型，表示卡券统一过期时间 ， 建议设置为截止日期的23:59:59过期 。
     * （ 东八区时间,UTC+8，单位为秒 ），设置了fixed_term卡券，当时间达到end_timestamp时卡券统一过期
     */
    private String end_time_stamp;


//================base_info（卡券基础信息）字段-非必填字段===================

    /**
     * 是否自定义Code码 。填写true或false，默认为false。
     * 通常自有优惠码系统的开发者选择 自定义Code码，并在卡券投放时带入 Code码，详情见 是否自定义Code码 。
     */
    private boolean use_custom_code;

    /**
     * 填入 GET_CUSTOM_CODE_MODE_DEPOSIT 表示该卡券为预存code模式卡券，
     * 须导入超过库存数目的自定义code后方可投放， 填入该字段后，quantity字段须为0,须导入code 后再增加库存
     */
    private String get_custom_code_mode;


    /**
     * 是否指定用户领取，填写true或false 。默认为false。通常指定特殊用户群体 投放卡券或防止刷券时选择指定用户领取。
     */
    private boolean bind_openid;

    /**
     * 客服电话
     */
    private String service_phone;

    /**
     * 门店位置poiid。 调用 POI门店管理接 口 获取门店位置poiid。具备线下门店 的商户为必填。
     */
    private int[] location_id_list;

    /**
     * 设置本卡券支持全部门店，与location_id_list互斥
     */
    private boolean use_all_locations;


    /**
     * 卡券顶部居中的按钮，仅在卡券状 态正常(可以核销)时显示
     */
    private String center_title;

    /**
     * 显示在入口下方的提示语 ，仅在卡券状态正常(可以核销)时显示。
     */
    private String center_sub_title;

    /**
     * 顶部居中的url ，仅在卡券状态正常(可以核销)时显示。
     */
    private String center_url;

    /**
     * 卡券跳转的小程序的user_name，仅可跳转该 公众号绑定的小程序 。
     */
    private String center_app_brand_user_name;

    /**
     * 卡券跳转的小程序的path
     */
    private String center_app_brand_pass;

    /**
     * 自定义跳转外链的入口名字
     */
    private String custom_url_name;

    /**
     * 自定义跳转的URL。
     */
    private String custom_url;

    /**
     * 显示在入口右侧的提示语
     */
    private String custom_url_sub_title;

    /**
     * 卡券跳转的小程序的user_name，仅可跳转该 公众号绑定的小程序
     */
    private String custom_app_brand_user_name;

    /**
     * 卡券跳转的小程序的path
     */
    private String custom_app_brand_pass;

    /**
     * 营销场景的自定义入口名称.(如:更多优惠)
     */
    private String promotion_url_name;

    /**
     * 营销场景的自定义入口跳转外链的地址链接。
     */
    private String promotion_url;

    /**
     * 显示在营销入口右侧的提示语。
     */
    private String promotion_url_sub_title;

    /**
     * 卡券跳转的小程序的user_name，仅可跳转该 公众号绑定的小程序 。
     */
    private String promotion_app_brand_user_name;

    /**
     * 卡券跳转的小程序的path
     */
    private String promotion_app_brand_pass;


    /**
     * 每人可领券的数量限制,不填写默认为50。
     */
    private Integer get_limit;

    /**
     * 每人可核销的数量限制,不填写默认为50
     */
    private Integer use_limit;

    /**
     * 卡券领取页面是否可分享。默认:false
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private boolean can_share;

    /**
     * 卡券是否可转赠。 默认:false
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private boolean can_give_friend;


    @Data
    public static class DateInfoEntity {


        /**
         * DATE_TYPE_FIX _TIME_RANGE 表示固定日期区间，
         * DATE_TYPE_ FIX_TERM 表示固定时长 （自领取后按天算。
         * 使用时间的类型，旧文档采用的1和2依然生效
         */
        private String type;


        /**
         * type为DATE_TYPE_FIX_TIME_RANGE时专用，表示起用时间。
         * 从1970年1月1日00:00:00至起用时间的秒数，最终需转换为字符串形态传入。（东八区时间,UTC+8，单位为秒）
         */
        @JsonProperty("begin_timestamp")
        private int begin_time_stamp;

        /**
         * 表示结束时间 ， 建议设置为截止日期的23:59:59过期 。 （ 东八区时间,UTC+8，单位为秒 ）
         */
        @JsonProperty("end_timestamp")
        private int end_time_stamp;
    }


    @Data
    public class Sku {

        private Integer quantity;
    }
}
