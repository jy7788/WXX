<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width,07.initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" />
<link rel="stylesheet"
	href="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.css">
<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
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
		<form method="post" action="demoform.asp">
		  <fieldset data-role="controlgroup" data-type="horizontal">
	      <legend>性别：</legend>
	        <label for="male">男</label>
	        <input type="radio" name="gender" id="male" value="male">
	        <label for="female">女</label>
	        <input type="radio" name="gender" id="female" value="female">	
	      </fieldset>
	      <br/>
			<label for="label_account">申请账号</label>
	        <input type="text" name="account" id="account" placeholder="">
	        <br/>
	        <label for="label_nickname">昵称</label>
	        <input type="text" name="nickname" id="nickname" placeholder="最长不超过8个汉字">
	        <br/>
	        <label for="label_email">安全邮箱</label>
	        <input type="text" name="email" id="email" >
	        <br/>
	        <label for="label_phone_num">手机号码</label>
	        <input type="text" name="phone_num" id="phone_num" >
	        <br/>
	        <label for="label_birthday">出生日期</label>
	        <input type="date" name="birthday" id="birthday" >
	        <br/>
	        <label for="label_password">密码</label>
	        <input type="password" name="password" id="password" placeholder="输入8至32位密码">
	        <br/>
	        <label for="label_birthday">确认密码</label>
	        <input type="password" name="confirm_password" id="confirm_password" placeholder="重复输入密码予确认">
	        <br/>
	        <input type="submit" data-inline="true" value="申请">
	        
	        </form>
		</div>
		<br />

		<div data-role="footer" class="ui-btn">
			<div data-role="controlgroup" data-type="horizontal">
				<a href="user_login.jsp" data-role="button">院士登录</a> 
				<a href="regisit.html" data-corners="false" data-role="button">院外访客</a>
			</div>
		</div>
		</div>
		<!--page end -->
</body>
</html>
