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
	<title>我的文章</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/sat/assets/weui.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/sat/assets/jquery-weui.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/sat/assets/demos.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/sat/mobile/css/style.css">
</head>
<body >
<input type="text" id="path" hidden="false" value="<%=request.getContextPath()%>">
	<div class="sat_content">
		<div class="header">
			<img src="<%=request.getContextPath()%>/sat/mobile/img/panner.PNG" alt="" style="width:100%;">
		</div>
		<div class="main" >
			<div>
			<div class="weui_cell wenzhang_list">
				<div class="weui_cell_hd"><i class="yuan">原创</i><img src="<%=request.getContextPath()%>/sat/mobile/img/xinwentupian-img.png" width="100" alt=""></div>
				<div class="weui_cell_bd weui_cell_primary">
					<p class="text">文字标题文字标题文题sssssssssssss</p>
					<div class="wenzhang_eye">
						<span><img src="<%=request.getContextPath()%>/sat/mobile/img/fenxiang-icon.png" width="20" alt=""><i>0</i></span>
						<span><img src="<%=request.getContextPath()%>/sat/mobile/img/guanzhu-icon.png" width="20" alt=""><i>12</i></span>
						<span></span>
						<b><i>编辑</i></b>
						<b><i>删除</i></b>
					</div>
				</div>
			</div>
			
			<c:forEach items="${myArticles}" var="satArticle">
				<c:choose>
					<c:when test="${ satArticle.selfCreated == 1 }">
						<a href="<%=request.getContextPath()%>/satarticle/myArticleDetail?id=${satArticle.id}&openid=${openid} "> 
						<div class="weui_cell wenzhang_list" id="articleTab" onclick="gotoMyArticleDetail(${openid}, ${satArticle.id})">
						<div class="weui_cell_hd"><i class="yuan">原创</i><img src="${satArticle.descImgUrl}" width="100" alt=""></div>
						<div class="weui_cell_bd weui_cell_primary">
							<p class="text">${satArticle.title} </p>
							<div class="wenzhang_eye">
								<span><img src="<%=request.getContextPath()%>/sat/mobile/img/fenxiang-icon.png" width="20" alt=""><i>${satArticle.shares}</i></span>
								<span><img src="<%=request.getContextPath()%>/sat/mobile/img/guanzhu-icon.png" width="20" alt=""><i>${satArticle.watches}</i></span>
								<span></span>
								<b><i>编辑</i></b>
								<b><i>删除</i></b>
							</div>
						</div>
						</div>
						</a>
					</c:when>
					<c:otherwise>
						<a href="<%=request.getContextPath()%>/satarticle/myArticleDetail?id=${satArticle.id}&openid=${openid} ">
						<div class="weui_cell wenzhang_list" onclick="gotoMyArticleDetail(${openid}, ${satArticle.id})">
						<div class="weui_cell_hd"><i class="yuan">转载</i><img src="${satArticle.descImgUrl}" width="100" alt=""></div>
						<div class="weui_cell_bd weui_cell_primary">
							<p class="text">${satArticle.title}</p>
							<div class="wenzhang_eye">
								<span><img src="<%=request.getContextPath()%>/sat/mobile/img/fenxiang-icon.png" width="20" alt=""><i>${satArticle.shares}</i></span>
								<span><img src="<%=request.getContextPath()%>/sat/mobile/img/guanzhu-icon.png" width="20" alt=""><i>${satArticle.watches}</i></span>
								<span></span>
								<b></b>
								<b><i>删除</i></b>
							</div>
						</div>
						</div>
						</a>
					</c:otherwise>
				</c:choose>	
			
				
			</c:forEach>
			<!-- <div class="weui_cell wenzhang_list">
				<div class="weui_cell_hd"><i class="zhuan">原创</i><img src="../img/xinwentupian-img.png" width="100" alt=""></div>
				<div class="weui_cell_bd weui_cell_primary">
					<p class="text">文字标题</p>
					<div class="wenzhang_eye">
						<span><img src="../img/fenxiang-icon.png" width="20" alt=""><i>0</i></span>
						<span><img src="../img/guanzhu-icon.png" width="20" alt=""><i>12</i></span>
						<span></span>
						<b>编辑</b>
						<b>删除</b>
					</div>
				</div>
			</div>
			<div class="weui_cell wenzhang_list">
				<div class="weui_cell_hd"><i class="yuan">原创</i><img src="../img/xinwentupian-img.png" width="100" alt=""></div>
				<div class="weui_cell_bd weui_cell_primary">
					<p class="text">文字标题文字标题文题</p>
					<div class="wenzhang_eye">
						<span><img src="../img/fenxiang-icon.png" width="20" alt=""><i>0</i></span>
						<span><img src="../img/guanzhu-icon.png" width="20" alt=""><i>12</i></span>
						<span></span>
						<b>编辑</b>
						<b>删除</b>
					</div>
				</div>
			</div>
			<div class="weui_cell wenzhang_list">
				<div class="weui_cell_hd"><i class="zhuan">原创</i><img src="../img/xinwentupian-img.png" width="100" alt=""></div>
				<div class="weui_cell_bd weui_cell_primary">
					<p class="text">文字标题</p>
					<div class="wenzhang_eye">
						<span><img src="../img/fenxiang-icon.png" width="20" alt=""><i>0</i></span>
						<span><img src="../img/guanzhu-icon.png" width="20" alt=""><i>12</i></span>
						<span></span>
						<b>编辑</b>
						<b>删除</b>
					</div>
				</div>
			</div>
			<div class="weui_cell wenzhang_list">
				<div class="weui_cell_hd"><i class="yuan">原创</i><img src="../img/xinwentupian-img.png" width="100" alt=""></div>
				<div class="weui_cell_bd weui_cell_primary">
					<p class="text">文字标题文字标题文题</p>
					<div class="wenzhang_eye">
						<span><img src="../img/fenxiang-icon.png" width="20" alt=""><i>0</i></span>
						<span><img src="../img/guanzhu-icon.png" width="20" alt=""><i>12</i></span>
						<span></span>
						<b>编辑</b>
						<b>删除</b>
					</div>
				</div>
			</div>
			<div class="weui_cell wenzhang_list">
				<div class="weui_cell_hd"><i class="zhuan">原创</i><img src="../img/xinwentupian-img.png" width="100" alt=""></div>
				<div class="weui_cell_bd weui_cell_primary">
					<p class="text">文字标题</p>
					<div class="wenzhang_eye">
						<span><img src="../img/fenxiang-icon.png" width="20" alt=""><i>0</i></span>
						<span><img src="../img/guanzhu-icon.png" width="20" alt=""><i>12</i></span>
						<span></span>
						<b>编辑</b>
						<b>删除</b>
					</div>
				</div>
			</div> -->
			</div>
		</div>
		<div class="footer">
			<ul class="sat_footer_ul">
				<li class="sat_footer_li"><a href="<%=request.getContextPath()%>/satarticle/list" class=""><b class="sat_footer_b zixun"></b>资讯</a></li>
				<li class="sat_footer_li"><a href="<%=request.getContextPath()%>/product/list" class=""><b class="sat_footer_b chanpin"></b>产品</a></li>
				<li class="sat_footer_li"><a class="clicked"><b class="sat_footer_b user"></b>我的</a></li>
			</ul>
		</div>
	</div>
<div class="right_bottom">
	<div class="bianxie">
		<div class="bianjipen"><img src="<%=request.getContextPath()%>/sat/mobile/img/pen.PNG" alt=""></div>
		<div class="bianji yuan" ><a href="<%=request.getContextPath()%>/satarticle/gotoArticleSelfCreate">原创</a></div>
		<div class="bianji zhuan" ><a href="<%=request.getContextPath()%>/satarticle/gotoArticleReproduce">转载</a></div>
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
		$(".bianjipen").click(function(){
			$(this).siblings().toggleClass('shows');
		})
		
		function gotoMyArticleDetail(openid, id) {
			alert("aaa");
			alert("　id " + id + openid);
		}
		<%-- function gotoSelfCreate() {
			var path = <%=request.getContextPath()%> + "/satarticle/gotoArticleSelfCreate";
			self.location = path;
		} 
		
		function gotoReproduce() {
			window.location.href = <%=request.getContextPath()%> + "/satarticle/gotoArticleReproduce";
			var path = <%=request.getContextPath()%> + "/satarticle/gotoArticleReproduce";
			self.location = path;
		} --%>
	</script>