package com.example.mybatis_demo.service;

import com.example.mybatis_demo.common.PageResult;
import com.example.mybatis_demo.dto.RectifyParam;
import com.example.mybatis_demo.entity.Rectify;
import com.example.mybatis_demo.entity.Rectifyfa;
import com.example.mybatis_demo.entity.Rectifyother;
import com.example.mybatis_demo.entity.Rectifysa;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jizhid
 * @since 2022-11-15
 */
public interface RectifyService extends IService<Rectify> {

    PageResult<Rectify> listRectify(RectifyParam rectifyParam, int pageSize, int pageNum);
    
    int addRectify(Rectify rectify,List<Rectifysa> saList, List<Rectifyfa> faList,List<Rectifyother> otherList,Long bankId) ;
	
    /**
     * get rectify object and review information;
     * @param Id
     * @return
     */
    Rectify getItemById(Long Id) ;

}
