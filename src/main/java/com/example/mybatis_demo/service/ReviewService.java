package com.example.mybatis_demo.service;

import com.example.mybatis_demo.common.PageResult;
import com.example.mybatis_demo.dto.ReviewParam;
import com.example.mybatis_demo.entity.Review;
import com.baomidou.mybatisplus.extension.service.IService;

import java.security.Principal;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jizhid
 * @since 2022-11-14
 */
public interface ReviewService extends IService<Review> {

        PageResult<Review>  listReview(ReviewParam reviewParam,int pageSize, int pageNum);
}
