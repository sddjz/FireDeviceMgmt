package com.example.mybatis_demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatis_demo.dto.SaAssetParam;
import com.example.mybatis_demo.dto.UserQueryParam;
import com.example.mybatis_demo.entity.Saasset;
import com.example.mybatis_demo.entity.User;
import com.example.mybatis_demo.mapper.SaassetMapper;
import com.example.mybatis_demo.mapper.UserMapper;
import com.example.mybatis_demo.service.impl.SaassetServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
public class Saasset_test {

    @Autowired
    SaassetMapper mapper;
    @Test
    void contextLoads() {
        /**
        List<Saasset> users = mapper.selectList(null);
        users.forEach(System.out::print);
         */
        SaAssetParam param = new SaAssetParam();
        param.setSaStatus(1);
        param.setSaType(1);

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
        int pageNum =1;
        int pageSize =5;
        Page<Saasset> page =new Page<Saasset>(pageNum,pageSize);

        IPage<Saasset> pageResult = mapper.listSaAsset(page,wrapper);
        List<Saasset> records = pageResult.getRecords();


        System.out.println("-----------------------------------------------");
        System.out.println("-----------------------------------------------");

        for (Saasset asset : records) {
            System.out.println(asset.getName());
        }
    }
}
