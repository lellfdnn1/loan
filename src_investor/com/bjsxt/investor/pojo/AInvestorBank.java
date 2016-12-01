package com.bjsxt.investor.pojo;

import java.util.Date;

/**
 * 出资方和银行的关联表
 * 
 * @author Administrator
 *
 */
public class AInvestorBank
{

	private int id; // id
	private int investorId; // 出资方Id
	private int bankId; // 银行Id
	private byte status; // 状态
	private Date createTime; // 创建时间
	private Date updateTime; // 更新时间
	private Date pubTime; // 发布时间(用来排序)
	
	/* 出资方银行表和银行表关系  多的一方  */
	private ABank bank;
	/* 出资方银行表和银行表关系  多的一方  */
	private AInvestor investor;
	
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
	public int getBankId()
	{
		return bankId;
	}
	public void setBankId(int bankId)
	{
		this.bankId = bankId;
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
	public ABank getBank()
	{
		return bank;
	}
	public void setBank(ABank bank)
	{
		this.bank = bank;
	}
	public AInvestor getInvestor()
	{
		return investor;
	}
	public void setInvestor(AInvestor investor)
	{
		this.investor = investor;
	}

	
}
