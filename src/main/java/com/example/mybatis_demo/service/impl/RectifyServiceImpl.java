package com.example.mybatis_demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatis_demo.common.CommonResult;
import com.example.mybatis_demo.common.PageResult;
import com.example.mybatis_demo.dto.RectifyParam;
import com.example.mybatis_demo.entity.Rectify;
import com.example.mybatis_demo.entity.Rectifyfa;
import com.example.mybatis_demo.entity.Rectifyother;
import com.example.mybatis_demo.entity.Rectifysa;
import com.example.mybatis_demo.entity.Review;
import com.example.mybatis_demo.mapper.RectifyMapper;
import com.example.mybatis_demo.mapper.RectifyfaMapper;
import com.example.mybatis_demo.mapper.RectifyotherMapper;
import com.example.mybatis_demo.mapper.RectifysaMapper;
import com.example.mybatis_demo.service.RectifyService;
import com.example.mybatis_demo.service.ReviewService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jizhid
 * @since 2022-11-15
 */
@Service
public class RectifyServiceImpl extends ServiceImpl<RectifyMapper, Rectify> implements RectifyService {

    @Autowired
    private RectifyMapper rectifyMapper;
    
    @Autowired
    private RectifysaMapper rectifySaMapper;
    @Autowired
    private RectifyfaMapper rectifyFaMapper;
    @Autowired
    private RectifyotherMapper rectifyOtherMapper;
    
    @Autowired
    private ReviewService reviewService;

    @Override
    public PageResult<Rectify> listRectify(RectifyParam rectifyParam, int pageSize, int pageNum) {

/**
 *
 * private Date stTime;
 *     private Date endTime;
 *     private  int status;
 *     private Long bankId;
 */
        QueryWrapper<Rectify> wrapper = new QueryWrapper<>();
        if(rectifyParam!=null) {
            wrapper.eq("rectify.bank_id",rectifyParam.getBankId());
            if(rectifyParam.getStTime()!=null){
                wrapper.ge("rectify.started_time",rectifyParam.getStTime());
            }
            if(rectifyParam.getEndTime()!=null){
                wrapper.le("rectify.started_time",rectifyParam.getEndTime());
            }
            if(rectifyParam.getStatus() != null){
                wrapper.le("rectify.status",rectifyParam.getStatus());
            }

        }
        Page<Rectify> page =new Page<Rectify>(pageNum,pageSize);

        IPage<Rectify> pageResult  = rectifyMapper.listRectify(page, wrapper);


        return new PageResult(pageNum,pageSize,pageResult.getPages(),pageResult.getTotal(),
                pageResult.getRecords());
    }
    
    
    
    
    	
    @Override
    @Transactional
    public int addRectify(Rectify rectify,List<Rectifysa> saList, List<Rectifyfa> faList,List<Rectifyother> otherList, Long bankId) {
    	
    	rectify.setBankId(bankId);
    	rectify.setStatus(1);
    	int rt = rectifyMapper.insert(rectify);
    	if(rt!=1) {
    		return rt;
    	}
    	
    	
    	Long rectifyId = rectify.getId();
    	
    	for(Rectifysa saItem : saList) {
    		saItem.setRectifyId(rectifyId);
    		saItem.setStatus(1);
    		rectifySaMapper.insert(saItem);
    	}
    	

    	for(Rectifyfa faItem : faList) {
    		faItem.setRectifyId(rectifyId);
    		faItem.setStatus(1);
    		rectifyFaMapper.insert(faItem);
    	}
    	

    	for(Rectifyother otherItem : otherList) {
    		otherItem.setRectifyId(rectifyId);
    		otherItem.setStatus(1);
    		rectifyOtherMapper.insert(otherItem);
    	}
    	
    	
    	
    	/**
    	for(Rectifysa item :saList) {
    		item.set
    	}*/
    	
    	return rt;
    }





	@Override
	public Rectify getItemById(Long Id) {
		// TODO Auto-generated method stub
		QueryWrapper<Rectify> wrapper = new QueryWrapper<>();
		wrapper.eq("rectify.id", Id);
		Rectify result = rectifyMapper.getRectify(wrapper);
		if(result==null) {return null;}
		
		if(result.getReviewId()!=null) {
			Review review = reviewService.getById(result.getReviewId());
			result.setReviewDate(review.getReviewDate());
			result.setReviewSerialNum(review.getSerialNum());
			result.setReviewerName(review.getReviewerName());
		}
		
		return result;	
	}

}
