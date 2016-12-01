package com.bjsxt.investor.test;

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
import com.bjsxt.investor.pojo.AGrant;
import com.bjsxt.investor.pojo.AInvestor;
import com.bjsxt.investor.pojo.AInvestorBank;
import com.bjsxt.investor.pojo.AInvestorGrant;
import com.bjsxt.investor.service.IInvestorService;

public class TestInvestorService extends BasicTest
{
	
	private IInvestorService investorService;
	

	@Before
	public void info()
	{
		investorService = (IInvestorService) this.ac.getBean("investorService");
	}

	@Test
	public void insertInvestorService()
	{
		AInvestor investor = new AInvestor();
		investor.setContactName("ssa");
		investor.setContactPhone("sds");
		investor.setSuccedNum(2132);
		investor.setSuccedNum(21);
		investor.setCode("aa");
		investor.setCoopType(Byte.valueOf("1"));
		investor.setUrl("assa");
		investor.setLogo("sss");
		investor.setContent("====");
		investor.setName("aaa");
		investor.setStatus(Byte.valueOf("1"));
		investor.setCreateTime(new Date());
		investor.setPubTime(new Date());
		investor.setUpdateTime(new Date());
		JSONObject jsonObject = this.investorService.insertInvestorService(investor);
		System.out.println(jsonObject);
	}

	@Test
	public void deleteInvestorService()
	{
		Map<String, Object> condMap = new HashMap<String, Object>();
		condMap.put("id", "6");
		JSONObject jsonObject = this.investorService.deleteInvestorService(condMap);
		System.out.println(jsonObject);
	}

	@Test
	public void findOneInvestorService()
	{
		Map<String, Object> condMap = new HashMap<String, Object>();
		condMap.put("id", "1");
		AInvestor investor = this.investorService.findOneInvestorService(condMap);
		ConstantFinalUtil.LOGGER.info("---出资方：investor.id={}-,name={}", investor.getId(),investor.getName());
		int count = 1;
		for (Iterator iterator = investor.getInvestorBankSet().iterator(); iterator.hasNext();)
		{
			AInvestorBank investorBank = (AInvestorBank) iterator.next();
			ConstantFinalUtil.LOGGER.info("--出资方银行:银行id:{}-出资方id：{}---",investorBank.getBankId(),investorBank.getInvestorId());
		}
		count = 1;
		for (Iterator iterator = investor.getInvestorGrantSet().iterator(); iterator.hasNext();)
		{
			AInvestorGrant investorGrant = (AInvestorGrant) iterator.next();
			ConstantFinalUtil.LOGGER.info("--出资方授权:出资方id:{}-授权方id：{}---",investorGrant.getInvestorId(),investorGrant.getGrantId());
		}
	}

	@Test
	public void findListInvestorService()
	{
		PageInfoUtil pageInfoUtil = new PageInfoUtil();
		pageInfoUtil.setPageSize(2);
		/* pageInfoUtil.setCurrentPage(-1); */
		Map<String, Object> condMap = new HashMap<String, Object>();
		//condMap.put("parentId", "0");
		//condMap.put("status", Byte.valueOf("1"));
		/*List<AInvestor> list = this.investorService.findListInvestorService(pageInfoUtil, condMap);*/
		
		 List<AInvestor> list = this.investorService.findListInvestorService(null,condMap);
		 
		int count = 1;
		for (Iterator<AInvestor> iterator = list.iterator(); iterator.hasNext();)
		{
			AInvestor investor = (AInvestor) iterator.next();
			System.out.println("计数：" + (count++) + ",name=" + investor.getName());
		}
	}
	@Test
	public void findOneGrantService()
	{
		Map<String, Object> condMap = new HashMap<String, Object>();
		condMap.put("id", "1");
		
		AGrant grant = this.investorService.findOneGrantService(condMap);
		int count = 1;
		for (Iterator iterator = grant.getInvestorGrants().iterator(); iterator.hasNext();)
		{
			AInvestorGrant investorGrant = (AInvestorGrant) iterator.next();
			
			ConstantFinalUtil.LOGGER.info("出资方授权关系：授权信息名称：{}，出资方Id：{}",grant.getName(),investorGrant.getInvestorId());
		}
		
	}

}
