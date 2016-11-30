package com.bjsxt.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.bjsxt.common.controller.BasicController;
import com.bjsxt.user.pojo.AAdmins;
/**
 * 后台Admins登录的拦截器
 * @author Administrator
 */
@Component("loginInterceptor")
public class LoginInterceptor extends HandlerInterceptorAdapter
{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
	{
		HttpSession session = request.getSession();
		AAdmins admins = (AAdmins)session.getAttribute("admins");
		BasicController.request = request;
		BasicController.response = response;
		if(admins == null)
		{
			session.setAttribute("info", "登录过期，请重新登录");
			response.sendRedirect("/loan/adminsLogin.htm");
			return false;
		}
		return true ;
	}
}
