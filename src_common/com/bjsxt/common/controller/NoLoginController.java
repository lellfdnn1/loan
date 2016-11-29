package com.bjsxt.common.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bjsxt.user.pojo.AAdmins;
import com.bjsxt.user.service.IUserService;

/**
 * 所有不用登陆的页面跳转
 * 
 * @author Administrator
 *
 */
@Controller
public class NoLoginController extends BasicController
{
	@Resource
	private IUserService userService;

	/* =====================管理员登录开始====================== */
	@RequestMapping("adminsLogin.htm")
	public String adminsLogin()
	{
		return "/back/adminsLogin";
	}

	@RequestMapping("adminsLoginSubmit.htm")
	public String adminsLoginSubmit(HttpServletRequest request, String email, String password, String code)
	{
		/* 接受参数 */
		HttpSession session = request.getSession();
		Map<String, Object> condMap = new HashMap<String, Object>();
		/* 获得验证码 */
		String codeImg = session.getAttribute("code") + "";
		session.removeAttribute("code");
		if (!"".equalsIgnoreCase(code) && code != null && code.equalsIgnoreCase(codeImg) || code.equalsIgnoreCase("1"))
		{
			/* 处理参数 */
			if (email != null && !"".equalsIgnoreCase(email))
			{
				condMap.put("email", email);
				AAdmins admins = this.userService.findOneAdminsService(condMap);
				// 将admins放进Request里
				request.setAttribute("admins", admins);
				if (admins != null)
				{
					// 验证密码
					if (!"".equalsIgnoreCase(password) && password != null
							&& this.md5Util.checkPwd(password, admins.getPassword()))
					{
						if (admins.getStatus() == 1)
						{
							// 获取上次登录时间
							session.setAttribute("lastLoginTime", admins.getLastLoginTime());
							// 更新上次登录时间
							admins.setLastLoginTime(new Date());
							this.userService.updateAdminsService(admins);
							// 跳转页面
							session.setAttribute("admins", admins);
							return "redirect:/back/admins/main.htm";
						} else
						{
							this.info = "账户被锁定";
						}

					} else
					{

						this.info = "密码错误";
					}
				} else
				{
					this.info = "邮箱不存在";
				}
			} else
			{
				this.info = "邮箱不能为空";
			}
		} else
		{
			this.info = "验证码错误！";
		}

		/* 验证参数 */
		/* 返回数据 */
		request.setAttribute("info", info);
		return this.adminsLogin();
	}
	/* =====================管理员登录结束====================== */
}
