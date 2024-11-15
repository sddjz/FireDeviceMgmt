package com.example.mybatis_demo.controller;


import com.example.mybatis_demo.common.CommonResult;
import com.example.mybatis_demo.dto.UserQueryParam;
import com.example.mybatis_demo.entity.User;
import com.example.mybatis_demo.entity.UserPos;
import com.example.mybatis_demo.service.LogonuserService;
import com.example.mybatis_demo.service.UserService;

import cn.hutool.core.lang.UUID;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

/**
 * <p>
 *  前端控制器
         * </p>
        *
        * @author jizhid
        * @since 2022-10-23
        */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private LogonuserService logonuserService;

    
    //获取yaml中配置的上传路径属性
    @Value(("${thk.imagesRealPath}"))
    private String uploadPath;
    
    //获取yaml中配置的上传路径属性
    @Value(("${thk.imagesServerPath}"))
    private String imgServerPath;


    @ApiOperation(value = "get user list")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public CommonResult listUser(UserQueryParam param, @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                 @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {

        param.print("in contrller-----------;");

        return CommonResult.success(userService.listUser(param, pageSize, pageNum));
    }


    @ApiOperation(value = "get user detail information")
    @RequestMapping(value = "/userdetail", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public CommonResult getUserDetail(@RequestParam String userId) {


        try {
            System.out.println("in contrller-------dd----: " + userId);

            Long params = Long.parseLong(userId);
            return CommonResult.success(userService.getUserDetail(params));

        } catch (Exception e) {
            return CommonResult.failed("参数异常");
        }
    }

    @ApiOperation(value = "upload  img   ")
    @PostMapping(value = "/upload")
    @ResponseBody
    @CrossOrigin
    // @RequestBody @RequestParam("fileRaw") ,consumes=MediaType.MULTIPART_FORM_DATA_VALUE
    public CommonResult upload( @RequestPart(value = "fileUpload",required = false)  MultipartFile fileUpload) {


        String fileName = fileUpload.getOriginalFilename();  //获取文件原名
        String visibleUri="/"+imgServerPath+"/"+fileName;     //拼接访问图片的地址
        String saveUri=uploadPath+"/"+fileName;        //拼接保存图片的真实地址

        //log.info("图片原文件名={} 图片访问地址={} 图片保存真实地址={}",fileName,visibleUri,saveUri);

        File saveFile = new File(saveUri);
        //判断是否存在文件夹，不存在就创建，但其实可以直接手动确定创建好，这样不用每次保存都检测
        if (!saveFile.exists()){
            saveFile.mkdirs();
        }
        try {
        	fileUpload.transferTo(saveFile);  //保存文件到真实存储路径下
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  CommonResult.success("success");
    }
    
    
    @ApiOperation(value = "create  user  ")
    @PostMapping(value = "/add")
    @ResponseBody
    @CrossOrigin
    // @RequestBody @RequestParam("fileRaw") ,consumes=MediaType.MULTIPART_FORM_DATA_VALUE
    public CommonResult create(@RequestPart(value="user") User user, @RequestPart(value = "fileUpload",required = false)  MultipartFile fileUpload) {

		        System.out.println(user);
		        System.out.println(fileUpload);
		 
        
		        String fileName = fileUpload.getOriginalFilename();  //获取文件原名
		        String visibleUri="/"+imgServerPath+"/"+fileName;     //拼接访问图片的地址
		        String saveUri=uploadPath+"/"+fileName;        //拼接保存图片的真实地址
		
		        //log.info("图片原文件名={} 图片访问地址={} 图片保存真实地址={}",fileName,visibleUri,saveUri);
		
		        String accessPath = this.imgServerPath;
		        
		        File saveFile = new File(saveUri);
		        //判断是否存在文件夹，不存在就创建，但其实可以直接手动确定创建好，这样不用每次保存都检测
		        
		        if (!saveFile.exists()){
		            saveFile.mkdirs();
		        }
		        try {
		        	fileUpload.transferTo(saveFile);  //保存文件到真实存储路径下
		        } catch (IOException e) {
		            e.printStackTrace();
		        }

		        user.setHeadImage(visibleUri);
	            return CommonResult.success(userService.insertUser(user, user.getUserPosList()));

    }

    @ApiOperation(value = "update  user  ")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public CommonResult update( User user, @RequestBody List<UserPos> userPosList) {


        try {
            System.out.println("in contrller-------dd----: " + user + "userPos" + userPosList);

            return CommonResult.success(userService.updateUser(user, userPosList));

        } catch (Exception e) {
            return CommonResult.failed("参数异常");
        }
    }


    @ApiOperation(value = "get users in same bank  ")
    @RequestMapping(value = "/getinbank", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public CommonResult getUsersInSameBank(Principal principal) {
        try {
            String userName = principal.getName();
            //
            Long userId = logonuserService.GetLogonUserByName(userName).getEmpId();

            Long bank_id = userService.getById(userId).getBankId();
            System.out.println("bank id is" + bank_id);
            return CommonResult.success(userService.getUsersInSameBank(bank_id));

        } catch (Exception e) {
            return CommonResult.failed("参数异常");
        }
    }
    
    @ApiOperation(value = "get user level&position in same bank  ")
    @RequestMapping(value = "/poslist", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public CommonResult getUserLevel(Principal principal) {
    	 
    	        String userName = principal.getName();
    	        //
    	        Long userId = logonuserService.GetLogonUserByName(userName).getEmpId();
    	        User user  = userService.getById(userId);
    	        Long bankId = user.getBankId();
    	        System.out.println("bank id is" + bankId);
    	        
    	        return CommonResult.success(userService.listUserPosition(bankId));
    }

}
