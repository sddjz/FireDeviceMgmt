package com.example.mybatis_demo.service.impl;

import com.example.mybatis_demo.entity.Bank;
import com.example.mybatis_demo.mapper.BankMapper;
import com.example.mybatis_demo.service.BankService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jizhid
 * @since 2022-10-23
 */
@Service
public class BankServiceImpl extends ServiceImpl<BankMapper, Bank> implements BankService {

}
