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
	<title>注册中心</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/sat/assets/weui.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/sat/assets/jquery-weui.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/sat/assets/demos.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/sat/mobile/css/style.css">
</head>
<body >

	<form id="userForm" action="regist" method="post" enctype="multipart/form-data">
	<input type="hidden" name="validId" value="" />
	<input type="hidden" name="imgUrl" value="" />
	<div class="sat_content">
		<div class="sat_login">
			<div class="login_header">
				<h1 class="login_h1">注册</h1>
			</div>
			<div class="login_main">
				<div class="sat_data">
					<div class="weui_cell nobef">
						<div class="weui_cell_hd login_icon"><label class="weui_label"> <img src="<%=request.getContextPath()%>/sat/mobile/img/xingming-icon.png" width="23" alt=""></label></div>
						<div class="weui_cell_bd weui_cell_primary">
							<input class="weui_input" type="tel" id="username" name="username" placeholder="您的姓名">
						</div>
					</div>
					<div class="weui_cell">
						<div class="weui_cell_hd login_icon"><label class="weui_label"> <img src="<%=request.getContextPath()%>/sat/mobile/img/dianhua-icon.png" width="23" alt=""></label></div>
						<div class="weui_cell_bd weui_cell_primary">
							<input class="weui_input" type="tel" id="phoneNum" name="phoneNum" placeholder="您的电话" value="">
						</div>
					</div>
					<div class="weui_cell" style="display:none">
						<div class="weui_cell_hd login_icon"><label for="name" class="weui_label"><img src="<%=request.getContextPath()%>/sat/mobile/img/hangye-icon.png" width="23" alt=""></label></div>
						<div class="weui_cell_bd weui_cell_primary"> 
							<input class="weui_input" id="job" id="trade" type="text" name="trade" value="" readonly="" data-values="" placeholder="您的行业">
						</div>
					</div>
					<div class="weui_cell" >
						<div class="weui_cell_hd login_icon"><label class="weui_label"> <img src="<%=request.getContextPath()%>/sat/mobile/img/qiye-icon.png" width="23" alt=""></label></div>
						<div class="weui_cell_bd weui_cell_primary">
							<input class="weui_input" type="tel" id="organization" name="organization" placeholder="您的公司名称" value="">
						</div>
					</div>
					<div class="weui_cell weui_vcode afterL" >
						<div class="weui_cell_hd login_icon"><label class="weui_label"><img src="<%=request.getContextPath()%>/sat/mobile/img/mima-icon.png" width="23" alt=""></label></div>
						<div class="weui_cell_bd weui_cell_primary">
							<input class="weui_input" type="number" id="validCode" name="validCode" placeholder="验证码">
						</div>
						<input type="button" class="weui_cell_ft" id="getValidCodeButton" value="获取验证码">
					</div>

					<div class="weui_cell weui_cells_checkbox nobef">
						<label class="weui_cell weui_check_label" for="s11" style="padding:0;">
							<div class="weui_cell_hd">
								<input type="checkbox" class="weui_check" name="checkbox1" id="s11" checked="checked">
								<i class="weui_icon_checked"></i>
							</div>
							<div class="weui_cell_bd weui_cell_primary">
								<p class="sat_chickboxtext">我同意《SAT用户使用协议》</p>
							</div>
						</label>
					</div>
 					<!--<a href="javascript:;" class="weui_btn weui_btn_primary sat_zhuce">注册</a> -->
					<input id="registButton" type="button" name="registButton" class="weui_btn weui_btn_primary sat_zhuce" value="注册"></a>
				</div>
			</div>
			<div class="login_footer">
				<img src="<%=request.getContextPath()%>/sat/mobile/img/dibu-img.png" width="320" alt="">
			</div>
		</div>
	</div>
	</form>
</body>
	<script src="<%=request.getContextPath()%>/sat/assets/fastclick.js"></script>
	<script src='<%=request.getContextPath()%>/sat/assets/jquery.min.js'></script>
	<script src='<%=request.getContextPath()%>/sat/assets/jquery-weui.min.js'></script>
	<script src="<%=request.getContextPath()%>/sat/assets/swiper.js"></script>
	<script src='<%=request.getContextPath()%>/sat/mobile/js/rem.js'></script>
	<script>
	//职业插件
      $("#job").select({
        title: "选择职业",
        items: ["金融/投资/证券", "保险", "银行", "互联网/电子商务", "房地产/建筑","微商/自营", "其他"],
        onChange: function(d) {
          console.log(this, d);
        },
        onClose: function() {
          console.log("close");
        },
        onOpen: function() {
          console.log("open");
        },
      });
	
      function checkPhoneNum() {
    		if($("#phoneNum").val().length != 11) {
    			return false;
    		}else {
    			return true;
    		}
    	}

    	function GetJsonData() {
    	    var json = {
    	        "userNum": $("#phoneNum").val(),
    	        "verfType":"4"
    	    };
    	    return json;
    	}

   		var wait=60;  
   		function time(o) { 
   	        if (wait == 0) {  
   	            o.val("获取验证码");  
   	         	$("#getValidCodeButton").attr("disabled", false);            
   	            wait = 60;  
   	        } else {  
   	            o.val("重新发送(" + wait + ")");  
   	         	$("#getValidCodeButton").attr("disabled", true);  
   	            wait--; 
   	            setTimeout(function() {  
   	                time(o)
   	            },  
   	            1000)
   	        }  
   	    } 
	    
    $(document).ready(function () {
    	//提交信息
	    $("#registButton").click(function () {
	    	
	    		if($("#organization").val() == "" || $("#username").val() == ""  
	    				|| $("#validCode").val() == "") {
	    			alert("请将信息填写完整");
	    		}else {
	    			$.ajax( {
	          		    url : "valid?" + "phoneNum=" +  $("#phoneNum").val() + "&validCode=" + $("#validCode").val(),
	          		    type : "GET", 
	          		    success : function(msg) {
	          		    	if(msg.indexOf("success") > 0) {
	          		    		$("#userForm").submit();
	          		    	}else {
	          		    		alert("验证码错误");
	          		    	}
	          		    },
	          	        error:function(e){
	          	   		}  
	           		});	
	    		}
	    }); 
	    
	    //获取验证码
	    $("#getValidCodeButton").click(function () {
	    	//alert(JSON.stringify(GetJsonData()));
	    	if(checkPhoneNum()) {
	    		if($("#phoneNum").val() != "") {
		    		$.ajax({
		    	   		url : "getYzm?" + "phoneNum=" +  $("#phoneNum").val(),
		    		    type : "GET", 
		    		    success : function(data) {
		    		        var obj = jQuery.parseJSON(data);
		    		        if(obj != null) {
		    		        	
		    		        }
		    		    },
		    	        error:function(e){
		    		    	//alert("该手机号尚未绑定");   
		    	   		}  
		    	    });
		    		time($("#getValidCodeButton"));
		    	}else {
		    		alert("手机号不能为空");
		    	}
	    	} else {
	    		alert("请输入正确手机号", "确定");
	    	}
	   });
    });
   		
	</script>