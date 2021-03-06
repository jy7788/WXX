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

<input type="text" value="${ad.id }" hidden="true" id="adId">
<input type="text" value="${ad.openid }" hidden="true" id="openid">
	<div class="sat_content">
		
		<div class="sat_data guanggaoxq">
			<div class="sat_zhuanzai">
				<p>已有签名<span>${adSize }</span>/<i>3</i></p>
				<b onclick="setEdit()" id="editButton" >编辑</b>
			</div>
			<div class="weui_cell">
				<div class="weui_cell_hd"><label class="weui_label">标题</label></div>
				<div class="weui_cell_bd weui_cell_primary">
					<input class="weui_input" type="text" placeholder="请输入广告标题" value="${ad.name }" readonly id="name">
				</div>
			</div>
			<div class="weui_cell ">
				<div class="weui_cell_hd"><label for="name" class="weui_label">描述</label></div>
				<div class="weui_cell_bd weui_cell_primary article_cell">
					<textarea class="weui_textarea" placeholder="请输入广告内容最多不超过150个字" readonly rows="5" id="description">${ad.description }</textarea>
					<div class="weui_textarea_counter"><span id="curLen">${fn:length(ad.description)}</span>/150</div>
				</div>
			</div>
			<div class="weui_uploader">
				<div class="weui_uploader_hd weui_cell">
					<div class="weui_cell_bd">图片</div>
				</div>
				<div class="weui_uploader_bd">
					<img src="${ad.imgUrl }" height="112" width="274" alt=""  id="image">
					<ul class="weui_uploader_files" id='img'></ul>
					<div class="weui_uploader_input_wrp">
						<!-- <input class="weui_uploader_input" type="file" accept="image/*" multiple="" readonly > -->
						<input class="weui_uploader_input" type="file" accept="image/*" id="headimgurl" onchange="previewImage(this)">
						<input  type="text" id="imageUrl" value="" hidden="true" />
					</div>
				</div>
			</div>
			<div class="weui_cell nobef">
				<div class="weui_cell_hd"><label class="weui_label">链接</label></div>
				<div class="weui_cell_bd weui_cell_primary">
					<input class="weui_input" type="tel" placeholder="请添加广告跳转网址" value="${ad.linkUrl }" readonly id="linkUrl">
				</div>
			</div>
		</div>
	</div>
</body>
	<script src="<%=request.getContextPath()%>/sat/assets/fastclick.js"></script>
	<script src='<%=request.getContextPath()%>/sat/assets/jquery.min.js'></script>
	<script src='<%=request.getContextPath()%>/sat/assets/jquery-weui.min.js'></script>
	<script src='<%=request.getContextPath()%>/sat/mobile/js/rem.js'></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/lrz/lrz.bundle.js"></script>
	<script>
		var openid = $("#openid").val();
		//上传图片预览
		function previewImage(file) {
		    var MAXWIDTH = 100;
		    var MAXHEIGHT = 200;
		    if (file.files && file.files[0]) {
		        var reader = new FileReader();
		        reader.onload = function (evt) {         
		            $("#image").attr("hidden", "true");
		            $('#img').html('<li class="weui_uploader_file" style="background-image:url('+evt.target.result+')"></li>');
		        };
		        reader.readAsDataURL(file.files[0]);//
		        
		        lrz(file.files[0], {width: 800})  
		        .then(function (rst) {  
		            var formData = new FormData();  
		            formData.append("file", rst.file);  
		            $.ajax({  
		                type: "POST",  
		                url: "<%=request.getContextPath()%>/ad/uploadImage/",  
		                data: formData,  
		                async: false,  
		                cache: false,  
		                contentType: false,  
		                processData: false,  
		                beforeSend: function (XMLHttpRequest) {  
		                    //showLoader();  
		                },  
		                success: function (data) {  
		  					//var dataObj=eval("("+data+")");
		  					if(data.indexOf("failed") > 0) {
		  						alert("图片上传失败");
		  					}else {
		  						alert("图片上传成功");
		  						$("#imageUrl").val(data);
		  						$("#image").attr("src",data);
		  						//$("#headimgurl").attr("style", "display:none");
		  						
		  					}
		                },  
		                complete: function (XMLHttpRequest, textStatus) {  
		                    //hideLoader();  
		                },  
		                error: function (XMLHttpRequest, textStatus, errorThrown) { //上传失败  
		                    //hideLoader();  
		                    alert('操作错误');  
		                }  
		            });  
		            return rst;  
		        });  
		        
		        console.log(file.files[0]);
		    }
		}
	
		$(function() {
			FastClick.attach(document.body);
		});
		$("#description").bind('propertychange input', function () {  
	        var counter = $('#description').val().length;
	        if(counter < 150) {
		        $("#curLen").text(counter);
	        }else {
	        	$("#curLen").text(150);
	        	$('#description').val($('#description').val().substr(0,150));
	        }
	        //alert(counter);
	        //$('#tips var').text(150 - counter);    
		});
		
		function gotoadList() {
			window.location = "<%=request.getContextPath()%>/ad/list/" + openid;
		}
		
		function setEdit() {
			var text = $("#editButton").text();
			//点击编辑
			if( $.trim(text) == "编辑") {
				$("#name").removeAttr("readonly");
				$("#description").removeAttr("readonly");
				$("#image").removeAttr("readonly");
				$("#linkUrl").removeAttr("readonly");
				$("#editButton").text("完成");
			}
			//点击完成
			if( $.trim(text) == "完成") {
				var adId = $("#adId").val().trim();
				var name = $("#name").val().trim();
				var description = $("#description").val().trim();
				var image = $("#image").attr("src").trim();
				var linkUrl = $("#linkUrl").val().trim();
				//alert(image + "adId " + "name " + name + "description " + description + "linkUrl " + linkUrl);
				if(!isNull(adId) && !isNull(name) && !isNull(description) && !isNull(image) && !isNull(linkUrl)) {
					var url = "<%=request.getContextPath()%>/ad/update";
					$.ajax({
						url : url,
						type : 'POST',
						dataType : 'json',
						async : true,
						data : {
							"adId" : adId,
							"name" : name,
							"description" : description,
							"image" : image,
							"linkUrl" : linkUrl,
							"openid" : $("#openid").val()
						},
						success : function(data) {
							if(data.indexOf("success") > 0){
								gotoadList();
							} else {
								var dataRole =$.parseJSON(data);
								DisplayNewsItems(dataRole);
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
		}
	</script>	
</html>