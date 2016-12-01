package com.bjsxt.investor.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.bjsxt.common.util.PageInfoUtil;
import com.bjsxt.investor.dao.IAInvestorDao;
import com.bjsxt.investor.dao.IBankDao;
import com.bjsxt.investor.dao.ICateDao;
import com.bjsxt.investor.dao.IGrantDao;
import com.bjsxt.investor.dao.IInvestorBankDao;
import com.bjsxt.investor.dao.IInvestorGrantDao;
import com.bjsxt.investor.pojo.ABank;
import com.bjsxt.investor.pojo.ACate;
import com.bjsxt.investor.pojo.AGrant;
import com.bjsxt.investor.pojo.AInvestor;
import com.bjsxt.investor.pojo.AInvestorBank;
import com.bjsxt.investor.pojo.AInvestorGrant;
import com.bjsxt.investor.service.IInvestorService;
/**
 * 所有有关出资方的servcie的实现
 * @author Administrator
 *
 */	      
@Service("investorService")
public class InvestorServiceImpl implements IInvestorService
{
	@Resource
	private IAInvestorDao investorDao ;
	@Resource
	private IBankDao bankDao ;
	@Resource
	private IGrantDao grantDao;
	@Resource
	private ICateDao cateDao;
	@Resource
	private IInvestorBankDao investorBankDao;
	@Resource
	private IInvestorGrantDao investorGrantDao;
	
	/* =================出资方的service的实现开始==================== */
	@Override
	public JSONObject insertInvestorService(AInvestor investor)
	{
		JSONObject resultJson = new JSONObject();
		
		int insert = this.investorDao.insert(investor);
		
		if(insert>0)
		{
			resultJson.put("code", "1");
			resultJson.put("info", "出资方添加成功");
			JSONObject data = new JSONObject();
			data.put("id", investor.getId());
			resultJson.put("data", data);
		}else
		{
			resultJson.put("code", "0");
			resultJson.put("info", "出资方添加失败");
		}
		return resultJson;
	}

	@Override
	public JSONObject deleteInvestorService(Map<String, Object> condMap)
	{
		JSONObject resultJson = new JSONObject();
		int delete = this.investorDao.delete(condMap);
		if(delete>0)
		{
			resultJson.put("code", "1");
			resultJson.put("info", "出资方删除成功");
			JSONObject data = new JSONObject();
			data.put("删除个数", delete);
			resultJson.put("data", data);
		}else
		{
			resultJson.put("code", "0");
			resultJson.put("info", "出资方删除失败");
		}
		return resultJson;
	}

	@Override
	public JSONObject updateInvestorService(AInvestor investor)
	{
		JSONObject resultJson = new JSONObject();
		int update = this.investorDao.update(investor);
		
		if(update>0)
		{
			resultJson.put("code", "1");
			resultJson.put("info", "出资方修改成功");
			JSONObject data = new JSONObject();
			data.put("id", investor.getId());
			resultJson.put("data", data);
		}else
		{	
			resultJson.put("code", "0");
			resultJson.put("info", "出资方修改失败");
		}
		return resultJson;
	}
	@Override
	public AInvestor findOneInvestorService(Map<String, Object> condMap)
	{
		
		return this.investorDao.findOne(condMap);
	}
	@Override
	public List<AInvestor> findListInvestorService(PageInfoUtil pageInfoUtil, Map<String, Object> condMap)
	{
		/* 修改条件 */
		if(condMap.get("keyword")!=null)
		{
			condMap.put("keyword", "%"+condMap.get("keyword")+"%");
		}
		if(pageInfoUtil == null)
		{
			/* 不分页查询 */
			return this.investorDao.findList(condMap);
		}else
		{
			/* 分页查询  */
			/* 先查总记录数  */
			condMap.put("pageOperation", "true");
			List<AInvestor> findList = this.investorDao.findList(condMap);
			pageInfoUtil.setTotalRecord(findList.get(0).getId());
			/* 查询总记录数 */
			condMap.put("pageOperation", "false");
			condMap.put("currRecord", pageInfoUtil.getCurrRecord());
			condMap.put("pageSize", pageInfoUtil.getPageSize());
			List<AInvestor> list = this.investorDao.findList(condMap);
			return list ;
		}
	}
	/* =================出资方的service的实现结束==================== */
	/* =================银行的service的实现开始==================== */

	@Override
	public JSONObject insertBankService(ABank Bank)
	{
		JSONObject resultJson = new JSONObject();
		
		int insert = this.bankDao.insert(Bank);
		
		if(insert>0)
		{
			resultJson.put("code", "1");
			resultJson.put("info", "银行添加成功");
			JSONObject data = new JSONObject();
			data.put("id", Bank.getId());
			resultJson.put("data", data);
		}else
		{
			resultJson.put("code", "0");
			resultJson.put("info", "银行添加失败");
		}
		return resultJson;
	}

	@Override
	public JSONObject deleteBankService(Map<String, Object> condMap)
	{
		JSONObject resultJson = new JSONObject();
		int delete = this.bankDao.delete(condMap);
		if(delete>0)
		{
			resultJson.put("code", "1");
			resultJson.put("info", "银行删除成功");
			JSONObject data = new JSONObject();
			data.put("删除个数", delete);
			resultJson.put("data", data);
		}else
		{
			resultJson.put("code", "0");
			resultJson.put("info", "银行删除失败");
		}
		return resultJson;
	}

	@Override
	public JSONObject updateBankService(ABank Bank)
	{
		JSONObject resultJson = new JSONObject();
		int update = this.bankDao.update(Bank);
		
		if(update>0)
		{
			resultJson.put("code", "1");
			resultJson.put("info", "银行修改成功");
			JSONObject data = new JSONObject();
			data.put("id", Bank.getId());
			resultJson.put("data", data);
		}else
		{	
			resultJson.put("code", "0");
			resultJson.put("info", "银行修改失败");
		}
		return resultJson;
	}
	@Override
	public ABank findOneBankService(Map<String, Object> condMap)
	{
		
		return this.bankDao.findOne(condMap);
	}
	@Override
	public List<ABank> findListBankService(PageInfoUtil pageInfoUtil, Map<String, Object> condMap)
	{
		/* 修改条件 */
		if(condMap.get("keyword")!=null)
		{
			condMap.put("keyword", "%"+condMap.get("keyword")+"%");
		}
		if(pageInfoUtil == null)
		{
			/* 不分页查询 */
			return this.bankDao.findList(condMap);
		}else
		{
			/* 分页查询  */
			/* 先查总记录数  */
			condMap.put("pageOperation", "true");
			List<ABank> findList = this.bankDao.findList(condMap);
			pageInfoUtil.setTotalRecord(findList.get(0).getId());
			/* 查询总记录数 */
			condMap.put("pageOperation", "false");
			condMap.put("currRecord", pageInfoUtil.getCurrRecord());
			condMap.put("pageSize", pageInfoUtil.getPageSize());
			List<ABank> list = this.bankDao.findList(condMap);
			return list ;
		}
	}
	/* =================银行的service的实现结束==================== */
	
	
	/* =================权限的service的实现开始==================== */

	@Override
	public JSONObject insertGrantService(AGrant Grant)
	{
		JSONObject resultJson = new JSONObject();
		
		int insert = this.grantDao.insert(Grant);
		
		if(insert>0)
		{
			resultJson.put("code", "1");
			resultJson.put("info", "银行添加成功");
			JSONObject data = new JSONObject();
			data.put("id", Grant.getId());
			resultJson.put("data", data);
		}else
		{
			resultJson.put("code", "0");
			resultJson.put("info", "银行添加失败");
		}
		return resultJson;
	}

	@Override
	public JSONObject deleteGrantService(Map<String, Object> condMap)
	{
		JSONObject resultJson = new JSONObject();
		int delete = this.grantDao.delete(condMap);
		if(delete>0)
		{
			resultJson.put("code", "1");
			resultJson.put("info", "银行删除成功");
			JSONObject data = new JSONObject();
			data.put("删除个数", delete);
			resultJson.put("data", data);
		}else
		{
			resultJson.put("code", "0");
			resultJson.put("info", "银行删除失败");
		}
		return resultJson;
	}

	@Override
	public JSONObject updateGrantService(AGrant Grant)
	{
		JSONObject resultJson = new JSONObject();
		int update = this.grantDao.update(Grant);
		
		if(update>0)
		{
			resultJson.put("code", "1");
			resultJson.put("info", "银行修改成功");
			JSONObject data = new JSONObject();
			data.put("id", Grant.getId());
			resultJson.put("data", data);
		}else
		{	
			resultJson.put("code", "0");
			resultJson.put("info", "银行修改失败");
		}
		return resultJson;
	}
	@Override
	public AGrant findOneGrantService(Map<String, Object> condMap)
	{
		
		return this.grantDao.findOne(condMap);
	}
	@Override
	public List<AGrant> findListGrantService(PageInfoUtil pageInfoUtil, Map<String, Object> condMap)
	{
		/* 修改条件 */
		if(condMap.get("keyword")!=null)
		{
			condMap.put("keyword", "%"+condMap.get("keyword")+"%");
		}
		if(pageInfoUtil == null)
		{
			/* 不分页查询 */
			return this.grantDao.findList(condMap);
		}else
		{
			/* 分页查询  */
			/* 先查总记录数  */
			condMap.put("pageOperation", "true");
			List<AGrant> findList = this.grantDao.findList(condMap);
			pageInfoUtil.setTotalRecord(findList.get(0).getId());
			/* 查询总记录数 */
			condMap.put("pageOperation", "false");
			condMap.put("currRecord", pageInfoUtil.getCurrRecord());
			condMap.put("pageSize", pageInfoUtil.getPageSize());
			List<AGrant> list = this.grantDao.findList(condMap);
			return list ;
		}
	}
	/* =================权限的service的实现结束==================== */
	
	/* =================分类的service的实现开始==================== */

	@Override
	public JSONObject insertCateService(ACate Cate)
	{
		JSONObject resultJson = new JSONObject();
		
		int insert = this.cateDao.insert(Cate);
		
		if(insert>0)
		{
			resultJson.put("code", "1");
			resultJson.put("info", "银行添加成功");
			JSONObject data = new JSONObject();
			data.put("id", Cate.getId());
			resultJson.put("data", data);
		}else
		{
			resultJson.put("code", "0");
			resultJson.put("info", "银行添加失败");
		}
		return resultJson;
	}

	@Override
	public JSONObject deleteCateService(Map<String, Object> condMap)
	{
		JSONObject resultJson = new JSONObject();
		int delete = this.cateDao.delete(condMap);
		if(delete>0)
		{
			resultJson.put("code", "1");
			resultJson.put("info", "银行删除成功");
			JSONObject data = new JSONObject();
			data.put("删除个数", delete);
			resultJson.put("data", data);
		}else
		{
			resultJson.put("code", "0");
			resultJson.put("info", "银行删除失败");
		}
		return resultJson;
	}

	@Override
	public JSONObject updateCateService(ACate Cate)
	{
		JSONObject resultJson = new JSONObject();
		int update = this.cateDao.update(Cate);
		
		if(update>0)
		{
			resultJson.put("code", "1");
			resultJson.put("info", "银行修改成功");
			JSONObject data = new JSONObject();
			data.put("id", Cate.getId());
			resultJson.put("data", data);
		}else
		{	
			resultJson.put("code", "0");
			resultJson.put("info", "银行修改失败");
		}
		return resultJson;
	}
	@Override
	public ACate findOneCateService(Map<String, Object> condMap)
	{
		
		return this.cateDao.findOne(condMap);
	}
	@Override
	public List<ACate> findListCateService(PageInfoUtil pageInfoUtil, Map<String, Object> condMap)
	{
		/* 修改条件 */
		if(condMap.get("keyword")!=null)
		{
			condMap.put("keyword", "%"+condMap.get("keyword")+"%");
		}
		if(pageInfoUtil == null)
		{
			/* 不分页查询 */
			return this.cateDao.findList(condMap);
		}else
		{
			/* 分页查询  */
			/* 先查总记录数  */
			condMap.put("pageOperation", "true");
			List<ACate> findList = this.cateDao.findList(condMap);
			pageInfoUtil.setTotalRecord(findList.get(0).getId());
			/* 查询总记录数 */
			condMap.put("pageOperation", "false");
			condMap.put("currRecord", pageInfoUtil.getCurrRecord());
			condMap.put("pageSize", pageInfoUtil.getPageSize());
			List<ACate> list = this.cateDao.findList(condMap);
			return list ;
		}
	}
	/* =================分类的service的实现结束==================== */
	
	
	/* =================出资方和银行的service的实现开始==================== */

	@Override
	public JSONObject insertInvestorBankService(AInvestorBank InvestorBank)
	{
		JSONObject resultJson = new JSONObject();
		
		int insert = this.investorBankDao.insert(InvestorBank);
		
		if(insert>0)
		{
			resultJson.put("code", "1");
			resultJson.put("info", "出资方和银行添加成功");
			JSONObject data = new JSONObject();
			data.put("id", InvestorBank.getId());
			resultJson.put("data", data);
		}else
		{
			resultJson.put("code", "0");
			resultJson.put("info", "出资方和银行添加失败");
		}
		return resultJson;
	}

	@Override
	public JSONObject deleteInvestorBankService(Map<String, Object> condMap)
	{
		JSONObject resultJson = new JSONObject();
		int delete = this.investorBankDao.delete(condMap);
		if(delete>0)
		{
			resultJson.put("code", "1");
			resultJson.put("info", "出资方和银行删除成功");
			JSONObject data = new JSONObject();
			data.put("删除个数", delete);
			resultJson.put("data", data);
		}else
		{
			resultJson.put("code", "0");
			resultJson.put("info", "出资方和银行删除失败");
		}
		return resultJson;
	}

	@Override
	public JSONObject updateInvestorBankService(AInvestorBank InvestorBank)
	{
		JSONObject resultJson = new JSONObject();
		int update = this.investorBankDao.update(InvestorBank);
		
		if(update>0)
		{
			resultJson.put("code", "1");
			resultJson.put("info", "出资方和银行修改成功");
			JSONObject data = new JSONObject();
			data.put("id", InvestorBank.getId());
			resultJson.put("data", data);
		}else
		{	
			resultJson.put("code", "0");
			resultJson.put("info", "出资方和银行修改失败");
		}
		return resultJson;
	}
	@Override
	public AInvestorBank findOneInvestorBankService(Map<String, Object> condMap)
	{
		return this.investorBankDao.findOne(condMap);
	}
	@Override
	public List<AInvestorBank> findListInvestorBankService(PageInfoUtil pageInfoUtil, Map<String, Object> condMap)
	{
		/* 修改条件 */
		if(condMap.get("keyword")!=null)
		{
			condMap.put("keyword", "%"+condMap.get("keyword")+"%");
		}
		if(pageInfoUtil == null)
		{
			/* 不分页查询 */
			return this.investorBankDao.findList(condMap);
		}else
		{
			/* 分页查询  */
			/* 先查总记录数  */
			condMap.put("pageOperation", "true");
			List<AInvestorBank> findList = this.investorBankDao.findList(condMap);
			pageInfoUtil.setTotalRecord(findList.get(0).getId());
			/* 查询总记录数 */
			condMap.put("pageOperation", "false");
			condMap.put("currRecord", pageInfoUtil.getCurrRecord());
			condMap.put("pageSize", pageInfoUtil.getPageSize());
			List<AInvestorBank> list = this.investorBankDao.findList(condMap);
			return list ;
		}
	}
	/* =================出资方和银行的service的实现结束==================== */
	
	/* =================出资方和权限的service的实现开始==================== */

	@Override
	public JSONObject insertInvestorGrantService(AInvestorGrant InvestorGrant)
	{
		JSONObject resultJson = new JSONObject();
		
		int insert = this.investorGrantDao.insert(InvestorGrant);
		
		if(insert>0)
		{
			resultJson.put("code", "1");
			resultJson.put("info", "出资方和权限添加成功");
			JSONObject data = new JSONObject();
			data.put("id", InvestorGrant.getId());
			resultJson.put("data", data);
		}else
		{
			resultJson.put("code", "0");
			resultJson.put("info", "出资方和权限添加失败");
		}
		return resultJson;
	}

	@Override
	public JSONObject deleteInvestorGrantService(Map<String, Object> condMap)
	{
		JSONObject resultJson = new JSONObject();
		int delete = this.investorGrantDao.delete(condMap);
		if(delete>0)
		{
			resultJson.put("code", "1");
			resultJson.put("info", "出资方和权限删除成功");
			JSONObject data = new JSONObject();
			data.put("删除个数", delete);
			resultJson.put("data", data);
		}else
		{
			resultJson.put("code", "0");
			resultJson.put("info", "出资方和权限删除失败");
		}
		return resultJson;
	}

	@Override
	public JSONObject updateInvestorGrantService(AInvestorGrant InvestorGrant)
	{
		JSONObject resultJson = new JSONObject();
		int update = this.investorGrantDao.update(InvestorGrant);
		
		if(update>0)
		{
			resultJson.put("code", "1");
			resultJson.put("info", "出资方和权限修改成功");
			JSONObject data = new JSONObject();
			data.put("id", InvestorGrant.getId());
			resultJson.put("data", data);
		}else
		{	
			resultJson.put("code", "0");
			resultJson.put("info", "出资方和权限修改失败");
		}
		return resultJson;
	}
	@Override
	public AInvestorGrant findOneInvestorGrantService(Map<String, Object> condMap)
	{
		return this.investorGrantDao.findOne(condMap);
	}
	@Override
	public List<AInvestorGrant> findListInvestorGrantService(PageInfoUtil pageInfoUtil, Map<String, Object> condMap)
	{
		/* 修改条件 */
		if(condMap.get("keyword")!=null)
		{
			condMap.put("keyword", "%"+condMap.get("keyword")+"%");
		}
		if(pageInfoUtil == null)
		{
			/* 不分页查询 */
			return this.investorGrantDao.findList(condMap);
		}else
		{
			/* 分页查询  */
			/* 先查总记录数  */
			condMap.put("pageOperation", "true");
			List<AInvestorGrant> findList = this.investorGrantDao.findList(condMap);
			pageInfoUtil.setTotalRecord(findList.get(0).getId());
			/* 查询总记录数 */
			condMap.put("pageOperation", "false");
			condMap.put("currRecord", pageInfoUtil.getCurrRecord());
			condMap.put("pageSize", pageInfoUtil.getPageSize());
			List<AInvestorGrant> list = this.investorGrantDao.findList(condMap);
			return list ;
		}
	}
	/* =================出资方和权限的service的实现结束==================== */
}