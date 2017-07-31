<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.css">
<script src="http://code.jquery.com/jquery-1.8.3.min.js"></script>
<script
	src="http://code.jquery.com/mobile/1.3.2/jquery.mobile-1.3.2.min.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>	
<script type="text/javascript">
function loginUser() {
	alert("aaa");
	getData();
}
function getData() {
	var username = document.getElementById("username").value;
	var password = document.getElementById("password").value;
	var xhr = createXmlHttpRequest();
	//alert(username + password);
	xhr.open("POST","http://1d6289976g.imwork.net/wx/fiveBookUser/login",false);
	xhr.onreadystatechange = function() {
		if(xhr.readyState==4&&xhr.status==200) {
			var resp = xhr.responseText;
			if(resp=="teacher") {
				 location.href ="http://1d6289976g.imwork.net/wx/manage.html";
			}else if(resp=="student"){
				 location.href ="http://1d6289976g.imwork.net/wx/studentManage.html";
			}else {
				document.getElementById("text").innerHTML="登录失败";
			}
		}
	}
	xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhr.send("username="+username + "&password=" + password);
}

function createXmlHttpRequest() {
	if(window.XMLHttpRequest) {
		//针对其他主流浏览器
		return new XMLHttpRequest();
	} else if(window.ActiveXObject) {
		//针对IE5和IE6
		return new ActiveXObject("Microsoft.XMLHTTP");
	} else {
		alert("你使用的浏览器不支持XMLHttpRequest，请换一个浏览器再试！");
		return null;
	}
}

</script>
</head>
<body>
	    <form name="loginForm" >
		<table cellpadding="0" cellspacing="0">
		<tr>
		<td>用户名:</td>
		<td><input type="text" name="username" id="username" placeholder="学员证号/工作证号/注册号"/></td>
		</tr>
		<tr>
		<td>密码:</td>
		<td><input type="password" name="password" id= "password"/></td>
		</tr>
		<tr>
		<td colspan="2"><input type="button" id="submit" value="开门进屋" onclick="getData()"/>
						
		</td>
		<td><h2 id="text"></h2></td>
		</tr>
		</table>
		</form>
</body>
</html>