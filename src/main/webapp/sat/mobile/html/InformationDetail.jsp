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
	<title id="satArticleTitle">${satArticle.title }</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/sat/assets/weui.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/sat/assets/jquery-weui.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/sat/assets/demos.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/sat/mobile/css/style.css">
	<script src="http://res.wx.qq.com/open/js/jweixin-1.1.0.js"> </script>
</head>
<body>
<div id="myparams" style="display: none">
	<span id="timestamp">${timestamp }</span>
	<span id="nonceStr">${nonceStr }</span>
	<span id="signature">${signature }</span>
	<span id="appId">${appId }</span>
</div>


<input type="text" id="mOpenid" hidden="true" value="${satUser.openid}">
<%-- <input type="text" id="articleOpenid" hidden="true" value="${satArticle.openid}"> --%>
<input type="text" id="satArticleImg" hidden="true" value="${satArticle.descImgUrl}">
<input type="text" id="satArticleId" hidden="true" value="${satArticle.id}">

	<div class="sat_content">
		<div class="data_header">
			<div class="head_png weui_cell">
				<div class="weui_cell_hd"><img src="${satUser.imgUrl}" width="42" alt=""></div>
				<div class="weui_cell_bd weui_cell_primary">
					<p>修改头像</p>
					<p><a href="tel:${satUser.phoneNum}"><img src="<%=request.getContextPath()%>/sat/mobile/img/sat-dianhua-icon.png" width="20" style="padding-right:10px" alt=""></a><img src="<%=request.getContextPath()%>/sat/mobile/img/sat-dianhua-icon.png" width="20" style="padding-right:10px" alt=""><img src="<%=request.getContextPath()%>/sat/mobile/img/sat-dianhua-icon.png" width="20" style="padding-right:10px" alt=""></p>
				</div>
				<div class="weui_cell_ft sousuo"><img src="<%=request.getContextPath()%>/sat/mobile/img/huisesejiantou-icon.png" width="10" alt=""></div>
			</div>
			<div class="head_png shousuo">
				<div class="touxiang"><img src="${satUser.imgUrl}" width="42" alt=""></div>
				<div class="sousuo"><img src="<%=request.getContextPath()%>/sat/mobile/img/huisesejiantou-icon.png" width="9" alt=""></div>
			</div>
			<div class="data_main">
				<div class="main_guanggao"><img src="" alt="广告图"></div>
				<h1>${satArticle.title }</h1>
				<div class="sat_zhuanzai">
					<p>${satArticle.createTime }</p>
					<p>
						<img src="<%=request.getContextPath()%>/sat/mobile/img/dianzan-icon.png" width="20" alt=""><span>${satArticle.stars }</span>
						<img src="<%=request.getContextPath()%>/sat/mobile/img/fenxiang-icon.png" width="20" alt=""><span>${satArticle.shares }</span>
						<img src="<%=request.getContextPath()%>/sat/mobile/img/guanzhu-icon.png" width="20" alt=""><span>${satArticle.watches }</span>
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
					<span>
						<img src="<%=request.getContextPath()%>/sat/mobile/img/dianzan-but.png" width="65" alt="点赞">
					</span>
					<span>
						<img src="<%=request.getContextPath()%>/sat/mobile/img/dianzan-but.png" width="65" alt="收藏">
					</span>
				</div>
			</div>
				
		</div>
		<div class="data_footer">
			<div class="foot_png weui_cell">
				<div class="weui_cell_hd"><img src="${satUser.imgUrl}" width="35" alt=""></div>
				<div class="weui_cell_bd weui_cell_primary">
					<p>${satUser.organization}</p>
				</div>
				<div class="weui_cell_ft">
					<a><img src="<%=request.getContextPath()%>/sat/mobile/img/mingpian-dianhua-icon.png" width="34" alt=""></a>
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
	$(".sousuo").click(function(){
		$(this).parents(".head_png").hide();
		$(this).parents().siblings(".head_png").show();
	})
	
	jQuery(document).ready(function(){
		  //初始化库 
		 loadXMLDoc();
		 //初始化库结束
	});	 
	  //初始化 微信硬件jsapi库
	  function loadXMLDoc()
	  {
	      var appId =jQuery("#appId").text();
	      var timestamp=jQuery("#timestamp").text();
	      var nonceStr =jQuery("#nonceStr").text();
	      var signature=jQuery("#signature").text();
	      wx.config({
	               beta: true,
	                debug: false,// 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
	                appId: appId, 
	                timestamp: timestamp,
	                nonceStr: nonceStr,
	                signature: signature,
	                jsApiList: [
	                  'getWXDeviceUnbindTicket',
	                  'scanQRCode',
	                  'chooseImage',
	                  'onMenuShareAppMessage',
	                  'onMenuShareTimeline', 
	                  'onMenuShareQQ'
	                ]
	            });
	               //alert("初始化库结束");
	  }
	  
	  var infoTitle = $("#satArticleTitle").html();
	  var infoSummary = infoTitle;
	  var currUrl = window.location.href;
	  var iconUrl = $("#satArticleImg").attr("src");
	  var openid = $("#openid").val();//原来的openid
	  var mOpenid = $("#mOpenid").val();//我的openid
	  var articleOpenid = $("#articleOpenid").val();
	  var articleId = $("#satArticleId").val();
	  
	  wx.ready(function () {
		    //描述和图片需要重新定义，描述取正文的第一段文字，没有文字则为空
		    //图片取正文第一张图片；没有图片用默认的图片；
		    //alert(infoTitle + "　infoSummary　" +infoSummary + " currUrl " + currUrl);
			wx.onMenuShareAppMessage({
		    	title: infoTitle,
			    desc: infoSummary,
			    link: currUrl,
			    imgUrl: iconUrl,
			    trigger: function (res) {
			    	alert("分享");
			    },
			    success: function (res) {
			        alert('已分享22');
			        updateShareCnt();
			        //Toast_msg("分享成功",2000);
			    },
			    cancel: function (res) {
			        //alert('已取消');
			    },
			    fail: function (res) {
			        alert("页面加载中，请稍候再试。");
			    }
		    });
		    wx.onMenuShareTimeline({
		        title: infoTitle, // 分享标题
		        link: currUrl, // 分享链接
		        imgUrl: iconUrl, // 分享图标
		        trigger: function (res) {
		        	
		 	    },
		        success: function () {  
		        	alert("分享成功");
		        },
		        cancel: function (res) {
			        alert('已取消');
			    },
			    fail: function (res) {
			        alert("页面加载中，请稍候再试。");
			    }     
		    });
		    
		    wx.onMenuShareQQ({
		    	title: infoTitle, // 分享标题
				desc: infoSummary, // 分享描述
				link: currUrl + '&isQQShare=true', // 分享链接
				imgUrl: iconUrl, // 分享图标
				success: function () { 
					alert("分享成功");
				},
				cancel: function () { 
				     // 用户取消分享后执行的回调函数
					alert('已取消');
				}
			});
		}); 
	  
	  function updateShareCnt(){
			var url = "<%=request.getContextPath()%>/satarticle/updateUserShareCount";
			$.ajax({
				url : url,
				type : 'POST',
				dataType : 'json',
				async : true,
				data : {
					"articleId" : articleId,
					"openid" : mOpenid
				},
				success : function(data) {
					if(data.indexOf("success") > 0){
						alert("更新转发量成功");
					}else{
						alert("系统异常，更新转发量失败");
					}
				},
				error : function() {
					alert("网络连接异常");
				}
			});
		}
	</script>
</html>