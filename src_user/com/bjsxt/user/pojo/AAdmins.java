package com.bjsxt.user.pojo;

import java.util.Date;

public class AAdmins
{
	private int id;
	private int roleId;
	private String email;
	private String password;
	private String trueName;
	private String phone;
	private String qq;
	private byte status;
	private Date createTime;
	private Date updateTime;
	private Date lastLoginTime;
	private String statusStr ;
	/* 多对一，多的一端的引用 */
	private ARole role;

	public int getRoleId()
	{
		return roleId;
	}

	public void setRoleId(int roleId)
	{
		this.roleId = roleId;
	}
	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getTrueName()
	{
		return trueName;
	}

	public void setTrueName(String trueName)
	{
		this.trueName = trueName;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public String getQq()
	{
		return qq;
	}

	public void setQq(String qq)
	{
		this.qq = qq;
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

	public ARole getRole()
	{
		return role;
	}

	public void setRole(ARole role)
	{
		this.role = role;
	}

	public String getStatusStr()
	{
		if(this.status == 1)
		{
			return "启用";
		}else if(this.status == 0)
		{
			return "禁用";
		}
		return "未知";
	}

}
