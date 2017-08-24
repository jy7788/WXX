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
	<div class="sat_content">
		
		<div class="sat_data guanggaoxq">
			<div class="sat_zhuanzai">
				<p>已有签名<span>2</span>/<i>3</i></p>
				<b onclick="setEdit()" id="editButton" >编辑</b>
			</div>
			<div class="weui_cell">
				<div class="weui_cell_hd"><label class="weui_label">名称</label></div>
				<div class="weui_cell_bd weui_cell_primary">
					<input class="weui_input" type="text" placeholder="姓名" value="${ad.name }" readonly>
				</div>
			</div>
			<div class="weui_cell ">
				<div class="weui_cell_hd"><label for="name" class="weui_label">描述</label></div>
				<div class="weui_cell_bd weui_cell_primary article_cell">
					<textarea class="weui_textarea" placeholder="请输入文章标题最多不超过50个字" readonly rows="5">${ad.description }</textarea>
					<div class="weui_textarea_counter"><span>120</span>/300</div>
				</div>
			</div>
			<div class="weui_uploader">
				<div class="weui_uploader_hd weui_cell">
					<div class="weui_cell_bd">图片</div>
				</div>
				<div class="weui_uploader_bd">
					<img src="${ad.imgUrl }" height="112" width="274" alt="">
					<div class="weui_uploader_input_wrp">
						<input class="weui_uploader_input" type="file" accept="image/*" multiple="" readonly>
					</div>
				</div>
			</div>
			<div class="weui_cell nobef">
				<div class="weui_cell_hd"><label class="weui_label">链接</label></div>
				<div class="weui_cell_bd weui_cell_primary">
					<input class="weui_input" type="tel" placeholder="手机号" value="${ad.linkUrl }" readonly>
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
		
		function setEdit() {
			//$("#editButton").val("保存");
			alert("aaa");
		}
	</script>	
</html>