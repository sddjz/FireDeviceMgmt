package com.example.mybatis_demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class UserPos  {

/**
 * implements Serializable
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
*/
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @JsonProperty("parentId")
    @TableField(value ="parent_id")
    private Long parentId;

    @JsonProperty("userId")
    @TableField(value ="user_id")
    private Long userId;

    @JsonProperty("posId")//一般用于前台json 数据->object;
    @TableField(value ="pos_id")
    private Long posId;

    @JsonProperty("deptId")
    @TableField(value ="dept_id")
    private Long deptId;

    @JsonFormat(pattern = "yyyy-MM-dd" )
    @DateTimeFormat(pattern="yyyy-MM-dd")	//页面写入数据库时格式化
    @TableField(value ="st_time")
    @JsonProperty("stTime")
    private Date stTime;    //@JsonProperty("value=stTime")


    @JsonFormat(pattern = "yyyy-MM-dd" )
    @DateTimeFormat(pattern="yyyy-MM-dd")	//页面写入数据库时格式化
    @JsonProperty("endTime")
    @TableField(value ="end_time")
    private Date endTime;

    @JsonProperty("enabled")//json ->属性(指定属性名称)
    @TableField(value ="enabled")
    private  int enabled;
    
    @TableField(exist=false)
    private Dept dept;
    
    @TableField(exist=false)
    private Position pos;
    
    @JsonProperty("parentPosName")
    @TableField(exist=false)
    private String parentPosName;
    
    @JsonProperty("parentPosUserName")
    @TableField(exist=false)
    private String parentPosUserName;
    

}
