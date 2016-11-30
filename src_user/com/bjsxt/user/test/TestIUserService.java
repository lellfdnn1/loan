package com.bjsxt.user.test;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.bjsxt.common.util.BasicTest;
import com.bjsxt.common.util.ConstantFinalUtil;
import com.bjsxt.common.util.MD5Util;
import com.bjsxt.common.util.PageInfoUtil;
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
		md5Util = (MD5Util)this.ac.getBean("md5Util");
	}
	@Test
	public void insertAdminsService()
	{
		AAdmins admins = new AAdmins();
		for(int i=0; i<30 ;i++)
		{
			admins.setPassword(md5Util.encryString("1"+i));
			admins.setPhone("123"+i);
			admins.setQq("123"+i);
			admins.setEmail("aa@aa.com"+i);
			admins.setTrueName("asd"+i);
			admins.setCreateTime(new Date());
			admins.setLastLoginTime(new Date());
			admins.setUpdateTime(new Date());
			JSONObject jsonObject = this.userService.insertAdminsService(admins);
			System.out.println(jsonObject);
		}
	}
	@Test
	public void deleteAdminsService()
	{
		Map<String,Object> condMap = new HashMap<String,Object>();
		condMap.put("status", "1");
		JSONObject jsonObject = this.userService.deleteAdminsService(condMap);
		System.out.println(jsonObject);
	}
	
	
	@Test
	public void findOneAdminsService()
	{
		Map<String,Object> condMap = new HashMap<String,Object>();
		condMap.put("id", 4);
		AAdmins admins = this.userService.findOneAdminsService(condMap);
		ConstantFinalUtil.LOGGER.info("---admins.id={}-admins.trueName={}-角色信息={}-",admins.getId(),admins.getTrueName(),admins.getRole().getName());
		admins.setEmail("ccc@bb.com");
		JSONObject jsonObject = this.userService.updateAdminsService(admins);
		System.out.println(jsonObject);
	}
	
	@Test
	public void findListAdminsService()
	{
		PageInfoUtil pageInfoUtil = new PageInfoUtil();
		pageInfoUtil.setPageSize(5);
/*		pageInfoUtil.setCurrentPage(-1);*/
		Map<String,Object> condMap = new HashMap<String,Object>();
		condMap.put("status", Byte.valueOf("1"));
		List<AAdmins> list = this.userService.findListAdminsService(pageInfoUtil, condMap);
		/*List<AAdmins> list = this.userService.findListAdminsService(null, condMap);*/
		int count = 1;
		for (Iterator<AAdmins> iterator = list.iterator(); iterator.hasNext();)
		{
			AAdmins admins = (AAdmins) iterator.next();
			System.out.println("计数："+(count++)+",email="+admins.getEmail());
		}
	}
	
}
