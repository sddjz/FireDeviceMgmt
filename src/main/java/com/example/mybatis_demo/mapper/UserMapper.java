package com.example.mybatis_demo.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.mybatis_demo.entity.Role;
import com.example.mybatis_demo.entity.User;
import com.example.mybatis_demo.entity.UserPos;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.*;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {

     List<User> FetchUserInfo();

     Role FetchRole(long userId);
    /**
     * 动态查询
     */
    /**
    @Select("SELECT user.name " +
            " FROM user left join user_pos on user.id=user_pos.user_id  left join position on position.id=user_pos.pos_id " +
            " ${ew.customSqlSegment} ")
    */
    IPage<User> listUser(IPage<User> page, @Param("ew") Wrapper wrapper);

    User getUserDetail(Long userId);

    Long insertSelective(User user);
    
    //fetch user&pos information
    List<User> listUserPosition(Long bankId, @Param("ew")Wrapper wrapper);
}
