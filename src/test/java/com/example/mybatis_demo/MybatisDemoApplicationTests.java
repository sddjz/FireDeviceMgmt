package com.example.mybatis_demo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatis_demo.entity.User;
import com.example.mybatis_demo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;
import java.util.*;
@SpringBootTest
class MybatisDemoApplicationTests {

    @Autowired
    UserMapper mapper;
    @Test
    void contextLoads() {
        List<User> users = mapper.selectList(null);
        users.forEach(System.out::print);
    }

    /**
     * 查询时候会自动过滤逻辑删除的记录
     *
     *
     *
     */
    // test delete
    //select 多个
    @Test
    void testDeleteLogic(){
        mapper.deleteById(1583584289143787525l);
    }


    // test delete
    //select 多个
    @Test
    void testDeleteId(){
        mapper.deleteById(1583584289143787525l);


    }

    // test delete
    //select 多个
    @Test
    void testDeleteBatchId(){
        mapper.deleteBatchIds(Arrays.asList(1583584289143787525l,1583584289143787524l));
    }

    // test delete
    //select 多个
    @Test
    void testDeleteMap(){
        Map<String,Object> maps = new HashMap<String,Object>();
        maps.put("name","支行2——2处长");
       mapper.deleteByMap(maps);

    }

    // test select
    //select 多个
    @Test
    void testSelectBatch(){
        User user = new User();
        List<User> users = mapper.selectBatchIds(Arrays.asList(1583584289143787524l,1583584289143787525l));
        users.forEach(System.out::println);

    }

    // test select
    //select 多个
    @Test
    //自定义条件查询  简单的下
    void testSelectByMap(){
        Map map = new HashMap();
        map.put("name","支行1——1处长");
        map.put("address","1_jiali");

        List<User> users = mapper.selectByMap(map);
        users.forEach(System.out::println);

    }



    @Test
    //分页
    void testSelectPage(){


      Page<User> page =new Page<User>(1,5);

      mapper.selectPage(page,null);
      //记录数目
      System.out.println(page.getTotal());
      List<User> users = page.getRecords();

       users.forEach(System.out::println);

    }



    // test insert
    @Test
    void testInsert(){
        User user1 = new User();
        user1.setName("支行1——1处长");
        user1.setAddress("1_jiali");
        //371526198710022400
        user1.setSocialId("371526198710022400");
        //user1.setPassword("111");
        int result = mapper.insert(user1);
        System.out.println(result);
        System.out.println(user1);

        User user = new User();
        user.setName("支行2——2处长");
        user.setAddress("2_jiali");
        //371526198710022400
        user.setSocialId("372526198710022400");
        //user.setPassword("111");

        result = mapper.insert(user);
        System.out.println(result);
        System.out.println(user);
    }

    // test insert
    @Test
    void testUpdate(){
        User user = new User();
        user.setId(1583584289143787525l);
        user.setEmail("jz222@vm.com");



        int result = mapper.updateById(user);
        System.out.println(result);
        System.out.println(user);
    }


    // test insert
    @Test
    void testOptimisticLock(){


        User user = mapper.selectById(1583584289143787525l);
        user.setEmail("jzxxx222@vm.com");
        int result = mapper.updateById(user);
        System.out.println(result);
        System.out.println(user);
    }


    // test insert
    @Test
    void testOptimisticLock2(){


        User user1 = mapper.selectById(1583584289143787525l);
        user1.setEmail("jz_11@vm.com");

  //模拟多线程，抢先更新；
        User user2 = mapper.selectById(1583584289143787525l);
        user2.setEmail("jz_22@vm.com");

        int result2 = mapper.updateById(user2);

        //更新失败 用自旋锁 解决
        //多线程下一定要枷锁
        //User:@version+@config
        int result1 = mapper.updateById(user1);

        System.out.println(result1);
        System.out.println(result2);

    }
    //数据库级别，自动填充
    //
}
