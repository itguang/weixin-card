package com.yearcon.weixincard.weixinEntity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * （卡券高级信息）字段
 *
 * @author itguang
 * @create 2017-12-18 13:17
 **/
@Data
public class AdvancedInfoEntity {


    //===============以下都是非必填字段=======================

    /**
     * 使用门槛（条件）字段，若不填写使用条件则在券面拼写 ：无最低消费限制，全场通用，不限品类；并在使用说明显示： 可与其他优惠共享
     * "use_condition": {
     * "accept_category": "鞋类",
     * "reject_category": "阿迪达斯",
     * "can_use_with_other_discount": true
     * },
     */
    private UseCondition use_condition;


    /**
     * 封面摘要结构体名称
     * <p>
     * "abstract": {
     * "abstract": "微信餐厅推出多种新季菜品，期待您的光临",
     * "icon_url_list": [
     * "http://mmbiz.qpic.cn/mmbiz/p98FjXy8LacgHxp3sJ3vn97bGLz0ib0Sfz1bjiaoOYA027iasqSG0sjpiby4vce3AtaPu6cIhBHkt6IjlkY9YnDsfw/0"
     * ]
     * },
     */
    @JsonProperty("abstract")
    private Abstract anAbstract;


    /**
     * 图文列表，显示在详情内页 ，优惠券券开发者须至少传入 一组图文列表
     * <p>
     * "text_image_list": [
     * {
     * "image_url": "http://mmbiz.qpic.cn/mmbiz/p98FjXy8LacgHxp3sJ3vn97bGLz0ib0Sfz1bjiaoOYA027iasqSG0sjpiby4vce3AtaPu6cIhBHkt6IjlkY9YnDsfw/0",
     * "text": "此菜品精选食材，以独特的烹饪方法，最大程度地刺激食 客的味蕾"
     * },
     * {
     * "image_url": "http://mmbiz.qpic.cn/mmbiz/p98FjXy8LacgHxp3sJ3vn97bGLz0ib0Sfz1bjiaoOYA027iasqSG0sj piby4vce3AtaPu6cIhBHkt6IjlkY9YnDsfw/0",
     * "text": "此菜品迎合大众口味，老少皆宜，营养均衡"
     * }
     * ],
     */
    @JsonProperty("text_image_list")
    private TextImageList[] textImageList;

    /**
     * 商家服务类型：
     * BIZ_SERVICE_DELIVER 外卖服务；
     * BIZ_SERVICE_FREE_PARK 停车位；
     * BIZ_SERVICE_WITH_PET 可带宠物；
     * BIZ_SERVICE_FREE_WIFI 免费wifi，
     * 可多选
     */
    private String[] business_service;


    /**
     * 使用时段限制，包含以下字段
     */
    private TimeLimit time_limit;

    @Data
    private class TimeLimit {

        /**
         * 限制类型枚举值：支持填入
         * MONDAY 周一
         * TUESDAY 周二
         * WEDNESDAY 周三
         * THURSDAY 周四
         * FRIDAY 周五
         * SATURDAY 周六
         * SUNDAY 周日
         * 此处只控制显示， 不控制实际使用逻辑，不填默认不显示
         */
        private String type;

        /**
         * 当前type类型下的起始时间（小时） ，如当前结构体内填写了MONDAY， 此处填写了10，则此处表示周一 10:00可用
         */
        private Integer begin_hour;

        /**
         * 当前type类型下的起始时间（分钟） ，如当前结构体内填写了MONDAY， begin_hour填写10，此处填写了59， 则此处表示周一 10:59可用
         */
        private Integer begin_minute;

        /**
         * 当前type类型下的结束时间（小时） ，如当前结构体内填写了MONDAY， 此处填写了20， 则此处表示周一 10:00-20:00可用
         */
        private Integer end_hour;

        /**
         * 当前type类型下的结束时间（分钟） ，如当前结构体内填写了MONDAY， begin_hour填写10，此处填写了59， 则此处表示周一 10:59-00:59可用
         */
        private Integer end_minute;

    }


    @Data
    private class TextImageList {

        /**
         * 图片链接，必须调用 上传图片接口 上传图片获得链接，并在此填入， 否则报错
         */
        private String image_url;

        /**
         * 图文描述
         */
        private String text;


    }


    @Data
    public class Abstract {


        /**
         * 封面摘要简介。
         */
        @JsonProperty("abstract")
        private String abstract2;

        /**
         * 封面图片列表，仅支持填入一 个封面图片链接， 上传图片接口 上传获取图片获得链接，
         * 填写 非CDN链接会报错，并在此填入。 建议图片尺寸像素850*350
         */
        private String icon_url_list;

    }

    @Data
    public class UseCondition {
        /**
         * 指定可用的商品类目，仅用于代金券类型 ，填入后将在券面拼写适用于xxx
         */
        private String accept_category;

        /**
         * 指定不可用的商品类目，仅用于代金券类型 ，填入后将在券面拼写不适用于xxxx
         */
        private String reject_category;

        /**
         * 满减门槛字段，可用于兑换券和代金券 ，填入后将在全面拼写消费满xx元可用。
         */
        private Integer least_cost;

        /**
         * 购买xx可用类型门槛，仅用于兑换 ，填入后自动拼写购买xxx可用。
         */
        private String object_use_for;

        /**
         * 不可以与其他类型共享门槛 ，填写false时系统将在使用须知里 拼写“不可与其他优惠共享”，
         * 填写true时系统将在使用须知里 拼写“可与其他优惠共享”， 默认为true
         */
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        private boolean can_use_with_other_discount;


    }


}



