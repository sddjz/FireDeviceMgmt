package com.example.mybatis_demo.service;

import com.example.mybatis_demo.entity.Satype;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jizhid
 * @since 2022-11-08
 */
public interface SatypeService extends IService<Satype> {
    List<Satype> listSaType();

}
