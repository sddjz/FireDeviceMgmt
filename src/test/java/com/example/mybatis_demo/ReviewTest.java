package com.example.mybatis_demo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatis_demo.entity.Review;
import com.example.mybatis_demo.mapper.ReviewMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ReviewTest {

    @Autowired
    ReviewMapper reviewMapper;

    @Test
    public  void test_get_review_list(){
        int pageNum=1, pageSize=5;

        Page<Review> page =new Page<Review>(pageNum,pageSize);
        QueryWrapper<Review> wrapper = new QueryWrapper<>();

            wrapper.eq("review.bank_id",1L);
        List<Review> reviewList = reviewMapper.listReview(page,wrapper).getRecords();
        reviewList.forEach(System.out::println);


    }
}
