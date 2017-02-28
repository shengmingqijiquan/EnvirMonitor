<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2016/12/13
  Time: 18:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">


  <title>重金属监测系统 - 登录</title>
  <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
  <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

  <link rel="shortcut icon" href="favicon.ico"> <link href="${pageContext.request.contextPath}/css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">

  <link href="${pageContext.request.contextPath}/css/animate.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/css/style.min.css?v=4.0.0" rel="stylesheet"><base target="_blank">
  <!--[if lt IE 8]>
  <meta http-equiv="refresh" content="0;ie.html" />
  <![endif]-->
  <script>if(window.top !== window.self){ window.top.location = window.location;}</script>
</head>

<body class="gray-bg">

<div class="middle-box text-center loginscreen  animated fadeInDown">
  <div>
    <div>

      <h1 class="logo-name">H+</h1>

    </div>
    <h3>欢迎使用重金属监测系统</h3>

    <form class="m-t" role="form" action="${pageContext.request.contextPath}/login" method="post">
      <div class="form-group">
        <input type="*" class="form-control" placeholder="用户名" required="" name="username">
      </div>
      <div class="form-group">
        <input type="password" class="form-control" placeholder="密码" required="" name="password">
      </div>
      <button type="submit" class="btn btn-primary block full-width m-b">登 录</button>
      </p>

    </form>
  </div>
</div>
<script src="${pageContext.request.contextPath}/js/jquery-1.9.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js?v=3.3.5"></script>
<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
</body>

</html>
