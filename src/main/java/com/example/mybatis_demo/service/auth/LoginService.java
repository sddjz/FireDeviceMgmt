package com.example.mybatis_demo.service.auth;

import com.example.mybatis_demo.common.CommonResult;
import com.example.mybatis_demo.entity.Logonuser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface LoginService {

    public String login(String username, String password);

    public UserDetailsService getAdminByUsername(String username);

}
