<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0"/>
<title>用户签到</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css" type="text/css"/>
</head>
<body>
<form name="bindForm" action="bind" method="post">
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
		<c:when test="${mUser==null}">
			<tr>
			<td colspan="2"><input type="submit" id="submit" value="签到"/>
			</td>
			</tr>
		</c:when>
		<c:otherwise><tr><td>已经签到过了</td></tr></c:otherwise>
	</c:choose>
	</table>
</form>
</body>
</html>