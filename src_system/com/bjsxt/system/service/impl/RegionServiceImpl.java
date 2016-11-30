package com.bjsxt.system.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.bjsxt.common.util.PageInfoUtil;
import com.bjsxt.system.dao.IARegionDao;
import com.bjsxt.system.pojo.ARegion;
import com.bjsxt.system.service.IRegionService;
/**
 * 所有有关用户的servcie的实现
 * @author Administrator
 *
 */
@Service("regionService")
public class RegionServiceImpl implements IRegionService
{
	@Resource
	private IARegionDao regionDao ;
	
	/* =================行政区的service的实现开始==================== */

	@Override
	public JSONObject insertRegionService(ARegion region)
	{
		JSONObject resultJson = new JSONObject();
		
		int insert = this.regionDao.insert(region);
		
		if(insert>0)
		{
			resultJson.put("code", "1");
			resultJson.put("info", "行政区添加成功");
			JSONObject data = new JSONObject();
			data.put("id", region.getId());
			resultJson.put("data", data);
		}else
		{
			resultJson.put("code", "0");
			resultJson.put("info", "行政区添加失败");
		}
		return resultJson;
	}

	@Override
	public JSONObject deleteRegionService(Map<String, Object> condMap)
	{
		JSONObject resultJson = new JSONObject();
		int delete = this.regionDao.delete(condMap);
		if(delete>0)
		{
			resultJson.put("code", "1");
			resultJson.put("info", "行政区删除成功");
			JSONObject data = new JSONObject();
			data.put("删除个数", delete);
			resultJson.put("data", data);
		}else
		{
			resultJson.put("code", "0");
			resultJson.put("info", "行政区删除失败");
		}
		return resultJson;
	}

	@Override
	public JSONObject updateRegionService(ARegion region)
	{
		JSONObject resultJson = new JSONObject();
		int update = this.regionDao.update(region);
		
		if(update>0)
		{
			resultJson.put("code", "1");
			resultJson.put("info", "行政区修改成功");
			JSONObject data = new JSONObject();
			data.put("id", region.getId());
			resultJson.put("data", data);
		}else
		{	
			resultJson.put("code", "0");
			resultJson.put("info", "行政区修改失败");
		}
		return resultJson;
	}
	@Override
	public ARegion findOneRegionService(Map<String, Object> condMap)
	{
		
		return this.regionDao.findOne(condMap);
	}
	@Override
	public List<ARegion> findListRegionService(PageInfoUtil pageInfoUtil, Map<String, Object> condMap)
	{
		/* 修改条件 */
		if(condMap.get("keyword")!=null)
		{
			condMap.put("keyword", "%"+condMap.get("keyword")+"%");
		}
		if(pageInfoUtil == null)
		{
			/* 不分页查询 */
			return this.regionDao.findList(condMap);
		}else
		{
			/* 分页查询  */
			/* 先查总记录数  */
			condMap.put("pageOperation", "true");
			List<ARegion> findList = this.regionDao.findList(condMap);
			pageInfoUtil.setTotalRecord(findList.get(0).getId());
			/* 查询总记录数 */
			condMap.put("pageOperation", "false");
			condMap.put("currRecord", pageInfoUtil.getCurrRecord());
			condMap.put("pageSize", pageInfoUtil.getPageSize());
			List<ARegion> list = this.regionDao.findList(condMap);
			return list ;
		}
	}
	/* =================行政区的service的实现结束==================== */

}

