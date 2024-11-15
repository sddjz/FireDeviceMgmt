package com.example.mybatis_demo;

import com.example.mybatis_demo.entity.Satype;
import com.example.mybatis_demo.mapper.SaassetMapper;
import com.example.mybatis_demo.mapper.SatypeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import  java.util.*;
@SpringBootTest
public class SaTypeTest {
    @Autowired
    SatypeMapper mapper;

    @Test
    void contextLoads() {

        List<Satype> rt = mapper.selectList(null);
        rt.forEach(System.out::println);
    }
}
