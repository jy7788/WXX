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
	<div class="sat_content">
		<div class="zixun_head">
			<div class="head_top">
				<div class="search">
					<input type="text" placeholder="请输入文章关键字">
					<span><img src="" alt="搜索"></span>
				</div>
				<div class="remove">
					<span>取消</span>
				</div>
			</div>
			<div class="head_center">
				<h6 class="head_sousuo">热门搜索</h6>
				<ul>
					<li>腾讯科技</li>
					<li>重修宪法</li>
					<li>大连万达</li>
					<li>中国人民解放军建军80周年</li>
					<li>高德软件</li>
					<li>抗战</li>
				</ul>
				<h6 class="head_sousuo">最近搜索</h6>
				<ol>
					<li>华为</li>
					<li>百度视频</li>
					<li>腾讯科技</li>
				</ol>
			</div>
			<div class="head_center" style="display:none">
				<p class="head_cen_p">搜索到<span>200</span>条相关内容</p>
				<div class="weui_tab">
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
					
			<div class="head_bottom">
				<p>清空最近搜索记录</p>
			</div>
		</div>
			
		<div class="main">
			<div class="main_head" style="position:relative;">
				<div class="search">
					<input type="text" placeholder="请输入文章关键字" readonly>
					<span><img src="<%=request.getContextPath()%>/sat/mobile/img/huisesejiantou-icon.png" alt="搜索"></span>
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
				<div class="sat_nav ">
					<div class="main_swiper_list"><span>本周头条</span></div>
				</div>
				<div class="sat_nav click">
					<div class="main_swiper_list"><span>时事政坛</span></div>
				</div>
				<div class="sat_nav">
					<div class="main_swiper_list"><span>体坛风云</span></div>
				</div>
				<div class="sat_nav">
					<div class="main_swiper_list"><span>叱咤金融</span></div>
				</div>
				<div class="sat_add">
					<div class="main_swiper_list">
						<span id="listOne"><img src="<%=request.getContextPath()%>/sat/mobile/img/huisesejiantou-icon.png" width="11" alt="添加"></span>
						<div class="main_list_box">
							<div class="list_box">
								<span class="click">金融新干线</span>
								<span>保险基金</span>
								<span>社会热点</span>
								<span>生活养生</span>
								<span>娱乐资本论</span>
								<span>财经私房</span>
								<span>贷款微课堂</span>
								<span>心灵鸡汤</span>
							</div>
							<div class="list_btn ">
								<button>确认</button>
							</div>
						</div>
					</div>
				</div>
					
				
			</div>
			<div class="weui_tab">
				<div>
					<div class="weui_panel_bd">
					<c:forEach items="${articleList}" var="satArticle">
						<a href="detail?id=${satArticle.id}&openid=${openid}" class="weui_media_box weui_media_appmsg">
						<div class="weui_media_hd">
							<img class="weui_media_appmsg_thumb" src="${satArticle.descImgUrl} " alt="">
						</div>
						<div class="weui_media_bd">
							<p class="weui_media_desc">${satArticle.title} </p>
							<p class="zuozhe">
								<b>${satArticle.openid}</b>
								<span><img src="<%=request.getContextPath()%>/sat/mobile/img/fenxiang-icon.png" width="20" alt=""><i>${satArticle.shares }</i></span>
								<span><img src="<%=request.getContextPath()%>/sat/mobile/img/guanzhu-icon.png" width="20" alt=""><i>${satArticle.watches }</i></span>
							</p>
						</div>
						</a>
					</c:forEach>
					
					
						<%-- <a href="javascript:;" class="weui_media_box weui_media_appmsg">
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
						</a><a href="javascript:;" class="weui_media_box weui_media_appmsg">
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
						</a><a href="javascript:;" class="weui_media_box weui_media_appmsg">
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
						</a><a href="javascript:;" class="weui_media_box weui_media_appmsg">
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
						</a> --%>
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
		    	              + "<p class='weui_media_desc'>" + element.title  + "ssssss"+ "</p>"
		    	              + "<p class='zuozhe'>" + element.open_id 
		    	              + "<b class='zhuanfa'>转发" + element.shares + "</b></p>" 
		    	              + "</div>"
		    	              + "</a>";
				//alert(content);
		    	//$("#dialogText")
		    	dispContent += content;
		    });  
		    //$("#div_this_week").html("");
			$("#div_this_week").html(dispContent);
		}  
		
		function getMoreDetail(category){
			//alert("get more detail");
			var url = "<%=request.getContextPath()%>/satarticle/getArticlesByCategory";
			$.ajax({
				url : url,
				type : 'POST',
				dataType : 'json',
				async : true,
				data : {
					"categoryId" : category
				},
				success : function(data) {
					var dataRole =$.parseJSON(data);
					//alert(dataRole);
					DisplayNewsItems(dataRole);
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
	</script>