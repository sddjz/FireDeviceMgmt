package com.example.mybatis_demo.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.mybatis_demo.entity.Famrecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatis_demo.entity.Samrecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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
public interface FamrecordMapper extends BaseMapper<Famrecord> {


    IPage<Famrecord> listFamRecord(IPage<Famrecord> page, @Param("ew") Wrapper wrapper);

}
