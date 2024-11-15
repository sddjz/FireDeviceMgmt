package com.example.mybatis_demo.service.impl;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.mybatis_demo.entity.UserPos;
import com.example.mybatis_demo.mapper.UserPosMapper;
import com.example.mybatis_demo.service.UserPosService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mybatis_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;
import java.time.LocalDate;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jizhid
 * @since 2022-10-23
 */
@Service
public class UserPosServiceImpl extends ServiceImpl<UserPosMapper, UserPos> implements UserPosService {


    @Autowired
    private UserPosMapper userPosMapper;

    @Autowired
    private UserService userService;

    @Transactional
    @Override
    public boolean updatePos(Long userId,List<UserPos> userPosList) {

        if(userPosList==null||userPosList.isEmpty()){
            this.deactivePos(userId,0l);
            return true;
        }

        //userService.getById(userId);
        Map<String,Object> map =new HashMap<String,Object>();
        map.put("user_id",userId);
        map.put("enabled",1);

        List<UserPos> cur_pos = userPosMapper.selectByMap(map);
        for(UserPos userPos: userPosList) {
            boolean existed = false;
            Iterator<UserPos> it = cur_pos.iterator();
            while (it.hasNext()) {
                UserPos pos = it.next();
                if ( userPos.getPosId() == pos.getPosId() && userPos.getDeptId() == pos.getDeptId() )
                {
                    existed = true;
                    if(userPos.getParentId()!=pos.getParentId()){
                        userPos.setId(pos.getId());
                        this.updatePosInfo(userPos);
                    }
                    it.remove();
                    //当前状态 enabled=0;
                    break;
                }
                //userPosMapper.insert(userPos);
            }
            if(!existed) {

                List<UserPos> tmpList = new ArrayList<UserPos>();
                tmpList.add(userPos);
                this.insertPos(userId,tmpList);
            }
        }
        for(UserPos item: cur_pos){
            this.deactivePos(item.getUserId(),item.getPosId());
        }
        return true;
    }

    @Transactional
    public  void updatePosInfo( UserPos userPos){
        if(userPos.getStTime()==null)
            userPos.setStTime(new Date());
        userPosMapper.updateById(userPos);
    }

    @Transactional
    @Override
    public boolean insertPos(Long userId,List<UserPos> userPosList) {
        for(UserPos userPos:userPosList) {
            userPos.setUserId(userId);
            if (userPos.getStTime() == null) {
                userPos.setStTime(new Date());
            }
            //userPosMapper.insertSelective(userPos);
            userPosMapper.insert(userPos);
        }
        return true;
    }

    @Override
    @Transactional
    public boolean deactivePos(Long userId, Long posId) {
        UpdateWrapper<UserPos> wrapper = new UpdateWrapper<>();
        wrapper.eq("user_id",userId);
        if(posId!=0)
            wrapper.eq("pos_id",posId);

        wrapper.set("enabled",0);
        wrapper.set("end_time",new Date());
        userPosMapper.update(null,wrapper);

        return false;
    }
}
