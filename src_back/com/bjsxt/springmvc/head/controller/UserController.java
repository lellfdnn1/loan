package com.bjsxt.springmvc.head.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bjsxt.common.util.ConstantFinalUtil;

@Controller
@RequestMapping("/back/admins/")
public class UserController
{
	
	@RequestMapping("/main")
	public String main()
	{
		ConstantFinalUtil.LOGGER.info("------main----");
		return "/back/main";
	}
}
