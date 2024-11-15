package com.example.mybatis_demo.mapper;

import com.example.mybatis_demo.entity.Dept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jizhid
 * @since 2022-10-23
 */
@Mapper
@Repository
public interface DeptMapper extends BaseMapper<Dept> {

	List<Dept> listDept(Long bankId);

}
