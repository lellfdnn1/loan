package com.bjsxt.springmvc.head.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.bjsxt.common.controller.BasicController;
import com.bjsxt.common.util.ConstantFinalUtil;
import com.bjsxt.common.util.PageInfoUtil;
import com.bjsxt.user.pojo.AAdmins;
import com.bjsxt.user.service.IUserService;

@Controller
@RequestMapping("/back/admins/")
public class AdminsBackController extends BasicController
{
	@Resource
	private IUserService userService;
	/**
	 * 进入主页面
	 * @return
	 */
	@RequestMapping("/main.htm")
	public String main()
	{
		ConstantFinalUtil.LOGGER.info("------main----");
		return "/back/main";
	}
	
	/**
	 * 左侧菜单选项卡
	 */
	@RequestMapping("leftMenu.htm")
	public String leftMenu()
	{
		return "/back/leftMenu";
	}
	/**
	 * 管理员推出
	 */
	@RequestMapping("adminsBack")
	public String adminsBack(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		session.removeAttribute("admins");
		session.removeAttribute("lastLaginTime");
		session.setAttribute("info", "成功退出");
		return "redirect:/adminsLogin.htm";
	}
	/* 管理员的操作开始 */
	/**
	 * 用户添加操作
	 * @return
	 */
	@RequestMapping("adminsList.htm")
	public String adminsList(HttpServletRequest request)
	{
		/* 封装分页信息 */
		PageInfoUtil pageInfoUtil =  super.getPageInfo(request);
		/* 接受Admins条件参数 */
		Map<String,Object> condMap = this.getCondMap(request);
		/* 从数据库查询数据 */
		List<AAdmins> adminsList = this.userService.findListAdminsService(pageInfoUtil, condMap);
		/* 将数据存入作用域 */
		
		if(condMap.get("startTime")!=null && condMap.get("endTime")!=null)
		{
			/*  将日期转回来 */
			condMap.put("startTime", request.getParameter("startTime"));
			condMap.put("endTime",request.getParameter("endTime"));
		}
		condMap.put("keyword", request.getParameter("keyword"));
		request.setAttribute("map", condMap);
		request.setAttribute("pageInfoUtil", pageInfoUtil);
		request.setAttribute("adminsList", adminsList);
		return "/back/adminsList";
	}
	/**
	 * 用户提交添加
	 * @return
	 */
	@RequestMapping("adminsInsert.htm")
	public  String adminsInsert()
	{
		return "/back/adminsInsert";
	}
	/**
	 * 用户提交操作
	 * @return
	 */
	@RequestMapping("adminsInsertSubmit.htm")
	public @ResponseBody String adminsInsertSubmit(HttpServletRequest request,HttpServletResponse response,AAdmins admins)
	{
		/* 处理参数 */
		admins.setPassword(this.md5Util.encryString(admins.getPassword()));
		admins.setCreateTime(new Date());
		admins.setLastLoginTime(new Date());
		admins.setUpdateTime(new Date());
		/* 保存对象 */
		JSONObject jsonObject = this.userService.insertAdminsService(admins);
		JSONObject resultJson = super.getResultJson(request,jsonObject.get("info"));
		try
		{
			response.getWriter().write(resultJson.toJSONString());
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 管理员删除操作
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping("adminsDelete.htm")
	public @ResponseBody String adminsDelete(HttpServletRequest request,HttpServletResponse response,String id)
	{
		Map<String,Object> condMap = new HashMap<String,Object>();
		condMap.put("id", id);
		JSONObject jsonObject = this.userService.deleteAdminsService(condMap);
		try
		{
			response.getWriter().write(this.getResultJson(request, jsonObject.get("info")).toJSONString());
		} catch (IOException e)
		{
		}
		return null;
	}
	/**
	 * 改Admins信息
	 * @param id
	 * @return
	 */
	@RequestMapping("adminsUpdate.htm")
	public String adminsUpdate(String id)
	{
		/* 查询数据库或的admins信息 */
		Map<String,Object> condMap = new HashMap<String,Object>();
		condMap.put("id", id);
		AAdmins admins = this.userService.findOneAdminsService(condMap);
		this.request.setAttribute("admins", admins);
		return "/back/adminsUpdate";
	}	
	/**
	 * 提交修改信息
	 * @param id
	 * @return
	 */
	@RequestMapping("adminsUpdateSubmit.htm")
	public String adminsUpdateSubmit(String id)
	{
		/* 查询数据库或的admins信息 */
		ConstantFinalUtil.LOGGER.info("--adminsUpdateSubmit--");
		return null;
	}	
	
	/* 管理员的操作结束 */
	/*====================================辅助方法========================*/
	/***
	 * 封装查询条件
	 * @param request
	 * @return
	 */
	private Map<String, Object> getCondMap(HttpServletRequest request)
	{
		String keyword = request.getParameter("keyword");
		String status = request.getParameter("status");
		String start = request.getParameter("startTime");
		String end = request.getParameter("endTime");
		
		Map<String,Object> condMap = new HashMap<String,Object>();
		
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
		/* 设置参数 */
		condMap.put("keyword", keyword);
		condMap.put("status", status);
		condMap.put("startTime", startTime);
		condMap.put("endTime", endTime);
		return condMap;
	}

}
