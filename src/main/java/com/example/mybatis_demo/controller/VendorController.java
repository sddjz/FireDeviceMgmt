package com.example.mybatis_demo.controller;


import com.example.mybatis_demo.common.CommonResult;
import com.example.mybatis_demo.dto.SaAssetParam;
import com.example.mybatis_demo.dto.VendorParam;
import com.example.mybatis_demo.entity.Vendor;
import com.example.mybatis_demo.service.SaassetService;
import com.example.mybatis_demo.service.VendorService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jizhid
 * @since 2022-10-23
 */
@RestController
@RequestMapping("/vendor")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @ApiOperation(value = "get vendor list")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public CommonResult listVendor(VendorParam param, int pageSize, int pageNum) {

        return CommonResult.success(vendorService.listVendor(param,pageSize,pageNum));
    }


    @ApiOperation(value = "get All vendor list")
    @RequestMapping(value = "/listall",method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public CommonResult listAllVendor() {

        return CommonResult.success(vendorService.listAllVendor());
    }

    @ApiOperation(value = "add vendor list")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public CommonResult addVendor(@RequestBody Vendor vendor) {

        return CommonResult.success(vendorService.addVendor(vendor));
    }
}

