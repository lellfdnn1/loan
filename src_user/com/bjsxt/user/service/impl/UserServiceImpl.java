package com.bjsxt.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.bjsxt.common.util.PageInfoUtil;
import com.bjsxt.user.dao.IAAdminsDao;
import com.bjsxt.user.pojo.AAdmins;
import com.bjsxt.user.service.IUserService;
/**
 * 所有有关用户的servcie的实现
 * @author Administrator
 *
 */
@Service("userService")
public class UserServiceImpl implements IUserService
{
	@Resource
	private IAAdminsDao adminsDao ;
	
	/* =================管理员的service的实现开始==================== */

	@Override
	public JSONObject insertAdminsService(AAdmins admins)
	{
		JSONObject resultJson = new JSONObject();
		int insert = this.adminsDao.insert(admins);
		
		if(insert>0)
		{
			resultJson.put("code", "1");
			resultJson.put("info", "管理员添加成功");
			JSONObject data = new JSONObject();
			data.put("id", admins.getId());
			resultJson.put("data", data);
		}else
		{
			resultJson.put("code", "0");
			resultJson.put("info", "管理员添加失败");
		}
		return resultJson;
	}

	@Override
	public JSONObject deleteAdminsService(Map<String, Object> condMap)
	{
		JSONObject resultJson = new JSONObject();
		int delete = this.adminsDao.delete(condMap);
		if(delete>0)
		{
			resultJson.put("code", "1");
			resultJson.put("info", "管理员删除成功");
			JSONObject data = new JSONObject();
			data.put("删除个数", delete);
			resultJson.put("data", data);
		}else
		{
			resultJson.put("code", "0");
			resultJson.put("info", "管理员删除失败");
		}
		return resultJson;
	}

	@Override
	public JSONObject updateAdminsService(AAdmins admins)
	{
		JSONObject resultJson = new JSONObject();
		int update = this.adminsDao.update(admins);
		
		if(update>0)
		{
			resultJson.put("code", "1");
			resultJson.put("info", "管理员修改成功");
			JSONObject data = new JSONObject();
			data.put("id", admins.getId());
			resultJson.put("data", data);
		}else
		{
			resultJson.put("code", "0");
			resultJson.put("info", "管理员修改失败");
		}
		return resultJson;
	}
	@Override
	public AAdmins findOneAdminsService(Map<String, Object> condMap)
	{
		
		return this.adminsDao.findOne(condMap);
	}
	@Override
	public List<AAdmins> findListAdminsService(PageInfoUtil pageInfoUtil, Map<String, Object> condMap)
	{
		if(pageInfoUtil == null)
		{
			/* 不分页查询 */
			return this.adminsDao.findList(condMap);
		}else
		{
			/* 分页查询  */
			/* 先查总记录数  */
			condMap.put("pageOperation", "true");
			List<AAdmins> findList = this.adminsDao.findList(condMap);
			pageInfoUtil.setTotalRecord(findList.get(0).getId());
			/* 查询总记录数 */
			condMap.put("pageOperation", "false");
			condMap.put("currRecord", pageInfoUtil.getCurrRecord());
			condMap.put("pageSize", pageInfoUtil.getPageSize());
			List<AAdmins> list = this.adminsDao.findList(condMap);
			return list ;
		}
	}
	
	/* =================管理员的service的实现结束==================== */
}

