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
	<input type="text" hidden="true" value="${openid }" id="openid">
	<div class="sat_content">
		<div class="header">
			<img src="<%=request.getContextPath()%>/sat/mobile/img/panner.PNG" alt="" style="width:100%;">
		</div>
		<div class="main" >
			<div class="weui_cell tongjiri">
				<div class="weui_cell_hd tongji_hd">周统计</div>
				<div class="weui_cell_bd tongjibd weui_cell_primary">
					<p>文章转载次数<span id="wShares"></span></p>
				</div>
				<div class="weui_cell_bd tongjibd weui_cell_primary">
					<p>文章查看次数<span id="wWatches"></span></p>
				</div>
				<div class="weui_cell_bd tongjibd weui_cell_primary">
					<p>广告点击量<span id="wAdClicks"></span></p>
				</div>
			</div>
			<div class="weui_cell tongjiri">
				<div class="weui_cell_hd tongji_hd">总统计</div>
				<div class="weui_cell_bd tongjibd weui_cell_primary">
					<p>文章转载次数<span id="tShares"></span></p>
				</div>
				<div class="weui_cell_bd tongjibd weui_cell_primary">
					<p>文章查看次数<span id="tWatches"></span></p>
				</div>
				<div class="weui_cell_bd tongjibd weui_cell_primary">
					<p>广告点击量<span id="tAdClicks"></span></p>
				</div>
			</div>
		</div>
		<div class="footer">
			<ul class="sat_footer_ul">
				<li class="sat_footer_li"><a href="<%=request.getContextPath()%>/satarticle/gotoNewsList" class=""><b class="sat_footer_b zixun"></b>资讯</a></li>
				<li class="sat_footer_li"><a class=""><b class="sat_footer_b chanpin"></b>产品</a></li>
				<li class="sat_footer_li"><a class="clicked"><b class="sat_footer_b user"></b>我的</a></li>
			</ul>
		</div>
	</div>

</body>
	<script src="<%=request.getContextPath()%>/sat/assets/fastclick.js"></script>
	<script src='<%=request.getContextPath()%>/sat/assets/jquery.min.js'></script>
	<script src='<%=request.getContextPath()%>/sat/assets/jquery-weui.min.js'></script>
	<script src="<%=request.getContextPath()%>/sat/assets/swiper.js"></script>
	<script src='<%=request.getContextPath()%>/sat/mobile/js/rem.js'></script>
	<script src='<%=request.getContextPath()%>/js/base.js'></script>
	<script>
		var openid ; 
		$(".header .swiper-container").swiper({
			loop: true,
			autoplay: 1000
		});
		$(document).ready(function () {
			openid = $("#openid").val();
			//alert(openid);
			getStatistics();
		}); 
		
		//获取统计数据
		function getStatistics() {
			if(!isNull(openid)) {
				var url = "<%=request.getContextPath()%>/statistics/getData";
				$.ajax({
					url : url,
					type : 'POST',
					dataType : 'json',
					async : true,
					data : {
						"openid" : openid
					},
					success : function(data) {
						//alert(data);
						if(data.indexOf("shares") > 0){
							obj = $.parseJSON(data);
							//alert(obj.shares + obj.watches + obj.adClicks);
							$("#wShares").html(obj.shares);
							$("#wWatches").html(obj.watches);
							$("#wAdClicks").html(obj.adClicks);
							$("#tShares").html(obj.shares);
							$("#tWatches").html(obj.watches);
							$("#tAdClicks").html(obj.adClicks);
							//alert(obj.shares);
							//DisplayNewsItems(sharelist, $("#articleListDisp"));
						} else if(data.indexOf("failed") > 0) {
							alert("获取失败");
						} else {
							alert("获取失败");
						}
					},
					error : function() {
						alert("网络连接异常");
					}
				});
			}
		} 
	</script>