package com.example.mybatis_demo.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
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
public class Saasset implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("price")
    private BigDecimal price;

    @TableField(value ="vendor_id")
    @JsonProperty("vendorId")
    private Integer vendorId;

    @TableField(value ="buy_date")
    @JsonProperty("buyDate")
    private String buyDate;

    @TableField(value ="repos_id")
    @JsonProperty("reposId")
    private Long reposId;

    @ApiModelProperty(value = "签收人，默认就是负责人")
    @JsonProperty("signerId")
    @TableField(value ="signer_id")
    private Long signerId;


    @JsonProperty("saType")
    @TableField(value ="sa_type")
    private Integer saType;


    @JsonProperty("status")
    @TableField(value ="status")
    private Integer status;


    @JsonProperty("bankId")
    @TableField(value ="bank_id")
    private Long bankId;

    @JsonProperty("serialNum")
    @TableField(value ="serial_num")
    private String serialNum;


    @JsonFormat(pattern = "yyyy-MM-dd" )
    @DateTimeFormat(pattern="yyyy-MM-dd")	//页面写入数据库时格式化
    @JsonProperty("gmtInStore")
    @TableField(value ="gmt_in_store")
    private Date gmtInStore;

    @TableField(exist = false)
    private User reposUser;

    @TableField(exist = false)
    private User signerUser;

    @TableField(exist = false)
    private Satype sa_type;

    @TableField(exist = false)
    private Vendor vendor;

    @TableField(exist = false)
    private Bank bank;




    @TableField(fill = FieldFill.INSERT,value = "gmt_create")
    private Date gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE,value = "gmt_modified")
    private Date gmtModified;


    /**
     * type name:
     * status
     *
     */

}
