package com.example.mybatis_demo.service.impl;

import com.example.mybatis_demo.entity.Role;
import com.example.mybatis_demo.mapper.RoleMapper;
import com.example.mybatis_demo.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jizhid
 * @since 2022-10-28
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
