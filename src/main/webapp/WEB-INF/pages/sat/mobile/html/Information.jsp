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
<input hidden="true" value="${openid}" id="openid" type="text">
	<div class="sat_content">
		<div class="zhezhaoceng"></div>
		<div class="zixun_head">
			<div class="head_top">
				<div class="search">
					<input type="text" placeholder="请输入文章关键字" id="inputKey">
					<span id="searchButton" onclick="getSearchData()"><img src="<%=request.getContextPath()%>/sat/mobile/img/fangdajing-icon.png" width="25" alt="搜索"></span>
				</div>
				<div class="remove">
					<span>取消</span>
				</div>
			</div>
			
			<div class="head_center" id="hotSearch" >
				<h6 class="head_sousuo"><img src="<%=request.getContextPath()%>/sat/mobile/img/zuijinshousuo-icon.png" width="16" alt="">热门搜索</h6>
				<ul id="hotUl">
					<li>京东</li>
					<li>阿里</li>
					<li>万达</li>
					<li>谷歌</li>
					<li>油价</li>
					<li>万科</li>
				</ul>
				<h6 class="head_sousuo"><img src="<%=request.getContextPath()%>/sat/mobile/img/zuijinshousuo-icon.png" width="16" alt="">最近搜索</h6>
				<ol id="recentSearch">
					<li>华为</li>
					<li>百度视频</li>
					<li>腾讯科技</li>
				</ol>
			</div>
			
			
			
			<div class="head_center" style="display:none" id="searchListDiv">
				<p class="head_cen_p">搜索到<span>200</span>条相关内容</p>
				<div class="weui_tab" style="height:auto">
					<div class="weui_panel_bd">
						<a href="javascript:;" class="weui_media_box weui_media_appmsg">
							<div class="weui_media_hd">
								<img class="weui_media_appmsg_thumb" src="<%=request.getContextPath()%>/sat/mobile/img/xinwentupian-img.png" alt="">
							</div>
							<div class="weui_media_bd">
								<p class="weui_media_desc">由各种物质组成的巨型球状天体，叫做星球。星球有一定的形状，有自己的运行轨道。</p>
								<p class="zuozhe">
									<b>毒舌姐原创</b>
									<span><img src="<%=request.getContextPath()%>/sat/mobile/img/fenxiang-icon.png" width="20" alt=""><i>0</i></span>
									<span><img src="<%=request.getContextPath()%>/sat/mobile/img/guanzhu-icon.png" width="20" alt=""><i>12</i></span>
								</p>
							</div>
						</a>
						<a href="javascript:;" class="weui_media_box weui_media_appmsg">
							<div class="weui_media_hd">
								<img class="weui_media_appmsg_thumb" src="<%=request.getContextPath()%>/sat/mobile/img/xinwentupian-img.png" alt="">
							</div>
							<div class="weui_media_bd">
								<p class="weui_media_desc">由各种物质组成的巨型球状天体，叫做星球。星球有一定的形状，有自己的运行轨道。</p>
								<p class="zuozhe">
									<b>毒舌姐原创</b>
									<span><img src="<%=request.getContextPath()%>/sat/mobile/img/fenxiang-icon.png" width="20" alt=""><i>0</i></span>
									<span><img src="<%=request.getContextPath()%>/sat/mobile/img/guanzhu-icon.png" width="20" alt=""><i>12</i></span>
								</p>
							</div>
						</a>
						<a href="javascript:;" class="weui_media_box weui_media_appmsg">
							<div class="weui_media_hd">
								<img class="weui_media_appmsg_thumb" src="<%=request.getContextPath()%>/sat/mobile/img/xinwentupian-img.png" alt="">
							</div>
							<div class="weui_media_bd">
								<p class="weui_media_desc">由各种物质组成的巨型球状天体，叫做星球。星球有一定的形状，有自己的运行轨道。</p>
								<p class="zuozhe">
									<b>毒舌姐原创</b>
									<span><img src="../img/fenxiang-icon.png" width="20" alt=""><i>0</i></span>
									<span><img src="../img/guanzhu-icon.png" width="20" alt=""><i>12</i></span>
								</p>
							</div>
						</a>
						<a href="javascript:;" class="weui_media_box weui_media_appmsg">
							<div class="weui_media_hd">
								<img class="weui_media_appmsg_thumb" src="../img/xinwentupian-img.png" alt="">
							</div>
							<div class="weui_media_bd">
								<p class="weui_media_desc">由各种物质组成的巨型球状天体，叫做星球。星球有一定的形状，有自己的运行轨道。</p>
								<p class="zuozhe">
									<b>毒舌姐原创</b>
									<span><img src="../img/fenxiang-icon.png" width="20" alt=""><i>0</i></span>
									<span><img src="../img/guanzhu-icon.png" width="20" alt=""><i>12</i></span>
								</p>
							</div>
						</a>
					</div>
				</div>
			</div>
					
			<div class="head_bottom" id="clearRecord" onclick="clearAllRecords()">
				<p>清空最近搜索记录</p>
			</div>
		</div>
			
		<div class="main">
			<div class="main_head" style="position:relative;">
				<div class="search">
					<input type="text" placeholder="请输入文章关键字" readonly>
					<span><img src="<%=request.getContextPath()%>/sat/mobile/img/fangdajing-icon.png" width="25" alt="搜索"></span>
				</div>
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
				<div class="sat_nav click">
					<div class="main_swiper_list" onclick="updateNewsCategory()"><span>本周头条</span></div>
				</div>
				<div class="sat_nav ">
					<div class="main_swiper_list"><span class="sta_nav_tihuan">时事政坛</span></div>
				</div>
				<div class="sat_nav">
					<div class="main_swiper_list"><span class="sta_nav_tihuan">体坛风云</span></div>
				</div>
				<div class="sat_nav">
					<div class="main_swiper_list"><span class="sta_nav_tihuan">叱咤金融</span></div>
				</div>
				<div class="sat_add">
					<div class="main_swiper_list">
						<span id="listOne"><img src="<%=request.getContextPath()%>/sat/mobile/img/zengjia-icon.png" width="18" alt="添加"></span>
						<div class="main_list_box hide">
							<ul class="list_box">
								<li>
									<span>时事政坛</span>
									<span>体坛风云</span>
									<span>叱咤金融</span>
								</li>
								<li>
									<span class="click">金融新干线</span>
									<span>保险基金</span>
									<span>生活养生</span>
								</li>
								<li>
									<span>娱乐资本论</span>
									<span>财经私房</span>
									<span>心灵鸡汤</span>
								</li>
							</ul>
								
						</div>
					</div>
				</div>		
				
			</div>
			<div class="weui_tab" style="height:auto">
				<div>
					<div class="weui_panel_bd" id = "newsListDiv">
					<c:forEach items="${articleList}" var="satArticle">
						<a href="detail?id=${satArticle.id}&openid=${openid}" class="weui_media_box weui_media_appmsg">
						<div class="weui_media_hd">
							<img class="weui_media_appmsg_thumb" src="${satArticle.descImgUrl} " alt="">
						</div>
						<div class="weui_media_bd">
							<p class="weui_media_desc">${satArticle.title} </p>
							<p class="zuozhe">
								<b>作者</b>
								<span><img src="<%=request.getContextPath()%>/sat/mobile/img/fenxiang-icon.png" width="20" alt=""><i>${satArticle.shares }</i></span>
								<span><img src="<%=request.getContextPath()%>/sat/mobile/img/guanzhu-icon.png" width="20" alt=""><i>${satArticle.watches }</i></span>
							</p>
						</div>
						</a>
					</c:forEach>
					
					</div>
				</div>
			</div>		
		</div>
		<div class="footer">
			<ul class="sat_footer_ul">
				<li class="sat_footer_li"><a class="clicked"><b class="sat_footer_b zixun"></b>资讯</a></li>
				<li class="sat_footer_li"><a href="<%=request.getContextPath()%>/product/list" class=""><b class="sat_footer_b chanpin"></b>产品</a></li>
				<li class="sat_footer_li"><a href="<%=request.getContextPath()%>/satuser/gotoUserCenter" class=""><b class="sat_footer_b user"></b>我的</a></li>
			</ul>
		</div>
	</div>

</body>
	<script src="<%=request.getContextPath()%>/sat/assets/fastclick.js"></script>
	<script src='<%=request.getContextPath()%>/sat/assets/jquery.min.js'></script>
	<script src='<%=request.getContextPath()%>/sat/assets/jquery-weui.min.js'></script>
	<script src="<%=request.getContextPath()%>/sat/assets/swiper.js"></script>
	<script src='<%=request.getContextPath()%>/sat/mobile/js/rem.js'></script>
	<script>
		$(".main_head .swiper-container").swiper({
			loop: true,
			autoplay: 1000
		});
		 $(".search").click(function(){
			$(".zixun_head").css("display","flex");
		})
		$(".remove").on("click",function(){
			$(".zixun_head").hide();
		}) 
		
		$(".list_box span").on("click",function(){
			//添加点击效果，取消其他兄弟样式；
			$(this).addClass("click").siblings().removeClass('click');
			$(this).parent("li").siblings().find("span").removeClass('click');
			//获取值更换到页面；
			var val=$(this).parent().find('span');
			for(var j=0;j<3;j++){
				$(".sta_nav_tihuan").eq(j).text(val.eq(j).text());
			}
			//遮罩层隐藏，
			$(".zhezhaoceng").toggleClass('show');
			$(".main_list_box").toggleClass('hide');
		})

		$("#listOne").on("click",function(){
	    	$(".zhezhaoceng").toggleClass('show');
			$(".main_list_box").toggleClass('hide');
		})
		$(".zhezhaoceng").click(function(){
			$(".main_list_box").addClass('hide');
			$(this).removeClass('show');
		})
		
		
		//导航点击效果
		$(".sat_nav").click(function(){
			$(this).addClass("click").siblings().removeClass("click");
			var text=$(this).text();
			//alert($.trim(text));
			updateNewsCategory($.trim(text));
		})
		var openid = $("#openid").val();
		//新闻列表展示
		function DisplayNewsItems(list, obj) {  
			var dispContent = "";
			
			//alert(openid);
		    $.each(list, function(index, element) {
		    	//alert(element.title);
		    	var content = "<a href='" + "detail?id=" + element.id + "&openid=" + openid + "'" +  " class='weui_media_box weui_media_appmsg'>" 
		    	              + "<div class='weui_media_hd'>" 
		    	              + "<img class='weui_media_appmsg_thumb' src='" + element.descImgUrl + "'" + " alt=''>"
		    	              + "</div>"
		    	              + "<div class='weui_media_bd'>"
		    	              + "<p class='weui_media_desc'>"
		    	              + "<p class='weui_media_desc'>" + element.title + "</p>"
		    	              + "<p class='zuozhe'>" 
		    	              + "<b class='zhuanfa'>转发" + element.shares + "</b></p>" 
		    	              + "</div>"
		    	              + "</a>";
				//alert(content);
		    	//$("#dialogText")
		    	dispContent += content;
		    });  
		    obj.html("");
			obj.html(dispContent);
		}  
		
		//根据类别获取数据
		function updateNewsCategory(text){
			//alert("get more detail");
			var url = "<%=request.getContextPath()%>/satarticle/listArticlesByClassifyName";
			$.ajax({
				url : url,
				type : 'POST',
				dataType : 'json',
				async : true,
				data : {
					"classifyName" : text
				},
				success : function(data) {
					if(data.indexOf("unsuccess") > 0){
						//alert(data);
					} else {
						//alert(data);
						var dataRole =$.parseJSON(data);
						//$("#searchListDiv").attr("style", "display:block");
						DisplayNewsItems(dataRole, $("#newsListDiv"));
					}
				},
				error : function() {
					//alert("网络连接异常");
				}
			});
		}
		
		//热门搜索
		function hotSearch(text){
			var url = "<%=request.getContextPath()%>/satarticle/getLike";
			$.ajax({
				url : url,
				type : 'POST',
				dataType : 'json',
				async : true,
				data : {
					"title" : text
				},
				success : function(data) {
					if(data.indexOf("unsuccess") > 0){
						//alert(data);
					} else {
						//alert(data);
						$("#searchListDiv").attr("style", "display:block");
						$("#hotSearch").attr("style", "display:block");
						$("#clearRecord").attr("style", "display:none");
						var dataRole =$.parseJSON(data);
						//$("#searchListDiv").attr("style", "display:block");
						DisplayNewsItems(dataRole, $("#searchListDiv"));
					}
				},
				error : function() {
					alert("网络连接异常");
				}
			});
		}
		//根据输入数据查询文章列表
		function getSearchData() {
			var url = "<%=request.getContextPath()%>/satarticle/getLike";
			var title = $("#inputKey").val();
			$.ajax({
				url : url,
				type : 'POST',
				dataType : 'json',
				async : true,
				data : {
					"title" : title
				},
				success : function(data) {
					if(data.indexOf("failed") > 0){
						alert("没有搜索到");
					} else {
						//alert(data);
						//不显示搜索框
						$("#searchListDiv").attr("style", "display:block");
						$("#hotSearch").attr("style", "display:none");
						$("#clearRecord").attr("style", "display:none");
						var dataRole =$.parseJSON(data);
						DisplayNewsItems(dataRole,$("#searchListDiv"));
					}
					/* if(data.indexOf("success") > 0){
						//alert("")
						alert(data);
						//alert("更新转发量成功");
					}else{
						//alert("系统异常，更新转发量失败");
					} */
				},
				error : function() {
					alert("网络连接异常");
				}
			});
		}
		$("#inputKey").focus(function(){
			$("#searchListDiv").attr("style", "display:block");
			$("#hotSearch").attr("style", "display:block");
			$("#clearRecord").attr("style", "display:none");
		});
		
		$("#hotUl li").click(function(){
		    var y = $(this);
		    //alert(y.text());
		    hotSearch(y.text());
		});
		
		function clearAllRecords() {
			$("#recentSearch").children().remove();
		}
	</script>