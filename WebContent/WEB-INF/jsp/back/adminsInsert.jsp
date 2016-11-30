<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/include/page.jsp"%>
<link href="${rootPath}/css/AdminsInsertCss.css" type="text/css"  />
<h2 class="contentTitle">管理员添加</h2>
<div class="pageContent">
	<form method="post" action="${rootPath }/back/admins/adminsInsertSubmit.htm"
		class="pageForm required-validate"
		onsubmit="return iframeCallback(this,navTabAjaxDone);" 
		
		<!-- 关闭当前的页面 -->
		<input type="hidden" name="callbackType" value="closeCurrent">
		<input type="hidden" name="navTabId" value="adminsList">
		
		<div class="pageFormContent nowrap" layoutH="97">
			<dl>
				<dt>邮箱：</dt>
				<dd>
					<input type="text" name="email" class="required email"
						alt="请输入您的电子邮件" /> <span class="info"></span>
				</dd>
			</dl>
			<dl>
				<dt>密码：</dt>
				<dd>
					<input id="admins_insert_pwd" type="password" name="password"
						class="required alphanumeric" minlength="6" maxlength="20"
						alt="字母、数字、下划线 6-20位" /> <span class="info"></span>
				</dd>
			</dl>
			<dl>
				<dt>确认密码：</dt>
				<dd>
					<input type="password"  class="required"
						equalto="#admins_insert_pwd" /> <span class="info"></span>
				</dd>
			</dl>
			<dl>
				<dt>真实姓名：</dt>
				<dd>
					<input id="w_validation_pwd" type="text" name="trueName"   /> <span class="info"></span>
				</dd>
			</dl>
			<dl>
				<dt>电话：</dt>
				<dd>
					<input type="text" name="phone" class="phone" alt="请输入您的电话" /> <span
						class="info">class="phone"</span>
				</dd>
			</dl>
			<dl>
				<dt>qq：</dt>
				<dd>
					<input type="text" name="qq" class="digits" /> <span
						class="info"></span>
				</dd>
			</dl>
			<dl>
				<dt>状态:</dt>
				<dd>
					<input id="statusAdminsInsert1" name="status" type="radio" value="1"/><label style="float:none;" for="statusAdminsInsert1">启用</label>
					<input id="statusAdminsInsert2" name="status" type="radio" value="0"/><label style="float:none;" for="statusAdminsInsert2">禁用</label>
				</dd>
			</dl>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive">
						<div class="buttonContent">
							<button type="submit">提交</button>
						</div>
					</div></li>
				<li><div class="button">
						<div class="buttonContent">
							<button type="button" class="close">取消</button>
						</div>
					</div></li>
			</ul>
		</div>
	</form>

</div>

<!-- 
<script type="text/javascript">
	function customvalidXxx(element) {
		if ($(element).val() == "xxx")
			return false;
		return true;
	}
</script> -->
