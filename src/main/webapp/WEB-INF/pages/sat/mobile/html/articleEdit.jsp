<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=320,maximum-scale=1.3,user-scalable=no">
	<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
	<!--禁止ios设备将数字作为拨号连接，邮箱自动发送，点击地图跳转-->
	<meta name="format-detection" content="telephone=no,email=no,adress=no">
	<!--强制全屏显示-->
	<meta name="full-screen" content="yes">
	<!--开启对webapp的支持-->
	<meta name="apple-mobile-web-app-capable" content="yes">
	<!--web app应用下状态条(屏幕顶部条)的颜色,默认值为default(白色)-->
	<meta name="apple-mobile-web-app-status-bar-style" content="black-translucent">
	<!--禁止浏览器从缓存中访问页面内容-->
	<meta http-equiv="Pragma" content="no-cache">
	<meta name="format-detection" content="telephone=no"/>
	<meta name="format-detection" content="email=no"/>
	<title>SAT</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/sat/assets/weui.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/sat/assets/jquery-weui.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/sat/assets/demos.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/sat/mobile/css/style.css">
</head>
<body>
	<div class="sat_content gray">
		<div class="data_header pad">
			<div class="weui_cell nobef">
				<div class="weui_cell_bd weui_cell_primary article_cell">
					<textarea class="weui_textarea" placeholder="请输入文章标题最多不超过50个字" rows="3"></textarea>
					<div class="weui_textarea_counter"><span>0</span>/50</div>
				</div>
			</div>
			<div class="weui_cell nobef">
				<div class="weui_cell_bd weui_cell_primary article_cell">
					<textarea class="weui_textarea" placeholder="请输入文章内容" rows="13"></textarea>
				</div>
			</div>
		</div>
		<div class="data_footer">
			<div class="wenzhang_foot weui_cell">
				<div class="weui_cell_bd weui_cell_primary">
					<a><img src="<%=request.getContextPath()%>/sat/mobile/img/mingpian-dianhua-icon.png" width="34" alt=""></a>
					<a><img src="<%=request.getContextPath()%>/sat/mobile/img/mingpian-tianjiaguanzhu-icon.png" width="34" alt=""></a>
					<a><img src="<%=request.getContextPath()%>/sat/mobile/img/mingpian-weixin-icon.png" width="34" alt=""></a>
				</div>
				<div class="weui_cell_ft wenzhang_table">				
					<p class="wenzhang_p"><span class="bg"></span><b class="yu">预览</b></p>
					
				</div>
				<div class="weui_cell_ft wenzhang_table none">
					<p class="wenzhang_p"><span class="bianji">编辑</span><span>发布</span></p>
				</div>
			</div>
		</div>
			
	</div>
</body>
	<script src="<%=request.getContextPath()%>/sat/assets/fastclick.js"></script>
	<script src='<%=request.getContextPath()%>/sat/assets/jquery.min.js'></script>
	<script src='<%=request.getContextPath()%>/sat/assets/jquery-weui.min.js'></script>
	<script src='<%=request.getContextPath()%>/sat/mobile/js/rem.js'></script>
	<script>
		$(function() {
			FastClick.attach(document.body);
		});
		$("#dianzan").click(function(){
			$(this).find("i").show().animate({
				"top": "-14px"
			});
		});
		$(".bianji").click(function(){
			$(this).parents(".wenzhang_table").hide().siblings().show();
		})
		$(".yu").click(function(){
			$(this).parents(".wenzhang_table").hide().siblings().show();
		})
	</script>
</html>