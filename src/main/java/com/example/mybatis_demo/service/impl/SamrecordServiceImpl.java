package com.example.mybatis_demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatis_demo.common.PageResult;
import com.example.mybatis_demo.dto.SamParam;
import com.example.mybatis_demo.entity.Saasset;
import com.example.mybatis_demo.entity.Samrecord;
import com.example.mybatis_demo.entity.User;
import com.example.mybatis_demo.mapper.SamrecordMapper;
import com.example.mybatis_demo.service.SamrecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jizhid
 * @since 2022-11-08
 */
@Service
public class SamrecordServiceImpl extends ServiceImpl<SamrecordMapper, Samrecord> implements SamrecordService {

    @Autowired
    private SamrecordMapper samrecordMapper;

    @Override
    public PageResult<Samrecord> listSaRecord(SamParam param, Integer pageSize, Integer pageNum) {

        System.out.println("SamParam  value are as followings: ");
        Page<Samrecord> page =new Page<Samrecord>(pageNum,pageSize);
        param.print("SamParam print is:");

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        if(param.getSaSerialNum()!=null){
            wrapper.like("sa.serial_num",param.getSaSerialNum());
        }

        if(param.getM_start()!=null){
            wrapper.ge("sam.repair_time",param.getM_start());
        }
        if(param.getM_end()!=null){
            wrapper.le("sam.repair_time",param.getM_end());
        }
        if(param.getSaType()!=null){
            wrapper.eq("sa.id",param.getSaType());
        }


        IPage<Samrecord> pageResult = samrecordMapper.listSamRecord(page,wrapper);
        return new PageResult(pageNum,pageSize,pageResult.getPages(),pageResult.getTotal(),
                pageResult.getRecords());

    }
}
