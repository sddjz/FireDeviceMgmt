package com.example.mybatis_demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewParam {

    private String  reviewerName;
    private Date    stTime;
    private Date    endTime;

    private Long bankId;

}


