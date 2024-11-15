package com.example.mybatis_demo.entity;
import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Delete;

import java.security.Permission;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    //id_worker默认全局id; id_work_str: id_worker的字符串截取；
//id_input:手动输入
    @JsonProperty(value = "id")
    @TableId(type = IdType.AUTO)
    private Long id;

    @JsonProperty(value = "name")
    private String name;
    
    @JsonProperty(value = "email")
    private String email;

    @JsonProperty(value = "address")
    private String address;

    @JsonProperty(value="headImage")
    @TableField(value="headimage")
    private String headImage;

    @JsonProperty(value = "socialId")
    @TableField(value = "social_id")//解决字段名不一致
    private String socialId;

    @JsonProperty(value = "phone")
    private String phone;
    
    @JsonProperty(value = "empNum")
    @TableField(value = "emp_num")//解决字段名不一致
    private  String empNum;

    @JsonProperty(value = "gendor")
    private  int gendor;

    @JsonProperty(value = "status")
    private int status;

    @JsonProperty(value = "bankId")
    @TableField(value = "bank_id")//解决字段名不一致
    private Long bankId;

    //自动填充的字段；填充内容在Config中
    @JsonProperty(value = "creationTime")
    @TableField(fill = FieldFill.INSERT)
    private Date creation_time;
    
    @JsonProperty(value = "updateTime")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date update_time;

    @JsonProperty(value = "deleted")
    @TableLogic //逻辑删除的字段
    private int deleted;

    @JsonProperty(value = "version")
    @Version
    private int version;

    @JsonProperty(value = "role")
    @TableField(exist = false)
    private Role role;

    @TableField(exist = false)
    @JsonProperty(value = "userPosList")
    private List<UserPos> userPosList;

    /**
    @TableField(exist = false)
    @JsonProperty(value = "pos")

    private Position pos;

    @JsonProperty(value = "dept")
    @TableField(exist = false)
    private Dept dept;
    */
    
    @JsonProperty(value = "bank")
    @TableField(exist = false)
    private Bank bank;

}
