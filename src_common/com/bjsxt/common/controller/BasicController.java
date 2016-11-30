package com.bjsxt.common.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.bjsxt.common.util.DateFormatUtil;
import com.bjsxt.common.util.MD5Util;
import com.bjsxt.common.util.PageInfoUtil;
import com.bjsxt.common.util.RegCheck;
import com.bjsxt.common.util.VerifyCodeUtils;

/**
 * 公共的controller
 * @author Administrator
 *
 */
public class BasicController
{
	
	protected String info ;
	
	@Resource
	protected MD5Util md5Util;
	
	@Resource
	protected DateFormatUtil dateFormatUtil;
	/**
	 * 获得验证码
	 * @throws IOException 
	 */
	@RequestMapping("/code.htm")
	public String getCode(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		/* 获得随机数 */
		String code = RegCheck.getRandomStr(4);
		/* 将验证码放到session对象中 */
		request.getSession().setAttribute("code", code);
		/* 将验证码输出到浏览器 */
		VerifyCodeUtils.outputImage(75, 40, response.getOutputStream(), code);
		return null;
	}
	/**
	 * 封装分页信息
	 * @param request
	 * @return
	 */
	protected PageInfoUtil getPageInfo(HttpServletRequest request)
	{
		String pageSize = request.getParameter("pageSize");
		String currentPage = request.getParameter("currentPage");
		PageInfoUtil pageInfoUtil = new PageInfoUtil();
		try
		{
			pageInfoUtil.setCurrentPage(Integer.valueOf(currentPage));
			pageInfoUtil.setPageSize(Integer.valueOf(pageSize));
		} catch (Exception e)
		{
		}
		return pageInfoUtil;
	}
	/**
	 * 拼装jui需要的json对象
	 * @param request
	 * @param obj
	 * @return
	 */
	protected JSONObject getResultJson(HttpServletRequest request,Object obj)
	{
		String navTabId = request.getParameter("navTabId");
		String rel = request.getParameter("rel");
		String callbackType = request.getParameter("callbackType");
		String forwardUrl = request.getParameter("forwardUrl");
		String confirmMsg = request.getParameter("confirmMsg");
		
		if(navTabId==null)
		{
			navTabId = "";
		}
		if(rel==null)
		{
			rel = "";
		}
		if(callbackType==null)
		{
			callbackType = "";
		}
		if(forwardUrl==null)
		{
			forwardUrl = "";
		}
		if(confirmMsg==null)
		{
			confirmMsg = "";
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("statusCode", "200");
		jsonObject.put("message", obj+"");
		jsonObject.put("navTabId", navTabId);
		jsonObject.put("rel", rel);
		jsonObject.put("callbackType", callbackType);
		jsonObject.put("forwardUrl", forwardUrl);
		jsonObject.put("confirmMsg", confirmMsg);
		return jsonObject;
	}
	
	/***
	 * 封装查询条件
	 * 
	 * 
	 * @param request
	 * @return
	 */
	protected Map<String, Map<String,Object>> getCondMap(HttpServletRequest request)
	{
		String keyword = request.getParameter("keyword");
		String status = request.getParameter("status");
		String start = request.getParameter("startTime");
		String end = request.getParameter("endTime");
		
		if(keyword == null )
		{
			keyword = "";
		}
		if(status == null)
		{
			status = "";
		}
		if(start == null )
		{
			start = "";
		}
		if(end == null )
		{
			end = "";
		}
		
		Date startTime = null;
		Date endTime = null;
		
		if(!"".equalsIgnoreCase(start) && !"".equalsIgnoreCase(end))
		{
			startTime =  this.dateFormatUtil.parseStr(start);
			endTime =  this.dateFormatUtil.parseStr(end);
		}
		
		/* 返回参数容器 */
		Map<String,Object> sourceMap = new HashMap<String,Object>();
		sourceMap.put("keyword", keyword);
		sourceMap.put("status", status);
		sourceMap.put("startTime", start);
		sourceMap.put("endTime", end);
		/* 查询参数容器 */
		Map<String,Object> condMap = new HashMap<String,Object>();
		
		/* 设置参数 */
		condMap.put("keyword", keyword);
		condMap.put("status", status);
		condMap.put("startTime", startTime);
		condMap.put("endTime", endTime);
		
		/* 返回参数容器 */
		Map<String,Map<String,Object>> resultMap = new HashMap<String,Map<String,Object>>();
		resultMap.put("sourceMap", sourceMap);
		resultMap.put("condMap", condMap);
		return resultMap;
	}
}
