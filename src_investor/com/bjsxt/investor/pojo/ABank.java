package com.bjsxt.investor.pojo;

import java.util.Date;
import java.util.Set;

/**
 * 出资方
 * 
 * @author Administrator
 *
 */
public class ABank
{

	private int id; // id
	private String name; // 名字
	private String code; // 编码
	private String content; // 内容
	private String url; // 公司的主页
	private String logo; // logn图片的地址
	private byte status; // 状态
	private Date createTime; // 创建时间
	private Date updateTime; // 更新时间
	private Date pubTime; // 发布时间(用来排序)

	/* 银行(一)-----》银行出资方银行关系表(多) */
	private Set<AInvestorBank> investorBankSet;  
	
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

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public String getLogo()
	{
		return logo;
	}

	public void setLogo(String logo)
	{
		this.logo = logo;
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

	public Set<AInvestorBank> getInvestorBankSet()
	{
		return investorBankSet;
	}

	public void setInvestorBankSet(Set<AInvestorBank> investorBankSet)
	{
		this.investorBankSet = investorBankSet;
	}

}
