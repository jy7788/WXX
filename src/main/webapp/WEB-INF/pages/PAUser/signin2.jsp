<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0"/>
<script src="js/jquery.min.js" type="text/javascript"></script> <!--jquery必须库-->
    <script src="js/formValidator1/formValidator-4.0.1.min.js" type="text/javascript"></script> <!--表单验证必须库-->
    <script src="js/formValidator1/formValidatorRegex.js" type="text/javascript"></script> <!--表单验证扩展库-->
    <link href="js/formValidator1/style/validator.css" rel="stylesheet" type="text/css" /><!--表单验证样式表-->
<title>用户签到</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css" type="text/css"/>
<script type="text/javascript">
$(function(){
	 
    var ok1=false;
    var ok2=false;
    var ok3=false;
    var ok4=false;
    // 验证用户名
    $('input[name="phoneNum"]').focus(function(){
        $(this).next().text('用户名应该为3-20位之间').removeClass('state1').addClass('state2');
    }).blur(function(){
        if($(this).val().length >= 3 && $(this).val().length <=12 && $(this).val()!=''){
            $(this).next().text('输入成功').removeClass('state1').addClass('state4');
            ok1=true;
        }else{
            $(this).next().text('用户名应该为3-20位之间').removeClass('state1').addClass('state3');
        }
         
    });

    //提交按钮,所有验证通过方可提交
    $('#submit').click(function(){
    	alert("aaa");
        if(ok1){
            $('bindForm').submit();
        }else{
            return false;
        }
    });
     
});



function checkSubmitMobile() { 
	if ($("#phoneNum").val() == "") { 
	alert("手机号码不能为空！"); 
	//$("#moileMsg").html("<font color='red'>手机号码不能为空！</font>"); 
	$("#phoneNum").focus(); 
	return false; 
	} 

	if (!$("#phoneNum").val().match(/^(((13[0-9]{1})|159|153)+\d{8})$/)) { 
	alert("手机号码格式不正确！"); 
	//$("#moileMsg").html("<font color='red'>手机号码格式不正确！请重新输入！</font>"); 
	$("#phoneNum").focus(); 
	return false; 
	} 
	return true; 
	} 
</script>


</head>
<body>
<form name="bindForm" action="signin" method="post">
	<table cellpadding="0" cellspacing="0">
	<tr>
	<td>email:</td>
	<td><input type="text" name="email" id="email"/></td>
	</tr>
	<tr>
	<td>手机号:</td>
	<td><input type="text" name="phoneNum" id= "phoneNum"/></td>
	</tr>
	<c:choose>
		<c:when test="${mUser==null || mUser.bind==0}">
			<tr>
			<td colspan="2">
			<a href="javascript:;"><img class='submit' type='text' value="aaa"/></a>
			<!-- <input type="submit" id="submit" value="签到"/> -->
			</td>
			</tr>
		</c:when>
		<c:otherwise><tr><td>已经签到过了</td></tr></c:otherwise>
	</c:choose>
	</table>
</form>
</body>
</html>