package com.bjsxt.springmvc.head.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bjsxt.common.controller.BasicController;
import com.bjsxt.common.util.PageInfoUtil;
import com.bjsxt.system.pojo.ARegion;
import com.bjsxt.system.service.IRegionService;

@Controller
@RequestMapping("/back/system/")
public class SystemBackController extends BasicController
{
	@Resource
	private IRegionService regionService;
	
	@RequestMapping("regionList.htm")
	public String regionList(HttpServletRequest request)
	{
		/* 接受分页参数 */
		PageInfoUtil pageInfoUtil = super.getPageInfo(request);
		/* 封装接受参数 */
		Map<String,Map<String,Object>> basicMap = this.getCondMap(request);
		/* 数据库查询 */
		/* 封装基本查询条件 */
		Map<String,Object> condMap = basicMap.get("condMap");
		/* 封装额外的查询条件 */
		String parentId = request.getParameter("parentId");
		if(parentId != null && !"".equalsIgnoreCase(parentId))
		{
			condMap.put("parentId", Integer.valueOf(parentId));
		}
		
		List<ARegion> list = this.regionService.findListRegionService(pageInfoUtil, condMap);
		/* 返回数据 */
		request.setAttribute("list", list);
		request.setAttribute("parentId", parentId);
		request.setAttribute("map", basicMap.get("sourceMap"));
		request.setAttribute("pageInfoUtil", pageInfoUtil);
		
		return "/back/system/regionList";
	}
	
}
