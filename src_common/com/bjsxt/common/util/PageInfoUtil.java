package com.bjsxt.common.util;

/**
 * 分页的工具类
 * 
 * @author wangshSxt
 *
 */
public class PageInfoUtil
{
	/* 每页多少条 */
	private int pageSize = 20;
	/* 总记录数 */
	private int totalRecord;

	/* 当前页 */
	private int currentPage;
	/* 上一页 */
	private int prePage;
	/* 下一页 */
	private int nextPage;
	/* 总页数 */
	private int totalPage;
	/* 当前页 是第几条 */
	private int currRecord;

	public int getPageSize()
	{
		return pageSize;
	}

	public void setPageSize(int pageSize)
	{
		this.pageSize = pageSize;
	}

	public int getTotalRecord()
	{
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord)
	{
		this.totalRecord = totalRecord;
	}

	public int getCurrentPage()
	{
		/* 如果当前页小于1,默认为1 */
		if(this.currentPage < 1 )
		{
			this.currentPage = 1 ; 
		}
		
		/* 如果当前页大于总页数,默认为总页数 */
		/*
		 * && this.getTotalRecord() > 0 
		 * 
		 * 如果总记录数为0;那么总页数也为0;
		 * 程序执行到此,currentPage 肯定>=1
		 * 
		 * this.currentPage > this.getTotalPage() (肯定成立)
		 */
		if(this.currentPage > this.getTotalPage() && this.getTotalRecord() > 0 )
		{
			this.currentPage = this.getTotalPage() ; 
		}
		return currentPage;
	}

	public void setCurrentPage(int currentPage)
	{
		this.currentPage = currentPage;
	}

	public int getPrePage()
	{
		this.prePage = this.currentPage - 1 ; 
		/* 如果当前页小于1,默认为1 */
		if(this.prePage < 1 )
		{
			this.prePage = 1 ; 
		}
		
		/* 如果当前页大于总页数,默认为总页数 */
		if(this.prePage > this.getTotalPage())
		{
			this.prePage = this.getTotalPage() ; 
		}
		return prePage;
	}

	public int getNextPage()
	{
		this.nextPage = this.currentPage + 1 ; 
		if(this.nextPage < 1 )
		{
			this.nextPage = 1 ; 
		}
		
		/* 如果当前页大于总页数,默认为总页数 */
		if(this.nextPage > this.getTotalPage())
		{
			this.nextPage = this.getTotalPage() ; 
		}
		return nextPage;
	}

	public int getTotalPage()
	{
		this.totalPage = (int) Math.ceil(1.0 * this.getTotalRecord() / this.pageSize) ; 
		return totalPage;
	}

	public int getCurrRecord()
	{
		/*
		 * 共35条,每页10条.
		 * 
		 * 第一页 1
		 * 第二页 11  
		 * */
		this.currRecord = (this.getCurrentPage() - 1 )* this.pageSize;
		return currRecord;
	}

	@Override
	public String toString()
	{
		return "PageInfoUtil [pageSize=" + pageSize + ", totalRecord=" + totalRecord + ", currentPage=" + this.getCurrentPage()
				+ ", prePage=" + this.getPrePage() + ", nextPage=" + this.getNextPage() + ", totalPage=" + this.getTotalPage() + ", currRecord="
				+ this.getCurrRecord() + "]";
	}
	
	
	public static void main(String[] args)
	{
		PageInfoUtil pageInfoUtil = new PageInfoUtil();
		pageInfoUtil.setTotalRecord(35);
		pageInfoUtil.setPageSize(10);
		pageInfoUtil.setCurrentPage(2);
		
		System.out.println(pageInfoUtil);
	}
}

