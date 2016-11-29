package com.bjsxt.common.controller;

import java.io.IOException;

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
}
