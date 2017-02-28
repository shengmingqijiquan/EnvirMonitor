<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加区域角色</title>
<%--<link href="${pageContext.request.contextPath}/css/demo.css" type="text/css" rel="stylesheet" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css" media="all" />--%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/js/mywidget/widgets/themes/darkangel/darkangel.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/js/mywidget/widgets/themes/darkangel/override.css" />
	<script type="text/javascript">
        $(function(){
            $(".registerform").Validform({
                tiptype:2,
                ajaxPost:true
            });
        });
	</script>
</head>
<body style="background-color:#ffffff">
<form action="insertRegion" method="post" class="registerform">
	<table align="center">
		<tr><td colspan="3" style="color:red">基本信息</td></tr>
		<tr align="center"><td>角色名</td><td><input type="text" datatype="*" nullmsg="请输入用户名！" name="name"></td><td>*</td></tr>
		<tr><td></td><td><input type="submit" value="添加"></td><td><input type="reset" value="取消" onclick="javascript:window.close()"></td></tr>
	</table>
</form>	
</body>
</html>