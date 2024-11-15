package com.example.mybatis_demo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginParam {

    @NotNull
    //@ApiModelProperty(value = "username",required = true)
    private String username;


    @NotNull
    //@ApiModelProperty(value = "password",required = true)
    private String password;
}
