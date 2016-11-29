package com.bjsxt.common.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;

import com.bjsxt.common.util.MD5Util;
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
}
