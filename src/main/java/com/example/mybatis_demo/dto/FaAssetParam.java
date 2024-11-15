package com.example.mybatis_demo.dto;

import lombok.Data;

@Data
public class FaAssetParam {

    private String inStore_st;
    private String inStore_end;
    private Integer faStatus;// 报废 or 正常；

    private Integer faType;//设备类型；

    public String print(String tag){
        System.out.println(tag);
        String rt = "status:"+inStore_st+"; posId"+inStore_end+"; "+faStatus +"; "+faType;
        System.out.println(rt);
        return rt;
    }
}
