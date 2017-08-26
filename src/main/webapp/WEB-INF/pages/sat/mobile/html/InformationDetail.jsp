<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=320,maximum-scale=1.3,user-scalable=no">
	<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
	<!--禁止ios设备将数字作为拨号连接，邮箱自动发送，点击地图跳转-->
	<meta name="format-detection" content="telephone=no,email=no,adress=no">
	<!--强制全屏显示-->
	<meta name="full-screen" content="yes">
	<!--开启对webapp的支持-->
	<meta name="apple-mobile-web-app-capable" content="yes">
	<!--web app应用下状态条(屏幕顶部条)的颜色,默认值为default(白色)-->
	<meta name="apple-mobile-web-app-status-bar-style" content="black-translucent">
	<!--禁止浏览器从缓存中访问页面内容-->
	<meta http-equiv="Pragma" content="no-cache">
	<meta name="format-detection" content="telephone=no"/>
	<meta name="format-detection" content="email=no"/>
	<title id="satArticleTitle">${satArticle.title }</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/sat/assets/weui.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/sat/assets/jquery-weui.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/sat/assets/demos.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/sat/mobile/css/style.css">
	<script src="http://res.wx.qq.com/open/js/jweixin-1.1.0.js"> </script>
</head>
<body>
<div id="myparams" style="display: none">
	<span id="timestamp">${timestamp }</span>
	<span id="nonceStr">${nonceStr }</span>
	<span id="signature">${signature }</span>
	<span id="appId">${appId }</span>
</div>


<input type="text" id="mOpenid" hidden="true" value="${satUser.openid}">
<%-- <input type="text" id="articleOpenid" hidden="true" value="${satArticle.openid}"> --%>
<input type="text" id="satArticleImg" hidden="true" value="${satArticle.descImgUrl}">
<input type="text" id="satArticleId" hidden="true" value="${satArticle.id}">

	<div class="sat_content">
		<div class="sat_zhuanzai">
			<p><span id="size"> </span><i></i></p>
			<b onclick="showNewDiv()">+新建</b>
		</div>
		<div class="data_header">
			<div class="head_png weui_cell">
				<div class="weui_cell_hd"><img src="${satUser.imgUrl}" width="42" alt=""></div>
				<div class="weui_cell_bd weui_cell_primary">
					<p>修改头像</p>
					<p><a href="tel:${satUser.phoneNum}"><img src="<%=request.getContextPath()%>/sat/mobile/img/sat-dianhua-icon.png" width="20" style="padding-right:10px" alt=""></a><img src="<%=request.getContextPath()%>/sat/mobile/img/sat-dianhua-icon.png" width="20" style="padding-right:10px" alt=""><img src="<%=request.getContextPath()%>/sat/mobile/img/sat-dianhua-icon.png" width="20" style="padding-right:10px" alt=""></p>
				</div>
				<div class="weui_cell_ft sousuo"><img src="<%=request.getContextPath()%>/sat/mobile/img/huisesejiantou-icon.png" width="10" alt=""></div>
			</div>
			<div class="head_png shousuo">
				<div class="touxiang"><img src="${satUser.imgUrl}" width="42" alt=""></div>
				<div class="sousuo"><img src="<%=request.getContextPath()%>/sat/mobile/img/huisesejiantou-icon.png" width="9" alt=""></div>
			</div>
			<div class="data_main">
				<div class="main_guanggao"><img src="" alt="广告图"></div>
				<h1>${satArticle.title }</h1>
				<div class="sat_zhuanzai">
					<p>${satArticle.createTime }</p>
					<p>
						<img src="<%=request.getContextPath()%>/sat/mobile/img/dianzan-icon.png" width="20" alt=""><span>${satArticle.stars }</span>
						<img src="<%=request.getContextPath()%>/sat/mobile/img/fenxiang-icon.png" width="20" alt=""><span>${satArticle.shares }</span>
						<img src="<%=request.getContextPath()%>/sat/mobile/img/guanzhu-icon.png" width="20" alt=""><span>${satArticle.watches }</span>
					</p>
				</div>
				<div class="main_cont">
					<!-- 新华社北京7月19日电 中共中央总书记、国家主席、中央军委主席、中央全面深化改革领导小组组长习近平7月19日下午主持召开中央全面深化改革领导小组第三十七次会议并发表重要讲话。他强调，各地区要切实把思想和行动统一到党中央改革决策部署上来，从服务党和国家工作大局出发推动改革，敢于担当、善谋实干、实事求是、锐意进取，扎实推进各项改革落到实处、见到成效。
					新华社北京7月19日电 中共中央总书记、国家主席、中央军委主席、中央全面深化改革领导小组组长习近平7月19日下午主持召开中央全面深化改革领导小组第三十七次会议并发表重要讲话。他强调，各地区要切实把思想和行动统一到党中央改革决策部署上来，从服务党和国家工作大局出发推动改革，敢于担当、善谋实干、实事求是、锐意进取，扎实推进各项改革落到实处、见到成效。
					新华社北京7月19日电 中共中央总书记、国家主席、中央军委主席、中央全面深化改革领导小组组长习近平7月19日下午主持召开中央全面深化改革领导小组第三十七次会议并发表重要讲话。他强调，各地区要切实把思想和行动统一到党中央改革决策部署上来，从服务党和国家工作大局出发推动改革，敢于担当、善谋实干、实事求是、锐意进取，扎实推进各项改革落到实处、见到成效。
					新华社北京7月19日电 中共中央总书记、国家主席、中央军委主席、中央全面深化改革领导小组组长习近平7月19日下午主持召开中央全面深化改革领导小组第三十七次会议并发表重要讲话。他强调，各地区要切实把思想和行动统一到党中央改革决策部署上来，从服务党和国家工作大局出发推动改革，敢于担当、善谋实干、实事求是、锐意进取，扎实推进各项改革落到实处、见到成效。 -->
					<article>
					${satArticle.content }
					</article>
				</div>
				<div class="laiyuan">
					<p>（毒蛇姐原创）</p>
				</div>
				<div class="main_foot">
					<span>
						<img src="<%=request.getContextPath()%>/sat/mobile/img/dianzan-but.png" width="65" alt="点赞">
					</span>
					<span>
						<img src="<%=request.getContextPath()%>/sat/mobile/img/dianzan-but.png" width="65" alt="收藏">
					</span>
				</div>
			</div>
				
		</div>
		<div class="data_footer">
			<div class="foot_png weui_cell">
				<div class="weui_cell_hd"><img src="${satUser.imgUrl}" width="35" alt=""></div>
				<div class="weui_cell_bd weui_cell_primary">
					<p>${satUser.organization}</p>
				</div>
				<div class="weui_cell_ft">
					<a><img src="<%=request.getContextPath()%>/sat/mobile/img/mingpian-dianhua-icon.png" width="34" alt=""></a>
				</div>
			</div>
		</div>
			
		<div class="sat_alert_details" style="display:none" id="adOuter">
		<div class="sat_xinjian" style="display:none" id="adNewDiv"> <!--style="display:none"-->
			<h5 class="sat_alert_h5">新建签名</h5>
			<div class="weui_cell nobef">
				<div class="weui_cell_bd weui_cell_primary">
					<input class="weui_input" type="text" id="newName" placeholder="请添加名称"> 
				</div>
			</div>
			<div class="weui_cell nobef">
				<div class="weui_cell_bd weui_cell_primary article_cell">
					<textarea class="weui_textarea" placeholder="请添加描述" rows="3" id="newDescription"></textarea>
					<div class="weui_textarea_counter"><span id="curLen"></span>/150</div>
				</div>
			</div>
			<div class="weui_uploader">
				<div class="weui_uploader_bd">
					<ul class="weui_uploader_files" id='img'></ul>
					<div class="weui_uploader_input_wrp">
						<input class="weui_uploader_input" type="file" accept="image/*" onchange="previewImage(this)">
						<input  type="text" id="imageUrl" value="" hidden="true" />
					</div>
				</div>
			</div>
			<div class="weui_cell nobef">
				<div class="weui_cell_bd weui_cell_primary">
					<input class="weui_input" type="text" placeholder="请添加上传路径" val="http://" id="newUrl">
				</div>
			</div>
				<div class="button_sp_area">
					<a class="weui_btn weui_btn_mini weui_btn_default" id="cancelEdit2">取消</a>
					<a class="weui_btn weui_btn_mini weui_btn_primary" id="share2">分享</a>
					
				</div>
		</div>
		<div class="sat_tianjia" id="adListDiv">
			<h5 class="sat_alert_h5">添加签名<span id="addAdButton" onclick="addAd()">+新建</span></h5>
			<div class="weui_cell nobef weui_cell_select">
                <div class="weui_cell_bd weui_cell_primary">
                    <select class="weui_select" name="select1" id="select1">
                        <option selected="" value="1" >理财通发行推广</option>
                        <option value="2">夏季上新折扣季</option>
                        <option value="3">夏季上新折扣季</option>
                    </select>
                </div>
            </div>
			<div class="weui_uploader">
				<div class="weui_uploader_bd">
					<ul class="weui_uploader_files" >
						<li>
							<img id="imgDetail" src="<%=request.getContextPath()%>/sat/mobile/img/tupian.png" height="112" width="274" alt="">
						</li>
					</ul>
				</div>
			</div>
			<div class="weui_cells weui_cells_radio">
	            <label class="weui_cell nobef weui_check_label" for="x11">
	                <div class="weui_cell_ft">
	                    <input type="radio" class="weui_check" name="radio1" id="x11" checked="checked">
	                    <span class="weui_icon_checked"></span>
	                </div>
	                <div class="weui_cell_bd weui_cell_primary">
	                    <p>固定吸顶</p>
	                </div>
	            </label>
	            <label class="weui_cell nobef weui_check_label" for="x13"> 
	                <div class="weui_cell_ft">
	                    <input type="radio" name="radio1" class="weui_check" id="x13">
	                    <span class="weui_icon_checked"></span>
	                </div>
	                <div class="weui_cell_bd weui_cell_primary">
	                    <p>置于文章底部</p>
	                </div>
	            </label>
	        </div>
			<div class="button_sp_area">
				<a class="weui_btn weui_btn_mini weui_btn_default" id="cancelEdit">取消</a>
				<a class="weui_btn weui_btn_mini weui_btn_primary" id="share">分享</a>
			</div>
		</div>
	</div>
	</div>
</body>
	<script src="<%=request.getContextPath()%>/sat/assets/fastclick.js"></script>
	<script src='<%=request.getContextPath()%>/sat/assets/jquery.min.js'></script>
	<script src='<%=request.getContextPath()%>/sat/assets/jquery-weui.min.js'></script>
	<script src='<%=request.getContextPath()%>/sat/mobile/js/rem.js'></script>
	<script src='<%=request.getContextPath()%>/js/base.js'></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/lrz/lrz.bundle.js"></script>
	<script>
	
	var infoTitle = $("#satArticleTitle").html();
	  var infoSummary = infoTitle;
	  var currUrl = window.location.href;
	  var iconUrl = $("#satArticleImg").attr("src");
	  var openid = $("#openid").val();//原来的openid
	  var mOpenid = $("#mOpenid").val();//我的openid
	  var articleOpenid = $("#articleOpenid").val();
	  var articleId = $("#satArticleId").val();
	  var list;
	  var newName, newDescription, newImageUrl, newUrl;
	
	//上传图片和预览
	function previewImage(file) {
	    var MAXWIDTH = 100;
	    var MAXHEIGHT = 200;
	    if (file.files && file.files[0]) {
	        var reader = new FileReader();
	        reader.onload = function (evt) {         
	            $('#img').html('<li class="weui_uploader_file" style="background-image:url('+evt.target.result+')"></li>');          
	        };
	        reader.readAsDataURL(file.files[0]);//
	        
	        lrz(file.files[0], {width: 800})  
	        .then(function (rst) {  
	            var formData = new FormData();  
	            formData.append("file", rst.file);  
	            $.ajax({  
	                type: "POST",  
	                url: "<%=request.getContextPath()%>/ad/uploadImage/",  
	                data: formData,  
	                async: false,  
	                cache: false,  
	                contentType: false,  
	                processData: false,  
	                beforeSend: function (XMLHttpRequest) {  
	                },  
	                success: function (data) {  
	  					if(data.indexOf("failed") > 0) {
	  						alert("图片上传失败");
	  					}else {
	  						alert("图片上传成功");
	  						$("#imageUrl").val(data);
	  					}
	                },  
	                complete: function (XMLHttpRequest, textStatus) {  
	                },  
	                error: function (XMLHttpRequest, textStatus, errorThrown) { //上传失败  
	                    alert('操作错误');  
	                }  
	            });  
	            return rst;  
	        });  
	        
	        console.log(file.files[0]);
	    }
	}
	
	
	$(function() {
		FastClick.attach(document.body);
	});
	$(".sousuo").click(function(){
		$(this).parents(".head_png").hide();
		$(this).parents().siblings(".head_png").show();
	})
	
	jQuery(document).ready(function(){
		  //初始化库 
		 loadXMLDoc();
		 //初始化库结束
	});	 
	
	//取消按钮
	$("#cancelEdit").click(function(){
		$("#adOuter").attr("style", "display:none");
	 });
	//取消按钮
	$("#cancelEdit2").click(function(){
		$("#adOuter").attr("style", "display:none");
	 });
	//选定广告标签更改事件
	$("#select1").change(function(){
		 var index =  $("#select1").val();
		 //alert(list[index].imgUrl);
		 $("#imgDetail").attr("src", list[index].imgUrl);
	 });
	//绑定广告
	$("#share").click(function(){
		
	 });
	//新增广告分享按钮
	$("#share2").click(function(){
		newName =$("#newName").val().trim(); 
		newDescription =$("#newDescription").val().trim(); 
		newImageUrl =$("#imageUrl").val().trim(); 
		newUrl =$("#newUrl").val().trim(); 
		if(!isNull(newName) && !isNull(newDescription) && 
				!isNull(newImageUrl) && !isNull(newUrl) && !isNull(mOpenid)) {
		//alert(newName + newDescription + newImageUrl + newUrl + mOpenid);
			uploadAd();
		} else {
			alert("字段不能为空");
		}
	 });
	//新增广告字数限制和统计
	$("#newDescription").bind('propertychange input', function () {  
        var counter = $('#newDescription').val().length;
        if(counter < 300) {
	        $("#curLen").text(counter);
        }else {
        	$("#curLen").text(300);
        	$('#newDescription').val($('#newDescription').val().substr(0,300));
        }
	});
	
	//上传广告
	function uploadAd() {
		var url = "<%=request.getContextPath()%>/ad/insert";
		$.ajax({
			url : url,
			type : 'POST',
			dataType : 'json',
			async : true,
			data : {
				"name" : newName,
				"description" : newDescription,
				"image" : newImageUrl,
				"linkUrl" : newUrl,
				"openid" : mOpenid
			},
			success : function(data) {
				if(data.indexOf("success") > 0){
					//gotoadList();
					alert("广告添加成功");
					$("#adOuter").attr("style", "display:none");//显示广告
					$("#adListDiv").attr("style", "display:none");//显示广告列表
				} else if(data.indexOf("full") > 0) {
					alert("广告位满了");
				} else {
					alert("新增失败");
				}
			},
			error : function() {
				alert("网络连接异常");
			}
		});
	}
	
	  //初始化 微信硬件jsapi库
	  function loadXMLDoc()
	  {
	      var appId =jQuery("#appId").text();
	      var timestamp=jQuery("#timestamp").text();
	      var nonceStr =jQuery("#nonceStr").text();
	      var signature=jQuery("#signature").text();
	      wx.config({
	               beta: true,
	                debug: false,// 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
	                appId: appId, 
	                timestamp: timestamp,
	                nonceStr: nonceStr,
	                signature: signature,
	                jsApiList: [
	                  'getWXDeviceUnbindTicket',
	                  'scanQRCode',
	                  'chooseImage',
	                  'onMenuShareAppMessage',
	                  'onMenuShareTimeline', 
	                  'onMenuShareQQ'
	                ]
	            });
	               //alert("初始化库结束");
	  }
	  
	  
	  wx.ready(function () {
		    //描述和图片需要重新定义，描述取正文的第一段文字，没有文字则为空
		    //图片取正文第一张图片；没有图片用默认的图片；
		    //alert(infoTitle + "　infoSummary　" +infoSummary + " currUrl " + currUrl);
			wx.onMenuShareAppMessage({
		    	title: infoTitle,
			    desc: infoSummary,
			    link: currUrl,
			    imgUrl: iconUrl,
			    trigger: function (res) {
			    	alert("分享");
			    },
			    success: function (res) {
			        alert('已分享22');
			        updateShareCnt();
			        //Toast_msg("分享成功",2000);
			    },
			    cancel: function (res) {
			        //alert('已取消');
			    },
			    fail: function (res) {
			        alert("页面加载中，请稍候再试。");
			    }
		    });
		    wx.onMenuShareTimeline({
		        title: infoTitle, // 分享标题
		        link: currUrl, // 分享链接
		        imgUrl: iconUrl, // 分享图标
		        trigger: function (res) {
		        	
		 	    },
		        success: function () {  
		        	alert("分享成功");
		        },
		        cancel: function (res) {
			        alert('已取消');
			    },
			    fail: function (res) {
			        alert("页面加载中，请稍候再试。");
			    }     
		    });
		    
		    wx.onMenuShareQQ({
		    	title: infoTitle, // 分享标题
				desc: infoSummary, // 分享描述
				link: currUrl + '&isQQShare=true', // 分享链接
				imgUrl: iconUrl, // 分享图标
				success: function () { 
					alert("分享成功");
				},
				cancel: function () { 
				     // 用户取消分享后执行的回调函数
					alert('已取消');
				}
			});
		}); 
	  
	  function updateShareCnt(){
			var url = "<%=request.getContextPath()%>/satarticle/updateUserShareCount";
			$.ajax({
				url : url,
				type : 'POST',
				dataType : 'json',
				async : true,
				data : {
					"articleId" : articleId,
					"openid" : mOpenid
				},
				success : function(data) {
					if(data.indexOf("success") > 0){
						alert("更新转发量成功");
					}else{
						alert("系统异常，更新转发量失败");
					}
				},
				error : function() {
					alert("网络连接异常");
				}
			});
		}
	  //显示并获取我的广告签名
	  function showNewDiv() {
		  var url = "<%=request.getContextPath()%>/ad/getUserAds";
		  //alert(mOpenid);
			$.ajax({
				url : url,
				type : 'POST',
				dataType : 'json',
				async : true,
				data : {
					"openid" : mOpenid
				},
				success : function(data) {
					if(data.indexOf("failed") > 0){
						alert("获取不到广告");
						
					}else{
						list =$.parseJSON(data);
						console.log(list);
						$("#adOuter").attr("style", "display:block");//显示广告
						$("#adListDiv").attr("style", "display:block");//显示广告列表
						$("#adNewDiv").attr("style", "display:none");//显示广告列表
						$("#select1").empty();//清空选择option内容
						//更新签名标题内容
						$.each(list, function(index, element) {
					    	$("#select1").append("<option value='" + index +"'>" + element.name + "</option>"); 
					    });  
						$("#imgDetail").attr("src", list[0].imgUrl);//设置第一个广告的图片
					}
				},
				error : function() {
					alert("网络连接异常");
				}
			});
	  }
	  //得到Json数组长度
	  function getJsonLength(jsonData){
		  var jsonLength = 0;
		  for(var item in jsonData){
		  	jsonLength++;
		  }
		  return jsonLength;
	  }
	  //显示新建签名层
	  function addAd() {
		  //alert(getJsonLength(list));
		  var listLen = getJsonLength(list);
		  if(listLen < 3) {
			  $("#adNewDiv").attr("style", "display:block");
			  $("#adListDiv").attr("style", "display:none");
		  }else {
			  alert("广告位已满，无法添加");
		  }
	  }
	  
	</script>
</html>