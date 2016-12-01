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
import com.bjsxt.investor.pojo.ABank;
import com.bjsxt.investor.pojo.AInvestorBank;
import com.bjsxt.investor.service.IInvestorService;

public class TestBankService extends BasicTest
{
	
	private IInvestorService investorService;

	@Before
	public void info()
	{
		investorService = (IInvestorService) this.ac.getBean("investorService");
	}

	@Test
	public void insertBankService()
	{
		ABank bank = new ABank();
		bank.setCode("aa");
		bank.setUrl("assa");
		bank.setLogo("sss");
		bank.setContent("====");
		bank.setName("aaa");
		bank.setStatus(Byte.valueOf("1"));
		bank.setCreateTime(new Date());
		bank.setPubTime(new Date());
		bank.setUpdateTime(new Date());
		JSONObject jsonObject = this.investorService.insertBankService(bank);
		System.out.println(jsonObject);
	}

	@Test
	public void deleteBankService()
	{
		Map<String, Object> condMap = new HashMap<String, Object>();
		condMap.put("id", "6");
		JSONObject jsonObject = this.investorService.deleteBankService(condMap);
		System.out.println(jsonObject);
	}

	@Test
	public void findOneBankService()
	{
		Map<String, Object> condMap = new HashMap<String, Object>();
		condMap.put("id", "1");
		ABank bank = this.investorService.findOneBankService(condMap);
		ConstantFinalUtil.LOGGER.info("---bank.id={}-,name={}", bank.getId(),bank.getName());
		int count = 1;
		for (Iterator iterator = bank.getInvestorBankSet().iterator(); iterator.hasNext();)
		{
			AInvestorBank investorBank = (AInvestorBank) iterator.next();
			ConstantFinalUtil.LOGGER.info("--出资方银行关系表--银行id:{}---出资方Id:{}---",investorBank.getBankId(),investorBank.getInvestorId());
		}
	}

	@Test
	public void findListBankService()
	{
		PageInfoUtil pageInfoUtil = new PageInfoUtil();
		pageInfoUtil.setPageSize(2);
		/* pageInfoUtil.setCurrentPage(-1); */
		Map<String, Object> condMap = new HashMap<String, Object>();
		//condMap.put("parentId", "0");
		//condMap.put("status", Byte.valueOf("1"));
		/*List<ABank> list = this.bankService.findListBankService(pageInfoUtil, condMap);*/
		
		 List<ABank> list = this.investorService.findListBankService(null,condMap);
		 
		int count = 1;
		for (Iterator<ABank> iterator = list.iterator(); iterator.hasNext();)
		{
			ABank bank = (ABank) iterator.next();
			System.out.println("计数：" + (count++) + ",name=" + bank.getName());
		}
	}

}
