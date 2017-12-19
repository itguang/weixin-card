package com.yearcon.weixincard.weixinEntity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * 创建卡券
 *
 * 主要有三个字段:
 *
 * 卡券类型<br/>
 * 卡券信息 generalCoupon<br/>
 * 卡券详情,不同卡券类型,字段不一样<br/>
 *
 * @author itguang
 * @create 2017-12-18 12:24
 **/
@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class CreateCardEntity {

    /**
     * 卡券类型  card_type  必填<br/>
     * GROUPON: 团购券类型<br/>
     * CASH: 代金券<br/>
     * DISCOUNT: 折扣券<br/>
     * GIFT: 兑换券<br/>
     * GENERAL_COUPON:优惠券<br/>
     */
    private String card_type;


    @JsonProperty("general_coupon")
    private GeneralCoupon generalCoupon;





    @Data
    public class GeneralCoupon {
        /**
         * 基本的卡券数据   base_info  必填
         */
        @JsonProperty("base_info")
        private BaseInfoEntity baseInfoEntity;
        /**
         * （卡券高级信息）字段. 选填
         */
        @JsonProperty("advanced_info")
        private AdvancedInfoEntity advancedInfoEntity;

        //=================以下字段互斥,根据选择的卡券类型选择填写相应字段=====================================

        /**
         * 团购券专用，团购详情。
         */
        private String deal_detail;

        /**
         * 兑换券专用，填写兑换内容的名称. 如:可兑换音乐木盒一个。
         */
        private String gift;

        /**
         * 折扣券专用，表示打折额度（百分比）。填30就是七折
         */
        private Integer discount;

        /**
         * 代金券专用，表示起用金额（单位为分）,如果无起用门槛则填0。
         */
        private Integer least_cost;

        /**
         * 代金券专用，表示减免金额。（单位为分）
         */
        private Integer reduce_cost;


        /**
         * 优惠券专用，填写优惠详情。
         */
        private String default_detail;

    }
}
