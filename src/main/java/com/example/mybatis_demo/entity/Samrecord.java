package com.example.mybatis_demo.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
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
@ApiModel(value="Samrecord对象", description="")
public class Samrecord implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    private Long saId;


    private String repairName;

    private String repairTime;

    private Long reviewId;

    private BigDecimal fee;

    private String descp;


    @TableField(exist = false)

    private String serial_num; //设备序列号
    @TableField(exist = false)

    private String reviewerName; //审核人

    @TableField(exist = false)
    private String sa_name; //设备名称；
    @TableField(exist = false)

    private  String satype_name;


}
