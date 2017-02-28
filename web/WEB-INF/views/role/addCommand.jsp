<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.xiangtan.ws.impl.RoleLvWSImplService" %>
<%@ page import="com.xiangtan.ws.RoleLvWS" %>
<%@ page import="com.xiangtan.ws.RoleLv" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加命令角色</title>
<link href="${pageContext.request.contextPath}/css/demo.css" type="text/css" rel="stylesheet" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css" media="all" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/js/mywidget/widgets/themes/darkangel/darkangel.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/js/mywidget/widgets/themes/darkangel/override.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/script/Validform_v5.3.2_min.js"></script>
<script type="text/javascript">
 	$(function(){
    	$(".registerform").Validform({
        	tiptype:2,
            ajaxPost:true
        });
    });
</script>
</head>
<body style="background-color:#ffffff;align:center">
<form action="insertCommand" method="post" class="registerform">
	<table align="center">
		<tr align="center"><td>角色名</td><td><input type="text" datatype="*" nullmsg="请输入用户名！" name="name"></td><td>*</td></tr>
		<tr align="center">
			<td>农田环境采样点</td>
			<td>
				<input type="checkbox" name="command" value="ADD_SAMPLES">添加&nbsp;&nbsp;
				<input type="checkbox" name="command" value="DELETE_SAMPLES">删除&nbsp;&nbsp;
				<input type="checkbox" name="command" value="UPDATE_SAMPLES">修改&nbsp;&nbsp;
				<input type="checkbox" name="command" value="VIEW_SAMPLES">查看
			</td>
		</tr>
		<tr>
			<td>农产品质量监测结果</td>
			<td>
				<input type="checkbox" name="command" value="ADD_RESIDUE">添加&nbsp;&nbsp;
				<input type="checkbox" name="command" value="DELETE_RESIDUE">删除&nbsp;&nbsp;
				<input type="checkbox" name="command" value="UPDATE_RESIDUE">修改&nbsp;&nbsp;
				<input type="checkbox" name="command" value="VIEW_RESIDUE">查看
			</td>
		</tr>
		<tr>
			<td>基地信息</td>
			<td>
				<input type="checkbox" name="command" value="ADD_BASES">添加&nbsp;&nbsp;
				<input type="checkbox" name="command" value="DELETE_BASES">删除&nbsp;&nbsp;
				<input type="checkbox" name="command" value="UPDATE_BASES">修改&nbsp;&nbsp;
				<input type="checkbox" name="command" value="VIEW_BASES">查看
			</td>
		</tr>
		<tr>
			<td>地块信息</td>
			<td>
				<input type="checkbox" name="command" value="ADD_PLOTS">添加&nbsp;&nbsp;
				<input type="checkbox" name="command" value="DELETE_PLOTS">删除&nbsp;&nbsp;
				<input type="checkbox" name="command" value="UPDATE_PLOTS">修改&nbsp;&nbsp;
				<input type="checkbox" name="command" value="VIEW_PLOTS">查看
			</td>
		</tr>
		<tr>
			<td>生产组长信息</td>
			<td>
				<input type="checkbox" name="command" value="ADD_CHARGEMEN">添加&nbsp;&nbsp;
				<input type="checkbox" name="command" value="DELETE_CHARGEMEN">删除&nbsp;&nbsp;
				<input type="checkbox" name="command" value="UPDATE_CHARGEMEN">修改&nbsp;&nbsp;
				<input type="checkbox" name="command" value="VIEW_CHARGEMEN">查看
			</td>
		</tr>
		<tr>
			<td>种植履历信息</td>
			<td>
				<input type="checkbox" name="command" value="ADD_RECORDS">添加&nbsp;&nbsp;
				<input type="checkbox" name="command" value="DELETE_RECORDS">删除&nbsp;&nbsp;
				<input type="checkbox" name="command" value="UPDATE_RECORDS">修改&nbsp;&nbsp;
				<input type="checkbox" name="command" value="VIEW_RECORDS">查看
			</td>
		</tr>
		<tr>
			<td>农作物信息</td>
			<td>
				<input type="checkbox" name="command" value="ADD_CROPS">添加&nbsp;&nbsp;
				<input type="checkbox" name="command" value="DELETE_CROPS">删除&nbsp;&nbsp;
				<input type="checkbox" name="command" value="UPDATE_CROPS">修改&nbsp;&nbsp;
				<input type="checkbox" name="command" value="VIEW_CROPS">查看
			</td>
		</tr>
		<tr>
			<td>用户信息</td>
			<td>
				<input type="checkbox" name="command" value="ADD_USER">添加&nbsp;&nbsp;
				<input type="checkbox" name="command" value="DELETE_USER">删除&nbsp;&nbsp;
				<input type="checkbox" name="command" value="UPDATE_USER">修改&nbsp;&nbsp;
				<input type="checkbox" name="command" value="VIEW_USER">查看
			</td>
		</tr>
		<tr>
			<td>用户组信息</td>
			<td>
				<input type="checkbox" name="command" value="ADD_USERGROUP">添加&nbsp;&nbsp;
				<input type="checkbox" name="command" value="DELETE_USERGROUP">删除&nbsp;&nbsp;
				<input type="checkbox" name="command" value="UPDATE_USERGROUP">修改&nbsp;&nbsp;
				<input type="checkbox" name="command" value="VIEW_USERGROUP">查看
			</td>
		</tr>
		<tr>
			<td>角色信息</td>
			<td>
				<input type="checkbox" name="command" value="ADD_ROLE">添加&nbsp;&nbsp;
				<input type="checkbox" name="command" value="DELETE_ROLE">删除&nbsp;&nbsp;
				<input type="checkbox" name="command" value="UPDATE_ROLE">修改&nbsp;&nbsp;
				<input type="checkbox" name="command" value="VIEW_ROLE">查看
			</td>
		</tr>
		<tr>
			<td>信息统计分析</td>
			<td>
				<input type="checkbox" name="command" value="PRODUCT_STATISTICS">允许&nbsp;&nbsp;
			</td>
		</tr>
		<tr>
			<td>农产品质量统计分析</td>
			<td>
				<input type="checkbox" name="command" value="QUALITY_STATISTICS">允许&nbsp;&nbsp;
			</td>
		</tr>
		<tr>
			<td>产地环境质量统计分析</td>
			<td>
				<input type="checkbox" name="command" value="ENV_STATISTICS">允许&nbsp;&nbsp;
			</td>
		</tr>
		<tr><td><input type="submit" value="添加"></td><td>&nbsp;&nbsp;<input type="reset" value="取消" onclick="javascript:window.close()"></td></tr>
	</table>
</form>	
</body>
</html>