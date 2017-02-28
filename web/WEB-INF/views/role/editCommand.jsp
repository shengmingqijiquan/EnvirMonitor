<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改角色</title>
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
	<form action="updateCommand" method="post" class="registerform">
		<table align="center">
			<tr align="center"><td>角色名</td><td><input type="text" datatype="*" nullmsg="请输入用户名！" name="roleName" value="${role.roleName}"></td><td>*</td></tr>
			<tr align="center">
				<td>农田环境采样点</td>
				<td>
					<input type="checkbox" name="command" value="ADD_SAMPLES" <c:if test='${role.desText.indexOf("ADD_SAMPLES")>=0}'>  checked="checked" </c:if> >添加&nbsp;&nbsp;
					<input type="checkbox" name="command" value="DELETE_SAMPLES" <c:if test='${role.desText.indexOf("DELETE_SAMPLES")>=0}'>  checked="checked" </c:if>>删除&nbsp;&nbsp;
					<input type="checkbox" name="command" value="UPDATE_SAMPLES" <c:if test='${role.desText.indexOf("UPDATE_SAMPLES")>=0}'>  checked="checked" </c:if>>修改&nbsp;&nbsp;
					<input type="checkbox" name="command" value="VIEW_SAMPLES" <c:if test='${role.desText.indexOf("VIEW_SAMPLES")>=0}'>  checked="checked" </c:if>>查看
				</td>
			</tr>
			<tr>
				<td>农产品质量监测结果</td>
				<td>
					<input type="checkbox" name="command" value="ADD_RESIDUE" <c:if test='${role.desText.indexOf("ADD_RESIDUE")>=0}'>  checked="checked" </c:if> >添加&nbsp;&nbsp;
					<input type="checkbox" name="command" value="DELETE_RESIDUE" <c:if test='${role.desText.indexOf("DELETE_RESIDUE")>=0}'>  checked="checked" </c:if> >删除&nbsp;&nbsp;
					<input type="checkbox" name="command" value="UPDATE_RESIDUE" <c:if test='${role.desText.indexOf("UPDATE_RESIDUE")>=0}'>  checked="checked" </c:if> >修改&nbsp;&nbsp;
					<input type="checkbox" name="command" value="VIEW_RESIDUE" <c:if test='${role.desText.indexOf("VIEW_RESIDUE")>=0}'>  checked="checked" </c:if> >查看
				</td>
			</tr>
			<tr>
				<td>基地信息</td>
				<td>
					<input type="checkbox" name="command" value="ADD_BASES" <c:if test='${role.desText.indexOf("ADD_BASES")>=0}'>  checked="checked" </c:if> >添加&nbsp;&nbsp;
					<input type="checkbox" name="command" value="DELETE_BASES" <c:if test='${role.desText.indexOf("DELETE_BASES")>=0}'>  checked="checked" </c:if> >删除&nbsp;&nbsp;
					<input type="checkbox" name="command" value="UPDATE_BASES" <c:if test='${role.desText.indexOf("UPDATE_BASES")>=0}'>  checked="checked" </c:if> >修改&nbsp;&nbsp;
					<input type="checkbox" name="command" value="VIEW_BASES" <c:if test='${role.desText.indexOf("VIEW_BASES")>=0}'>  checked="checked" </c:if> >查看
				</td>
			</tr>
			<tr>
				<td>地块信息</td>
				<td>
					<input type="checkbox" name="command" value="ADD_PLOTS" <c:if test='${role.desText.indexOf("ADD_PLOTS")>=0}'>  checked="checked" </c:if> >添加&nbsp;&nbsp;
					<input type="checkbox" name="command" value="DELETE_PLOTS" <c:if test='${role.desText.indexOf("DELETE_PLOTS")>=0}'>  checked="checked" </c:if> >删除&nbsp;&nbsp;
					<input type="checkbox" name="command" value="UPDATE_PLOTS" <c:if test='${role.desText.indexOf("UPDATE_PLOTS")>=0}'>  checked="checked" </c:if> >修改&nbsp;&nbsp;
					<input type="checkbox" name="command" value="VIEW_PLOTS" <c:if test='${role.desText.indexOf("VIEW_PLOTS")>=0}'>  checked="checked" </c:if> >查看
				</td>
			</tr>
			<tr>
				<td>生产组长信息</td>
				<td>
					<input type="checkbox" name="command" value="ADD_CHARGEMEN" <c:if test='${role.desText.indexOf("ADD_CHARGEMEN")>=0}'>  checked="checked" </c:if> >添加&nbsp;&nbsp;
					<input type="checkbox" name="command" value="DELETE_CHARGEMEN" <c:if test='${role.desText.indexOf("DELETE_CHARGEMEN")>=0}'>  checked="checked" </c:if> >删除&nbsp;&nbsp;
					<input type="checkbox" name="command" value="UPDATE_CHARGEMEN" <c:if test='${role.desText.indexOf("UPDATE_CHARGEMEN")>=0}'>  checked="checked" </c:if> >修改&nbsp;&nbsp;
					<input type="checkbox" name="command" value="VIEW_CHARGEMEN" <c:if test='${role.desText.indexOf("VIEW_CHARGEMEN")>=0}'>  checked="checked" </c:if> >查看
				</td>
			</tr>
			<tr>
				<td>种植履历信息</td>
				<td>
					<input type="checkbox" name="command" value="ADD_RECORDS" <c:if test='${role.desText.indexOf("ADD_RECORDS")>=0}'>  checked="checked" </c:if> >添加&nbsp;&nbsp;
					<input type="checkbox" name="command" value="DELETE_RECORDS" <c:if test='${role.desText.indexOf("DELETE_RECORDS")>=0}'>  checked="checked" </c:if> >删除&nbsp;&nbsp;
					<input type="checkbox" name="command" value="UPDATE_RECORDS" <c:if test='${role.desText.indexOf("UPDATE_RECORDS")>=0}'>  checked="checked" </c:if> >修改&nbsp;&nbsp;
					<input type="checkbox" name="command" value="VIEW_RECORDS" <c:if test='${role.desText.indexOf("VIEW_RECORDS")>=0}'>  checked="checked" </c:if> >查看
				</td>
			</tr>
			<tr>
				<td>农作物信息</td>
				<td>
					<input type="checkbox" name="command" value="ADD_CROPS" <c:if test='${role.desText.indexOf("ADD_CROPS")>=0}'>  checked="checked" </c:if> >添加&nbsp;&nbsp;
					<input type="checkbox" name="command" value="DELETE_CROPS" <c:if test='${role.desText.indexOf("DELETE_CROPS")>=0}'>  checked="checked" </c:if> >删除&nbsp;&nbsp;
					<input type="checkbox" name="command" value="UPDATE_CROPS" <c:if test='${role.desText.indexOf("UPDATE_CROPS")>=0}'>  checked="checked" </c:if> >修改&nbsp;&nbsp;
					<input type="checkbox" name="command" value="VIEW_CROPS" <c:if test='${role.desText.indexOf("VIEW_CROPS")>=0}'>  checked="checked" </c:if> >查看
				</td>
			</tr>
			<tr>
				<td>用户信息</td>
				<td>
					<input type="checkbox" name="command" value="ADD_USER" <c:if test='${role.desText.indexOf("ADD_USER")>=0}'>  checked="checked" </c:if> >添加&nbsp;&nbsp;
					<input type="checkbox" name="command" value="DELETE_USER" <c:if test='${role.desText.indexOf("DELETE_USER")>=0}'>  checked="checked" </c:if> >删除&nbsp;&nbsp;
					<input type="checkbox" name="command" value="UPDATE_USER"<c:if test='${role.desText.indexOf("UPDATE_USER")>=0}'>  checked="checked" </c:if> >修改&nbsp;&nbsp;
					<input type="checkbox" name="command" value="VIEW_USER" <c:if test='${role.desText.indexOf("VIEW_USER")>=0}'>  checked="checked" </c:if> >查看
				</td>
			</tr>
			<tr>
				<td>用户组信息</td>
				<td>
					<input type="checkbox" name="command" value="ADD_USERGROUP" <c:if test='${role.desText.indexOf("ADD_USERGROUP")>=0}'>  checked="checked" </c:if> >添加&nbsp;&nbsp;
					<input type="checkbox" name="command" value="DELETE_USERGROUP" <c:if test='${role.desText.indexOf("DELETE_USERGROUP")>=0}'>  checked="checked" </c:if> >删除&nbsp;&nbsp;
					<input type="checkbox" name="command" value="UPDATE_USERGROUP"<c:if test='${role.desText.indexOf("UPDATE_USERGROUP")>=0}'>  checked="checked" </c:if> >修改&nbsp;&nbsp;
					<input type="checkbox" name="command" value="VIEW_USERGROUP" <c:if test='${role.desText.indexOf("VIEW_USERGROUP")>=0}'>  checked="checked" </c:if> >查看
				</td>
			</tr>
			<tr>
				<td>角色信息</td>
				<td>
					<input type="checkbox" name="command" value="ADD_ROLE" <c:if test='${role.desText.indexOf("ADD_ROLE")>=0}'>  checked="checked" </c:if> >添加&nbsp;&nbsp;
					<input type="checkbox" name="command" value="DELETE_ROLE" <c:if test='${role.desText.indexOf("DELETE_ROLE")>=0}'>  checked="checked" </c:if> >删除&nbsp;&nbsp;
					<input type="checkbox" name="command" value="UPDATE_ROLE" <c:if test='${role.desText.indexOf("UPDATE_ROLE")>=0}'>  checked="checked" </c:if> >修改&nbsp;&nbsp;
					<input type="checkbox" name="command" value="VIEW_ROLE" <c:if test='${role.desText.indexOf("VIEW_ROLE")>=0}'>  checked="checked" </c:if> >查看
				</td>
			</tr>
			<tr>
				<td>信息统计分析</td>
				<td>
					<input type="checkbox" name="command" value="PRODUCT_STATISTICS" <c:if test='${role.desText.indexOf("PRODUCT_STATISTICS")>=0}'>  checked="checked" </c:if> >允许&nbsp;&nbsp;
				</td>
			</tr>
			<tr>
				<td>农产品质量统计分析</td>
				<td>
					<input type="checkbox" name="command" value="QUALITY_STATISTICS" <c:if test='${role.desText.indexOf("QUALITY_STATISTICS")>=0}'>  checked="checked" </c:if> >允许&nbsp;&nbsp;
				</td>
			</tr>
			<tr>
				<td>产地环境质量统计分析</td>
				<td>
					<input type="checkbox" name="command" value="ENV_STATISTICS" <c:if test='${role.desText.indexOf("ENV_STATISTICS")>=0}'>  checked="checked" </c:if> >允许&nbsp;&nbsp;
				</td>
			</tr>
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