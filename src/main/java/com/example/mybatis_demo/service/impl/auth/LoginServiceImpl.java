package com.example.mybatis_demo.service.impl.auth;

import com.example.mybatis_demo.common.CommonResult;
import com.example.mybatis_demo.entity.Logonuser;
import com.example.mybatis_demo.entity.auth.LoginUser;
import com.example.mybatis_demo.service.auth.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.mybatis_demo.util.RedisCache;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import java.util.Objects;
import  com.example.mybatis_demo.util.JwtTokenUtil;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    RedisCache redisCache;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public String  login(String username, String password) {

        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password);
        Authentication authenticate = authenticationManager.authenticate(authToken);
        if(Objects.isNull(authenticate)){
            throw new RuntimeException("username or password is wrong");
        }

        //使用 userid 生成token
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();

        //generate token by usernName from LoginUser(impl UserDetail)
        //and new Date()
        String jwt = jwtTokenUtil.generateToken(loginUser);
        //saeve to SecurityContextHolder;
        SecurityContextHolder.getContext().setAuthentication(authToken);


        //save to redis;
        //key: login+logonUserId; value: authenticate obj;
        redisCache.setCacheObject("login_"+loginUser.getUser().getLogonUser(),loginUser);
        System.out.println("redisKey in Filter"+"login_"+loginUser.getUser().getId());

        return jwt;
    }

    @Override
    public UserDetailsService getAdminByUsername(String username){


        return null;
    }

}
