package com.example.mybatis_demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class Logonuser implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @JsonProperty("logonUser")
    private String logonUser;

    @JsonProperty("password")
    private String password;

    @JsonProperty("empId")
    private Long empId;


}
