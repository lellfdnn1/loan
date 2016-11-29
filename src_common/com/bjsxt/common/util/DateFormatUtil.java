package com.bjsxt.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component("dateFormatUtil")
public class DateFormatUtil
{
	private String pattern = "yyyy-MM-dd HH:mm:ss";
	/* ==================字符串转时间开始================ */
	public Date parseStr(String souStr)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try
		{
			return sdf.parse(souStr);
		} catch (ParseException e)
		{
			return null;
		}
	}
	public Date parseStr(String souStr,String pattern)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try
		{
			return sdf.parse(souStr);
		} catch (ParseException e)
		{
			return null;
		}
	}
	/* ==================字符串转时间开始================ */
	/* ==================时间转字符串开始================ */
	public String formatDate(Date date)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
	
	public String formatDate(Date date,String pattern)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
}
