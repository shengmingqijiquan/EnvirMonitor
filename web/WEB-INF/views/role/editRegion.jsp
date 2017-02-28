<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改区域角色</title>
<%--<link href="${pageContext.request.contextPath}/css/demo.css" type="text/css" rel="stylesheet" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css" media="all" />--%>
<script type="text/javascript" src=${pageContext.request.contextPath}/script/jquery-1.9.1.min.js"></script>
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
	<form action="updateCommand" method="post" class="registerform">
		<table align="center">
			<tr align="center"><td>角色名</td><td><input type="text" datatype="*" nullmsg="请输入用户名！" name="roleName" value="${role.roleName}"></td><td>*</td></tr>

			<tr>
				<td><input type="hidden" name="id" value="${role.id}"></td>
			</tr>
			<tr>
				<td><input type="hidden" name="type" value="command"></td>
			</tr>
			<tr><td><input type="submit" value="修改"></td><td>&nbsp;&nbsp;<input type="reset" value="取消" onclick="javascript:window.close()"></td></tr>
		</table>
	</form>

</body>
</html>