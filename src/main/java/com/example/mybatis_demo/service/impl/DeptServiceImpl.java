package com.example.mybatis_demo.service.impl;

import com.example.mybatis_demo.entity.Dept;
import com.example.mybatis_demo.mapper.DeptMapper;
import com.example.mybatis_demo.service.DeptService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jizhid
 * @since 2022-10-23
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements DeptService {

	
	@Autowired
	private DeptMapper deptMapper;
	
	@Override
	public List<Dept> listDept(Long bankId) {

		return deptMapper.listDept(bankId);
	}

}
