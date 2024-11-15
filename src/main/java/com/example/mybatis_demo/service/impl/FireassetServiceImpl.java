package com.example.mybatis_demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatis_demo.common.PageResult;
import com.example.mybatis_demo.dto.FaAssetParam;
import com.example.mybatis_demo.entity.Fireasset;
import com.example.mybatis_demo.entity.Saasset;
import com.example.mybatis_demo.entity.User;
import com.example.mybatis_demo.mapper.FireassetMapper;
import com.example.mybatis_demo.mapper.SaassetMapper;
import com.example.mybatis_demo.service.FireassetService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
public class FireassetServiceImpl extends ServiceImpl<FireassetMapper, Fireasset> implements FireassetService {


    @Autowired
    private FireassetMapper  fireassetMapper;

    @Override
    public PageResult<Fireasset> listAsset(FaAssetParam param, int pageSize, int pageNum) {

        System.out.println("FaAssetParam value are as followings: ");
        Page<Fireasset> page =new Page<Fireasset>(pageNum,pageSize);
        param.print("FaAssetParam print is:");

        QueryWrapper<Fireasset> wrapper = new QueryWrapper<>();
        int default_status = 1;
        if(param.getFaStatus()!=null){
            default_status = param.getFaStatus();
        }
        wrapper.eq("fireasset.status",default_status);
        if(param.getInStore_st()!=null){
            wrapper.ge("fireasset.gmt_in_store",param.getInStore_st());
        }
        if(param.getInStore_end()!=null){
            wrapper.le("fireasset.gmt_in_store",param.getInStore_end());
        }
        if(param.getFaType()!=null){
            wrapper.eq("fireasset.fire_type",param.getFaType());
        }


        IPage<Fireasset> pageResult = fireassetMapper.listFaAsset(page,wrapper);
        return new PageResult(pageNum,pageSize,pageResult.getPages(),pageResult.getTotal(),
                pageResult.getRecords());
    }

    @Override
    public List<Fireasset> listAllAsset() {
        return fireassetMapper.selectList(null);
    }

    @Override
    @Transactional
    public int addFa(Fireasset asset) {

        return fireassetMapper.insert(asset);

    }
}
