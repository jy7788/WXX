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
	<title>新闻中心</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/sat/assets/weui.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/sat/assets/jquery-weui.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/sat/assets/demos.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/sat/mobile/css/style.css">
</head>
<body >
	<div class="sat_content">
		<div class="header">
			<div class="swiper-container">
				<!-- Additional required wrapper -->
				<div class="swiper-wrapper">
				<!-- Slides -->
					<div class="swiper-slide"><img src="<%=request.getContextPath()%>/sat/mobile/img/banner-06.png" class="slide_img"/></div>
					<div class="swiper-slide"><img src="<%=request.getContextPath()%>/sat/mobile/img/banner-06.png" class="slide_img"/></div>
					<div class="swiper-slide"><img src="<%=request.getContextPath()%>/sat/mobile/img/banner-06.png" class="slide_img"/></div>
				</div>
				<!-- If we need pagination -->
				<div class="swiper-pagination"></div>
			</div>
		</div>
		<div class="nav">
				<a class="sat_nav click">
					<div class="main_swiper_list"><span>本周头条</span></div>
				</a>
				<a class="sat_nav">
					<div class="main_swiper_list"><span>最新上线</span></div>
				</a>
				<a class="sat_nav">
					<div class="main_swiper_list"><span>推荐关注<i>+</i></span></div>
				</a>
		</div>
		<div class="main" >
			<div class="weui_tab">
				<div class="weui_panel_bd" id="div_this_week">
					<%-- <a href="javascript:;" class="weui_media_box weui_media_appmsg">
						<div class="weui_media_hd">
							<img class="weui_media_appmsg_thumb" src="<%=request.getContextPath()%>/sat/mobile/img/xinwentupian-img.png" alt="">
						</div>
						<div class="weui_media_bd">
							<p class="weui_media_desc">由各种物质组成的巨型球状天体，叫做星球。星球有一定的形状，有自己的运行轨道。</p>
							<p class="zuozhe">毒蛇姐原创<b class="zhuanfa">转发18</b></p>
						</div>
					</a> --%>
					
					<c:forEach items="${articleList}" var="satArticle">
						<a href="detail/${satArticle.id} " class="weui_media_box weui_media_appmsg">
						<div class="weui_media_hd">
							<img class="weui_media_appmsg_thumb" src="${satArticle.descImgUrl} " alt="">
						</div>
						<div class="weui_media_bd">
							<p class="weui_media_desc">${satArticle.title} </p>
							<p class="zuozhe">${satArticle.openid} <b class="zhuanfa">转发${satArticle.shares }</b></p>
						</div>
						</a>
					</c:forEach>
					
					<%-- <a href="javascript:;" class="weui_media_box weui_media_appmsg">
						<div class="weui_media_hd">
							<img class="weui_media_appmsg_thumb" src="<%=request.getContextPath()%>/sat/mobile/img/xinwentupian-img.png" alt="">
						</div>
						<div class="weui_media_bd">
							<p class="weui_media_desc">由各种物质组成的巨型球状天体，叫做星球。星球有一定的形状，有自己的运行轨道。</p>
							<p class="zuozhe">毒蛇姐原创<b class="zhuanfa">转发18</b></p>
						</div>
					</a>
					<a href="javascript:;" class="weui_media_box weui_media_appmsg">
						<div class="weui_media_hd">
							<img class="weui_media_appmsg_thumb" src="<%=request.getContextPath()%>/sat/mobile/img/xinwentupian-img.png" alt="">
						</div>
						<div class="weui_media_bd">
							<p class="weui_media_desc">由各种物质组成的巨型球状天体，叫做星球。星球有一定的形状，有自己的运行轨道。</p>
							<p class="zuozhe">毒蛇姐原创<b class="zhuanfa">转发18</b></p>
						</div>
					</a><a href="javascript:;" class="weui_media_box weui_media_appmsg">
						<div class="weui_media_hd">
							<img class="weui_media_appmsg_thumb" src="<%=request.getContextPath()%>/sat/mobile/img/xinwentupian-img.png" alt="">
						</div>
						<div class="weui_media_bd">
							<p class="weui_media_desc">由各种物质组成的巨型球状天体，叫做星球。星球有一定的形状，有自己的运行轨道。</p>
							<p class="zuozhe">毒蛇姐原创<b class="zhuanfa">转发18</b></p>
						</div>
					</a>
					<a href="javascript:;" class="weui_media_box weui_media_appmsg">
						<div class="weui_media_hd">
							<img class="weui_media_appmsg_thumb" src="<%=request.getContextPath()%>/sat/mobile/img/xinwentupian-img.png" alt="">
						</div>
						<div class="weui_media_bd">
							<p class="weui_media_desc">由各种物质组成的巨型球状天体，叫做星球。星球有一定的形状，有自己的运行轨道。</p>
							<p class="zuozhe">毒蛇姐原创<b class="zhuanfa">转发18</b></p>
						</div>
					</a>
					<a href="javascript:;" class="weui_media_box weui_media_appmsg">
						<div class="weui_media_hd">
							<img class="weui_media_appmsg_thumb" src="<%=request.getContextPath()%>/sat/mobile/img/xinwentupian-img.png" alt="">
						</div>
						<div class="weui_media_bd">
							<p class="weui_media_desc">由各种物质组成的巨型球状天体，叫做星球。星球有一定的形状，有自己的运行轨道。</p>
							<p class="zuozhe">毒蛇姐原创<b class="zhuanfa">转发18</b></p>
						</div>
					</a><a href="javascript:;" class="weui_media_box weui_media_appmsg">
						<div class="weui_media_hd">
							<img class="weui_media_appmsg_thumb" src="<%=request.getContextPath()%>/sat/mobile/img/xinwentupian-img.png" alt="">
						</div>
						<div class="weui_media_bd">
							<p class="weui_media_desc">由各种物质组成的巨型球状天体，叫做星球。星球有一定的形状，有自己的运行轨道。</p>
							<p class="zuozhe">毒蛇姐原创<b class="zhuanfa">转发18</b></p>
						</div>
					</a>
					<a href="javascript:;" class="weui_media_box weui_media_appmsg">
						<div class="weui_media_hd">
							<img class="weui_media_appmsg_thumb" src="<%=request.getContextPath()%>/sat/mobile/img/xinwentupian-img.png" alt="">
						</div>
						<div class="weui_media_bd">
							<p class="weui_media_desc">由各种物质组成的巨型球状天体，叫做星球。星球有一定的形状，有自己的运行轨道。</p>
							<p class="zuozhe">毒蛇姐原创<b class="zhuanfa">转发18</b></p>
						</div>
					</a>
					<a href="javascript:;" class="weui_media_box weui_media_appmsg">
						<div class="weui_media_hd">
							<img class="weui_media_appmsg_thumb" src="<%=request.getContextPath()%>/sat/mobile/img/xinwentupian-img.png" alt="">
						</div>
						<div class="weui_media_bd">
							<p class="weui_media_desc">由各种物质组成的巨型球状天体，叫做星球。星球有一定的形状，有自己的运行轨道。</p>
							<p class="zuozhe">毒蛇姐原创<b class="zhuanfa">转发18</b></p>
						</div>
					</a><a href="javascript:;" class="weui_media_box weui_media_appmsg">
						<div class="weui_media_hd">
							<img class="weui_media_appmsg_thumb" src="<%=request.getContextPath()%>/sat/mobile/img/xinwentupian-img.png" alt="">
						</div>
						<div class="weui_media_bd">
							<p class="weui_media_desc">由各种物质组成的巨型球状天体，叫做星球。星球有一定的形状，有自己的运行轨道。</p>
							<p class="zuozhe">毒蛇姐原创<b class="zhuanfa">转发18</b></p>
						</div>
					</a>
					<a href="javascript:;" class="weui_media_box weui_media_appmsg">
						<div class="weui_media_hd">
							<img class="weui_media_appmsg_thumb" src="<%=request.getContextPath()%>/sat/mobile/img/xinwentupian-img.png" alt="">
						</div>
						<div class="weui_media_bd">
							<p class="weui_media_desc">由各种物质组成的巨型球状天体，叫做星球。星球有一定的形状，有自己的运行轨道。</p>
							<p class="zuozhe">毒蛇姐原创<b class="zhuanfa">转发18</b></p>
						</div>
					</a>
					<a href="javascript:;" class="weui_media_box weui_media_appmsg">
						<div class="weui_media_hd">
							<img class="weui_media_appmsg_thumb" src="<%=request.getContextPath()%>/sat/mobile/img/xinwentupian-img.png" alt="">
						</div>
						<div class="weui_media_bd">
							<p class="weui_media_desc">由各种物质组成的巨型球状天体，叫做星球。星球有一定的形状，有自己的运行轨道。</p>
							<p class="zuozhe">毒蛇姐原创<b class="zhuanfa">转发18</b></p>
						</div>
					</a>
					<a href="javascript:;" class="weui_media_box weui_media_appmsg">
						<div class="weui_media_hd">
							<img class="weui_media_appmsg_thumb" src="<%=request.getContextPath()%>/sat/mobile/img/xinwentupian-img.png" alt="">
						</div>
						<div class="weui_media_bd">
							<p class="weui_media_desc">由各种物质组成的巨型球状天体，叫做星球。星球有一定的形状，有自己的运行轨道。</p>
							<p class="zuozhe">毒蛇姐原创<b class="zhuanfa">转发18</b></p>
						</div>
					</a>
					<a href="javascript:;" class="weui_media_box weui_media_appmsg">
						<div class="weui_media_hd">
							<img class="weui_media_appmsg_thumb" src="<%=request.getContextPath()%>/sat/mobile/img/xinwentupian-img.png" alt="">
						</div>
						<div class="weui_media_bd">
							<p class="weui_media_desc">由各种物质组成的巨型球状天体，叫做星球。星球有一定的形状，有自己的运行轨道。</p>
							<p class="zuozhe">毒蛇姐原创<b class="zhuanfa">转发18</b></p>
						</div>
					</a>
					<a href="javascript:;" class="weui_media_box weui_media_appmsg">
						<div class="weui_media_hd">
							<img class="weui_media_appmsg_thumb" src="<%=request.getContextPath()%>/sat/mobile/img/xinwentupian-img.png" alt="">
						</div>
						<div class="weui_media_bd">
							<p class="weui_media_desc">由各种物质组成的巨型球状天体，叫做星球。星球有一定的形状，有自己的运行轨道。</p>
							<p class="zuozhe">毒蛇姐原创<b class="zhuanfa">转发18</b></p>
						</div>
					</a> --%>
				</div>
				<div class="weui_panel_bd">
					<c:forEach items="${articleList}" var="satArticle">
						<a href="${satArticle.url} " class="weui_media_box weui_media_appmsg">
						<div class="weui_media_hd">
							<img class="weui_media_appmsg_thumb" src="${satArticle.descImgUrl} " alt="">
						</div>
						<div class="weui_media_bd">
							<p class="weui_media_desc">${satArticle.title} </p>
							<p class="zuozhe">${satArticle.openid} <b class="zhuanfa">转发${satArticle.shares }</b></p>
						</div>
						</a>
					</c:forEach>
					<%-- <a href="javascript:;" class="weui_media_box weui_media_appmsg">
						<div class="weui_media_hd">
							<img class="weui_media_appmsg_thumb" src="<%=request.getContextPath()%>/sat/mobile/img/xinwentupian-img.png" alt="">
						</div>
						<div class="weui_media_bd">
							<p class="weui_media_desc">士大夫似的范德萨范德萨撒地方三大范德萨范德萨士大夫的撒撒打发第三方士大夫士大夫的撒</p>
							<p class="zuozhe">毒蛇姐原创<b class="zhuanfa">转发18</b></p>
						</div>
					</a>
					<a href="javascript:;" class="weui_media_box weui_media_appmsg">
						<div class="weui_media_hd">
							<img class="weui_media_appmsg_thumb" src="<%=request.getContextPath()%>/sat/mobile/img/xinwentupian-img.png" alt="">
						</div>
						<div class="weui_media_bd">
							<p class="weui_media_desc">士大夫似的范德萨范德萨撒地方三大范德萨范德萨士大夫的撒撒打发第三方士大夫士大夫的撒</p>
							<p class="zuozhe">毒蛇姐原创<b class="zhuanfa">转发18</b></p>
						</div>
					</a>
					<a href="javascript:;" class="weui_media_box weui_media_appmsg">
						<div class="weui_media_hd">
							<img class="weui_media_appmsg_thumb" src="<%=request.getContextPath()%>/sat/mobile/img/xinwentupian-img.png" alt="">
						</div>
						<div class="weui_media_bd">
							<p class="weui_media_desc">士大夫似的范德萨范德萨撒地方三大范德萨范德萨士大夫的撒撒打发第三方士大夫士大夫的撒</p>
							<p class="zuozhe">毒蛇姐原创<b class="zhuanfa">转发18</b></p>
						</div>
					</a>
					<a href="javascript:;" class="weui_media_box weui_media_appmsg">
						<div class="weui_media_hd">
							<img class="weui_media_appmsg_thumb" src="<%=request.getContextPath()%>/sat/mobile/img/xinwentupian-img.png" alt="">
						</div>
						<div class="weui_media_bd">
							<p class="weui_media_desc">士大夫似的范德萨范德萨撒地方三大范德萨范德萨士大夫的撒撒打发第三方士大夫士大夫的撒</p>
							<p class="zuozhe">毒蛇姐原创<b class="zhuanfa">转发18</b></p>
						</div>
					</a>
					<a href="javascript:;" class="weui_media_box weui_media_appmsg">
						<div class="weui_media_hd">
							<img class="weui_media_appmsg_thumb" src="<%=request.getContextPath()%>/sat/mobile/img/xinwentupian-img.png" alt="">
						</div>
						<div class="weui_media_bd">
							<p class="weui_media_desc">士大夫似的范德萨范德萨撒地方三大范德萨范德萨士大夫的撒撒打发第三方士大夫士大夫的撒</p>
							<p class="zuozhe">毒蛇姐原创<b class="zhuanfa">转发18</b></p>
						</div>
					</a>
					<a href="javascript:;" class="weui_media_box weui_media_appmsg">
						<div class="weui_media_hd">
							<img class="weui_media_appmsg_thumb" src="<%=request.getContextPath()%>/sat/mobile/img/xinwentupian-img.png" alt="">
						</div>
						<div class="weui_media_bd">
							<p class="weui_media_desc">士大夫似的范德萨范德萨撒地方三大范德萨范德萨士大夫的撒撒打发第三方士大夫士大夫的撒</p>
							<p class="zuozhe">毒蛇姐原创<b class="zhuanfa">转发18</b></p>
						</div>
					</a> --%>
				</div>
				<div class="weui_panel_bd">
					<a href="javascript:;" class="weui_media_box weui_media_appmsg">
						<div class="weui_media_hd">
							<img class="weui_media_appmsg_thumb" src="<%=request.getContextPath()%>/sat/mobile/img/xinwentupian-img.png" alt="">
						</div>
						<div class="weui_media_bd">
							<p class="weui_media_desc">我要册呢岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑</p>
							<p class="zuozhe">毒蛇姐原创<b class="zhuanfa">转发18</b></p>
						</div>
					</a>
					<a href="javascript:;" class="weui_media_box weui_media_appmsg">
						<div class="weui_media_hd">
							<img class="weui_media_appmsg_thumb" src="<%=request.getContextPath()%>/sat/mobile/img/xinwentupian-img.png" alt="">
						</div>
						<div class="weui_media_bd">
							<p class="weui_media_desc">我要册呢岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑</p>
							<p class="zuozhe">毒蛇姐原创<b class="zhuanfa">转发18</b></p>
						</div>
					</a>
					<a href="javascript:;" class="weui_media_box weui_media_appmsg">
						<div class="weui_media_hd">
							<img class="weui_media_appmsg_thumb" src="<%=request.getContextPath()%>/sat/mobile/img/xinwentupian-img.png" alt="">
						</div>
						<div class="weui_media_bd">
							<p class="weui_media_desc">我要册呢岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑</p>
							<p class="zuozhe">毒蛇姐原创<b class="zhuanfa">转发18</b></p>
						</div>
					</a>
					<a href="javascript:;" class="weui_media_box weui_media_appmsg">
						<div class="weui_media_hd">
							<img class="weui_media_appmsg_thumb" src="<%=request.getContextPath()%>/sat/mobile/img/xinwentupian-img.png" alt="">
						</div>
						<div class="weui_media_bd">
							<p class="weui_media_desc">我要册呢岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑</p>
							<p class="zuozhe">毒蛇姐原创<b class="zhuanfa">转发18</b></p>
						</div>
					</a>
					<a href="javascript:;" class="weui_media_box weui_media_appmsg">
						<div class="weui_media_hd">
							<img class="weui_media_appmsg_thumb" src="<%=request.getContextPath()%>/sat/mobile/img/xinwentupian-img.png" alt="">
						</div>
						<div class="weui_media_bd">
							<p class="weui_media_desc">我要册呢岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑</p>
							<p class="zuozhe">毒蛇姐原创<b class="zhuanfa">转发18</b></p>
						</div>
					</a>
					<a href="javascript:;" class="weui_media_box weui_media_appmsg">
						<div class="weui_media_hd">
							<img class="weui_media_appmsg_thumb" src="<%=request.getContextPath()%>/sat/mobile/img/xinwentupian-img.png" alt="">
						</div>
						<div class="weui_media_bd">
							<p class="weui_media_desc">我要册呢岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑岑</p>
							<p class="zuozhe">毒蛇姐原创<b class="zhuanfa">转发18</b></p>
						</div>
					</a>
				</div>
			</div>		
		</div>
		<div class="footer">
			<ul class="sat_footer_ul">
				<li class="sat_footer_li"><a class="clicked"><b class="sat_footer_b zixun"></b>资讯</a></li>
				<li class="sat_footer_li"><a class=""><b class="sat_footer_b chanpin"></b>产品</a></li>
				<li class="sat_footer_li"><a href="<%=request.getContextPath()%>/satuser/gotoUserCenter" class=""><b class="sat_footer_b user"></b>我的</a></li>
			</ul>
		</div>
	</div>

</body>
	<script src="<%=request.getContextPath()%>/sat/assets/fastclick.js"></script>
	<script src="<%=request.getContextPath()%>/sat/assets/jquery.min.js"></script>
	<script src="<%=request.getContextPath()%>/sat/assets/jquery-weui.min.js"></script>
	<script src="<%=request.getContextPath()%>/sat/assets/swiper.js"></script>
	<script src="<%=request.getContextPath()%>/sat/mobile/js/rem.js"></script>
	<script>
		//新闻列表展示
		function DisplayNewsItems(list) {  
			var dispContent = "";
		    $.each(list, function(index, element) {
		    	//alert(element.title);
		    	var content = "<a href='" + element.url + "'" +  "class='weui_media_box weui_media_appmsg'>" 
		    	              + "<div class='weui_media_hd'>" 
		    	              + "<img class='weui_media_appmsg_thumb' src='" + element.descImgUrl + "'" + " alt=''>"
		    	              + "</div>"
		    	              + "<div class='weui_media_bd'>"
		    	              + "<p class='weui_media_desc'>"
		    	              + "<p class='weui_media_desc'>" + element.title + "</p>"
		    	              + "<p class='zuozhe'>" + element.open_id 
		    	              + "<b class='zhuanfa'>转发" + element.shares + "</b></p>" 
		    	              + "</div>"
		    	              + "</a>";
				//alert(content);
		    	//$("#dialogText")
		    	dispContent += content;
		    });  
		    $("#div_this_week").html("");
			$("#div_this_week").html(dispContent);
		}  
		
		//请求后台新闻列表Json数据
		/* $(document).ready(function () {
			$.ajax({ 
			   type: "GET",
			   url:  "/satarticles/list",
			   dataType: "json",
			   success: function(data){
				   var dataRole =$.parseJSON(data);
				   DisplayNewsItems(dataRole);
			   },
			   complete: function(data){
			   }
		   	});
		}); */
	
		$(".header .swiper-container").swiper({
			loop: true,
			autoplay: 1000
		});
		$(".sat_nav").click(function(){
			$(this).addClass("click").siblings('').removeClass("click");
			var index = $(this).index();
			$('.weui_panel_bd').eq(index).show('').siblings('').hide('');
			$('.weui_panel_bd').eq(index).css('top','0')
		})
	</script>