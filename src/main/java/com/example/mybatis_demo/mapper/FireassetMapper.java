package com.example.mybatis_demo.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.mybatis_demo.entity.Fireasset;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatis_demo.entity.Saasset;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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
public interface FireassetMapper extends BaseMapper<Fireasset> {


    IPage<Fireasset> listFaAsset(IPage<Fireasset> page, @Param("ew") Wrapper wrapper);

}
