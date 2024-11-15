package com.example.mybatis_demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mybatis_demo.entity.Position;
import com.example.mybatis_demo.mapper.PositionMapper;
import com.example.mybatis_demo.service.PositionService;
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
public class PositionServiceImpl extends ServiceImpl<PositionMapper, Position> implements PositionService {

    @Autowired
    private PositionMapper positionMapper;

    @Override
    public List<Position> listPosition() {

        return positionMapper.selectList(null);

    }

    @Override
    public List<Position> listPositionByBankLevel(int bankLevel) {
        QueryWrapper<Position> wrapper = new QueryWrapper<>();
        wrapper.eq("bank_level",bankLevel);
        return positionMapper.selectList(wrapper);

    }

    @Override
    public List<Position> FetchAccessedListByUserId(Long userId) {


        return null;
    }
}
