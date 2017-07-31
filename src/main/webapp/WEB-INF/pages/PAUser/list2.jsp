<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0"/>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css" type="text/css"/>
<title>用户列表</title>
</head>
<body>
<table width="900" align="center" border="1">


<c:choose>
	<c:when test="${mUser==null || mUser.bind==0}">
		<tr>
			<td>请进行<a href="/pauser/signin">签到</a>
		</td>
		</tr>
	</c:when>
	<c:otherwise>
	<tr>
	<td>ID</td><td>username</td><td>nickname</td><td>openid</td><td>status</td><td>头像</td>
	</tr>
	<tr><td>
		<c:forEach items="${PAUsers}" var="pAUser">
			<tr>
			<td>${pAUser.id }</td>
			<td>${pAUser.username }</td>
			<td>${pAUser.nickname}</td>
			<td>${pAUser.openid }</td>
			<td>${pAUser.status }</td>
			<td><img width="120" src="${pAUser.imgUrl }"></td>
			<c:choose>
				<c:when test="${ pAUser.status == 1 }">
					<td>
						<td>已绑定</a></td>
					</td>
				</c:when>
				<c:otherwise>
					<td>
						<a href="bindUser/${pAUser.openid }">绑定用户</a>&nbsp;
					</td>
				</c:otherwise>
			</c:choose>		
		</c:forEach>
	</td></tr></c:otherwise>
</c:choose>

</table>
</body>
</html>