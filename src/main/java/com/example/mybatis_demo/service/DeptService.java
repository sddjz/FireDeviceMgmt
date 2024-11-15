package com.example.mybatis_demo.service;

import com.example.mybatis_demo.entity.Dept;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jizhid
 * @since 2022-10-23
 */
public interface DeptService extends IService<Dept> {

	List<Dept> listDept(Long bankId);

}
