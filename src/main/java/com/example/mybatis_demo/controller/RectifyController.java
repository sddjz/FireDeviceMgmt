package com.example.mybatis_demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mybatis_demo.common.CommonResult;
import com.example.mybatis_demo.dto.RectifyParam;
import com.example.mybatis_demo.dto.ReviewParam;
import com.example.mybatis_demo.entity.Rectify;
import com.example.mybatis_demo.entity.Rectifyfa;
import com.example.mybatis_demo.entity.Rectifyother;
import com.example.mybatis_demo.entity.Rectifysa;
import com.example.mybatis_demo.entity.Review;
import com.example.mybatis_demo.entity.User;
import com.example.mybatis_demo.mapper.RectifyMapper;
import com.example.mybatis_demo.service.LogonuserService;
import com.example.mybatis_demo.service.RectifyService;
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
 *
 * @author jizhid
 * @since 2022-11-15
 */
@RestController
@RequestMapping("/rectify")
public class RectifyController {

    @Autowired
    private RectifyService rectifyService;
    @Autowired
    private UserService userService;

    @Autowired
    private LogonuserService logonuserService;
    
    @Autowired
    private ReviewService reviewService;

    @ApiOperation(value = "list rectify   ")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public CommonResult list(RectifyParam rectifyParam, int pageSize, int pageNum, Principal principal) {

        String userName = principal.getName();
        //
        Long userId = logonuserService.GetLogonUserByName(userName).getEmpId();
        User user  = userService.getById(userId);
        Long bank_id = user.getBankId();
        System.out.println("bank id is" + bank_id);
        if(rectifyParam==null){
            rectifyParam = new RectifyParam();
        }
        rectifyParam.setBankId(bank_id);


        return CommonResult.success(rectifyService.listRectify(rectifyParam,pageSize,pageNum));
    }
    
    @ApiOperation(value = "add rectify   ")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public CommonResult add(@RequestBody Rectify rectify , Principal principal) {

        String userName = principal.getName();
        //
        Long userId = logonuserService.GetLogonUserByName(userName).getEmpId();
        User user  = userService.getById(userId);
        Long bankId = user.getBankId();
        System.out.println("bank id is" + bankId);

        if(rectify==null){
        	return CommonResult.failed("整改值为空");
        }
        
        rectify.setReviewId(null);
        System.out.println("-----------------------------ee");
        System.out.println(rectify);

        String serialNum = rectify.getReviewSerialNum();
        
        if(serialNum!=null  && (!serialNum.trim().isEmpty())) {
	        QueryWrapper<Review> wrapper = new QueryWrapper<>();
	        wrapper.eq("serial_num", serialNum);
	        Review item = reviewService.getOne(wrapper);
	        if(item==null) {
	        	return CommonResult.failed("评审 序列号 有误");
	        }
	        rectify.setReviewId(item.getId());
	     }
        
        rectify.setStartUserId(userId);
        
        int rt = rectifyService.addRectify(rectify,  rectify.getRectifysa(),  rectify.getRectifyfa(),  rectify.getRectifyother(),bankId);
        
        if(rt!=1) {
        	return CommonResult.failed("操作失败");
        }

        return CommonResult.success("操作成功");
    }
    
    @ApiOperation(value = "get rectify by id  ")
    @RequestMapping(value = "/getitem", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public CommonResult getById(@RequestParam Long itemId) {
    	
    	if(itemId<1l) {        return CommonResult.success("数据有误");}
    		
     	
        return CommonResult.success(rectifyService.getItemById(itemId));
    }
    
    
    
    

}

