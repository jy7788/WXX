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
			<!-- header 頁眉 -->
			<!-- <a href="#" data-role="button" data-icon="home">首页</a> -->
			<h1>五本书院</h1>
			<!-- <a href="#" data-role="button" class="ui-btn-right" data-icon="search">搜索</a> -->
		</div>
		<!-- 頁眉 End  -->
	
		<br />
		
		
		<div >
			<h1>院士回家</h1>
		</div>
		<div data-role="fieldcontain">

			<label for="textinput1"> 用戶名： </label> <input id="textinput1"
				placeholder="" value="" type="text" /> <br /> <label
				for="textinput2"> 密 碼： </label> <input id="textinput2"
				placeholder="" value="" type="Password" />

		</div>
		<br />
		<div data-role="fieldcontain">
			<div data-role="controlgroup" data-type="vertical">
				<a href="index.html" data-role="button">登 录</a> <a
					href="regisit.html" data-corners="false" data-role="button">注 册</a>

			</div>
		</div>

		<div data-role="footer">
			<div data-role="controlgroup" data-type="horizontal">
				<a href="index.jsp" data-role="button">院士申请</a> 
				<a href="regisit.html" data-corners="false" data-role="button">院外访客</a>

			</div>
		</div>
		<!--page end -->
</body>
</html>
