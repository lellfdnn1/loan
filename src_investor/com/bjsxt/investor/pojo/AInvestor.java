package com.bjsxt.investor.pojo;

import java.util.Date;
import java.util.Set;

/**
 * 出资方
 * @author Administrator
 *
 */
public class AInvestor
{
	private int id;                            //id
	private String name;					   //名字
	private String contactName;				   //联系人名字
	private String contactPhone;			   //联系人电话
	private String code;					   //编码
	private String content;					   //内容
	private String url;						   //公司的主页
	private int totalNum;				   	   //总共有多少次的交易限度
	private int succedNum;				       //总共成功了多少次的交易
	private String logo;					   //logn图片的地址
	private byte coopType;					   //合作类型:0:直通;1:非直通
	private byte status;				   	   //预期利率
	private Date createTime;				   //创建时间
	private Date updateTime;				   //更新时间
	private Date pubTime;				       //发布时间(用来排序)
	
	/* 出资方银行关系表和出资方的关系 */
	private Set<AInvestorBank> investorBankSet;
	
	/* 出资方授权表和出资方表的关系 */
	private Set<AInvestorGrant> investorGrantSet;
	
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
	public String getContactName()
	{
		return contactName;
	}
	public void setContactName(String contactName)
	{
		this.contactName = contactName;
	}
	public String getContactPhone()
	{
		return contactPhone;
	}
	public void setContactPhone(String contactPhone)
	{
		this.contactPhone = contactPhone;
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
	public int getTotalNum()
	{
		return totalNum;
	}
	public void setTotalNum(int totalNum)
	{
		this.totalNum = totalNum;
	}
	public int getSuccedNum()
	{
		return succedNum;
	}
	public void setSuccedNum(int succedNum)
	{
		this.succedNum = succedNum;
	}
	public String getLogo()
	{
		return logo;
	}
	public void setLogo(String logo)
	{
		this.logo = logo;
	}
	public byte getCoopType()
	{
		return coopType;
	}
	public void setCoopType(byte coopType)
	{
		this.coopType = coopType;
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
	public Set<AInvestorGrant> getInvestorGrantSet()
	{
		return investorGrantSet;
	}
	public void setInvestorGrantSet(Set<AInvestorGrant> investorGrantSet)
	{
		this.investorGrantSet = investorGrantSet;
	}
	
}
