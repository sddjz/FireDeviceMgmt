package com.example.mybatis_demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mybatis_demo.entity.Logonuser;
import com.example.mybatis_demo.mapper.LogonuserMapper;
import com.example.mybatis_demo.service.LogonuserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.annotation.W3CDomHandler;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jizhid
 * @since 2022-10-23
 */
@Service
public class LogonuserServiceImpl extends ServiceImpl<LogonuserMapper, Logonuser> implements LogonuserService {

    @Autowired
    private  LogonuserMapper logonuserMapper;

    @Override
    public Logonuser GetLogonUserByName(String logonUserName) {
        if(logonUserName==null || logonUserName.isEmpty()) return null;

        QueryWrapper<Logonuser> wrapper = new QueryWrapper<Logonuser>();
        wrapper.eq("logon_User",logonUserName);
        return logonuserMapper.selectOne(wrapper);
    }
}
