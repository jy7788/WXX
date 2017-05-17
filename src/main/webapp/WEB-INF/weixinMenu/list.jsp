<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
table.one
{
	table-layout:fixed ;
}
</style>
<a href="add">添加</a><a href="publish">发布</a>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<table width="900" border="1" class="one">
		<tr>
			<td>ID</td>
			<td>name</td>
			<td>key</td>
			<td width="500" style="word-wrap:break-word;">url</td>
			<td>content</td>
			<td>pid</td>
			<td>type</td>
			<td>respType</td>
		</tr>
		<c:forEach items="${menus}" var="menu">
			<tr>
				<td>${menu.id }</td>
				<td>${menu.name }[<a href="update/${menu.id }">更新</a>][<a
					href="delete/${menu.id}">删除</a>]
				</td>
				<td>${menu.menuKey }</td>
				<td width="500" style="word-wrap:break-word;">${menu.url }</td>
				<td>${menu.content }</td>
				<td>${menu.pid }</td>
				<td>${menu.type }</td>
				<td>${menu.respType }</td>
			</tr>
		</c:forEach>
	</table>

	<div>
		<c:forEach items="${wmds }" var="wmd">
			<div>
				${wmd.name }--->${wmd.type }-->${wmd.key }--->${wmd.id } <br />
				&nbsp;
				<c:forEach items="${wmd.sub_button }" var="sbm">
				${sbm.name }--->${sbm.type }-->${sbm.key }--->${sbm.id }
				<br />&nbsp;
			</c:forEach>
			</div>
		</c:forEach>
	</div>
</body>
</html>