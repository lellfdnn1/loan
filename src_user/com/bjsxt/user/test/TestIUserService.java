package com.bjsxt.user.test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.bjsxt.common.util.BasicTest;
import com.bjsxt.common.util.ConstantFinalUtil;
import com.bjsxt.common.util.MD5Util;
import com.bjsxt.user.pojo.AAdmins;
import com.bjsxt.user.service.IUserService;

public class TestIUserService extends BasicTest
{
	private IUserService userService;
	
	private MD5Util md5Util;
	
	@Before
	public void info()
	{
		userService = (IUserService) this.ac.getBean("userService");
		md5Util = (MD5Util)this.ac.getBean("mD5Util");
	}
	@Test
	public void insertAdminsService()
	{
		AAdmins admins = new AAdmins();
		admins.setPassword(md5Util.encryString("123456"));
		admins.setPhone("123");
		admins.setQq("123");
		admins.setEmail("aa@aa.com");
		admins.setTrueName("asd");
		admins.setCreateTime(new Date());
		admins.setLastLoginTime(new Date());
		admins.setUpdateTime(new Date());
		JSONObject jsonObject = this.userService.insertAdminsService(admins);
		System.out.println(jsonObject);
	}
	
	@Test
	public void findOneAdminsService()
	{
		Map<String,Object> condMap = new HashMap<String,Object>();
		condMap.put("id", 3);
		AAdmins admins = this.userService.findOneAdminsService(condMap);
		ConstantFinalUtil.LOGGER.info("---admins.id={}-admins.trueName={}--",admins.getId(),admins.getTrueName());
	}
}
