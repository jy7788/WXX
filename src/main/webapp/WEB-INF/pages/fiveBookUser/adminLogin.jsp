<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</script>
</head>
<body>
	    <form name="loginForm" action="adminLogin" method="post">
		<table cellpadding="0" cellspacing="0">
		<tr>
		<td>用户名:</td>
		<td><input type="text" name="username" id="username"/></td>
		</tr>
		<tr>
		<td>密码:</td>
		<td><input type="password" name="password" id= "password"/></td>
		</tr>
		<tr>
		<td colspan="2"><input type="submit" id="submit" value="开门进屋"/>
		</td>
		</tr>
		</table>
		</form>
</body>
</html>