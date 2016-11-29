package com.bjsxt.common.util;

import java.util.Random;


public class RegCheck
{
	/**
	 * 获得指定长度的随机的字符串组合
	 * @param length
	 * @return
	 */
	public static String getRandomStr(int length)
	{
		String souStr = "0123456789abcdefghigklmnopqrstuvwxyzABCDEFGHIGKLMNOPQRSTUVWXYZ";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<length; i++)
		{
			sb.append(souStr.charAt(random.nextInt(souStr.length())));
		}
		return sb.toString();
	}
/*	public static void main(String[] args)
	{
		String string = RegCheck.getRandomStr(32);
		System.out.println(string);
	}*/
}
