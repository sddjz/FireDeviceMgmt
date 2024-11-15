package com.example.mybatis_demo.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;

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
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Rectifyother对象", description="")
public class Rectifyother implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * `.`review_id`,
     *     ``.`receiver_id`,
     *     ``.`descp`,
     *     ``.`finished_date`,
     *     ``.`deadline`,
     *     ``.`status`,
     *     ``.`asset_id`,
     *     ``.`fee`,
     *     ``.`bank_id`
     */
      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

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

    @ApiModelProperty(value = "1:待处理\n0：处理完成；")
    private Integer status;

    private BigDecimal fee;

    
    @JsonProperty(value ="budget")
    @TableField("budget")
    private BigDecimal budget;

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



}
