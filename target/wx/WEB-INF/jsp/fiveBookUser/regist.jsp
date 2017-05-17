<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width,07.initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" />
<link rel="stylesheet"
	href="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.css">
<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
<script
	src="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>	
<script src="//cdn.bootcss.com/jquery.tablesorter/2.0.6/js/jquery.metadata.js"></script>	
<script src="../js/messages_zh.js" type="text/javascript"></script>
<!-- <script src="../js/ajax.js" type="text/javascript"></script> -->
<script>
$().ready(function() {
	
    $("#registForm").validate({
	    rules: {
    	  password: {
    		  required: true,
    	      minlength: 5
          },
          confirm_password: {
        	  required: true,
              minlength: 5,
              equalTo: "#password"
          },
          phoneNum : {
        	  digits: true
          }
	    },
      messages: {
        password: {
          required: "请输入密码",
          minlength: "密码长度不能小于 5 个字符"
        },
        confirm_password: {
          required: "请输入密码",
          minlength: "密码长度不能小于 5 个字符",
          equalTo: "两次密码输入不一致"
        },
        phoneNum : {
      	  digits: "只能输入数字"
        },
        email: "请输入一个正确的邮箱",
        agree: "请接受我们的声明",
        topic: "请选择两个主题"
      },
		submitHandler: function(form) {
			var formData = $('#registForm').serialize(); 
	        //.serialize() 方法创建以标准 URL 编码表示的文本字符串 
	        $.ajax({ 
	        	type : "POST", 
	            url  : "http://1d6289976g.imwork.net/wx/fiveBookUser/regist",  
	            cache : false, 
	            data : formData, 
	            success : function(data) {
		            	data = $.trim(data); //去掉前后空格 
			            $('#notification').text(data).append();
			            if(data==("success") ) {
			            	location.href ="http://1d6289976g.imwork.net/wx/registResultaa.html";
			            } else {
			            	$('#notification').text("注册失败").append(); 
			            }
	            }
	        }); 
		}
     });
});

/* function doSubmit() {
    $("#registForm").submit();
} */
</script>
</head>
<body>
	
	<div data-role="page" id="page1">
		<!--  page  -->

		<div data-role="header">
			<h1>五本书院</h1>
		</div>
		<!-- 頁眉 End  -->
		<br />
		<div >
			<h1>院士申请</h1>
		</div>
		<div data-role="fieldcontain" align="center">
		<form id="registForm" >
		  <fieldset data-role="controlgroup" data-type="horizontal">
	      <legend>性别：</legend>
	        <label for="male">男</label>
	        <input type="radio" name="sex" id="male" value="1">
	        <label for="female">女</label>
	        <input type="radio" name="sex" id="female" value="0">	
	      </fieldset>
	      <br/>
			<label for="label_account">申请账号</label>
	        <input type="text" name="username" id="username" placeholder="" required>
	        <br/>
	        <label for="label_nickname">昵称</label>
	        <input type="text" name="nickname" id="nickname" placeholder="最长不超过8个汉字" required maxlength="8" >
	        <br/>
	        <label for="label_email">安全邮箱</label>
	        <input type="text" name="email" id="email" class="email">
	        <br/>
	        <label for="label_phone_num">手机号码</label>
	        <input type="text" name="phoneNum" id="phoneNum" >
	        <br/>
	        <label for="label_birthday">出生日期</label>
	        <input type="date" name="birthday" id="birthday" >
	        
	        <fieldset data-role="fieldcontain" data-type="horizontal" >
	      	<label for="role">角色</label>
	      	<select name="role" id="role" required >
	      	 <option selected value=""></option>
		      <option value="2">学生</option>
		      <option value="1">教师</option>
		      <option value="3">院外访客</option>
		    </select>
	      	</fieldset>
	      	
	        <label for="label_password">密码</label>
	        <input type="password" name="password" id="password" placeholder="输入8至32位密码">
	        <br/>
	        <label for="label_birthday">确认密码</label>
	        <input type="password" name="confirm_password" id="confirm_password" placeholder="重复输入密码予确认" >
	        <br/> 
	        <%-- <a href="<%=request.getContextPath() %>/registResultaa.html" data-corners="false" data-role="button" data-ajax="false" >申请</a> --%>
	        <h3 id="notification"></h3>
	        <div data-role="dialog" id="dialog"></div>
	        <input id="submit" type="submit" data-inline="true" value="申请" >
	        <!-- <button id="submit" type="submit">提交</button> -->
	        </form>
		</div>
		<br />

		<div data-role="footer" class="ui-btn">
			<div data-role="controlgroup" data-type="horizontal">
				<a href="<%=request.getContextPath() %>/fiveBookUser/login" data-role="button" data-ajax="false">院士回家</a> 
				<a href="<%=request.getContextPath() %>/fiveBookUser/regist" data-corners="false" data-role="button" data-ajax="false">院外访客</a>
			</div>
		</div>
		</div>
		<!--page end -->
</div>
	  
		
</body>
</html>
