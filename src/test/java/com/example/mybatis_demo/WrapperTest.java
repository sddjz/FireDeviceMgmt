package com.example.mybatis_demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mybatis_demo.entity.User;
import com.example.mybatis_demo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class WrapperTest {

    @Autowired
    UserMapper mapper;


    @Test
    void contextLoads() {
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        wrapper.isNotNull("email");

                //.ge("",12)
      List<User> users = mapper.selectList(wrapper);
      users.forEach(System.out::println);
    }

    @Test
    void test_2() {
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        wrapper.eq("name","支行1——1处长");

        //.ge("",12)
        User user  = mapper.selectOne(wrapper);
        System.out.println(user);
    }


    @Test
    void test_3() {
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        wrapper.eq("name","支行2——2处长");
        //.ge("",12)
        //查询结果的数量
        Integer count   = mapper.selectCount(wrapper);
        System.out.println(count);

    }

    @Test //模糊查询
    void test_4() {
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        wrapper.notLike("name","e"). //不包含e的
                likeLeft("name","处长");
        //likeRight:t%百分号在右边；
        List<Map<String, Object>> maps = mapper.selectMaps(wrapper);
        maps.forEach(System.out::println);

    }

    @Test //连接查询；内查询
    void test_5() {
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        //也可以用between
        wrapper.inSql("id","select id from user where id >"+10);
        //likeRight:t%百分号在右边；
        List<Object> objects = mapper.selectObjs(wrapper);
        objects.forEach(System.out::println);

    }

    @Test //连接查询；内查询
    void test_6() {
        QueryWrapper<User> wrapper = new QueryWrapper<User>();


        wrapper.orderByDesc("name");
        List<Object> objects = mapper.selectObjs(wrapper);
        objects.forEach(System.out::println);

    }


}
