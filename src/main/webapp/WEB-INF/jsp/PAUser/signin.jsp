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
<script src='<%=request.getContextPath()%>/js/qukuailian_weixin/js/rem.js'></script>
	<script src="<%=request.getContextPath()%>/js/qukuailian_weixin/js/jquery-1.11.3.min.js"></script> 
<link rel="stylesheet" href="<%=request.getContextPath()%>/js/qukuailian_weixin/css/style.css">
<style>
body{
  background:transparent;
}
a:link{
    color:#04013c;
}
</style>
<script type="text/javascript">
function GetJsonData() {
    var json = {
        "userNum": $("#phoneNum").val(),
        "verfType":"4"
    };
    return json;
}

$(document).ready(function () {
	//判断手机横竖屏状态：  
   	 window.addEventListener("onorientationchange" in window ? "orientationchange" : "resize", function() {  
            if (window.orientation === 90 || window.orientation === -90 ){   
                alert('请使用竖屏浏览，谢谢！');  
            }    
        }, false); 
	
     $("#submitButton").click(function () {
    	 var form = $("#bindForm");
    	 alert(form);
    	 var submitresult = $("#bindForm").submit();//提交
    	 alert(submitresult);
    }); 
     
    $("#validPhone").click(function () {
    	$.ajax( {
		    url : "valid?" + "phoneNum=" +  $("#phoneNum").val() + "&validCode=" + $("#dxyzm").val(),
		    type : "GET", 
		    success : function(msg) {
		    	if(msg.indexOf("success") > 0) {
		    		//alert("valid success");
		    		$("#bindForm").submit();
		    	}else {
		    		alert("验证码错误");
		    	}
		    },
	        error:function(e){
	   		}  
 		});
    }); 
        
    $("#checkButton").click(function () {
    	//alert(JSON.stringify(GetJsonData()));
	   	$.ajax({
	        /* type: "POST",
	        url: "http://smea.pingan.com.cn/smelp_core/a/customer/scf/customerInfo/getPhoneValidCode4json",
	        //contentType: "application/json; charset=utf-8",
	        //data: JSON.stringify(GetJsonData()),
	        data: "data=" + JSON.stringify(GetJsonData()),
	        //dataType: "json",
	        success: function (message) {
	            alert(message);
	        },
	        error: function (message) {
	            //$("#request-process-patent").html("提交数据失败！");
	        	alert(JSON.stringify(message));
	        },
	        complete:function(message) {
		    	alert(JSON.stringify(message));
		    } */
	   		url : "getYzm?" + "phoneNum=" +  $("#phoneNum").val(),
		    type : "GET", 
		    //dataType:"text",
		    //contentType:'application/json;charset=UTF-8',
		    //data:JSON.stringify({phoneNum:'1'}),
		    success : function(data) {
		        var obj = jQuery.parseJSON(data);
		        if(obj != null) {
		        	if(obj.organization != null) {
		        		$("#organization").val(obj.organization);
		        	}
		        	if(obj.username != null) {
		        		$("#username").val(obj.username);
		        	}
		        	if(obj.position != null) {
    		        	$("#position").val(obj.position);
		        	}
		        }
		    },
	        error:function(e){
		    	//alert("该手机号尚未绑定");   
	   		}  
	    });
   });
     
     $("#phoneNum").blur(function() {
    	 $.ajax( {
    		    url : "load?" + "phoneNum=" +  $("#phoneNum").val(),
    		    type : "GET", 
    		    //dataType:"text",
    		    //contentType:'application/json;charset=UTF-8',
    		    //data:JSON.stringify({phoneNum:'1'}),
    		    success : function(data) {
    		        var obj = jQuery.parseJSON(data);
    		        if(obj != null) {
    		        	if(obj.organization != null) {
    		        		$("#organization").val(obj.organization);
    		        	}
    		        	if(obj.username != null) {
    		        		$("#username").val(obj.username);
    		        	}
    		        	if(obj.position != null) {
	    		        	$("#position").val(obj.position);
    		        	}
    		        }
    		    },
    	        error:function(e){
    		    	//alert("该手机号尚未绑定");   
    	   		}  
     	});
     });
});
</script>
</head>
<body>
<input type="hidden" name="validId" value="" />
	<div class="qukuailian_bg" >
	    <div class="qkl_title_lg">
	      <div class="qkl_title">
		        <span class="font_s1">区块链培训研讨会</span><br>
		       <span class="font_s2">签到处</span>
	       </div>
	       <div class="qkl_title_bg_circle"></div>
	       <div class="r_arr"></div>
	        <div class="l_arr"></div>	
	    </div>
	    <div class="qkl_content" style="top:6.8rem;">
	       <!-- <div class="ipt_bg">
	          <select required="required">
	              <option>请选择所在机构</option>
	          </select>
	       </div> -->
	       <form name="bindForm" id="bindForm" action="signin" method="post" enctype="multipart/form-data">
	       <div class="ipt_bg">
	          <input type="text" name="phoneNum" id= "phoneNum" placeholder="请输入您的手机号码" required="required" autofocus="autofocus">
	          <span class="fdj" id="getMessage" name="getMessage"></span>
	       </div>
	       <div class="dxyzm_lr2">
	        <div class="ipt_bg">
	          <input class="dxyzm_l" id="dxyzm" type="text" placeholder="短信验证码" required="required" autofocus="autofocus">
	       </div>
	       <input class="dxyzm_r" id="checkButton" type="button" value="获取验证码">
	       </div>
	       <div class="ipt_bg">
	          <input type="text" name="organization" id= "organization" placeholder="所在机构" required="required" autofocus="autofocus">
	       </div>
	       <div class="ipt_bg">
	          <input type="text" name="username" id="username" placeholder="姓名" required="required">
	       </div>
	       <div class="ipt_bg">
	          <input type="text" name="position" id="position" placeholder="职位" required="required">
	       </div>
	       
	       <!-- <div class="dxyzm_lr2">
	        <div class="ipt_bg">
	          <input class="dxyzm_l" type="text" placeholder="短信验证码" required="required">
	       </div>
	       <input class="dxyzm_r" type="button" value="获取验证码">
	       </div> -->
	       <c:choose>
				<c:when test="${mUser==null || mUser.bind==0}">
					<td colspan="2">
					<!-- <input class="btn_tijiao_bg" type="submit" name="submit" value="签到"  style="border:0;margin-left:27%;"> -->
					<div class="btn_tijiao_bg" id="validPhone">提交</div>
				</c:when>
				<c:otherwise>
					<td colspan="2">
					<div class="btn_tijiao_bg" ><a href="gotolist">点击进入名单列表</a></div>
				</c:otherwise>
		   </c:choose>
	       </form>
	    </div>
	</div>
</body>

</html>