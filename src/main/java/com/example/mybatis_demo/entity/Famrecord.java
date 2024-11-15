package com.example.mybatis_demo.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author jizhid
 * @since 2022-11-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Famrecord对象", description="")
public class Famrecord implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long faId;

    private String repairName;

    private Date repairTime;

    private Long reviewId;

    private BigDecimal fee;

    private String descp;
    @TableField(exist = false)

    private String serialNum;
    @TableField(exist = false)

    private String reviewUserName;//user name
    @TableField(exist = false)

    private String fassetName;//fireasset name
    @TableField(exist = false)

    private String fatypeName;


}
