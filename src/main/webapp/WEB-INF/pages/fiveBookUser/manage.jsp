<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师账户管理</title>
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
</head>
<body>
<body>

<div data-role="page" id="pageone">
  <div data-role="content">
    <h2>我的课堂</h2>
   	 <h4 >欢迎 ${fiveBookUser.nickname}</h4> 
    <ul data-role="listview" data-inset="true">
      <li><a href="#"><img src="" alt="" class="ui-li-icon">我的课件</a></li>
      <li><a href="#"><img src="" alt="" class="ui-li-icon">我的邮箱</a></li>
      <li><a href="#"><img src="" alt="" class="ui-li-icon">我的课时</a></li>
      <li><a href="#"><img src="" alt="" class="ui-li-icon">我的积分</a></li>
      <li><a href="#"><img src="" alt="" class="ui-li-icon">我的学生</a></li>
      <li><a href="#"><img src="" alt="" class="ui-li-icon">我的课堂</a></li>
      <li><a href="#"><img src="" alt="" class="ui-li-icon">我的游戏</a></li>
      <li><a href="#"><img src="" alt="" class="ui-li-icon">我的考勤</a></li>
      <li><a href="http://1d6289976g.imwork.net/wx/setting.html"><img src="" alt="" class="ui-li-icon">账户设置</a></li>
      <li><a href="#"><img src="" alt="" class="ui-li-icon">我的日记</a></li>
      <li><a href="#"><img src="" alt="" class="ui-li-icon">我的收藏</a></li>
    </ul>
  </div>
</div> 

</body>
</body>
</html>