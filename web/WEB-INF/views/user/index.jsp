<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
 
  
<script src="${pageContext.request.contextPath}/script/zDialog.js"></script>
<script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
<script>
$(document).ready(function(){
	$("#add").click(function(){
		var diag = new Dialog();
		diag.Modal = false;
		diag.Title = "添加用户";
		diag.width = 300;
		diag.Height = 400;
		diag.URL = "./insert";
		diag.show();
	});	
});
$(document).ready(function(){
	$(".del").click(function(){	
		window.location.href="del?id="+this.getAttribute("uid");
	});
});
$(document).ready(function(){
	$(".edit").click(function(){
		var diag = new Dialog();
		diag.Modal = false;
		diag.Title = "修改用户";
		diag.width = 300;
		diag.Height = 400;
		diag.URL = "edit?id="+this.getAttribute("uid");
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
		diag.URL = "detail?id="+this.getAttribute("uid");
		diag.show();
	});
});
$(document).ready(function(){
	$("#first").click(function(){	
		window.location.href="index?currentPage="+this.getAttribute("currentPage")+"&flag=1";
	});
});
$(document).ready(function(){
	$("#pre").click(function(){	
		window.location.href="index?currentPage="+this.getAttribute("currentPage")+"&flag=2";
	});
});
$(document).ready(function(){
	$("#next").click(function(){	
		window.location.href="index?currentPage="+this.getAttribute("currentPage")+"&flag=3";
	});
});
$(document).ready(function(){
	$("#last").click(function(){	
		window.location.href="index?currentPage="+this.getAttribute("currentPage")+"&flag=4";
	});
});
$(document).ready(function(){
	$("#lookfor").click(function(){
		var diag = new Dialog();
		diag.Modal = true;
		diag.Title = "查找用户";
		diag.Width = 1200;
		diag.Height = 400;
		diag.URL = "./lookfor";
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
	<tr><td colspan="8">用户列表</td></tr>
	<tr><td>用户名</td><td>真实姓名</td><td>所属单位</td><td>联系电话</td><td>邮箱</td><td>备注</td><td>操作</td></tr>
	<c:forEach items="${users}" var="item">  
	<tr onmouseover="this.style.backgroundColor='#ffff66'" onmouseout="this.style.backgroundColor='#d4e3e5'">
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
<table align="center">
	<tr align="center">
		<td>
		<input type="button" value="添加用户" id="add">
		<input type="button" value="查找用户" id="lookfor">
		<td>
	</tr>
	<tr align="center">
		<td>
		<input type="button" value="首页" id="first" currentPage="${curPage}">
		<input type="button" value="上一页" id="pre" currentPage="${curPage}">
		<input type="button" value="下一页" id="next" currentPage="${curPage}">
		<input type="button" value="尾页" id="last" currentPage="${curPage}">
		</td>	
	</tr>
</table>
<H4 align="center">当前第${curPage}页，每页显示${pageSize}条,共${counts}条记录，一共${pages}页</H4>
</body>
</html>