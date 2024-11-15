package com.example.mybatis_demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatis_demo.common.PageResult;
import com.example.mybatis_demo.dto.VendorParam;
import com.example.mybatis_demo.entity.Vendor;
import com.example.mybatis_demo.mapper.VendorMapper;
import com.example.mybatis_demo.service.VendorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.annotations.ApiKeyAuthDefinition;
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
public class VendorServiceImpl extends ServiceImpl<VendorMapper, Vendor> implements VendorService {

    @Autowired
    VendorMapper vendorMapper;
    @Override
    public PageResult<Vendor> listVendor(VendorParam param, int pageSize, int pageNum) {
        Page<Vendor> page = new Page<Vendor>(pageNum,pageSize);
        QueryWrapper<Vendor> wrapper = new QueryWrapper<>();
        if(param!=null&&param.getName()!=null)
            wrapper.like("name",param.getName());
        Page<Vendor> result = vendorMapper.selectPage(page,wrapper);
        return new PageResult(pageNum,pageSize,result.getPages(),result.getTotal(),result.getRecords());

    }

    @Override
    @Transactional
    public int addVendor(Vendor vendor) {
        return vendorMapper.insert(vendor);
    }

    @Override
    public List<Vendor> listAllVendor() {
        return vendorMapper.selectList(null);
    }
}
