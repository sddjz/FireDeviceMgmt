package com.example.mybatis_demo.controller;


import com.example.mybatis_demo.common.CommonResult;
import com.example.mybatis_demo.dto.UserQueryParam;
import com.example.mybatis_demo.entity.Bank;
import com.example.mybatis_demo.entity.Logonuser;
import com.example.mybatis_demo.entity.Position;
import com.example.mybatis_demo.entity.User;
import com.example.mybatis_demo.service.BankService;
import com.example.mybatis_demo.service.LogonuserService;
import com.example.mybatis_demo.service.PositionService;
import com.example.mybatis_demo.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import  java.util.*;
import java.security.Principal;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jizhid
 * @since 2022-10-23
 */
@RestController
@RequestMapping("/position")
public class PositionController {
    @Autowired
    private PositionService positionService;


    @Autowired
    private UserService userService;

    @Autowired
    private LogonuserService logonuserService;

    @Autowired
    private BankService bankService;

    @ApiOperation(value = "get position  list label+name")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public CommonResult listPosition(Principal principal) {
        String userName = principal.getName();
        //
        Long userId = logonuserService.GetLogonUserByName(userName).getEmpId();

        User user  = userService.getById(userId);
        Long bank_id = user.getBankId();
        System.out.println("bank id is" + bank_id);

        List<Position> positionList = positionService.listPositionByBankLevel(bankService.getById(bank_id).getLevel());

        //positionService.FetchAccessedListByUserId(userId);

        /**
            if (userName==null){ return CommonResult.failed("username is wrong");}

                positionService.fetchAccessedPosByLogonUserName();
                return CommonResult.success(positionService.);
            }
        */
        return  CommonResult.success(positionList);
    }

    }

