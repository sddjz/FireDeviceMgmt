package com.example.mybatis_demo.service.impl.auth;

import cn.hutool.extra.template.engine.wit.WitTemplate;
import com.example.mybatis_demo.entity.Logonuser;
import com.example.mybatis_demo.entity.Menu;
import com.example.mybatis_demo.entity.auth.LoginUser;
import com.example.mybatis_demo.mapper.LogonuserMapper;
import com.example.mybatis_demo.mapper.RoleMapper;
import com.example.mybatis_demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

import static java.lang.System.in;
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    LogonuserMapper logonuserMapper;

    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

       //fetch info by username;
        Map keys = new HashMap();
        keys.put("logon_user",username);
        Logonuser logonUser = (Logonuser) logonuserMapper.selectByMap(keys).get(0);
        Long userId = logonUser.getEmpId();
        System.out.println("Emp id is "+ userId);

        //get menu list ;put name into the perms list;
        List<String> perms =new ArrayList<String>();
        List<Menu> menus = userMapper.FetchRole(userId).getMenuList();
        for(Menu item :menus){
            perms.add(item.getName());
        }

        return new LoginUser(logonUser,perms);
    }
}
