package com.example.mybatis_demo.dto;

import lombok.Data;

@Data
public class SaAssetParam {
    private String inStore_st;
    private String inStore_end;
    private Integer saStatus;// 报废 or 正常；

    private Integer saType;//设备类型；

    public String print(String tag){
        System.out.println(tag);
        String rt = "status:"+inStore_st+"; posId"+inStore_end+"; "+saStatus +"; "+saType;
        System.out.println(rt);
        return rt;
    }

}
