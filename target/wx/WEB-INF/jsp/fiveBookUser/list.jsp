<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
</head>
<body>
<a href="add">添加用户</a>&nbsp;<a href="list">用户列表</a>&nbsp;<a href="<%=request.getContextPath() %>/weixinMenu/list">菜单列表</a>
<table width="900" align="center" border="1">
<tr>
<td>ID</td><td>username</td><td>nickname</td><td>openid</td><td>status</td><td>头像</td>
</tr>
<c:forEach items="${fiveBookUsers}" var="fiveBookUser">
	<tr>
	<td>${fiveBookUser.id }</td>
	<td>${fiveBookUser.username }[<a href="update/${fiveBookUser.id }">更新</a>&nbsp;<a href="delete/${fiveBookUser.id }">删除</a>]</td>
	<td>${fiveBookUser.nickname}</td>
	<td>${fiveBookUser.openId }</td>
	<td>${fiveBookUser.status }</td>
	<td><img width="120" src="${fiveBookUser.imgUrl }"/></td>
	</tr>
</c:forEach>
</table>
</body>
</html>