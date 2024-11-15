package com.example.mybatis_demo.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <p>
 *
 * </p>
 *
 * @author jizhid
 * @since 2022-11-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Rectifysa对象", description="")
@NoArgsConstructor
@AllArgsConstructor
public class Rectifysa implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @JsonProperty(value ="assetId")
    @TableField("asset_id")
    private Long assetId;

    @JsonProperty(value ="rectifyId")
    @TableField("rectify_id")
    private Long rectifyId;

    @JsonProperty(value ="receiverId")
    @TableField("receiver_id")
    private Long receiverId;

    private String descp;

    @JsonProperty(value ="finishedDate")
    @TableField("finished_date")
    private Date finishedDate;

    @JsonProperty(value ="deadline")
    @TableField("deadline")
    private Date deadline;

    @JsonProperty(value ="budget")
    @TableField("budget")
    private BigDecimal budget;

    
    @ApiModelProperty(value = "1:待处理\n0：处理完成；")
    private Integer status;

    
    @JsonProperty(value ="fee")
    @TableField("fee")
    private BigDecimal fee;

    /**
     @JsonProperty(value ="bank_id")
     @TableField("bank_Id")
     private Long bankId;
     */
    //发出整改的人;
    @TableField(exist = false)
    private  User sendUser;

    @TableField(exist = false)
    private  User rectifyUser;

    @TableField(exist = false)
    private  Saasset saasset;

}
