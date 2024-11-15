package com.example.mybatis_demo.service.impl;

import com.example.mybatis_demo.entity.Menu;
import com.example.mybatis_demo.mapper.MenuMapper;
import com.example.mybatis_demo.service.MenuService;
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
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

}
