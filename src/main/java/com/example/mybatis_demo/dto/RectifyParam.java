package com.example.mybatis_demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RectifyParam {

     private Date stTime;
    private Date endTime;
    private  Integer status;
    private Long bankId;
}
