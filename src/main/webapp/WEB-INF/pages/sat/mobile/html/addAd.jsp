<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
<body>

<input type="text" value="${openid }" hidden="true" id="openid">
	<div class="sat_content">
		
		<div class="sat_data guanggaoxq">
			<div class="sat_zhuanzai">
				<p>已有签名<span>${adSize}</span>/<i>3</i></p>
				<b onclick="setEdit()" id="editButton" >完成</b>
			</div>
			<div class="weui_cell">
				<div class="weui_cell_hd"><label class="weui_label">名称</label></div>
				<div class="weui_cell_bd weui_cell_primary">
					<input class="weui_input" type="text" placeholder="姓名" value="${ad.name }" id="name">
				</div>
			</div>
			<div class="weui_cell ">
				<div class="weui_cell_hd"><label for="name" class="weui_label">描述</label></div>
				<div class="weui_cell_bd weui_cell_primary article_cell">
					<textarea class="weui_textarea" placeholder="请输入文章标题最多不超过50个字" rows="5" id="description"></textarea>
					<div class="weui_textarea_counter"><span id="curLen">0</span>/300</div>
				</div>
			</div>
			<div class="weui_uploader">
				<div class="weui_uploader_hd weui_cell">
					<div class="weui_cell_bd">图片</div>
				</div>
				<div class="weui_uploader_bd">
					<img src="" height="112" width="274" alt="" id="image">
					<div class="weui_uploader_input_wrp">
						<input class="weui_uploader_input" type="file" accept="image/*" multiple="" >
					</div>
				</div>
			</div>
			<div class="weui_cell nobef">
				<div class="weui_cell_hd"><label class="weui_label">链接</label></div>
				<div class="weui_cell_bd weui_cell_primary">
					<input class="weui_input" type="tel" placeholder="手机号" value="" id="linkUrl">
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
		var openid = $("#openid").val();
	
	
		$(function() {
			FastClick.attach(document.body);
		});
		$("#description").bind('propertychange input', function () {  
	        var counter = $('#description').val().length;
	        if(counter < 300) {
		        $("#curLen").text(counter);
	        }else {
	        	$("#curLen").text(300);
	        	$('#description').val($('#description').val().substr(0,300));
	        }
	        //alert(counter);
	        //$('#tips var').text(300 - counter);    
		});
		
		function gotoadList() {
			window.location.href = "<%=request.getContextPath()%>/ad/list/" + openid;
		}
		
		function setEdit() {
			var text = $("#editButton").text();
			//点击完成
			//var adId = $("#adId").val().trim();
			var name = $("#name").val().trim();
			var description = $("#description").val().trim();
			var image = $("#image").attr("src").trim();
			var linkUrl = $("#linkUrl").val().trim();
			if(name != null && description != null && image != null && linkUrl != null
					&& name != "" && description != "" && image != "" && linkUrl !="") {
				var url = "<%=request.getContextPath()%>/ad/insert";
				$.ajax({
					url : url,
					type : 'POST',
					dataType : 'json',
					async : true,
					data : {
						"name" : name,
						"description" : description,
						"image" : image,
						"linkUrl" : linkUrl,
						"openid" : openid
					},
					success : function(data) {
						if(data.indexOf("success") > 0){
							gotoadList();
						} else {
							alert("新增失败");
						}
					},
					error : function() {
						//alert("网络连接异常");
					}
				});
			} else{
				alert("字段不能为空");
			}
		}
	</script>	
</html>