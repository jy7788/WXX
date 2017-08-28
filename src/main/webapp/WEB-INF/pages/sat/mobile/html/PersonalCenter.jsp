<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	<title>个人中心</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/sat/assets/weui.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/sat/assets/jquery-weui.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/sat/assets/demos.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/sat/mobile/css/style.css">
<!-- 	<link rel="stylesheet" href="../../assets/weui.min.css">
	<link rel="stylesheet" href="../../assets/jquery-weui.css">
	<link rel="stylesheet" href="../../assets/demos.css">
	<link rel="stylesheet" href="../css/style.css"> -->
</head>
<body ontouchstart >
<input type="text" value="${visitorOpenid}" hidden="true" id="visitorOpenid"> 
<input type="text" value="${mUser.openid}" hidden="true" id="openid"> 
	<div class="sat_content PersonalCenter">
		<div class="header">
		    <div class="weui-row  head_t">
		      <div class="weui-col-100 tx_center touxiang_cc">
		         <div class="touxiang_c">
		             <img src="${mUser.imgUrl}">
		         </div>
		         <p class="myguanzhu1 myname">${mUser.username} </p>
		         <p class="myguanzhu2">${mUser.signature}</p>
		      </div>
		    </div>
		</div>
		<div class="weui-row head_b">
			<div class="weui-col-50 tx_center myguanzhu"><span>我的客户</span><b>888</b></div>
			<div class="weui-col-50 tx_center myguanzhu"><span>金币</span><b>808</b></div>
		</div>
		<div class="main">
		      <div class="bd ">
			      <div class="sat_grids">
					<a href="detail/${mUser.openid} " class="sat_grid ">
						<div class="weui_grid_icon">
							<img src="<%=request.getContextPath()%>/sat/mobile/img/gerenziliao-icon-24.png" width="83" alt="">
						</div>
						<p class="weui_grid_label">
							个人资料
						</p>
					</a>
					<a href="<%=request.getContextPath()%>/satarticle/listMyArticles/${mUser.openid}" class="sat_grid zuo_border">
						<div class="weui_grid_icon">
							<img src="<%=request.getContextPath()%>/sat/mobile/img/wenzhanguanli-icon-24-25.png" width="83" alt="">
						</div>
						<p class="weui_grid_label">
							我的微站
						</p>
					</a>
					<a href="javascript:getData()" class="sat_grid "> 
						<div class="weui_grid_icon" id="statisticsCenter">
							<img src="<%=request.getContextPath()%>/sat/mobile/img/shujutongji-icon-24-25-24.png" width="83" alt="">
						</div>
						<p class="weui_grid_label">
							统计数据
						</p>
					</a> 
					<a href="<%=request.getContextPath()%>/ad/list/${mUser.openid}" class="sat_grid zuo_border">
						<div class="weui_grid_icon">
							<img src="<%=request.getContextPath()%>/sat/mobile/img/tuiguang-icon-24-25-25.png" width="83" alt="">
						</div>
						<p class="weui_grid_label">
							广告签名
						</p>
					</a>
			      </div>
			   </div>
		</div>
		<div class="footer">
			<ul class="sat_footer_ul">
				<li class="sat_footer_li"><a href="<%=request.getContextPath()%>/satarticle/gotoNewsList" class=""><b class="sat_footer_b zixun"></b>资讯</a></li>
				<li class="sat_footer_li"><a href="<%=request.getContextPath()%>/product/list" class=""><b class="sat_footer_b chanpin"></b>产品</a></li>
				<li class="sat_footer_li"><a class="clicked"><b class="sat_footer_b user"></b>我的</a></li>
			</ul>
		</div>
	</div>

</body>
	<script src="<%=request.getContextPath()%>/sat/assets/fastclick.js"></script>
	<script src='<%=request.getContextPath()%>/sat/assets/jquery.min.js'></script>
	<script src='<%=request.getContextPath()%>/sat/assets/jquery-weui.min.js'></script>
	<script src='<%=request.getContextPath()%>/sat/mobile/js/rem.js'></script>
	<script src='<%=request.getContextPath()%>/js/base.js'></script>
	<script>
	var openid, visitorOpenid;
		$(document).ready(function () {
			openid = $("#openid").val();
		    visitorOpenid = $("#visitorOpenid").val();
		    //alert(openid+ "  " + visitorOpenid);
		});
	  $(function() {
	    FastClick.attach(document.body);
	  });
	  
	  function getData() {
		  var url = "/satarticle/statistics?openid=" + openid;
		  window.location = url;
	  }
	 <%--  $("#statisticsCenter").click(function() {
		  var url = "<%=request.getContextPath()%>/satarticle/statistics?openid=" + openid;
		  window.location = url;
	  }); --%>
	</script>
</html>