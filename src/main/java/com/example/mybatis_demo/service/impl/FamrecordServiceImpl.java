package com.example.mybatis_demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatis_demo.common.PageResult;
import com.example.mybatis_demo.dto.FamParam;
import com.example.mybatis_demo.entity.Famrecord;
import com.example.mybatis_demo.mapper.FamrecordMapper;
import com.example.mybatis_demo.service.FamrecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jizhid
 * @since 2022-11-08
 */
@Service
public class FamrecordServiceImpl extends ServiceImpl<FamrecordMapper, Famrecord> implements FamrecordService {

    @Autowired
    private FamrecordMapper famrecordMapper;


    @Override
    public PageResult<Famrecord> listFaRecord(FamParam param, Integer pageSize, Integer pageNum) {

        System.out.println("FamParam  value are as followings: ");
        Page<Famrecord> page =new Page<Famrecord>(pageNum,pageSize);
        param.print("FamParam print is:");

        QueryWrapper<Famrecord> wrapper = new QueryWrapper<>();
        if(param.getFaSerialNum()!=null){
            wrapper.like("fireasset.serial_num",param.getFaSerialNum());
        }

        if(param.getM_start()!=null){
            wrapper.ge("famrecord.repair_time",param.getM_start());
        }
        if(param.getM_end()!=null){
            wrapper.le("famrecord.repair_time",param.getM_end());
        }
        if(param.getFaType()!=null){
            wrapper.eq("firetype.id",param.getFaType());
        }


        IPage<Famrecord> pageResult = famrecordMapper.listFamRecord(page,wrapper);
        return new PageResult(pageNum,pageSize,pageResult.getPages(),pageResult.getTotal(),
                pageResult.getRecords());

    }
}
