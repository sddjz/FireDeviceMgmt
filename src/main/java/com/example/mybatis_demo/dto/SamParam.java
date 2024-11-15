package com.example.mybatis_demo.dto;


import lombok.Data;

@Data
public class SamParam {

    private  Integer saType;
    private  String saSerialNum;
    private  String m_start;
    private  String m_end;

    public String print(String tag){
        System.out.println(tag);
        String rt = "saType:"+saType+"; saSerialNum"+saSerialNum+"; m_start: "+m_start +"; m_end: "+m_end;
        System.out.println(rt);
        return rt;
    }


}
