<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
<link rel="stylesheet" href="js/mywidget/widgets/themes/darkangel/darkangel.css" />
<link rel="stylesheet" href="js/mywidget/widgets/themes/darkangel/override.css" />

<script type="text/javascript" src="script/zDrag.js"></script>
<script type="text/javascript" src="script/zDialog.js"></script>
<script type="text/javascript" src="script/innerHTML.js"></script>
<script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
<script>
$(document).ready(function(){
	$("#search").click(function(){	
		window.location.href="search?name="+document.getElementById("name").value+"&department="+document.getElementById("department").value+"&truename="+document.getElementById("truename").value;
	});
});
$(document).ready(function(){
	$(".del").click(function(){
/* 		var shopping = document.getElementById("purchases");
		shopping.setAttribute("title","a list of goods"); */	
		window.location.href="delUser_sub.jsp?id="+this.getAttribute("uid");
	});
});
$(document).ready(function(){
	$(".edit").click(function(){
		var diag = new Dialog();
		diag.Modal = false;
		diag.Title = "添加用户";
		diag.width = 300;
		diag.Height = 400;
		diag.URL = "editUser.jsp?id="+this.getAttribute("uid");
		diag.show();
	});
});
$(document).ready(function(){
	$(".detail").click(function(){
		var diag = new Dialog();
		diag.Modal = false;
		diag.Title = "用户详情";
		diag.width = 300;
		diag.Height = 400;
		diag.URL = "detailUser.jsp?id="+this.getAttribute("uid");
		diag.show();
	});
});
</script>
<style type="text/css">
table.hovertable {
	font-family: verdana,arial,sans-serif;
	font-size:11px;
	color:#333333;
	border-width: 1px;
	border-color: #999999;
	border-collapse: collapse;
}
table.hovertable th {
	background-color:#c3dde0;
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
}
table.hovertable tr {
	background-color:#d4e3e5;
	onmouseover:style.background-color;
}
table.hovertable td {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
}
</style>

</head>
<body>
<table align="center" class="hovertable" width="100%">
	<tr>
	<td>按用户名：<input type="text" id="name"></td>
	<td>按部门：<input type="text" id="department"></td>
	<td>按真实姓名：<input type="text" id="truename"></td>
	<td><input type="button" value="搜索" id="search">
	</tr>
</table>
<table align="center" class="hovertable" width="100%">
	<tr><td colspan="8">用户列表</td></tr>
	<tr><td>ID</td><td>用户名</td><td>真实姓名</td><td>所属单位</td><td>联系电话</td><td>邮箱</td><td>备注</td><td>操作</td></tr>
	<c:forEach items="${users}" var="item">  
	<tr onmouseover="this.style.backgroundColor='#ffff66'" onmouseout="this.style.backgroundColor='#d4e3e5'">
		<td>${item.id}</td>
		<td>${item.name}</td>
		<td>${item.truename}</td>
		<td>${item.department}</td>
		<td>${item.tel}</td>
		<td>${item.email}</td>
		<td>${item.note}</td>
		<td>
			<input type="button" value="查看详情" class="detail" uid="${item.id}">&nbsp;&nbsp;
			<input type="button" value="删除用户" class="del" uid="${item.id}">&nbsp;&nbsp;
			<input type="button" value="修改用户" class="edit" uid="${item.id}">&nbsp;&nbsp;
		</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>