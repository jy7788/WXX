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
		<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
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
		<meta name="format-detection" content="telephone=no" />
		<meta name="format-detection" content="email=no" />
		<title>顺易贷</title> 
		<link rel="stylesheet" href="<%=request.getContextPath()%>/erweima/css/erweima.css">
	</head>
	
<body>
	<div class="erweima_bd">
	
	     <div class="ewm_titlepng"></div>
	     
	     <p class="ewm_title">
	     	<span id="text_one">您的专属二维码</span>
	     	<br>
	     	<span id="text_two">即刻拥有!</span>
	     </p>
	     
	     <div class="ewm_w">
		      <div class="ewm_ipt">
		           <input class="ewm_tx" type="text" name ="phoneCode" placeholder="请输入您的手机号码" maxlength="11"/>
		           <span class="ewm_tip"><span class="ewm_tipimg"></span>请输入正确的手机号码</span>
		      </div>
		     <div class="ewm_btn">立即生成</div>
	     </div>
	     
		<div class="ewm_s">
			<div id="qrcode" class="qrcode"></div>
		</div>
	     
	</div>
	
	<script type="text/javascript" src='<%=request.getContextPath()%>/erweima/js/jquery.min.js'></script>
	<script type="text/javascript" src='<%=request.getContextPath()%>/erweima/js/rem.js'></script>
	<script type="text/javascript" src='./../static/js/ajax.post.js'></script>
	<script type="text/javascript" src='./../static/js/utils.js'></script>
	<script type="text/javascript" src='./../static/js/lib/qrcode.min.js'></script>
	<script type="text/javascript">
		//校验规则-手机号
		var phone_rules = /^[1][3578]\d{9}$/;
		var loan_h5_url = ajaxUtil.baseUrlPath+"shunyiloan_phone/shunyiloan.html";
		
		var qrcode = new QRCode(document.getElementById("qrcode"), {
			width:300,
			height:300
		});
		
		$(function(){
			//初始化
		});
	
		$('.ewm_btn').click(function () {
			$(".ewm_tip").hide();
			var phoneCode = $("input[name='phoneCode']").val();
			console.log(phoneCode);
			if (strUtil.isEmpty(phoneCode)||!phone_rules.test(phoneCode)) {
				$(".ewm_tip").show();//显示div  
	    		return false;
	    	}
			$(".ewm_w").hide();
			createQrcode(phoneCode);
			$("#text_one").text(phoneCode);
			$("#text_two").text("专属二维码已生成！");  
			$(".ewm_s").show();
		});

		function createQrcode(phoneCode){
			qrcode.clear();
			var textValue = loan_h5_url+'?sale='+phoneCode;//
        	console.log(textValue);
        	qrcode.makeCode(textValue);
	    };
		
	</script>
	
	
</body>
</html>