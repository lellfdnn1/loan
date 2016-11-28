package com.bjsxt.user.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
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
	public AAdmins findOneAdminsService(Map<String, Object> condMap)
	{
		
		return this.adminsDao.findOne(condMap);
	}

	@Override
	public JSONObject insertAdminsService(AAdmins admins)
	{
		JSONObject resultJson = new JSONObject();
		int insert = this.adminsDao.insert(admins);
		
		String str = null;
		str.charAt(1);
		
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
	
	/* =================管理员的service的实现结束==================== */
}

