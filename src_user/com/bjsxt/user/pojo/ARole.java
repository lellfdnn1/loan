package com.bjsxt.user.pojo;

import java.util.Date;
import java.util.Set;

public class ARole
{
	private int id;
	private String name;
	private String context;
	private byte status;
	private Date createTime;
	private Date updateTime;
	private Date lastLoginTime;
	
	/* 关联的一得一端 */
	private Set<AAdmins> adminsSet;
	
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
	public String getContext()
	{
		return context;
	}
	public void setContext(String context)
	{
		this.context = context;
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
	public Date getLastLoginTime()
	{
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime)
	{
		this.lastLoginTime = lastLoginTime;
	}
	public Set<AAdmins> getAdminsSet()
	{
		return adminsSet;
	}
	public void setAdminsSet(Set<AAdmins> adminsSet)
	{
		this.adminsSet = adminsSet;
	}
	
}
