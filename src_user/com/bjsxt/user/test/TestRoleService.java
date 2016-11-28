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
import com.bjsxt.common.util.PageInfoUtil;
import com.bjsxt.user.pojo.AAdmins;
import com.bjsxt.user.pojo.ARole;
import com.bjsxt.user.service.IUserService;

public class TestRoleService extends BasicTest
{
	private IUserService userService;

	@Before
	public void info()
	{
		userService = (IUserService) this.ac.getBean("userService");
	}

	@Test
	public void insertRoleService()
	{
		ARole role = new ARole();
		for(int i=0; i<30; i++)
		{
			role.setContext("aaa");
			role.setName("aaa");
			role.setCreateTime(new Date());
			role.setLastLoginTime(new Date());
			role.setUpdateTime(new Date());
			JSONObject jsonObject = this.userService.insertRoleService(role);
			System.out.println(jsonObject);
		}
	}
	@Test
	public void deleteRoleService()
	{
		Map<String,Object> condMap = new HashMap<String,Object>();
		condMap.put("id", "1");
		JSONObject jsonObject = this.userService.deleteRoleService(condMap);
		System.out.println(jsonObject);
	}
	
	@Test
	public void findOneAdminsService()
	{
		Map<String,Object> condMap = new HashMap<String,Object>();
		condMap.put("id", 4);
		ARole role = this.userService.findOneRoleService(condMap);
		ConstantFinalUtil.LOGGER.info("---admins.id={}-admins.trueName={}--",role.getId(),role.getName());
		role.setName("ccccccccc");
		JSONObject jsonObject = this.userService.updateRoleService(role);
		System.out.println(jsonObject);
	}
	
	@Test
	public void findListAdminsService()
	{
		PageInfoUtil pageInfoUtil = new PageInfoUtil();
		pageInfoUtil.setPageSize(5);
		pageInfoUtil.setCurrentPage(-1);
		Map<String,Object> condMap = new HashMap<String,Object>();
		condMap.put("status", Byte.valueOf("1"));
		List<ARole> list = this.userService.findListRoleService(pageInfoUtil, condMap);
		/*List<ARole> list = this.userService.findListRoleService(null, condMap);*/
		int count = 1;
		for (Iterator<ARole> iterator = list.iterator(); iterator.hasNext();)
		{
			ARole role = (ARole) iterator.next();
			System.out.println("计数："+(count++)+",email="+role.getName());
		}
	}
	
}
