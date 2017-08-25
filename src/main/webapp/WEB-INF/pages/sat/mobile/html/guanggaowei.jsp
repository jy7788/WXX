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
<body >
<input type="text" hidden="true" id="openid" value="${openid }">
	<div class="sat_content">
		<div class="main guanggao" >
			<!-- <p class="guanggao_p">已有签名<span>2</span>/<i>3</i></p>
			<div class="sat_zhuanzai">
				<p>不够用，想解锁更多签名格位？</p>
				<b>购买VIP</b>
			</div> -->
			<div class="sat_zhuanzai">
				<p>已有签名<span id="size">${size} </span>/<i>3</i></p>
				<b onclick="newAd()">+新建</b>
			</div>
			
			<div class="weui_panel_bd guanggaotu">
			
				<%-- <div class="weui_media_box weui_media_text">
					<h4 class="weui_media_title">
						<b>理财通发行推广</b><span>2017-01-29</span>
					</h4>
					<p class="weui_media_desc"><img src="<%=request.getContextPath()%>/sat/mobile/img/tupian.png" height="112" width="274" alt=""></p>
					<ul class="weui_media_info">
						<li class="">查看详情</li>
					</ul>
				</div>
				<div class="weui_media_box weui_media_text">
					<h4 class="weui_media_title">
						<b>保险产品推广</b><span>2017-03-29</span>
					</h4>
					<p class="weui_media_desc"><img src="<%=request.getContextPath()%>/sat/mobile/img/tupiantwo.png" height="112" width="274" alt=""></p>
					<ul class="weui_media_info">
						<li class="">查看详情</li>
					</ul>
				</div> --%>
				
				<c:forEach items="${adList}" var="ad">
					<div class="weui_media_box weui_media_text">
					<h4 class="weui_media_title">
						<b>${ad.name} </b><span>${ad.createTime }</span>
					</h4>
					<p class="weui_media_desc"><img src="${ad.imgUrl }" height="112" width="274" alt=""></p>
					<%-- <div onclick="gotoLink(${ad.linkUrl})"> --%>
					<a href="<%=request.getContextPath()%>/ad/detail/${ad.id }">
						<ul class="weui_media_info">
							<li class="">查看详情</li>
						</ul>
					</a>	
					<!-- </div> -->
				</div>
				
				</c:forEach>
			</div>
		</div>
	</div>

</body>
	<script src="<%=request.getContextPath()%>/sat/assets/fastclick.js"></script>
	<script src='<%=request.getContextPath()%>/sat/assets/jquery.min.js'></script>
	<script src='<%=request.getContextPath()%>/sat/assets/jquery-weui.min.js'></script>
	<script src="<%=request.getContextPath()%>/sat/assets/swiper.js"></script>
	<script src='<%=request.getContextPath()%>/sat/mobile/js/rem.js'></script>
	<script>
		$(".header .swiper-container").swiper({
			loop: true,
			autoplay: 1000
		});
		/* var size = ${size}; 
		var openid = ${ad.openid};
		alert(openid); */
		
		var openid = $("#openid").val();
		function gotoLink(link) {
			alert("aaa");
			alert(link);
		}
		
		function newAd() {
			if(size == 3) {
				alert("广告位已满,无法新建");
			} else {
				if(openid != null && openid != "") {
					window.location.href = "<%=request.getContextPath()%>/ad/gotoInsert/" + openid;
				}
			}
		}
	</script>