package com.example.mybatis_demo.dto;

import lombok.Data;

@Data
public class FamParam {
    private  Integer faType;
    private  String faSerialNum;
    private  String m_start;
    private  String m_end;

    public String print(String tag){
        System.out.println(tag);
        String rt = "saType:"+faType+"; saSerialNum"+faSerialNum+"; m_start: "+m_start +"; m_end: "+m_end;
        System.out.println(rt);
        return rt;
    }

}
