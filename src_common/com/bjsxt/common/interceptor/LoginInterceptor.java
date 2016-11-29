package com.bjsxt.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.bjsxt.common.util.ConstantFinalUtil;
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
		Object attribute = request.getSession().getAttribute("admins");
		if(attribute == null)
		{
			request.setAttribute("info", "登录失效，请重新登录！");
		}
		return true ;
	}
}
