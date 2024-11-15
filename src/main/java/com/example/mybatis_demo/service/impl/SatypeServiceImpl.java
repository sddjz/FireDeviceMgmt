package com.example.mybatis_demo.service.impl;

import com.example.mybatis_demo.entity.Satype;
import com.example.mybatis_demo.mapper.SatypeMapper;
import com.example.mybatis_demo.service.SatypeService;
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
public class SatypeServiceImpl extends ServiceImpl<SatypeMapper, Satype> implements SatypeService {

    @Autowired
    private SatypeMapper  satypeMapper;

    @Override
    public List<Satype> listSaType() {
        return satypeMapper.selectList(null);
    }


}
