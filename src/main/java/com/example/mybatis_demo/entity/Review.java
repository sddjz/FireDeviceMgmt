package com.example.mybatis_demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

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
@ApiModel(value="Review对象", description="")
@NoArgsConstructor
@AllArgsConstructor
public class Review implements Serializable {

    private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
   private Long id;

    @JsonProperty(value ="serialNum")
    @TableField(value = "serial_num" )
    private String serialNum;

    @ApiModelProperty(value = "评审人")
    @JsonProperty(value ="reviewerName")
    @TableField("reviewer_name")
    private String reviewerName;

    @JsonProperty(value ="reviewDate")
    @TableField("review_date")
    private Date reviewDate;


    @JsonProperty(value ="bankId")
    @TableField("bank_Id")
    private String bankId;

    @ApiModelProperty(value = "1: pass2:需要整改4.完成整改；")
    private Integer status;

    @TableField(fill = FieldFill.INSERT,value = "gmt_create")
    @JsonProperty(value ="gmtCreate")
    private Date gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE,value = "gmt_modified")
    @JsonProperty(value ="gmtModified")
    private Date gmtModified;

    @ApiModelProperty(value = "备注整改意见")
     private String descp;


    //整改内容；根据数据库内容决定是否存在；
    @TableField(exist = false)
    private List<Rectify> rectify;
}
