package com.example.mybatis_demo.service;
import com.example.mybatis_demo.common.PageResult;

import com.example.mybatis_demo.dto.SaAssetParam;
import com.example.mybatis_demo.entity.Saasset;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mybatis_demo.entity.Satype;
import com.example.mybatis_demo.entity.User;
import java.util.*;
/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jizhid
 * @since 2022-10-23
 */
public interface SaassetService extends IService<Saasset> {
    PageResult<Saasset> listAsset(SaAssetParam param, int pageSize, int pageNum);
    int addSa(Saasset  saasset);

    List<Saasset> listAllAsset();
}
