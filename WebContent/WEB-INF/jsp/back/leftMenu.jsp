<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/include/page.jsp"%>
<div class="accordion" fillSpace="sidebar">
	<div class="accordionContent">
		<c:if test="${param.oper == 'userMenu' }">
			<ul class="tree treeFolder">
				<li>
					<a href="tabsPage.html" target="navTab">用户管理</a>
					<ul>
						<li><a href="main.html" target="navTab" rel="userList">用户列表</a></li>
						<li><a href="http://www.baidu.com" target="navTab" rel="userInsert">用户添加</a></li>
					</ul>
				</li>
			</ul>
		</c:if>
		<c:if test="${param.oper == 'adminsMenu' }">
			<ul class="tree treeFolder">
				<li>
					<a href="${rootPath }/back/admins/adminsList.htm" target="navTab" rel="adminsList">管理员管理</a>
					<ul>
						<li><a href="${rootPath }/back/admins/adminsList.htm" target="navTab" rel="adminsList">管理员列表</a></li>
						<li><a href="${rootPath }/back/admins/adminsInsert.htm" target="navTab" rel="adminsInsert">管理员添加</a></li>
					</ul>
				</li>
			</ul>
			<ul class="tree treeFolder">
				<li>
					<a href="${rootPath }/back/system/regionList.htm" target="navTab" rel="regionList">行政区域管理</a>
					<ul>
						<li><a href="${rootPath }/back/system/regionList.htm" target="navTab" rel="regionList">行政区域管理</a></li>
					</ul>
				</li>
			</ul>
		</c:if>	
	</div>