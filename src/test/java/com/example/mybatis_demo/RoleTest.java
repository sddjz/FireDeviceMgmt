package com.example.mybatis_demo;

import com.example.mybatis_demo.entity.Role;
import com.example.mybatis_demo.mapper.RoleMapper;
import com.example.mybatis_demo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RoleTest {

    @Autowired
    RoleMapper role_mapper;

    @Autowired
    UserMapper userMapper;


    @Test
    public void test_role(){


        Role role = userMapper.FetchRole(userMapper.selectList(null).get(0).getId());
        System.out.println(role.getName());

    }
}
