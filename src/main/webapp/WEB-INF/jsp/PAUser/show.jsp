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
<title>区块链峰会签到</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/js/qukuailian_weixin/css/style.css">
<style>
a:link{
    color:#04013c;
}
</style>
</head>
<body>
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
				<div class="qukuailian_list">
					<span class="touxiang" 
					style="width:2.4rem;height:2.4rem;
					background:url(img/weizhitouxiang-icon.png) no-repeat;
					margin:0.6rem;
					background-size: 100% 100%;-webkit-background-size: 100% 100%;-ms-background-size: 100% 100%;-o-background-size: 100% 100%;-moz-background-size: 100% 100%;
					">
					  <img src="${pAUser.imgUrl }" style="width:100%;height:100%;border:none;">
					</span>
					<div  class="gongsiming">
						<div class="qukuailian_text" style="margin-bottom: 26%;">
							<p><span>${pAUser.organization }</span></p>
							<c:choose>
							<c:when test="${ pAUser.status == 1 }">
								<p><span>${pAUser.username }  TEL: ${pAUser.phoneNum }</span></p>
							</c:when>
							<c:otherwise>
								<p><span>${pAUser.username }希望获得您的联系电话</span></p>
							</c:otherwise>
							</c:choose>	
							
							
						</div>
						<!-- <div class="shouquan yi" style="background: url(img/jujue-but.png) no-repeat;background-size: 100%;position:absolute;left:-1rem;">
						  拒绝查看
						</div> -->
						
						<c:choose>
						<c:when test="${ pAUser.status == 1 }">
							<div class="shouquan wei">已授权</div>
						</c:when>
						<c:otherwise>
							<div class="shouquan wei"><a href="/pauser/accept/${pAUser.openid }">同意查看</a></div>
						</c:otherwise>
						</c:choose>	
						
					</div>
				</div>
				<!-- <div class="qukuailian_list">
					<span class="touxiang" 
					style="width:2.4rem;height:2.4rem;
					background:url(img/weizhitouxiang-icon.png) no-repeat;
					margin:0.6rem;
					background-size: 100% 100%;-webkit-background-size: 100% 100%;-ms-background-size: 100% 100%;-o-background-size: 100% 100%;-moz-background-size: 100% 100%;
					">
					  <img src="" style="width:100%;height:100%;border:none;">
					</span>
					<div  class="gongsiming">
						<div class="qukuailian_text" style="margin-bottom: 26%;">
							<p><span>浦发银行股份有限公司</span></p>
							<p><span>马卫希望获得您的联系电话</span></p>
						</div>
						<div class="shouquan yi" style="background: url(img/jujue-but.png) no-repeat;background-size: 100%;position:absolute;left:-1rem;">
						  拒绝查看
						</div>
						<div class="shouquan wei">同意查看</div>
					</div>
				</div>
				<div class="qukuailian_list">
					<span class="touxiang" 
					style="width:2.4rem;height:2.4rem;
					background:url(img/weizhitouxiang-icon.png) no-repeat;
					margin:0.6rem;
					background-size: 100% 100%;-webkit-background-size: 100% 100%;-ms-background-size: 100% 100%;-o-background-size: 100% 100%;-moz-background-size: 100% 100%;
					">
					  <img src="" style="width:100%;height:100%;border:none;">
					</span>
					<div  class="gongsiming">
						<div class="qukuailian_text" style="margin-bottom: 26%;">
							<p><span>浦发银行股份有限公司</span></p>
							<p><span>马卫希望获得您的联系电话</span></p>
						</div>
						<div class="shouquan yi" style="background: url(img/jujue-but.png) no-repeat;background-size: 100%;position:absolute;left:-1rem;">
						  拒绝查看
						</div>
						<div class="shouquan wei">同意查看</div>
					</div>
				</div>
				<div class="qukuailian_list">
					<span class="touxiang" 
					style="width:2.4rem;height:2.4rem;
					background:url(img/weizhitouxiang-icon.png) no-repeat;
					margin:0.6rem;
					background-size: 100% 100%;-webkit-background-size: 100% 100%;-ms-background-size: 100% 100%;-o-background-size: 100% 100%;-moz-background-size: 100% 100%;
					">
					  <img src="" style="width:100%;height:100%;border:none;">
					</span>
					<div  class="gongsiming">
						<div class="qukuailian_text" style="margin-bottom: 26%;">
							<p><span>浦发银行股份有限公司</span></p>
							<p><span>马卫希望获得您的联系电话</span></p>
						</div>
						<div class="shouquan yi" style="background: url(img/jujue-but.png) no-repeat;background-size: 100%;position:absolute;left:-1rem;">
						  拒绝查看
						</div>
						<div class="shouquan wei">同意查看</div>
					</div>
				</div>
				<div class="qukuailian_list">
					<span class="touxiang" 
					style="width:2.4rem;height:2.4rem;
					background:url(img/weizhitouxiang-icon.png) no-repeat;
					margin:0.6rem;
					background-size: 100% 100%;-webkit-background-size: 100% 100%;-ms-background-size: 100% 100%;-o-background-size: 100% 100%;-moz-background-size: 100% 100%;
					">
					  <img src="" style="width:100%;height:100%;border:none;">
					</span>
					<div  class="gongsiming">
						<div class="qukuailian_text" style="margin-bottom: 26%;">
							<p><span>浦发银行股份有限公司</span></p>
							<p><span>马卫希望获得您的联系电话</span></p>
						</div>
						<div class="shouquan yi" style="background: url(img/jujue-but.png) no-repeat;background-size: 100%;position:absolute;left:-1rem;">
						  拒绝查看
						</div>
						<div class="shouquan wei">同意查看</div>
					</div>
				</div> -->
			</div>
	    </div>
	</div>

	<script src='<%=request.getContextPath()%>/js/qukuailian_weixin/js/rem.js'></script>
	<script src="<%=request.getContextPath()%>/js/qukuailian_weixin/js/jquery-1.11.3.min.js"></script> 
</body>
</html>