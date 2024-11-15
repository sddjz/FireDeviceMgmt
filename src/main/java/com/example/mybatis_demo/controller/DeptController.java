package com.example.mybatis_demo.controller;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mybatis_demo.common.CommonResult;
import com.example.mybatis_demo.service.DeptService;
import com.example.mybatis_demo.service.LogonuserService;
import com.example.mybatis_demo.service.UserService;

import io.swagger.annotations.ApiOperation;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jizhid
 * @since 2022-10-23
 */
@RestController
@RequestMapping("/dept")
public class DeptController {
	
	@Autowired
	private DeptService deptService;
	
	@Autowired
	private LogonuserService logonuserService;
	
	@Autowired
	private UserService userService;
	
	 	
		@ApiOperation(value = "get dept list")
	    @RequestMapping(value = "/list",method = RequestMethod.GET)
	    @ResponseBody
	    @CrossOrigin
	    public CommonResult listDept(Principal principal) {

			   String userName = principal.getName();
	            //
	            Long userId = logonuserService.GetLogonUserByName(userName).getEmpId();

	            Long bankId = userService.getById(userId).getBankId();
	            //System.out.println("bank id is" + bank_id);
	        return CommonResult.success(deptService.listDept(bankId));
	    }
}

