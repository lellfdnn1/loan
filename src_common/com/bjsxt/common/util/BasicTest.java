package com.bjsxt.common.util;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * 所有的工具类的父类
 * @author Administrator
 *
 */
public class BasicTest
{
	/*sprig的IOC容器*/
	protected ApplicationContext ac = null;
	@Before
	public void infoSpring()
	{
		ac = new ClassPathXmlApplicationContext("classpath:spring/applicationContext_*.xml");
	}
	
	@Test
	public void testSuccess()
	{
		ConstantFinalUtil.LOGGER.info("----test---");
	}
}
