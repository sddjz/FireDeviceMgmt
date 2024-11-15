package com.example.mybatis_demo.controller;


import com.example.mybatis_demo.common.CommonResult;
import com.example.mybatis_demo.dto.ReviewParam;
import com.example.mybatis_demo.entity.User;
import com.example.mybatis_demo.entity.UserPos;
import com.example.mybatis_demo.service.LogonuserService;
import com.example.mybatis_demo.service.ReviewService;
import com.example.mybatis_demo.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 * 检查管理
 * @author jizhid
 * @since 2022-11-14
 */
@RestController
@RequestMapping("/review")

public class ReviewController {


    @Autowired
    private ReviewService reviewService;
    @Autowired
    private UserService userService;

    @Autowired
    private LogonuserService logonuserService;

    @ApiOperation(value = "list reivew   ")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public CommonResult list(ReviewParam reviewParam, int pageSize, int pageNum, Principal principal) {

        String userName = principal.getName();
        //
        Long userId = logonuserService.GetLogonUserByName(userName).getEmpId();
        User user  = userService.getById(userId);
        Long bank_id = user.getBankId();
        System.out.println("bank id is" + bank_id);
        if(reviewParam==null){
            reviewParam = new ReviewParam();
        }
        reviewParam.setBankId(bank_id);
        return CommonResult.success(reviewService.listReview(reviewParam,pageSize,pageNum));
    }

}
