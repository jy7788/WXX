<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=320.1,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no">
<link rel="stylesheet"
	href="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.css">
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.js"></script>
<script src="http://res.wx.qq.com/open/js/jweixin-1.1.0.js">
	
</script>
<script type="text/javascript">
$(document).ready(function() {
	$('#openButton').click(function (event) {
		alert("open");
		$.get("deviceOper", { operation : "open"},
		  function(data){
		    alert("Data Loaded: " + data);
		});
	});
	
	$('#closeButton').click(function (event) {
		alert("close");
		$.get("deviceOper", { operation : "close"},
		  function(data){
		    alert("Data Loaded: " + data);
		});
	});
</script>

<!-- <script type="text/javascript" src="js/blue/blue.js"></script> -->
<script
	src="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.js"></script>
</head>
<body>
	<!--标题行-->
	<div>
		<button onclick="" name="" id="openButton">开灯</button>
		<button onclick="" name="" id="closeButton">关灯</button>
	</div>
</body>
</html>
