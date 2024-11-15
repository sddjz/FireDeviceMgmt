package com.example.mybatis_demo.controller;


import com.example.mybatis_demo.common.CommonResult;
import com.example.mybatis_demo.service.FiretypeService;
import com.example.mybatis_demo.service.SatypeService;
import com.example.mybatis_demo.service.impl.FiretypeServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/fatype")
public class FiretypeController {
    @Autowired
    private FiretypeService firetypeService;

    @ApiOperation(value = "get fa type list")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public CommonResult listFaType(Principal principal) {

        return CommonResult.success(firetypeService.listFireType());
    }
}

