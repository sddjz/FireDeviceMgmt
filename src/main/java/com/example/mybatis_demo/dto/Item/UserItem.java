package com.example.mybatis_demo.dto.Item;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserItem {
    private  Long id;

    @JsonProperty(value = "name")
    private String name;
    @JsonProperty(value = "email")

    private String email;

    @JsonProperty(value = "address")
    private String address;
    @JsonProperty(value = "socialId")

    private String socialId;

    @JsonProperty(value = "phone")

    private String phone;
    @JsonProperty(value = "empNum")
    private  String empNum;
    @JsonProperty(value = "gendor")
    private  int gendor;

    private Long bankId;

}
