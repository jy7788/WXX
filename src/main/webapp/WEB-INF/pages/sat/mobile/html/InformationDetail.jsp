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
	<title>${satArticle.title }</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/sat/assets/weui.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/sat/assets/jquery-weui.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/sat/assets/demos.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/sat/mobile/css/style.css">
</head>
<body>
	<div class="sat_content">
		<div class="data_header">
			<div class="head_png weui_cell">
				<div class="weui_cell_hd"><img src="<%=request.getContextPath()%>/sat/mobile/img/dibuxiaotouxiang-icon.png" width="42" alt=""></div>
				<div class="weui_cell_bd weui_cell_primary">
					<p>修改头像</p>
					<p>1768283437</p>
				</div>
				<div class="weui_cell_ft"><img src="<%=request.getContextPath()%>/sat/mobile/img/sat-dianhua-icon.png" width="37" alt=""></div>
			</div>
			<div class="data_main">
				<h1>${satArticle.title }</h1>
				<div class="sat_zhuanzai">
					<p>${satArticle.createTime }</p>
					<p>
						<img src="<%=request.getContextPath()%>/sat/mobile/img/dianzan-icon.png" width="20" alt=""><span>${satArticle.stars}</span>
						<img src="<%=request.getContextPath()%>/sat/mobile/img/fenxiang-icon.png" width="20" alt=""><span>${satArticle.shares}</span>
						<img src="<%=request.getContextPath()%>/sat/mobile/img/guanzhu-icon.png" width="20" alt=""><span>${satArticle.watches}</span>
					</p>
				</div>
				<div class="main_cont">
					<!-- 新华社北京7月19日电 中共中央总书记、国家主席、中央军委主席、中央全面深化改革领导小组组长习近平7月19日下午主持召开中央全面深化改革领导小组第三十七次会议并发表重要讲话。他强调，各地区要切实把思想和行动统一到党中央改革决策部署上来，从服务党和国家工作大局出发推动改革，敢于担当、善谋实干、实事求是、锐意进取，扎实推进各项改革落到实处、见到成效。
					新华社北京7月19日电 中共中央总书记、国家主席、中央军委主席、中央全面深化改革领导小组组长习近平7月19日下午主持召开中央全面深化改革领导小组第三十七次会议并发表重要讲话。他强调，各地区要切实把思想和行动统一到党中央改革决策部署上来，从服务党和国家工作大局出发推动改革，敢于担当、善谋实干、实事求是、锐意进取，扎实推进各项改革落到实处、见到成效。
					新华社北京7月19日电 中共中央总书记、国家主席、中央军委主席、中央全面深化改革领导小组组长习近平7月19日下午主持召开中央全面深化改革领导小组第三十七次会议并发表重要讲话。他强调，各地区要切实把思想和行动统一到党中央改革决策部署上来，从服务党和国家工作大局出发推动改革，敢于担当、善谋实干、实事求是、锐意进取，扎实推进各项改革落到实处、见到成效。
					新华社北京7月19日电 中共中央总书记、国家主席、中央军委主席、中央全面深化改革领导小组组长习近平7月19日下午主持召开中央全面深化改革领导小组第三十七次会议并发表重要讲话。他强调，各地区要切实把思想和行动统一到党中央改革决策部署上来，从服务党和国家工作大局出发推动改革，敢于担当、善谋实干、实事求是、锐意进取，扎实推进各项改革落到实处、见到成效。 -->
					<article>
					${satArticle.content }
					</article>
				</div>
				<div class="laiyuan">
					<p>（毒蛇姐原创）</p>
				</div>
				<div class="main_foot">
					<span id="dianzan">
						<img src="<%=request.getContextPath()%>/sat/mobile/img/dianzan-but.png" width="65" alt="">
						<i>+1</i>
					</span>
					
				</div>
				<div class="main_guanggao">
					<span>广告</span>
				</div>
			</div>
				
		</div>
		<div class="data_footer">
			<div class="foot_png weui_cell">
				<div class="weui_cell_hd"><img src="<%=request.getContextPath()%>/sat/mobile/img/dibuxiaotouxiang-icon.png" width="35" alt=""></div>
				<div class="weui_cell_bd weui_cell_primary">
					<p>修改头像</p>
					<p>上海壹账通互联个案上海壹账通互联个案</p>
				</div>
				<div class="weui_cell_ft">
					<a><img src="<%=request.getContextPath()%>/sat/mobile/img/mingpian-dianhua-icon.png" width="34" alt=""></a>
					<a><img src="<%=request.getContextPath()%>/sat/mobile/img/mingpian-tianjiaguanzhu-icon.png" width="34" alt=""></a>
					<a><img src="<%=request.getContextPath()%>/sat/mobile/img/mingpian-weixin-icon.png" width="34" alt=""></a>
					<a><img src="<%=request.getContextPath()%>/sat/mobile/img/mingpian-xiewenzhang-icon.png" width="34" alt=""></a>
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
</script>
</html>