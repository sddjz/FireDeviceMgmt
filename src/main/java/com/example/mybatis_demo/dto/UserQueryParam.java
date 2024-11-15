package com.example.mybatis_demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserQueryParam {
    private Integer status;// 在职 or 离职 ；1：在职；user.status
    private Integer posId;//职位类型;
    private String pos_date;//任职日期;

    private Integer pos_enabled;// 职位有效性； user_pos.enabled;
    public String print(String tag){
        System.out.println(tag);
        String rt = "status:"+status+"; posId"+posId+"; "+pos_date+"; pos_enabled: "+pos_enabled;
        System.out.println(rt);
        return rt;
    }
}

/**
@Getter
@Setter
public class OmsOrderQueryParam {
    @ApiModelProperty(value = "订单编号")
    private String orderSn;
    @ApiModelProperty(value = "收货人姓名/号码")
    private String receiverKeyword;
    @ApiModelProperty(value = "订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单")
    private Integer status;
    @ApiModelProperty(value = "订单类型：0->正常订单；1->秒杀订单")
    private Integer orderType;
    @ApiModelProperty(value = "订单来源：0->PC订单；1->app订单")
    private Integer sourceType;
    @ApiModelProperty(value = "订单提交时间")
    private String createTime;
}
 */
