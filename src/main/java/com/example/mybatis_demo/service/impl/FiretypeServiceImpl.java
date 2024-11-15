package com.example.mybatis_demo.service.impl;

import com.example.mybatis_demo.entity.Firetype;
import com.example.mybatis_demo.mapper.FiretypeMapper;
import com.example.mybatis_demo.service.FiretypeService;
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
 * @since 2022-10-23
 */
@Service
public class FiretypeServiceImpl extends ServiceImpl<FiretypeMapper, Firetype> implements FiretypeService {

    @Autowired
    private  FiretypeMapper firetypeMapper;
    public List<Firetype> listFireType(){
        return firetypeMapper.selectList(null);
    }



}
