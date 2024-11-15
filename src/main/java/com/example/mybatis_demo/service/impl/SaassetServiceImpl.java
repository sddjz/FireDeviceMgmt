package com.example.mybatis_demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatis_demo.common.PageResult;
import com.example.mybatis_demo.dto.SaAssetParam;
import com.example.mybatis_demo.entity.Saasset;


import com.example.mybatis_demo.mapper.SaassetMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatis_demo.service.SaassetService;
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
public class SaassetServiceImpl extends ServiceImpl<SaassetMapper, Saasset> implements SaassetService {

    @Autowired
    private  SaassetMapper saAssetMapper;


    @Override
    public PageResult<Saasset> listAsset(SaAssetParam param, int pageSize, int pageNum) {

        System.out.println("SaAssetParam value are as followings: ");
        Page<Saasset> page =new Page<Saasset>(pageNum,pageSize);
        param.print("SaAssetParam print is:");

        QueryWrapper<Saasset> wrapper = new QueryWrapper<>();
        int default_status = 1;
        if(param.getSaStatus()!=null){
            default_status = param.getSaStatus();
        }
        wrapper.eq("saasset.status",default_status);
        if(param.getInStore_st()!=null){
            wrapper.ge("saasset.gmt_in_store",param.getInStore_st());
        }
        if(param.getInStore_end()!=null){
            wrapper.le("saasset.gmt_in_store",param.getInStore_end());
        }
        if(param.getSaType()!=null){
            wrapper.eq("saasset.sa_type",param.getSaType());
        }


        IPage<Saasset> pageResult = saAssetMapper.listSaAsset(page,wrapper);
        return new PageResult(pageNum,pageSize,pageResult.getPages(),pageResult.getTotal(),
                pageResult.getRecords());

    }

    @Override
    @Transactional
    public int addSa(Saasset saasset) {
        return saAssetMapper.insert(saasset);

    }

    @Override
    public List<Saasset> listAllAsset() {

        return saAssetMapper.selectList(null);
    }


}
