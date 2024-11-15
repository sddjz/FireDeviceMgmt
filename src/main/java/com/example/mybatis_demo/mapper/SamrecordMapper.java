package com.example.mybatis_demo.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.mybatis_demo.entity.Saasset;
import com.example.mybatis_demo.entity.Samrecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jizhid
 * @since 2022-11-08
 */
@Mapper
@Repository
public interface SamrecordMapper extends BaseMapper<Samrecord> {
    IPage<Samrecord> listSamRecord(IPage<Samrecord> page, @Param("ew") Wrapper wrapper);

}
