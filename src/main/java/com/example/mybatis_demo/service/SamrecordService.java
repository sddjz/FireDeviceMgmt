package com.example.mybatis_demo.service;

import com.example.mybatis_demo.common.PageResult;
import com.example.mybatis_demo.dto.SamParam;
import com.example.mybatis_demo.entity.Samrecord;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.RequestParam;
import  java.util.*;
/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jizhid
 * @since 2022-11-08
 */
public interface SamrecordService extends IService<Samrecord> {
    PageResult<Samrecord> listSaRecord(SamParam param, Integer pageSize, Integer pageNum);
}
