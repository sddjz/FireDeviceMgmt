package com.example.mybatis_demo.common;

/**
 * 常用API返回对象接口
 * Created by ssdjz on 2022/10/26.
 */
public interface IErrorCode {
    /**
     * 返回标志码
     */
    long getCode();
    /**
     * 返回信息内容
     */
    String getMessage();
}
