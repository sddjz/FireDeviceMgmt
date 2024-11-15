package com.example.mybatis_demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatis_demo.common.CommonResult;
import com.example.mybatis_demo.common.PageResult;
import com.example.mybatis_demo.dto.UserParam;
import com.example.mybatis_demo.dto.UserQueryParam;
import com.example.mybatis_demo.entity.Role;
import com.example.mybatis_demo.entity.User;
import com.example.mybatis_demo.entity.UserPos;
import com.example.mybatis_demo.mapper.UserMapper;
import com.example.mybatis_demo.mapper.UserPosMapper;
import com.example.mybatis_demo.service.UserPosService;
import com.example.mybatis_demo.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.netty.util.internal.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author jizhid
 * @since 2022-10-23
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private UserPosService userPosService;

	@Override
	public Role FetchRoleByUserId(Long userId) {
		Role role = userMapper.FetchRole(userId);
		if (role == null) {
			CommonResult.failed("invalid userid");
			return null;
		}
		return role;
	}

	/**
	 *
	 * select * from user left join user_pos on user.id=user_pos.user_id left join
	 * position on user_pos.pos_id = position.id
	 * 
	 * @param param
	 * @param pageSize
	 * @param pageNum
	 * @return
	 */
	@Override
	public PageResult<User> listUser(UserQueryParam param, int pageSize, int pageNum) {

		System.out.println("UserQueryParam value are as followings: ");
		Page<User> page = new Page<User>(pageNum, pageSize);
		param.print("UserQueryParam print is:");

		/**
		 * default 
		 */
		
		QueryWrapper<User> wrapper = new QueryWrapper<>();
	
		if (param.getPos_date() != null) {
			wrapper.ge("user_pos.st_time", param.getPos_date());
		}
		if (param.getPosId() != null) {
			wrapper.eq("user_pos.pos_id", param.getPosId());
		}else {
			wrapper.eq("user_pos.enabled", 1);
			wrapper.eq("user.status",1);
		}
		int default_status = 1;
		if (param.getStatus() != null) {
			default_status = param.getStatus();
			wrapper.eq("user.status", default_status);
		}
		
		IPage<User> pageResult = userMapper.listUser(page, wrapper);
		return new PageResult(pageNum, pageSize, pageResult.getPages(), pageResult.getTotal(), pageResult.getRecords());

		/**
		 * 记录数目 System.out.println(page.getTotal()); List<User> users =
		 * page.getRecords();
		 * 
		 * 
		 * return null;
		 */
	}

	@Override
	public User getUserDetail(Long userId) {

		User user = userMapper.getUserDetail(userId);
		System.out.println(user.getName());
		return user;
	}

	@Override
	public List<User> getUsersInSameBank(Long bank_id) {
		QueryWrapper<User> wrapper = new QueryWrapper<>();
		wrapper.eq("bank_id", bank_id);
		return userMapper.selectList(wrapper);
	}

	@Transactional
	@Override
	public boolean insertUser(User user, List<UserPos> userPosList) {
		/**
		 * PmsBrand pmsBrand = new PmsBrand(); BeanUtils.copyProperties(pmsBrandParam,
		 * pmsBrand); //如果创建时首字母为空，取名称的第一个为首字母 if
		 * (StrUtil.isEmpty(pmsBrand.getFirstLetter())) {
		 * pmsBrand.setFirstLetter(pmsBrand.getName().substring(0, 1)); } return
		 * brandMapper.insertSelective(pmsBrand);
		 */
		/**
		 * user+user_pos;
		 */
		// BeanUtils.copyProperties(userParam,user);
		// Long rt = userMapper.insertSelective(user);
		int rt = userMapper.insert(user);
		if (rt != 0) {
			System.out.println("insert result:" + rt);
			userPosService.insertPos(user.getId(), userPosList);
		}

		return true;
	}

	@Override
	public boolean updateUser(User user, List<UserPos> userPosList) {

		// userMapper.insertSelective(user);
		// this.constructUserPos(userParam);
		UpdateWrapper<User> wrapper = new UpdateWrapper<>();
		wrapper.eq("id", user.getId());
		userMapper.update(user, wrapper);
		userPosService.updatePos(user.getId(), userPosList);
		return true;
	}

	@Override
	public List<User> listUserPosition(Long bankId) {
		// TODO Auto-generated method stub
		QueryWrapper<User> wrapper = new QueryWrapper<>();
		
		wrapper.eq("user.bank_id",bankId);
		
		return userMapper.listUserPosition(bankId,wrapper);
	}

	/**
	 * private UserPos constructUserPos(UserParam userParam){ UserPos userPos = new
	 * UserPos();
	 * 
	 * userPos.setParent_id(userParam.getPos_parentId());
	 * userPos.setUserId(userParam.getId());
	 * userPos.setEnabled(userParam.getPos_enabled());
	 * userPos.setStTime(userParam.getPos_start());
	 * userPos.setEndTime(userParam.getPos_end());
	 * userPos.setDept_id(userParam.getDeptId()); return userPos; }
	 * 
	 * public boolean validateUser(User user){ if(user.getSocial_id()==null){ return
	 * false; }
	 * 
	 * 
	 * return true; }
	 */

}
