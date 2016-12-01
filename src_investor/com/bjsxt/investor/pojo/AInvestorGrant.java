package com.bjsxt.investor.pojo;

import java.util.Date;

/**
 * 出资方和银行的关联表
 * 
 * @author Administrator
 *
 */
public class AInvestorGrant
{
	private int id; // id
	private int investorId; // 出资方Id
	private int grantId; // 权限IDId
	private byte status; // 状态
	private Date createTime; // 创建时间
	private Date updateTime; // 更新时间
	private Date pubTime; // 发布时间(用来排序)
	
	/* 出资方授权关系表多对多中间表(多) */
	/* 出资方的引用 */
	private AInvestor investor;
	/* 授权的引用 */
	private AGrant grant;
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public int getInvestorId()
	{
		return investorId;
	}
	public void setInvestorId(int investorId)
	{
		this.investorId = investorId;
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
	public int getGrantId()
	{
		return grantId;
	}
	public void setGrantId(int grantId)
	{
		this.grantId = grantId;
	}
	public AInvestor getInvestor()
	{
		return investor;
	}
	public void setInvestor(AInvestor investor)
	{
		this.investor = investor;
	}
	public AGrant getGrant()
	{
		return grant;
	}
	public void setGrant(AGrant grant)
	{
		this.grant = grant;
	}

	
}
