package com.example.mybatis_demo.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

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
public class Vendor implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String name;

    private String descp;

    private String phone;

    private String company;

    private String address;

    private String email;

    @ApiModelProperty(value = "联系人名字")
    private String contact;

    @ApiModelProperty(value = "联系人电话")
    private String contactphone;

    @JsonProperty("bankId")
    @TableField(value ="bank_id")
    private String bankId;

    @TableField(value ="gmt_create",fill = FieldFill.INSERT)
    private Date gmt_create;

    @TableField(value ="gmt_modified",fill = FieldFill.INSERT_UPDATE)
    private Date gmt_modified;


}
