package com.bjsxt.system.service;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.bjsxt.common.util.PageInfoUtil;
import com.bjsxt.system.pojo.ARegion;
/***
 * 所有user的service层接口
 * @author Administrator
 *
 */
public interface IRegionService
{
	/*====================行政地区划分的service操作开始 ========================= */
	/**
	 * 添加一条Region记录
	 * @param region
	 * @return
	 */
	JSONObject insertRegionService(ARegion region);
	/**
	 * 删除一个Region操作
	 * @param condMap
	 * @return
	 */
	JSONObject deleteRegionService(Map<String,Object> condMap);
	/**
	 * 修改一个Region记录
	 * @param region
	 * @return
	 */
	JSONObject updateRegionService(ARegion region);
	/**
	 * 查询一条Region记录
	 * @param condMap
	 * @return
	 */
	ARegion findOneRegionService(Map<String,Object> condMap);
	/**
	 * 查询多条记录
	 * @param pageInfoUtil
	 * @param condMap
	 * @return
	 */
	List<ARegion> findListRegionService(PageInfoUtil pageInfoUtil,Map<String,Object> condMap);
	/*====================行政地区划分的service操作结束 ========================= */
}
