<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/include/page.jsp"%>
<form id="pagerForm" method="post" action="demo_page1.html">
	<input type="hidden" name="status" value="${param.status}"> <input
		type="hidden" name="keywords" value="${param.keywords}" /> <input
		type="hidden" name="pageNum" value="1" /> <input type="hidden"
		name="numPerPage" value="${model.numPerPage}" /> <input type="hidden"
		name="orderField" value="${param.orderField}" />
</form>


<div class="pageHeader">
	<form onsubmit="return navTabSearch(this);" action="${rootPath }/back/admins/adminsList.htm" method="post">
		<input type="hidden" name="currentPage" value="${requestScope.pageInfoUtil.currentPage }">
		<input type="hidden" name="pageSize" value="${requestScope.pageInfoUtil.pageSize }">
		<div class="searchBar">
			<table class="searchContent">
				<tr>
					<td>关键字：<input type="text" name="keyword" value="${requestScope.map.keyword }"/>
					</td>
					<td><select name="status">
							<option value="">-请选择-</option>
							<option value="1" ${requestScope.map.status == '1'?'selected':'' }>-启用-</option>
							<option value="0" ${requestScope.map.status == '0'?'selected':''}>-禁用-</option>
					</select></td>
					<td>日期:
						<input type="text" name="startTime" class="date" readonly="true" datefmt="yyyy-MM-dd HH:mm:ss" value="${requestScope.map.startTime }"/>-->
						<input type="text" name="endTime" class="date" readonly="true" datefmt="yyyy-MM-dd HH:mm:ss" value="${requestScope.map.endTime }"/>
					</td>
				</tr>
			</table>
			<div class="subBar">
				<ul>
					<li><div class="buttonActive">
							<div class="buttonContent">
								<button type="submit">检索</button>
							</div>
						</div></li>
				</ul>
			</div>
		</div>
	</form>
</div>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" href="${rootPath }/back/admins/adminsInsert.htm" target="navTab" rel="adminsInsert"><span>管理员添加</span></a></li>
			<li><a class="delete"
				href="demo/common/ajaxDone.html?uid={sid_user}" target="ajaxTodo"
				title="确定要删除吗?"><span>删除</span></a></li>
			<li><a class="edit" href="demo_page4.html?uid={sid_user}"
				target="navTab"><span>修改</span></a></li>
			<li class="line">line</li>
			<li><a class="icon" href="demo/common/dwz-team.xls"
				target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="80">序号</th>
				<th width="100">email</th>
				<th width="40">真实姓名</th>
				<th width="80">电话</th>
				<th width="80">qq</th>
				<th width="80" >状态</th>
				<th width="120">创建时间</th>
				<th width="120">更新时间</th>
				<th width="120">上次登录时间</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.adminsList}" var="admins" varStatus="vs">
				<tr target="sid_user" rel="${admins.id }">
					<td>${(requestScope.pageInfoUtil.currentPage-1)*requestScope.pageInfoUtil.pageSize+vs.count }</td>
					<td>${admins.email }</td>
					<td>${admins.trueName }</td>
					<td>${admins.phone }</td>
					<td>${admins.qq }</td>
					<td>${admins.statusStr }</td>
					<td>
						<fmt:formatDate value="${admins.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>					
					</td>
					<td>
						<fmt:formatDate value="${admins.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>					
					</td>
					<td>
						<fmt:formatDate value="${admins.lastLoginTime}" pattern="yyyy-MM-dd HH:mm:ss"/>					
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="panelBar">
		<div class="pages">
			<form action="${rootPath }/back/admins/adminsList.htm" method="post" id="adminsFormId" onsubmit="return navTabSearch(this);">
				<input type="hidden" name="keyword" value="${requestScope.map.keyword }" >
				<input type="hidden" name="status" value="${requestScope.map.status }" >
				<input type="hidden" name="startTime" value="${requestScope.map.startTime }" >
				<input type="hidden" name="endTime" value="${requestScope.map.endTime }" >
				<a class="button" onclick="return reflushAdminsList('adminsFormId','adminsListCurrentPage',1,'adminsListPageSize',${requestScope.pageInfoUtil.pageSize})"><span>首页&nbsp;&nbsp;</span></a>
				<a class="button" onclick="return reflushAdminsList('adminsFormId','adminsListCurrentPage',${requestScope.pageInfoUtil.prePage },'adminsListPageSize',${requestScope.pageInfoUtil.pageSize})"><span>上一页</span></a>
				<a class="button" onclick="return reflushAdminsList('adminsFormId','adminsListCurrentPage',${requestScope.pageInfoUtil.nextPage },'adminsListPageSize',${requestScope.pageInfoUtil.pageSize})"><span>下一页</span></a>
				<a class="button" onclick="return reflushAdminsList('adminsFormId','adminsListCurrentPage',${requestScope.pageInfoUtil.totalPage },'adminsListPageSize',${requestScope.pageInfoUtil.pageSize})"><span>尾页</span></a>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<span>第${requestScope.pageInfoUtil.currentPage }/</span>
				<span>${requestScope.pageInfoUtil.totalPage }页</span>
				<span>&nbsp;&nbsp;&nbsp;共${requestScope.pageInfoUtil.totalRecord }条记录</span>
				<input type="text" name="currentPage" id="adminsListCurrentPage" value="${requestScope.pageInfoUtil.currentPage }" size="5" maxlength="5">
				<input type="text" name="pageSize" id="adminsListPageSize" value="${requestScope.pageInfoUtil.pageSize }" size="5" maxlength="5">
				<input type="submit" value="GO">
			</form>
		</div>
	</div>
</div>

