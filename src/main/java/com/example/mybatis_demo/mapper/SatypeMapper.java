package com.example.mybatis_demo.mapper;

import com.example.mybatis_demo.entity.Satype;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
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
public interface SatypeMapper extends BaseMapper<Satype> {

}
