package com.bjsxt.investor.service;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.bjsxt.common.util.PageInfoUtil;
import com.bjsxt.investor.pojo.ABank;
import com.bjsxt.investor.pojo.ACate;
import com.bjsxt.investor.pojo.AGrant;
import com.bjsxt.investor.pojo.AInvestor;
import com.bjsxt.investor.pojo.AInvestorBank;
import com.bjsxt.investor.pojo.AInvestorGrant;
/***
 * 所有出资方模块的service层接口
 * @author Administrator
 *
 */
public interface IInvestorService
{
	
	
	/*====================出资方的service操作开始 ========================= */
	/**
	 * 添加一条Investor记录
	 * @param investor
	 * @return
	 */
	JSONObject insertInvestorService(AInvestor investor);
	/**
	 * 删除一个Investor操作
	 * @param condMap
	 * @return
	 */
	JSONObject deleteInvestorService(Map<String,Object> condMap);
	/**
	 * 修改一个Investor记录
	 * @param investor
	 * @return
	 */
	JSONObject updateInvestorService(AInvestor investor);
	/**
	 * 查询一条Investor记录
	 * @param condMap
	 * @return
	 */
	AInvestor findOneInvestorService(Map<String,Object> condMap);
	/**
	 * 查询多条记录
	 * @param pageInfoUtil
	 * @param condMap
	 * @return
	 */
	List<AInvestor> findListInvestorService(PageInfoUtil pageInfoUtil,Map<String,Object> condMap);
	/*====================出资方的service操作结束 ========================= */
	
	
	
	/*====================银行的service操作开始 ========================= */
	/**
	 * 添加一条Bank记录
	 * @param bank
	 * @return
	 */
	JSONObject insertBankService(ABank bank);
	/**
	 * 删除一个Bank操作
	 * @param condMap
	 * @return
	 */
	JSONObject deleteBankService(Map<String,Object> condMap);
	/**
	 * 修改一个Bank记录
	 * @param bank
	 * @return
	 */
	JSONObject updateBankService(ABank bank);
	/**
	 * 查询一条Bank记录
	 * @param condMap
	 * @return
	 */
	ABank findOneBankService(Map<String,Object> condMap);
	/**
	 * 查询多条记录
	 * @param pageInfoUtil
	 * @param condMap
	 * @return
	 */
	List<ABank> findListBankService(PageInfoUtil pageInfoUtil,Map<String,Object> condMap);
	/*====================银行的service操作结束 ========================= */

	
	
	
	/*====================授权的service操作开始 ========================= */
	/**
	 * 添加一条Grant记录
	 * @param grant
	 * @return
	 */
	JSONObject insertGrantService(AGrant grant);
	/**
	 * 删除一个Grant操作
	 * @param condMap
	 * @return
	 */
	JSONObject deleteGrantService(Map<String,Object> condMap);
	/**
	 * 修改一个Grant记录
	 * @param grant
	 * @return
	 */
	JSONObject updateGrantService(AGrant grant);
	/**
	 * 查询一条Grant记录
	 * @param condMap
	 * @return
	 */
	AGrant findOneGrantService(Map<String,Object> condMap);
	/**
	 * 查询多条记录
	 * @param pageInfoUtil
	 * @param condMap
	 * @return
	 */
	List<AGrant> findListGrantService(PageInfoUtil pageInfoUtil,Map<String,Object> condMap);
	/*====================授权的service操作结束 ========================= */
	
	
	
	
	
	/*====================分类的service操作开始 ========================= */
	/**
	 * 添加一条Cate记录
	 * @param cate
	 * @return
	 */
	JSONObject insertCateService(ACate cate);
	/**
	 * 删除一个Cate操作
	 * @param condMap
	 * @return
	 */
	JSONObject deleteCateService(Map<String,Object> condMap);
	/**
	 * 修改一个Cate记录
	 * @param cate
	 * @return
	 */
	JSONObject updateCateService(ACate cate);
	/**
	 * 查询一条Cate记录
	 * @param condMap
	 * @return
	 */
	ACate findOneCateService(Map<String,Object> condMap);
	/**
	 * 查询多条记录
	 * @param pageInfoUtil
	 * @param condMap
	 * @return
	 */
	List<ACate> findListCateService(PageInfoUtil pageInfoUtil,Map<String,Object> condMap);
	/*====================分类的service操作结束 ========================= */
	/*====================出资方和银行的service操作开始 ========================= */
	/**
	 * 添加一条InvestorBank记录
	 * @param investorBank
	 * @return
	 */
	JSONObject insertInvestorBankService(AInvestorBank investorBank);
	/**
	 * 删除一个InvestorBank操作
	 * @param condMap
	 * @return
	 */
	JSONObject deleteInvestorBankService(Map<String,Object> condMap);
	/**
	 * 修改一个InvestorBank记录
	 * @param investorBank
	 * @return
	 */
	JSONObject updateInvestorBankService(AInvestorBank investorBank);
	/**
	 * 查询一条InvestorBank记录
	 * @param condMap
	 * @return
	 */
	AInvestorBank findOneInvestorBankService(Map<String,Object> condMap);
	/**
	 * 查询多条记录
	 * @param pageInfoUtil
	 * @param condMap
	 * @return
	 */
	List<AInvestorBank> findListInvestorBankService(PageInfoUtil pageInfoUtil,Map<String,Object> condMap);
	/*====================出资方和银行的service操作结束 ========================= */
	/*====================出资方和权限的service操作开始 ========================= */
	/**
	 * 添加一条InvestorGrant记录
	 * @param investorGrant
	 * @return
	 */
	JSONObject insertInvestorGrantService(AInvestorGrant investorGrant);
	/**
	 * 删除一个InvestorGrant操作
	 * @param condMap
	 * @return
	 */
	JSONObject deleteInvestorGrantService(Map<String,Object> condMap);
	/**
	 * 修改一个InvestorGrant记录
	 * @param investorGrant
	 * @return
	 */
	JSONObject updateInvestorGrantService(AInvestorGrant investorGrant);
	/**
	 * 查询一条InvestorGrant记录
	 * @param condMap
	 * @return
	 */
	AInvestorGrant findOneInvestorGrantService(Map<String,Object> condMap);
	/**
	 * 查询多条记录
	 * @param pageInfoUtil
	 * @param condMap
	 * @return
	 */
	List<AInvestorGrant> findListInvestorGrantService(PageInfoUtil pageInfoUtil,Map<String,Object> condMap);
	/*====================出资方和权限的service操作结束 ========================= */
}

