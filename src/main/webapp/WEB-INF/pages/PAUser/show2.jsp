<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0"/>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css" type="text/css"/>
<title>用户${pAUser.username }</title>
</head>
<body>
<table width="900" align="center" border="1">
	<tr>
	<td>${pAUser.id }</td>
	<td>${pAUser.username }</td>
	<td>${pAUser.nickname}</td>
	<td>${pAUser.openid }</td>
	<td>${pAUser.status }</td>
	<td><img width="120" src="${pAUser.imgUrl }"/></td>
	</tr>
</table>
	<a href="/pauser/accept/${pAUser.openid }">接受</a>
</body>
</html>