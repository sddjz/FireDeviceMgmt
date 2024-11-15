package com.example.mybatis_demo.service;

import com.example.mybatis_demo.entity.Position;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.*;
/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jizhid
 * @since 2022-10-23
 */
public interface PositionService extends IService<Position> {

    List<Position> listPosition();

    List<Position> listPositionByBankLevel(int bankLevel);

    List<Position> FetchAccessedListByUserId(Long userId);
}
