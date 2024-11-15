package com.example.mybatis_demo.service;

import com.example.mybatis_demo.common.PageResult;
import com.example.mybatis_demo.dto.VendorParam;
import com.example.mybatis_demo.entity.Vendor;
import com.baomidou.mybatisplus.extension.service.IService;
import  java.util.*;
/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jizhid
 * @since 2022-10-23
 */
public interface VendorService extends IService<Vendor> {
  PageResult<Vendor> listVendor(VendorParam param, int pageSize, int pageNum);

    int  addVendor(Vendor vendor);

    List<Vendor> listAllVendor();
}
