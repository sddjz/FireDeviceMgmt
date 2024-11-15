package com.example.mybatis_demo.service;

import com.example.mybatis_demo.entity.Firetype;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jizhid
 * @since 2022-10-23
 */
public interface FiretypeService extends IService<Firetype> {

    List<Firetype> listFireType();
}
