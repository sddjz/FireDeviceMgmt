package com.example.mybatis_demo.dto;

import com.example.mybatis_demo.entity.User;
import lombok.Data;

import java.util.Date;

@Data
public class UserParam extends User {

    private  Long pos_parentId; //领导；
    private  Long positionId;//职位id；
    private  Long deptId;
    private  int pos_enabled;
    private Date pos_start;
    private Date pos_end;

}
