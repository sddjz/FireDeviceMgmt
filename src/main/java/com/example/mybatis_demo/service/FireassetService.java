package com.example.mybatis_demo.service;

import com.example.mybatis_demo.common.PageResult;
import com.example.mybatis_demo.dto.FaAssetParam;
import com.example.mybatis_demo.dto.SaAssetParam;
import com.example.mybatis_demo.entity.Fireasset;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mybatis_demo.entity.Saasset;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jizhid
 * @since 2022-10-23
 */
public interface FireassetService extends IService<Fireasset> {
    PageResult<Fireasset> listAsset(FaAssetParam param, int pageSize, int pageNum);

    List<Fireasset> listAllAsset();

    int addFa(Fireasset asset);
}
