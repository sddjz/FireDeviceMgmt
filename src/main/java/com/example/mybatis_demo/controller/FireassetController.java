package com.example.mybatis_demo.controller;


import com.example.mybatis_demo.common.CommonResult;
import com.example.mybatis_demo.dto.FaAssetParam;
import com.example.mybatis_demo.dto.SaAssetParam;
import com.example.mybatis_demo.entity.Fireasset;
import com.example.mybatis_demo.entity.Saasset;
import com.example.mybatis_demo.service.FireassetService;
import com.example.mybatis_demo.service.SaassetService;
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
@RequestMapping("/fa")
public class FireassetController {
    @Autowired
    private FireassetService fireassetService;

    @ApiOperation(value = "get fa asset list")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public CommonResult listSaAsset(FaAssetParam param, @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                    @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum ) {

        return CommonResult.success(fireassetService.listAsset(param,pageSize,pageNum));
    }

    @ApiOperation(value = "add fa asset list")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public CommonResult    addFaAsset(@RequestBody Fireasset asset ) {

        try {
            int rt = fireassetService.addFa(asset);
            return CommonResult.success("操作成功");
        }catch(Exception e){
            return  CommonResult.failed("参数错误");
        }

    }

    @ApiOperation(value = "get fa asset list")
    @RequestMapping(value = "/listall",method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public CommonResult listAllSaAsset(FaAssetParam param ) {

        return CommonResult.success(fireassetService.listAllAsset());
    }

}

