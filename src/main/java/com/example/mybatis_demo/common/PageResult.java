package com.example.mybatis_demo.common;

import lombok.Data;

import java.util.List;

@Data
public class PageResult<T>  {

    /**
     * pageNum":1,"pageSize":10,"totalPage":2,"total":15,
     * @param totalPage
     * @param total
     * @param <T>
     * @return
     */

    private     int pageNum;
    private     int pageSize;
    private     long totalPage;
    private     long toal;
    private List<T> list;



    public  PageResult(int pageNum, int pageSize, long totalPage,long total, List<T> data) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalPage = totalPage;
        this.toal = total;
        this.list = data;
    }
}
