package com.example.mybatis_demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatis_demo.common.PageResult;
import com.example.mybatis_demo.dto.ReviewParam;
import com.example.mybatis_demo.entity.Review;
import com.example.mybatis_demo.entity.User;
import com.example.mybatis_demo.mapper.ReviewMapper;
import com.example.mybatis_demo.service.LogonuserService;
import com.example.mybatis_demo.service.ReviewService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatis_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jizhid
 * @since 2022-11-14
 */
@Service
public class ReviewServiceImpl extends ServiceImpl<ReviewMapper, Review> implements ReviewService {


    @Autowired
    private  ReviewMapper reviewMapper;

    @Override
    public PageResult<Review> listReview(ReviewParam reviewParam, int pageSize, int pageNum) {


        QueryWrapper<Review> wrapper = new QueryWrapper<>();
        if(reviewParam!=null){
            if(reviewParam.getReviewerName()!=null){
                wrapper.like("review.reviewer_name",reviewParam.getReviewerName());
            }
            if(reviewParam.getStTime()!=null){
                wrapper.ge("review.review_date",reviewParam.getStTime());
            }
            if(reviewParam.getEndTime()!=null){
                wrapper.le("review.review_date",reviewParam.getEndTime());
            }
            wrapper.eq("review.bank_id",reviewParam.getBankId());
        }

        Page<Review> page =new Page<Review>(pageNum,pageSize);
        IPage<Review> pageResult  = reviewMapper.listReview(page, wrapper);

        return new PageResult(pageNum,pageSize,pageResult.getPages(),pageResult.getTotal(),
                pageResult.getRecords());

    }
}
