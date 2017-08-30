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
<input type="text" id="auth" hidden="true" value="${auth}">
<input type="text" id="canshare" hidden="true" value="${canshare}">
<input type="text" id="visitorOpenid" hidden="true" value="${visitorOpenid}">
	<div class="sat_content">
		
		<div class="data_header" >
			<div class="head_png weui_cell" style="display:none" >
				<div class="weui_cell_hd"><img src="${satUser.imgUrl}" width="42" alt=""></div>
				<div class="weui_cell_bd weui_cell_primary">
					<p>${satUser.username}</p>
					<p><a href="tel:${satUser.phoneNum}"><img src="<%=request.getContextPath()%>/sat/mobile/img/phone-icon.png"" width="25" style="padding-right:10px" alt=""></a>
					<img id="getQrCode" src="<%=request.getContextPath()%>/sat/mobile/img/weixin-icon.png" width="25" style="padding-right:10px" alt="" class="erwei">
					<img id="visitStation" src="<%=request.getContextPath()%>/sat/mobile/img/wodegerenzhongxin-icon.png" width="25" style="padding-right:10px" alt="">
					<b class="erweima show"><i></i><img id="gotQrCode" src=""></b>
					</p>						
				</div>
				<div class="weui_cell_ft sousuo"><img src="<%=request.getContextPath()%>/sat/mobile/img/arrow-icon.png" width="15" alt=""></div>
			</div>
			<div class="head_png shousuo" id="headDiv">
				<div class="touxiang"><img src="${satUser.imgUrl}" width="42" alt=""></div>
				<div class="sousuo"><img src="<%=request.getContextPath()%>/sat/mobile/img/002-arrow-icon.png" width="15" alt=""></div>
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
					<article>
					${satArticle.content }
					</article>
				</div>
				<div class="laiyuan">
					<p>（毒蛇姐原创）</p>
				</div>
				
				<div class="footer_guanggao" id="upAd" >
					<img id="upAdImg" src="<%=request.getContextPath()%>/sat/mobile/img/tupian.png" height="340" width="750" />
					<p id="upAdDescription">革决策部署上来，从服务党和国家工作大局出发推动改革，敢于担当</p>
				</div>
				
				<div class="main_foot">
					<span>
						<img src="<%=request.getContextPath()%>/sat/mobile/img/dianzan-but.png" width="65" alt="点赞" id="starButton">
					</span>
					<span>
						<img src="<%=request.getContextPath()%>/sat/mobile/img/shoucang-but.png" width="65" alt="收藏" id="collectButton">
					</span>
				</div>
			</div>
				
		</div>
		<div class="data_footer" id="buttomAd">
			<div class="foot_png weui_cell">
				<div class="weui_cell_hd"><img src="${satUser.imgUrl}" width="35" alt=""></div>
				<div class="weui_cell_bd weui_cell_primary">
					<p id="buttomDescription" style="text-align:center">添加广告</p>
				</div>
				<div class="weui_cell_ft">
					<a><img src="<%=request.getContextPath()%>/sat/mobile/img/xinwentupian-img.png" width="34" alt="" id="buttomImg"></a>
				</div>
			</div>
			<div class="xinjian_banner" id="newAd" onclick="showNewDiv()">
				<b ></b>
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
	                    <p>固定吸底</p>
	                </div>
	            </label>
	            <label class="weui_cell nobef weui_check_label" for="x13"> 
	                <div class="weui_cell_ft">
	                    <input type="radio" name="radio1" class="weui_check" id="x13" >
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
	
	//得到用户二维码
	$("#getQrCode").on("click",function(){
		$(".erweima").toggleClass('show');
		
		var url = "<%=request.getContextPath()%>/satuser/getUserQrCode";
		$.ajax({
			url : url,
			type : 'POST',
			dataType : 'json',
			async : true,
			data : {
				"openid" : mOpenid
			},
			success : function(data) {
				//alert(data);
				if(data.indexOf("failed") > 0){
					alert("尚未上传二维码");
				} else {
					$("#gotQrCode").attr("src", data);
				}
			},
			error : function() {
				//alert("网络连接异常");
			}
		});
	})
	
	  var infoTitle = $("#satArticleTitle").html();
	  var infoSummary = infoTitle;
	  var currUrl = window.location.href;
	  //var currUrl ;
	  var iconUrl = $("#satArticleImg").attr("src");
	  var openid = $("#openid").val();//原来的openid
	  var mOpenid = $("#mOpenid").val();//我的openid
	  var articleOpenid = $("#articleOpenid").val();
	  var articleId = $("#satArticleId").val();
	  var list;
	  var newName, newDescription, newImageUrl, newUrl,adId;
	  var auth, ad ,visitorOpenid,canshare;
	  var listLen = 0;
	  var adPosition, index, adImgUrl, adDescription;
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
	
	//收藏文章
	function collectArticle() {
		var url = "<%=request.getContextPath()%>/satarticle/collectArticle";
		$.ajax({
			url : url,
			type : 'POST',
			dataType : 'json',
			async : true,
			data : {
				"openid" : mOpenid,
				"articleId": articleId
			},
			success : function(data) {
				if(data.indexOf("success") > 0){
					//gotoadList();
					alert("收藏成功,在个人中心查看");
				} else if(data.indexOf("collected") > 0) {
					alert("收藏过了");
				} else {
					alert("收藏失败");
				}
			},
			error : function() {
				alert("网络连接异常");
			}
		});
	}
	
	//更新点赞
	function updateStar() {
		var url = "<%=request.getContextPath()%>/satarticle/starArticle";
		$.ajax({
			url : url,
			type : 'POST',
			dataType : 'json',
			async : true,
			data : {
				"articleId": articleId //只上传一个参数说明是原文章点赞
			},
			success : function(data) {
				if(data.indexOf("success") > 0){
					alert("成功点赞");
				} else if(data.indexOf("failed") > 0) {
					//alert("收藏过了");
				} else {
					//alert("收藏失败");
				}
			},
			error : function() {
				alert("网络连接异常");
			}
		});
	}
	//收藏点击
	$("#collectButton").click(function(){
		if(!isNull(mOpenid) && !isNull(articleId)) {
			collectArticle();
		}
	 });
	
	//点赞点击
	$("#starButton").click(function(){
		alert(articleId);
		if(!isNull(articleId)) {
			updateStar();
		}
	 });
	
	
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
		 auth=$("#auth").val();
		 canshare=$("#canshare").val();
		 //alert(canshare);
		 visitorOpenid = $("#visitorOpenid").val();
		 currUrl = "/satarticle/detail?id=" + articleId + "&openid=" + mOpenid;
		 if(isNull(mOpenid)) {
			 $("#headDiv").attr("style", "display:none");
		 }else {
			 $("#headDiv").attr("style", "display:block");
		 }
	});	 
	//置底，文章下面
	$("#x13").click(function(){
		$("#x11").removeAttr("checked");
		$("#x13").attr("checked", "checked");
	 });
	
	//吸底
	$("#x11").click(function(){
		$("#x13").removeAttr("checked");
		$("#x11").attr("checked", "checked");
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
		 index =  $("#select1").val();
		 //alert(list[index].imgUrl);
		 $("#imgDetail").attr("src", list[index].imgUrl);
		 adId = list[index].id;
		 $("#buttomImg").attr("src", list[index].imgUrl);
		 $("#buttomDescription").text(list[index].description);
		 adImgUrl = list[index].imgUrl;
		 adDescription = list[index].description;
	 });
	
	//绑定广告
	$("#share").click(function(){
		//alert(adId);
		$("#adOuter").attr("style", "display:none");
		//currUrl = currUrl + "&adId=" + adId;
		//alert($("#x11").attr("checked"));
		//最下方
		if($("#x11").attr("checked") == "checked") {
			adPosition = "ad_buttom";
		}
		
		//文章下面
		 if($("#x13").attr("checked") == "checked") {
			adPosition = "ad_up";
			$("#upAd").show();
			$("#upAdImg").attr("src", adImgUrl);
			$("#upAdDescription").attr("src", adDescription);//文章下方的广告
		} 
	 });
	
	//新增广告分享按钮
	$("#share2").click(function(){
		//获取添加的数据
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
				if(data.indexOf("open") > 0){
					alert("广告添加成功");
					$("#adOuter").attr("style", "display:none");//显示广告
					$("#adListDiv").attr("style", "display:none");//显示广告列表
					ad =$.parseJSON(data);
					//alert(data);
					
					//$("#imgDetail").attr("src", ad.imgUrl);//设置第一个广告的图片
					//adId = ad.id;//当前广告id
					//底部广告
					//$("#buttomImg").attr("src", ad.imgUrl);
					//$("#buttomDescription").text(adId.description);
					showNewDiv();
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
		    //alert(currUrl);
			wx.onMenuShareAppMessage({
		    	title: infoTitle,
			    desc: infoSummary,
			    link: currUrl,
			    imgUrl: iconUrl,
			    trigger: function (res) {
			    	//alert("<input type='text' value='aaaa' >");
			    	if(canshare.indexOf("noshare") > 0) {
				    	  alert("正在进入注册，请取消分享");
						  window.location = "/satuser/registerShareUser?openid=" + visitorOpenid + "&articleId=" + articleId ;
					}
			    },
			    success: function (res) {
			    	alert(adPosition);
			        alert('已分享22');
			        updateShareCnt();
			        //Toast_msg("分享成功",2000);
			    },
			    cancel: function (res) {
			        //alert('已取消');
			    	alert('已取消');
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
		        	alert("分享time");
			    	alert(currUrl);
		 	    },
		        success: function () { 
		        	updateShareCnt();
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
	  //更新分享记录
	  function updateShareCnt(){
			var url = "<%=request.getContextPath()%>/satarticle/updateUserShareCount";
			//alert("adId " + adId);
			if(!isNull(articleId) && !isNull(mOpenid) && !isNull(adId)&& !isNull(adPosition)) {
				//alert(adId);
				$.ajax({
					url : url,
					type : 'POST',
					dataType : 'json',
					async : true,
					data : {
						"articleId" : articleId,
						"openid" : mOpenid,
						"adId" : adId,
						"adPosition" : adPosition
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
			} else {
				alert("请选择广告");
			}
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
					
					//没有注册进入注册页面
					if(canshare.indexOf("noshare") > 0) {
						  window.location = "/satuser/registerShareUser?openid=" + visitorOpenid + "&articleId=" + articleId ;
					  }
					
					if(data.indexOf("failed") > 0){
						//alert("获取不到广告");
						listLen = 0;
						$("#adOuter").attr("style", "display:block");//显示广告
						  $("#adNewDiv").attr("style", "display:block");
						  $("#adListDiv").attr("style", "display:none");
						//addAd();
					}else{
						list =$.parseJSON(data);
						console.log(list);
						$("#adOuter").attr("style", "display:block");//显示广告
						$("#adListDiv").attr("style", "display:block");//显示广告列表
						$("#adNewDiv").attr("style", "display:none");//新建广告层
						$("#select1").empty();//清空选择option内容
						//更新签名标题内容
						$.each(list, function(index, element) {
					    	$("#select1").append("<option value='" + index +"'>" + element.name + "</option>");
					    });  
						$("#imgDetail").attr("src", list[0].imgUrl);//设置第一个广告的图片
						adId = list[0].id;//当前广告id
						//底部广告
						$("#buttomImg").attr("src", list[0].imgUrl);
						$("#buttomDescription").text(list[0].description);
						
						//更新全局广告图片信息
						adImgUrl = list[0].imgUrl;
						adDescription = list[0].description;
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
		  //alert(listLen);
		  //尚未注册进入注册页面
		  if(canshare.indexOf("noshare") > 0) {
			  window.location = "/satuser/registerShareUser?openid=" + visitorOpenid + "&articleId=" + articleId ;
		  }
		  if(listLen != 0) {
		  	listLen = getJsonLength(list);
		  }
		  if(listLen < 3) {
			  $("#adOuter").attr("style", "display:block");//显示广告
			  $("#adNewDiv").attr("style", "display:block");
			  $("#adListDiv").attr("style", "display:none");
		  }else {
			  alert("广告位已满，无法添加");
		  }
	  }
	  //得到用户二维码
	  /* $("#getQrCode").click(function() {
		  
	  }); */
	  //访问微站
	  $("#visitStation").click(function() {
		  
	  });
	  
	  //判断能否转发，不能则进入注册页面
	  function setUserDir() {
		  /* if(auth.indexOf("unregistered") > 0) {
			  alert("unre" + auth);
			  window.location = "satuser/registerShareUser?openid=" + mOpenid + "&articleId=" + articleId ;
		  } */
	  }
	  
	  //判断用户是否注册过，没有注册过需要注册再发送广告
	  function isUserRegistered() {
		  var url = "<%=request.getContextPath()%>/satuser/isUserRegistered";
			if(!isNull(articleId) && !isNull(mOpenid) && !isNull(adId)) {
				$.ajax({
					url : url,
					type : 'POST',
					dataType : 'json',
					async : true,
					data : {
						"openid" : visitorOpenid
					},
					success : function(data) {
						if(data.indexOf("unregistered") > 0){
							alert("未注册,请注册后再转发");
						}else{
							alert("注册过");
						}
					},
					error : function() {
						alert("网络连接异常");
					}
				});
			} else {
				alert("请选择广告");
			}
	  }
	  
	</script>
</html>