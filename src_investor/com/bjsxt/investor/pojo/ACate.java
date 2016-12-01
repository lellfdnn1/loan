package com.bjsxt.investor.pojo;

import java.util.Date;
import java.util.Set;

/**
 * 出资方
 * 
 * @author Administrator
 *
 */
public class ACate
{
	private int id; // id
	private String name; // 名字
	private String code; // 编码
	private String content; // 内容
	private byte cateType; // 类型:0:授权的分类;1:用户来源分类
	private byte status; // 状态
	private Date createTime; // 创建时间
	private Date updateTime; // 更新时间
	private Date pubTime; // 发布时间(用来排序)

	/* 授权表和授权分类表的关系(一) */
	private Set<AGrant> grantSet; 
	
	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public byte getStatus()
	{
		return status;
	}

	public void setStatus(byte status)
	{
		this.status = status;
	}

	public Date getCreateTime()
	{
		return createTime;
	}

	public void setCreateTime(Date createTime)
	{
		this.createTime = createTime;
	}

	public Date getUpdateTime()
	{
		return updateTime;
	}

	public void setUpdateTime(Date updateTime)
	{
		this.updateTime = updateTime;
	}

	public Date getPubTime()
	{
		return pubTime;
	}

	public void setPubTime(Date pubTime)
	{
		this.pubTime = pubTime;
	}

	public byte getCateType()
	{
		return cateType;
	}

	public void setCateType(byte cateType)
	{
		this.cateType = cateType;
	}

	public Set<AGrant> getGrantSet()
	{
		return grantSet;
	}

	public void setGrantSet(Set<AGrant> grantSet)
	{
		this.grantSet = grantSet;
	}

}
