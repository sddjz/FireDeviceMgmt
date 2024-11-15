package com.example.mybatis_demo.service;

import com.example.mybatis_demo.entity.User;
import com.example.mybatis_demo.entity.UserPos;
import com.baomidou.mybatisplus.extension.service.IService;
import  java.util.*;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jizhid
 * @since 2022-10-23
 */
public interface UserPosService extends IService<UserPos> {


    boolean updatePos(Long userId,List<UserPos> userPosList);
    boolean insertPos(Long userId,List<UserPos> userPos);
    boolean deactivePos(Long userId, Long posId);

}
