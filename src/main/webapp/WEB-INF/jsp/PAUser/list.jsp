<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=320,maximum-scale=1.3,user-scalable=no">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<!--禁止ios设备将数字作为拨号连接，邮箱自动发送，点击地图跳转-->
<meta name="format-detection" content="telephone=no,email=no,adress=no">
<!--强制全屏显示-->
<meta name="full-screen" content="yes">
<!--开启对webapp的支持-->
<meta name="apple-mobile-web-app-capable" content="yes">
<!--web app应用下状态条(屏幕顶部条)的颜色,默认值为default(白色)-->
<meta name="apple-mobile-web-app-status-bar-style"
	content="black-translucent">
<!--禁止浏览器从缓存中访问页面内容-->
<meta http-equiv="Pragma" content="no-cache">
<meta name="format-detection" content="telephone=no" />
<meta name="format-detection" content="email=no" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/js/qukuailian_weixin/css/style.css">
<title>区块链峰会签到</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="alert">
	<div class="alert_main">
		<a class="cuowu"></a>
		<p class="text">目前您还没有开通访问授权！<br>请您前去开庭！</p>
		<p class="fangwen">访问授权区块链</p>
	</div>
</div>
	<div class="qukuailian_bg">
	    <div class="qkl_title_lg">
	      <div class="qkl_title">
		       <span class="font_s1">区块链培训研讨会</span><br>
		       <span class="font_s2">签到处</span>
	       </div>
	       <div class="qkl_title_bg_circle"></div>
	       <div class="r_arr"></div>
	        <div class="l_arr"></div>	
	    </div>
	    <div class="qukuailianlist_content">
		    <div>
				<!-- <div class="qukuailian_list">
					<span class="jianchent">平</span>
					<div class="gongsiming">
						<div class="qukuailian_text">
							<p><span>平安银行股份有限公司</span></p>
							<p><span>姓名：<i></i></span><span>职位：<i>副行长</i></span></p>
							<p><span>TEL：18818199910</span></p>
							<p><span class="xiaosize">2017.02.23 18:09</span></p>
						</div>
						
						<div class="shouquan wei">授权查看</div>
					</div>
				</div> -->
				
				<c:forEach items="${PAUsers}" var="pAUser">
					<div class="qukuailian_list">
						<span class="jianchent">平</span>
						<div class="gongsiming">
							<div class="qukuailian_text">
								<p><span>平安银行股份有限公司</span></p>
								<p><span>姓名: ${pAUser.nickname}<i></i></span><span>职位: ${pAUser.position }<i></i></span></p>
								
								<c:choose>
								<c:when test="${ pAUser.status == 1 }">
									<p><span>TEL: ${pAUser.phoneNum }</span></p>
								</c:when>
								<c:otherwise>
									<p><span>TEL: 授权通过后才能看到</span></p>
								</c:otherwise>
								</c:choose>	
								
								
								<p><span class="xiaosize">2017.02.23 18:09</span></p>
							</div>
							<%-- <div class="shouquan wei"><a href="bindUser/${pAUser.openid }">授权查看</a></div> --%>
							<c:choose>
								<c:when test="${ pAUser.status == 1 }">
									<div class="shouquan wei">已授权</a></div>
								</c:when>
								<c:otherwise>
									<div class="shouquan wei"><a href="bindUser/${pAUser.openid }">授权查看</a></div>
								</c:otherwise>
							</c:choose>	
						</div>
						<%-- <img width="50" src="${pAUser.imgUrl }"> --%>
						
					</div>
						
				</c:forEach>
				<!-- <div class="qukuailian_list">
					<span class="jianchent">浦</span>
					<div class="gongsiming">
						<div class="qukuailian_text">
							<p><span>浦发银行股份有限公司</span></p>
							<p><span>姓名：<i></i></span><span>职位：<i>副行长</i></span></p>
							<p><span>TEL：18818199910</span></p>
							<p><span class="xiaosize">2017.02.23 18:09</span></p>
						</div>
						
						<div class="shouquan yi">已授权</div>
					</div>
				</div>
				<div class="qukuailian_list">
					<span class="jianchent">浦</span>
					<div class="gongsiming">
						<div class="qukuailian_text">
							<p><span>浦发银行股份有限公司</span></p>
							<p><span>姓名：<i></i></span><span>职位：<i>副行长</i></span></p>
							<p><span>TEL：18818199910</span></p>
							<p><span class="xiaosize">2017.02.23 18:09</span></p>
						</div>
						
						<div class="shouquan yi">已授权</div>
					</div>
				</div><div class="qukuailian_list">
					<span class="jianchent">浦</span>
					<div class="gongsiming">
						<div class="qukuailian_text">
							<p><span>浦发银行股份有限公司</span></p>
							<p><span>姓名：<i></i></span><span>职位：<i>副行长</i></span></p>
							<p><span>TEL：18818199910</span></p>
							<p><span class="xiaosize">2017.02.23 18:09</span></p>
						</div>
						
						<div class="shouquan yi">已授权</div>
					</div>
				</div> -->
			</div>
	    </div>
	</div>

	<script src='<%=request.getContextPath()%>/js/qukuailian_weixin/js/rem.js'></script>
	<script src="<%=request.getContextPath()%>/js/qukuailian_weixin/js/jquery-1.11.3.min.js"></script> 
</body>
</html>