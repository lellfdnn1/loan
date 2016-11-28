package com.bjsxt.user.service;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.bjsxt.common.util.PageInfoUtil;
import com.bjsxt.user.pojo.AAdmins;
import com.bjsxt.user.pojo.ARole;
/***
 * 所有user的service层接口
 * @author Administrator
 *
 */
public interface IUserService
{
	/*====================管理员的service操作开始 ========================= */
	/**
	 * 添加一条Admins记录
	 * @param admins
	 * @return
	 */
	JSONObject insertAdminsService(AAdmins admins);
	/**
	 * 删除一个Admins操作
	 * @param condMap
	 * @return
	 */
	JSONObject deleteAdminsService(Map<String,Object> condMap);
	/**
	 * 修改一个Admins记录
	 * @param admins
	 * @return
	 */
	JSONObject updateAdminsService(AAdmins admins);
	/**
	 * 查询一条Admins记录
	 * @param condMap
	 * @return
	 */
	AAdmins findOneAdminsService(Map<String,Object> condMap);
	/**
	 * 查询多条记录
	 * @param pageInfoUtil
	 * @param condMap
	 * @return
	 */
	List<AAdmins> findListAdminsService(PageInfoUtil pageInfoUtil,Map<String,Object> condMap);
	/*====================管理员的service操作结束 ========================= */
	
	/*====================角色的service操作开始 ========================= */
	/**
	 * 添加一条ARole记录
	 * @param role
	 * @return
	 */
	JSONObject insertRoleService(ARole role);
	/**
	 * 删除一个ARole操作
	 * @param condMap
	 * @return
	 */
	JSONObject deleteRoleService(Map<String,Object> condMap);
	/**
	 * 修改一个ARole记录
	 * @param role
	 * @return
	 */
	JSONObject updateRoleService(ARole role);
	/**
	 * 查询一条ARole记录
	 * @param condMap
	 * @return
	 */
	ARole findOneRoleService(Map<String,Object> condMap);
	/**
	 * 查询多条记录
	 * @param pageInfoUtil
	 * @param condMap
	 * @return
	 */
	List<ARole> findListRoleService(PageInfoUtil pageInfoUtil,Map<String,Object> condMap);
	/*====================角色的service操作开始 ========================= */
}
