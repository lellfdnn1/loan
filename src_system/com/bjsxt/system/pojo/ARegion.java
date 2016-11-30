package com.bjsxt.system.pojo;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

/**
 * 全国行政省市区表
 * @author Administrator
 *
 */
public class ARegion
{
	private int id;                            //id
	private int parentId;					   //上一级ID
	private String name;					   //名字
	private String pinyin;					   //拼音
	private String areacode;				   //地区编码
	private String content;					   //内容
	private byte leafStatus;				   //是否是叶节点、叶节点为0，非页节点为1
	private byte status;					   //状态码   1位启用，0位禁用
	private Date createTime;				   //创建时间
	private Date updateTime;				   //更新时间
	private Date pubTime;				       //发布时间(用来排序)
	
	/* 关联关系 */
	/* 多的一方  */
	private ARegion region ;
	/* 一的一方 */
	private Set<ARegion> regionSet = new TreeSet<ARegion>();
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public int getParentId()
	{
		return parentId;
	}
	public void setParentId(int parentId)
	{
		this.parentId = parentId;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getPinyin()
	{
		return pinyin;
	}
	public void setPinyin(String pinyin)
	{
		this.pinyin = pinyin;
	}
	public String getAreacode()
	{
		return areacode;
	}
	public void setAreacode(String areacode)
	{
		this.areacode = areacode;
	}
	public String getContent()
	{
		return content;
	}
	public void setContent(String content)
	{
		this.content = content;
	}
	public byte getLeafStatus()
	{
		return leafStatus;
	}
	public void setLeafStatus(byte leafStatus)
	{
		this.leafStatus = leafStatus;
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
	public ARegion getRegion()
	{
		return region;
	}
	public void setRegion(ARegion region)
	{
		this.region = region;
	}
	public Set<ARegion> getRegionSet()
	{
		return regionSet;
	}
	public void setRegionSet(Set<ARegion> regionSet)
	{
		this.regionSet = regionSet;
	}
}
