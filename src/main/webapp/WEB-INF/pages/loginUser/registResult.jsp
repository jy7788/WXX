<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width,07.initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" />
<link rel="stylesheet"
	href="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.css">
<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
<script src="//cdn.bootcss.com/jquery-validate/1.16.0/additional-methods.js"></script>
<script
	src="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.js"></script>
</head>
<body>

	<div data-role="page" id="page1">
		<!--  page  -->

		<div data-role="header">
			<h1>五本书院</h1>
		</div>
		<!-- 頁眉 End  -->
		<br />
		<div >
			<h1>院士申请</h1>
		</div>
		<div data-role="fieldcontain">
		
			尊敬的    ${fiveBookUser.nickname }:</br>
			恭喜您成为五本书院士
			<img width="120" src="${fiveBookUser.imgUrl }"/></br>
			院士身份:&nbsp;&nbsp;    ${fiveBookUser.username }</br>
			昵称:&nbsp;&nbsp;    ${fiveBookUser.nickname }</br>
			密码:&nbsp;&nbsp;    ${fiveBookUser.password }</br>
			性别:&nbsp;&nbsp;    ${fiveBookUser.sex }</br>
			地域: &nbsp;&nbsp;   ${fiveBookUser.area }</br>
			手机号:&nbsp;&nbsp;    ${fiveBookUser.phoneNum }</br>
			安全邮箱:&nbsp;&nbsp;    ${fiveBookUser.email }</br>
			出生日期:&nbsp;&nbsp;    ${fiveBookUser.birthday }</br>
			
		</div>
		<br /> 

		<div data-role="footer" class="ui-btn">
			<div data-role="controlgroup" data-type="horizontal">
				<a href="login.jsp" data-role="button">院士登录</a> 
				<a href="regisit.jsp" data-corners="false" data-role="button">院外访客</a>
			</div>
		</div>
		</div>
		<!--page end -->
</body>
</html>
