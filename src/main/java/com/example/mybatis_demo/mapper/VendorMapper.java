package com.example.mybatis_demo.mapper;

import com.example.mybatis_demo.entity.Vendor;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface VendorMapper extends BaseMapper<Vendor> {

}
