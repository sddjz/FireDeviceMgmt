package com.example.mybatis_demo.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mybatis_demo.common.CommonResult;
import com.example.mybatis_demo.dto.LoginParam;
import com.example.mybatis_demo.entity.Logonuser;
import com.example.mybatis_demo.entity.Role;
import com.example.mybatis_demo.entity.User;
import com.example.mybatis_demo.service.LogonuserService;
import com.example.mybatis_demo.service.UserService;
import com.example.mybatis_demo.service.auth.LoginService;
import io.micrometer.core.instrument.util.IOUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;

import javax.management.Query;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.*;

//https://blog.csdn.net/lyl54545/article/details/123672271
@CrossOrigin
@RestController
@Api(tags = "admin_controller")
@Tag(name = "AdminController", description = "后台用户管理")
@RequestMapping("/admin")
public class admin {

	   @Value("${jwt.tokenHead}")
	    private String tokenHead;

	   @Value("${jwt.tokenHeader}")
	   private String tokenHeader;

    @Autowired
    private LoginService adminService;

    @Autowired
    private LogonuserService logonuserService;

    @Autowired
    private UserService userService;

        @ApiOperation(value = "登录以后返回token")
        @RequestMapping(value = "/login",method = RequestMethod.POST)
        @ResponseBody
        @CrossOrigin
        //public CommonResult login(  @RequestBody LoginParam loginParam) {
        public CommonResult login( @Validated @RequestBody  LoginParam loginParam) {


            System.out.println(loginParam.getPassword());
            System.out.println(loginParam.getUsername());
            String token = adminService.login(loginParam.getUsername(), loginParam.getPassword());
            if (token == null) {
                return CommonResult.validateFailed("用户名或密码错误");
            }
            Map<String, String> tokenMap = new HashMap<>();
            tokenMap.put("token", token);
            tokenMap.put("tokenHead", tokenHead);
            return CommonResult.success(tokenMap);
        }



            @ApiOperation(value = "退出登录")
            @RequestMapping(value = "/logout",method = RequestMethod.POST)
            @ResponseBody
            @CrossOrigin
            //public CommonResult login(  @RequestBody LoginParam loginParam) {
            public CommonResult logout( ) {
                    return CommonResult.success(null);
            }

        @ApiOperation(value = "get info  ")
        @RequestMapping(value = "/info",method = RequestMethod.GET)
        @ResponseBody
        @CrossOrigin
        //public CommonResult login(  @RequestBody LoginParam loginParam) {
        public CommonResult FetchUserInfo(Principal principal) {
            String userName = principal.getName();
    //get user info by logonUser;


            Logonuser logonUser = logonuserService.GetLogonUserByName(userName);
            if (logonUser==null){ return CommonResult.failed("username is wrong");}

            Role role = userService.FetchRoleByUserId(logonUser.getEmpId());

            Map<String, Object> data = new HashMap<>();
            data.put("username", userName);
            data.put("menus", role.getMenuList());
            data.put("icon",role.getMenuList().get(0).getIcon());
            //get menu list by
            data.put("roles",role.getName());
            return CommonResult.success(data);

        }
    /**
     *
     *    UmsAdmin umsAdmin = adminService.getAdminByUsername(username);
     *         Map<String, Object> data = new HashMap<>();
     *         data.put("username", umsAdmin.getUsername());
     *         data.put("menus", roleService.getMenuList(umsAdmin.getId()));
     *         data.put("icon", umsAdmin.getIcon());
     *         List<UmsRole> roleList = adminService.getRoleList(umsAdmin.getId());
     *         if(CollUtil.isNotEmpty(roleList)){
     *             List<String> roles = roleList.stream().map(UmsRole::getName).collect(Collectors.toList());
     *             data.put("roles",roles);
     *         }
     *         return CommonResult.success(data);
     *     }
     */


}

