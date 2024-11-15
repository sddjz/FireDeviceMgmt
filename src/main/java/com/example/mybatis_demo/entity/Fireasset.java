package com.example.mybatis_demo.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 *
 * </p>
 *
 * @author jizhid
 * @since 2022-10-23
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fireasset implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @JsonProperty("fireType")
    @TableField(value ="fire_type")
    private Long fireType;

    private String name;

    @JsonProperty("price")
    @TableField(value ="price")
    private BigDecimal price;

    @JsonProperty("vendorId")
    @TableField(value ="vendor_id")
    private Long vendorId;

    @JsonProperty("buyDate")
    @TableField(value ="buy_date")
    private Date buyDate;


    @JsonProperty("signerId")
    @TableField(value ="signer_id")
    private Long signerId;


    @JsonProperty("reposId")
    @TableField(value ="repos_id")
    private Long reposId;

    @JsonProperty("status")
    @TableField(value ="status")
    private int status;

    @JsonProperty("serialNum")
    @TableField(value ="serial_num")
    private String serialNum;

    @JsonProperty("bankId")
    @TableField(value ="bank_id")
    private Long bankId;

    @JsonFormat(pattern = "yyyy-MM-dd" )
    @DateTimeFormat(pattern="yyyy-MM-dd")	//页面写入数据库时格式化
    @JsonProperty("gmtInStore")
    @TableField(value ="gmt_in_store")
    private Date gmtInStore;


    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;


    @TableField(exist = false)
    private User reposUser;

    @TableField(exist = false)
    private User signerUser;

    @TableField(exist = false)
    private Firetype fa_type;

    @TableField(exist = false)
    private Vendor vendor;

    @TableField(exist = false)
    private Bank bank;


}
