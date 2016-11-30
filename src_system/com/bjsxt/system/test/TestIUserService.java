package com.bjsxt.system.test;

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
import com.bjsxt.system.pojo.ARegion;
import com.bjsxt.system.service.IRegionService;

public class TestIUserService extends BasicTest
{
	private IRegionService regionService;

	@Before
	public void info()
	{
		regionService = (IRegionService) this.ac.getBean("regionService");
	}

	@Test
	public void insertRegionService()
	{
		ARegion region = new ARegion();
		region.setAreacode("1");
		region.setContent("====");
		region.setLeafStatus(Byte.valueOf("1"));
		region.setName("aaa");
		region.setPinyin("aa");
		region.setStatus(Byte.valueOf("1"));
		region.setCreateTime(new Date());
		region.setPubTime(new Date());
		region.setUpdateTime(new Date());
		JSONObject jsonObject = this.regionService.insertRegionService(region);
		System.out.println(jsonObject);
	}

	@Test
	public void deleteRegionService()
	{
		Map<String, Object> condMap = new HashMap<String, Object>();
		condMap.put("status", "1");
		JSONObject jsonObject = this.regionService.deleteRegionService(condMap);
		System.out.println(jsonObject);
	}

	@Test
	public void findOneRegionService()
	{
		Map<String, Object> condMap = new HashMap<String, Object>();
		condMap.put("name", "日本省");
		ARegion region = this.regionService.findOneRegionService(condMap);
		ConstantFinalUtil.LOGGER.info("---region.id={}-,name={}", region.getId(),region.getName());
		/* 查询父节点 */
		ConstantFinalUtil.LOGGER.info("--父级节点---name:{}---",region.getRegion().getName());
		/* 遍历孩子 */
		for (Iterator iterator = region.getRegionSet().iterator(); iterator.hasNext();)
		{
			region = (ARegion) iterator.next();
			ConstantFinalUtil.LOGGER.info("--孩子节点---name:{}---",region.getName());
		}
		
	}

	@Test
	public void findListRegionService()
	{
		PageInfoUtil pageInfoUtil = new PageInfoUtil();
		pageInfoUtil.setPageSize(2);
		/* pageInfoUtil.setCurrentPage(-1); */
		Map<String, Object> condMap = new HashMap<String, Object>();
		//condMap.put("status", Byte.valueOf("1"));
		/*List<ARegion> list = this.regionService.findListRegionService(pageInfoUtil, condMap);*/
		
		 List<ARegion> list = this.regionService.findListRegionService(pageInfoUtil,condMap);
		 
		int count = 1;
		for (Iterator<ARegion> iterator = list.iterator(); iterator.hasNext();)
		{
			ARegion region = (ARegion) iterator.next();
			System.out.println("计数：" + (count++) + ",name=" + region.getName());
		}
	}

}
