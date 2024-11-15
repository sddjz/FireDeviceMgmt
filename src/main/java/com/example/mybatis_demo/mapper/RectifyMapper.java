package com.example.mybatis_demo.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatis_demo.entity.Rectify;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatis_demo.entity.Review;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jizhid
 * @since 2022-11-15
 */
@Mapper
@Repository
public interface RectifyMapper extends BaseMapper<Rectify> {

    IPage<Rectify> listRectify(@Param("page")Page<Rectify> page, @Param("ew")QueryWrapper<Rectify> wrapper);
    
    Rectify  getRectify(@Param("ew")QueryWrapper<Rectify> wrapper );
}
