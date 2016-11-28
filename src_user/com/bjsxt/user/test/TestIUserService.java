package com.bjsxt.user.test;

import org.junit.Before;

import com.bjsxt.common.util.BasicTest;
import com.bjsxt.user.service.IUserService;

public class TestIUserService extends BasicTest
{
	private IUserService userService;
	@Before
	public void info()
	{
		userService = (IUserService) this.ac.getBean("userService");
	}
}
