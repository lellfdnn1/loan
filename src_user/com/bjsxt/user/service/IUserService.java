package com.bjsxt.user.service;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.bjsxt.user.pojo.AAdmins;
/***
 * 所有user的service层接口
 * @author Administrator
 *
 */
public interface IUserService
{
	/*====================管理员的service操作开始 ========================= */
	/**
	 * 查询一条Admins记录
	 * @param condMap
	 * @return
	 */
	AAdmins findOneAdminsService(Map<String,Object> condMap);
	/**
	 * 添加一条Admins记录
	 * @param admins
	 * @return
	 */
	JSONObject insertAdminsService(AAdmins admins);
	/*====================管理员的service操作开始 ========================= */
}
