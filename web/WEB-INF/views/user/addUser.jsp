<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>添加用户</title>
<%--<link href="${pageContext.request.contextPath}/css/demo.css" type="text/css" rel="stylesheet" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css" media="all" />--%>
<script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/script/Validform_v5.3.2_min.js"></script>
<script type="text/javascript">
$(function(){
	$(".registerform").Validform({
		tiptype:2,
		ajaxPost:true
	});
})
</script>
</head>
<body>
	<table>
		<form action="add" method="post" class="registerform">
		<tr><td cols="3" style="color:red">基本信息</td></tr>
		<tr><td>用户名</td><td><input type="text" datatype="" nullmsg="请输入用户名！" name="username"></td><td>*</td></tr>
		<!--密码-->
		<tr><td>密码</td><td><input type="password" value="" name="password" datatype="*6-15" errormsg="密码范围在6~15位之间！" /></td><td>*</td></tr>
		<!--确认密码-->
		<tr><td>重复密码</td><td><input type="password" value="" name="password2" datatype="*" recheck="password" errormsg="您两次输入的账号密码不一致！" /></td><td>*</td></tr>
		<tr><td>E-mail</td><td><input type="text" datatype="e" name="email"></td><td></td></tr>
		<tr><td>电话</td><td><input type="text" name="tel" class="inputxt" datatype="m" errormsg="请输入正确的手机号码！"></td><td></td></tr>
		<tr><td>姓名</td><td><input type="text" name=realname></td><td></td></tr>
		<tr><td>部门</td><td><input type="text" name="department"></td><td></td></tr>
		<tr><td>备注</td><td><input type="text" name="note"></td><td></td></tr>
		<tr><td colspan="3" style="color:red">角色配置</td></tr>
		<tr>
			<td colspan="3">区域角色</td>
		</tr>
		
		<c:forEach items="${roles}" var="item">
		<c:if test="${item.type=='region'}">
	    <tr>
			<td><input type="checkbox" name="roleIds" value="${item.id}"/>${item.roleName}</td>
		</tr>
		</c:if>
		</c:forEach>
		<tr><td colspan="3">命令角色</td></tr>
		<c:forEach items="${roles}" var="item">  
		<c:if test="${item.type=='command'}">
	    <tr>
			<td><input type="checkbox" name="roleIds" value="${item.id}"/>${item.roleName}</td>
		</tr>
		</c:if>
		</c:forEach>
		<tr><td></td><td><input type="submit" value="保存"></td><td><input type="reset" value="取消" onclick="javascript:window.close()"></td></tr>
		</form>
	</table>
	
</body>
</html>