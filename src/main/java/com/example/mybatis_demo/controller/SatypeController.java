package com.example.mybatis_demo.controller;


import com.example.mybatis_demo.common.CommonResult;
import com.example.mybatis_demo.entity.Satype;
import com.example.mybatis_demo.service.SatypeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jizhid
 * @since 2022-11-08
 */
@RestController
@RequestMapping("/satype")
public class SatypeController {


    @Autowired
    private SatypeService satypeService;

    @ApiOperation(value = "get sa type list")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public CommonResult listSaType(Principal principal) {

        return CommonResult.success(satypeService.listSaType());
    }
}

