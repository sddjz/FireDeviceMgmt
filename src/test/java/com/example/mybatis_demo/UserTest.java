package com.example.mybatis_demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatis_demo.dto.UserQueryParam;
import com.example.mybatis_demo.entity.Role;
import com.example.mybatis_demo.entity.Saasset;
import com.example.mybatis_demo.entity.User;
import com.example.mybatis_demo.mapper.RoleMapper;
import com.example.mybatis_demo.mapper.SaassetMapper;
import com.example.mybatis_demo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
@SpringBootTest
public class UserTest {

    //FetchUserInfo

    @Autowired
    UserMapper mapper;

    @Test
    void test_listUserDetail() {


        String str ="1583584289143787524";
        User user =mapper.getUserDetail(        Long.parseLong(str)     );
        System.out.println(user);

    }
    @Test
    void test_listUser(){
        UserQueryParam param = new UserQueryParam();
        param.setStatus(1);
        param.setPosId(1);
        param.setPos_date("2021-01-02");
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        int default_enabled = 1;
        if(param.getStatus()!=null){
            default_enabled = param.getStatus();
        }
        //员工在职状态《1：在职；2：离职》
        wrapper.eq("user.status",default_enabled);

        if(param.getPos_date()!=null){
            wrapper.ge("user_pos.st_time",param.getPos_date());
        }

        if(param.getPosId()!=null){
            wrapper.eq("position.id",param.getPosId());
        }


System.out.println("111111111111111111111111");
        System.out.println(default_enabled);
System.out.println(wrapper.getSqlSelect());
        System.out.println(wrapper.getCustomSqlSegment());
        System.out.println("222222222222222222222222222");

        System.out.println(wrapper.getCustomSqlSegment());

        int pageNum =1;
        int pageSize =5;
        Page<User> page =new Page<User>(pageNum,pageSize);

        IPage<User> pageResult = mapper.listUser(page,wrapper);
        if(pageResult.getSize()<1){
            System.out.println("no data");
            return;
        }
        List<User> records = pageResult.getRecords();


        System.out.println("-----------------------------------------------");
        System.out.println("-----------------------------------------------");

        for (User user : records) {
            System.out.println(user.getName());
        }
    }



    @Test
    void test_FetchRole(){

        Role role =mapper.FetchRole(mapper.selectList(null).get(0).getId());
        System.out.println(role.getName());
        role.getMenuList().forEach(System.out::println);
    }



    @Test
    void test_1st(){

        mapper.selectList(null);
    }


    @Test
    void contextLoads() {


        List<User> users = mapper.FetchUserInfo();
        //users.forEach(System.out::print);
        for (User item :users) {
            System.out.println("---------------------");
            System.out.println(item);
        }
    }
}
