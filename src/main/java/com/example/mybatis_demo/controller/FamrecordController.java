package com.example.mybatis_demo.controller;


import com.example.mybatis_demo.common.CommonResult;
import com.example.mybatis_demo.dto.FamParam;
import com.example.mybatis_demo.dto.SamParam;
import com.example.mybatis_demo.service.FamrecordService;
import com.example.mybatis_demo.service.SamrecordService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jizhid
 * @since 2022-11-08
 */
@RestController
@RequestMapping("/fam")
public class FamrecordController {
    @Autowired
    private FamrecordService famrecordService;

    @ApiOperation(value = "get fa record list")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public CommonResult listSaRecord(FamParam param, @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                     @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum ) {

        return CommonResult.success(famrecordService.listFaRecord(param,pageSize,pageNum));
    }
}

