<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色管理</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/js/mywidget/widgets/themes/darkangel/darkangel.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/js/mywidget/widgets/themes/darkangel/override.css" />

<script type="text/javascript" src="${pageContext.request.contextPath}/script/zDrag.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/script/zDialog.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/script/innerHTML.js"></script>
<script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
<script>
$(document).ready(function(){
	$("#addRegion").click(function(){
		var diag = new Dialog();
		diag.Modal = true;
		diag.Title = "添加区域角色";
		diag.width = 300;
		diag.Height = 400;
		diag.URL = "addRegion";
		diag.show();
		
		
	});	
});
$(document).ready(function(){
	$("#addCommand").click(function(){
		var diag = new Dialog();
		diag.Modal = true;
		diag.Title = "添加命令角色";
		diag.width = 300;
		diag.Height = 500;
		diag.URL = "addCommand";
		diag.show();
		
		
	});	
});
$(document).ready(function(){
	$(".del").click(function(){
/* 		var shopping = document.getElementById("purchases");
		shopping.setAttribute("title","a list of goods"); */	
		window.location.href="del?id="+this.getAttribute("rid");
	});
});
$(document).ready(function(){
	$(".edit").click(function(){
		var diag = new Dialog();
		diag.Modal = false;
		diag.Title = "修改角色";
		diag.width = 300;
		diag.Height = 400;
		diag.URL = "edit?id="+this.getAttribute("rid");
		diag.show();
	});
});
$(document).ready(function(){
    $(".detail").click(function(){
        var diag = new Dialog();
        diag.Modal = false;
        diag.Title = "角色详情";
        diag.width = 300;
        diag.Height = 400;
        diag.URL = "detail?id="+this.getAttribute("uid");
        diag.show();
    });
});
$(document).ready(function(){
    $("#first").click(function(){
        window.location.href="index?curPage="+this.getAttribute("currentPage")+"&flag=1";
    });
});
$(document).ready(function(){
    $("#pre").click(function(){
        window.location.href="index?curPage="+this.getAttribute("currentPage")+"&flag=2";
    });
});
$(document).ready(function(){
    $("#next").click(function(){
        window.location.href="index?curPage="+this.getAttribute("currentPage")+"&flag=3";
    });
});
$(document).ready(function(){
    $("#last").click(function(){
        window.location.href="index?curPage="+this.getAttribute("currentPage")+"&flag=4";
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
	<tr><td colspan="8">角色列表</td></tr>
	<tr><td>角色名</td><td>角色类别</td><td>角色权限</td><td>操作</td></tr>

	<c:forEach items="${roles}" var="item">
		<tr onmouseover="this.style.backgroundColor='#ffff66'" onmouseout="this.style.backgroundColor='#d4e3e5'">
		<td> ${item.roleName}</td>
		<td>${item.type}</td>
		<td width="200">${item.desText}</td>
		<td>
		<input type="button" value="删除角色" class="del" rid="${item.id}">&nbsp;&nbsp;
		<input type="button" value="修改角色" class="edit" rid="${item.id}">&nbsp;&nbsp;
		</td>
		</tr>
	</c:forEach>
		

</table>
<table align="center">
	<tr align="center">
		<td>
			<input type="button" value="添加命令角色" id="addCommand">&nbsp;&nbsp;
			<input type="button" value="添加区域角色" id="addRegion">
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