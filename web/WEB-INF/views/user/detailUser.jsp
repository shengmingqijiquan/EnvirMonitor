<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>查看用户详情</title>
<link href="./css/demo.css" type="text/css" rel="stylesheet" />
<link rel="stylesheet" href="./css/style.css" type="text/css" media="all" />
<script type="text/javascript" src="./script/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="./script/Validform_v5.3.2_min.js"></script>
</head>
<body>
	<table>
		<tr><td colspan="2" style="color:red">用户详情</td></tr>
		<tr><td>用户名</td><td><input type="text" datatype="" name="username" value="${user.name}" readonly="readonly"></td></tr>
		<!--密码-->
		<tr><td>密码</td><td><input type="text" name="password"  value="${user.password}" readonly="readonly" /></td></tr>
		<!--确认密码-->
		<tr><td>E-mail</td><td><input type="text" datatype="e" name="email" value="${user.email}" readonly="readonly" ></td></tr>
		<tr><td>电话</td><td><input type="text" name="tel" class="inputxt" value="${user.tel}" readonly="readonly" ></td></tr>
		<tr><td>姓名</td><td><input type="text" name="realname" value="${user.truename}" readonly="readonly" ></td></tr>
		<tr><td>部门</td><td><input type="text" name="department" value="${user.department}" readonly="readonly" ></td></tr>
		<tr><td>备注</td><td><input type="text" name="note" value="${user.note}" readonly="readonly" ></td></tr>
		<tr><td colspan="3" style="color:red">角色配置</td></tr>
		<tr><td colspan="3">区域角色</td></tr>
		<tr><td colspan="3">命令角色</td></tr>
	</table>
	
</body>
</html>