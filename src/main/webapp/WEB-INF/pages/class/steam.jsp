<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	 <title>接入微信JSSDK</title>
	<meta http-equiv="description" content="This is my page">
  <head>
  <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0;" name="viewport" />
    <script src="/wx/js/jquery/jquery.js"></script>
    <script src="/wx/js/zepto.js"></script>
	<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
	<script type="text/javascript">
	alert("aa");
	var hash = { name: 'zepto.js', size: 'micro' }
	$.each(hash, function(key, value){
	  console.log('aaaa%s: %s', key, value)
	})
	</script>
	<script type="text/javascript">
	$(function(){
		alert("enter");
		var appId=$("#appId").val();
		var nonceStr=$("#nonceStr").val();
		var timestamp=$("#timestamp").val();
		var signature=$("#signature").val();
				wx.config({
			      debug: true,
			      appId: appId,
			      timestamp: timestamp,
			      nonceStr: nonceStr,
			      signature: signature,
			      jsApiList: [
			        'checkJsApi',
			        'chooseImage'
			      	]
				  });	
		
		    //在这里写微信扫一扫的接口
		     $("#sao").bind("click",function(){
		    	 wx.chooseImage({
		    		    count: 9, // 默认9
		    		    sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
		    		    sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
		    		    success: function (res) {
		    		        var localIds = res.localIds; // 返回选定照片的本地ID列表，localId可以作为img标签的src属性显示图片
		    		    }
		    		});
		     
		     });
		}
		);
	wx.ready(function () {
  // 1 判断当前版本是否支持指定 JS 接口，支持批量判断
  alert("1230k"); 
    });
    
	 wx.error(function (res) {
	  alert(res.errMsg);
	});
</script>
</head>
<body>
<ul>
    <li>list item 1</li>
    <li>list item 2</li>
    <li>list item 3</li>
</ul>
<p>a paragraph</p>

<script type="text/javascript">
    $('li').add('p').css('background-color', 'red');
</script>

     <input type="button" id="sao" value="测试"/>
     <input id="appId"  type="hidden" value="${sign.appId }"/>
     <input id="url"  type="hidden" value="${sign.url}"/>
     <input id="tk"  type="hidden" value="${sign.jsapi_ticket }"/>     
	<input id="nonceStr" type="hidden" value="${sign.nonceStr }"/>
	<input id="timestamp" type="hidden" value="${sign.timestamp }"/>
	<input id="signature" type="hidden" value="${sign.signature }"/>
  </body>
</html>