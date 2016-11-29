package com.bjsxt.springmvc.head.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bjsxt.common.controller.BasicController;
import com.bjsxt.common.util.ConstantFinalUtil;

@Controller
@RequestMapping("/back/admins/")
public class AdminsBackController extends BasicController
{
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
}
