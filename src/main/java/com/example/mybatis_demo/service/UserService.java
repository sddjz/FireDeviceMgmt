package com.example.mybatis_demo.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.mybatis_demo.common.PageResult;
import com.example.mybatis_demo.dto.UserQueryParam;
import com.example.mybatis_demo.entity.Role;
import com.example.mybatis_demo.entity.User;
import com.example.mybatis_demo.entity.UserPos;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jizhid
 * @since 2022-10-23
 */
public interface UserService extends IService<User> {

    Role FetchRoleByUserId(Long userId);
    PageResult<User> listUser(UserQueryParam param, int pageSize, int pageNum);
    User getUserDetail(Long userId);
    List<User> getUsersInSameBank(Long bank_id);

    boolean insertUser(User user, List<UserPos> userPosList);
    boolean updateUser(User user, List<UserPos> userPosList);

    List<User> listUserPosition(Long bankId);
}
/**
 *
 * <insert id="insert" parameterType="com.macro.mall.model.PmsBrand">
 *     <selectKey keyProperty="id" order="AFTER" resultType="java.lang.Long">
 *       SELECT LAST_INSERT_ID()
 *     </selectKey>
 *     insert into pms_brand (name, first_letter, sort,
 *       factory_status, show_status, product_count,
 *       product_comment_count, logo, big_pic,
 *       brand_story)
 *     values (#{name,jdbcType=VARCHAR}, #{firstLetter,jdbcType=VARCHAR}, #{sort,jdbcType=INTEGER},
 *       #{factoryStatus,jdbcType=INTEGER}, #{showStatus,jdbcType=INTEGER}, #{productCount,jdbcType=INTEGER},
 *       #{productCommentCount,jdbcType=INTEGER}, #{logo,jdbcType=VARCHAR}, #{bigPic,jdbcType=VARCHAR},
 *       #{brandStory,jdbcType=LONGVARCHAR})
 *   </insert>
 */
