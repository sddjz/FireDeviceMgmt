package com.example.mybatis_demo.controller;


import com.example.mybatis_demo.common.CommonResult;
import com.example.mybatis_demo.dto.SaAssetParam;
import com.example.mybatis_demo.dto.UserQueryParam;
import com.example.mybatis_demo.entity.Saasset;
import com.example.mybatis_demo.service.SaassetService;
import com.example.mybatis_demo.service.UserService;
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
@RequestMapping("/sa")
public class SaassetController {


        @Autowired
        private SaassetService saAssetService;

        @ApiOperation(value = "get sa asset list")
        @RequestMapping(value = "/list",method = RequestMethod.GET)
        @ResponseBody
        @CrossOrigin
        public CommonResult listSaAsset(SaAssetParam param, @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum ) {

            return CommonResult.success(saAssetService.listAsset(param,pageSize,pageNum));
        }

        @ApiOperation(value = "add sa asset list")
        @RequestMapping(value = "/add",method = RequestMethod.POST)
        @ResponseBody
        @CrossOrigin
        public CommonResult    addSaAsset(@RequestBody Saasset asset ) {

              try {
                      int rt = saAssetService.addSa(asset);
                      return CommonResult.success("操作成功");
              }catch(Exception e){
                     return  CommonResult.failed("参数错误");
              }
        }

    @ApiOperation(value = "get all sa asset list")
    @RequestMapping(value = "/listall",method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public CommonResult listAllSaAsset() {

        return CommonResult.success(saAssetService.listAllAsset());
    }

}

