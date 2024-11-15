package com.example.mybatis_demo.service;

import com.example.mybatis_demo.common.PageResult;
import com.example.mybatis_demo.dto.FamParam;
import com.example.mybatis_demo.entity.Famrecord;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jizhid
 * @since 2022-11-08
 */
public interface FamrecordService extends IService<Famrecord> {
    PageResult<Famrecord> listFaRecord(FamParam param, Integer pageSize, Integer pageNum);

}
