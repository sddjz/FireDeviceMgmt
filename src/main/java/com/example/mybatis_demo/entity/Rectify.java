package com.example.mybatis_demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.math.BigDecimal;

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
 * @since 2022-11-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Rectify对象", description="")
@NoArgsConstructor
@AllArgsConstructor
public class Rectify implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @JsonProperty(value ="startUserId")
    @TableField("start_user_id")
    private Long startUserId;

    @JsonProperty(value ="startedTime")
    @TableField("started_time")
    private Date startedTime;

    @JsonProperty(value ="reviewId")
    @TableField("review_Id")
    private Long reviewId;

    @JsonProperty(value ="descp")
    @TableField("descp")
    private String descp;

    @JsonProperty(value ="receiverId")
    @TableField("receiver_id")
    private Long receiverId;

    @JsonProperty(value ="bankId")
    @TableField("bank_Id")
    private Long bankId;
    
    @JsonProperty(value="finishedDate")
    @TableField("finished_date")
    private Date finishedDate;
    
    @JsonProperty(value="deadline")
    @TableField("deadline")
    private Date deadline;
    
    
    @JsonProperty(value="budget")
    @TableField("budget")
    private BigDecimal budget;
     
    @JsonProperty(value="fee")
    @TableField("fee")
    private BigDecimal fee;


    @ApiModelProperty(value = "0:完成1：未完成：")
    private Integer status;

    @JsonProperty(value="rectifyfa")
    @TableField(exist = false)
    private List<Rectifyfa> rectifyfa;

    @JsonProperty(value="rectifysa")
    @TableField(exist = false)
    private List<Rectifysa> rectifysa;

    @JsonProperty(value="rectifyother")
    @TableField(exist = false)
	private List<Rectifyother> rectifyother;

    @TableField(exist = false)
    private User receiver;

    @TableField(exist = false)
    private User startUser;
    
    @JsonProperty(value="reviewSerialNum")
    @TableField(exist = false)
    private String reviewSerialNum;

    @TableField(exist = false)
    private Date reviewDate;
    
    @TableField(exist = false)
    private String reviewerName;

}
