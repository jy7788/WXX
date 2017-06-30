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
<style>
a:link{
    color:#04013c;
}
</style>
<script type="text/javascript">
function showDialog(text, link) {
	$("#dialogText").html(text);
	$("#dialogMessage").html(link);
	$("#msgDialog").attr("style", "display:block;");
	$("#dialogMessage").click(function () {
		$("#msgDialog").attr("style", "");
   });
	$("#closeImg").click(function () {
		$("#msgDialog").attr("style", "");
   });
	
	
}

function clickBind(openid) {
	//alert(openid);
	$.ajax( {
	    url : "bindUser?" + "openid=" +  openid,
	    type : "GET", 
	    success : function(data) {
	        if(data != null) {
	        	if(data.indexOf("success") > 0) {
		        	//alert("绑定请求发送完成,等待对方接受。。。");
		        	showDialog("绑定请求发送完成,等待对方接受。。。", "确定");
	        	} else {
		        	//alert("已经发送过请求");
		        	showDialog("已经发送过请求", "确定");
	        	}
	        	//$("#bindUserDiv").css('display','none');
	        }
	    },
        error:function(e){
	    	//alert("发送失败");   
	    	showDialog("发送失败", "确定");
   		}  
	});
}
$(document).ready(function () {
	/* $("#dialogMessage").click() {
		//$("#msgDialog").hide();
	} */
});
</script>

</head>
<body>

<c:choose>
<c:when test="${ mUser == null }">
	<div class="alert" id="msgDialog" style="display:block;position:fixed;">
		<div class="alert_main">
			<a class="cuowu" id="closeImg"></a>
			<p class="text" id="dialogText">目前您还没有开通访问授权！<br>请您前去开通！</p>
			<p class="fangwen" id="dialogMessage"><a href="/pauser/signin">访问授权区块链</a></p>
		</div>
	</div>
</c:when>
<c:otherwise>
	<div class="alert" id="msgDialog" style="position:fixed;">
		<div class="alert_main">
			<a class="cuowu" id="closeImg"></a>
			<p class="text" id="dialogText">目前您还没有开通访问授权！<br>请您前去开通！</p>
			<p class="fangwen" id="dialogMessage">访问授权区块链</p>
		</div>
	</div>
</c:otherwise>
</c:choose>	
	<div class="qukuailian_bg"  style="width: 100%;height: 100%;overflow-y: scroll;overflow-x: hidden;">
	    
	    <div class="qukuailianlist_content" style="padding-top:0;">
		    <div>
		        <div class="qkl_title_lg" style="margin-bottom:6.5rem;">
			      <div class="qkl_title">
				       <span class="font_s1">区块链培训研讨会</span><br>
				       <span class="font_s2">签到处</span>
			       </div>
			       <div class="qkl_title_bg_circle"></div>
			       <div class="r_arr"></div>
			        <div class="l_arr"></div>	
			    </div>
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
							<div class="qukuailian_text" style="margin-bottom:20%">
								<p><span>${pAUser.organization}</span></p>
								<p><span>姓名: ${pAUser.username}<i></i></span><span>职位: ${pAUser.position }<i></i></span></p>
								
								<c:choose>
								<c:when test="${ pAUser.status == 1 }">
									<p><span>TEL: ${pAUser.phoneNum }</span></p>
								</c:when>
								<c:otherwise>
									<p><span>TEL: 授权通过后才能看到</span></p>
								</c:otherwise>
								</c:choose>	
								
								
								<!-- <p><span class="xiaosize">2017.02.23 18:09</span></p> -->
							</div>
							<%-- <div class="shouquan wei"><a href="bindUser/${pAUser.openid }">授权查看</a></div> --%>
							<c:choose>
								<c:when test="${ pAUser.status == 1 }">
									<div class="shouquan wei">已授权</a></div>
								</c:when>
								<c:otherwise>
									<div class="shouquan wei" name="bindUserDiv" id="bindUserDiv" onclick="clickBind('${pAUser.openid }')">授权查看</div>  
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