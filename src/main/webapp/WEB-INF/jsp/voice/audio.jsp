<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
session.setAttribute("basePath",basePath);
%>
<!DOCTYPE html>
<html class="ie"><!--<![endif]-->
<head>
<meta charset="utf-8">
  <title>微信语音识别</title>
  <style type="text/css">/*<![CDATA[*/
	body{margin:0;padding:0;font-family:Times New Roman, serif}
	p{margin:0;padding:0}
	html,body{
	    width:100%;
	    height:100%;
	}
	#map_container{height:100%; border: 1px solid #999;height:300px;}
	
	@media print{
	  #notes{display:none}
	  #map_container{margin:0}
	}
  /*]]>*/</style>
  
  <meta name="viewport" content="width=320.1,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no">
  
  <link rel="stylesheet" href="<%=basePath %>resource/device/weui.min.css?what=0">
  <script src="http://libs.baidu.com/jquery/2.0.0/jquery.js"></script>
  <script src="http://res.wx.qq.com/open/js/jweixin-1.1.0.js"> </script>
  <script type="text/javascript" src="js/base64.js"></script>
  <script src="http://api.map.baidu.com/api?v=2.0&ak=5oX8kCKjSuBebgQGEAe8M2mjWkcGHGyK" type="text/javascript"></script>
</head>
<body ontouchstart>
<!--标题行-->
<h2 style="color: white;background-color: green;text-align: center;background-position: center;">微信语音识别</h2>
  <div class="page">
    <div class="bd spacing">
        <div class="weui_cells weui_cells_form" hidden ="true">
                
            <div class="weui_cell">
                <div class="weui_cell_hd"><label class="weui_label" style="width: auto;">当前设备:&nbsp</label></div>
                <div class="weui_cell_bd weui_cell_primary">
                   <label id="lbdeviceid" class="weui_label" style="width: auto;"></label>
                </div>
            </div>
            <div class="weui_cell">
                <div class="weui_cell_hd"><label class="weui_label" style="width: auto;">状态信息:&nbsp</label></div>
                <div class="weui_cell_bd weui_cell_primary">
                    <label id="lbInfo" class="weui_label" style="width: auto;"></label>
                </div>
            </div> 
            <div class="weui_cell" >
                <div class="weui_cell_hd"><label class="weui_label">日志:  </label></div>
                <div class="weui_cell_bd weui_cell_primary">
                    <textarea id="logtext" class="weui_textarea" placeholder="日志" rows="5"></textarea>
                </div>
            </div>
  
        </div>
 
        <div class="weui_btn_area weui">
             
            <!-- <input type="text" value="115.159.194.138" id="ip" /> -->
            <button class="weui_btn weui_btn weui_btn_warn" id="CallGetWXrefresh" hidden ="true">获取设备</button><br>
            <button class="weui_btn  weui_btn_primary" id="icFuWei" >录音</button>
            <button class="weui_btn  weui_btn_primary" id="lightClose" >停止</button>
			<button class="weui_btn  weui_btn_primary" id="startScan" hidden="true">扫一扫</button>
  			<!-- <input type="text" value="connectStatus" id="connectStatus"/> -->
  			<label id="connectStatus" class="weui_label" style="width: auto;" hidden="true" >connectStatus</label>
        </div>
  
    </div>
 
    <div class="weui_dialog_alert" id="Mydialog" style="display: none;">
    <div class="weui_mask"></div>
    <div class="weui_dialog">
        <div class="weui_dialog_hd" id="dialogTitle"><strong class="weui_dialog_title">着急啦</strong></div>
        <div class="weui_dialog_bd" id="dialogContent">亲,使用本功能,请先打开手机蓝牙！</div>
        <div class="weui_dialog_ft">
            <a href="#" class="weui_btn_dialog primary">确定</a>
        </div>
    </div>
    </div>
     
     
    <!--BEGIN toast-->
    <div id="toast" style="display: none;">
        <div class="weui_mask_transparent"></div>
        <div class="weui_toast">
            <i class="weui_icon_toast"></i>
            <p class="weui_toast_content" id="toast_msg">已完成</p>
        </div>
    </div>
    <!--end toast-->
 
    <!-- loading toast -->
    <div id="loadingToast" class="weui_loading_toast" style="display:none;">
        <div class="weui_mask_transparent"></div>
        <div class="weui_toast">
            <div class="weui_loading">
                <div class="weui_loading_leaf weui_loading_leaf_0"></div>
                <div class="weui_loading_leaf weui_loading_leaf_1"></div>
                <div class="weui_loading_leaf weui_loading_leaf_2"></div>
                <div class="weui_loading_leaf weui_loading_leaf_3"></div>
                <div class="weui_loading_leaf weui_loading_leaf_4"></div>
                <div class="weui_loading_leaf weui_loading_leaf_5"></div>
                <div class="weui_loading_leaf weui_loading_leaf_6"></div>
                <div class="weui_loading_leaf weui_loading_leaf_7"></div>
                <div class="weui_loading_leaf weui_loading_leaf_8"></div>
                <div class="weui_loading_leaf weui_loading_leaf_9"></div>
                <div class="weui_loading_leaf weui_loading_leaf_10"></div>
                <div class="weui_loading_leaf weui_loading_leaf_11"></div>
            </div>
            <p class="weui_toast_content" id="loading_toast_msg">数据加载中</p>
        </div>
    </div>
    <!-- End loading toast -->
     
    <!--BEGIN dialog1-->
    <div class="weui_dialog_confirm" id="dialog1" style="display: none;">
        <div class="weui_mask"></div>
        <div class="weui_dialog">
            <div class="weui_dialog_hd"><strong class="weui_dialog_title">弹窗标题</strong></div>
            <div class="weui_dialog_bd">自定义弹窗内容，居左对齐显示，告知需要确认的信息等</div>
            <div class="weui_dialog_ft">
                <a href="javascript:;" class="weui_btn_dialog default" id="qxBtn">取消</a>
                <a href="javascript:;" class="weui_btn_dialog primary" id="okBtn">确定</a>
            </div>
        </div>
    </div>
    <!--END dialog1-->
    <!--BEGIN dialog2-->
    <div class="weui_dialog_alert" id="dialog2" style="display: none;">
        <div class="weui_mask"></div>
        <div class="weui_dialog">
            <div class="weui_dialog_hd"><strong class="weui_dialog_title">弹窗标题</strong></div>
            <div class="weui_dialog_bd">弹窗内容，告知当前页面信息等</div>
            <div class="weui_dialog_ft">
                <a href="javascript:;" class="weui_btn_dialog primary">确定</a>
            </div>
        </div>
    </div>
    <!--END dialog2-->
    
</div>
 
<div id="myparams" style="display: none">
 <span id="timestamp">${timestamp }</span>
 <span id="nonceStr">${nonceStr }</span>
 <span id="signature">${signature }</span>
 <span id="appId">${appId }</span>
  
</div>
 
</body> 
<script type="text/javascript">
 jQuery(document).ready(function(){
  //初始化库 
 loadXMLDoc();
 //初始化库结束
 //点击获取设备按钮的函数 开始
 $("#CallGetWXrefresh").on("click",function(e){  
     //1. 打开微信设备 
     my_openWXDeviceLib();
     //2. 获取设备信息
     my_getWXDeviceInfos();
     //3. 接收设备数据
     my_onReceiveDataFromWXDevice();
 });
 
 function callback(data) {
	 alert("success" + data);
    var resultObj = $("#logtext");
    resultObj.html(data);
 }
 //点击获取设备按钮的函数 结束 
  
 /***
   * 
   */
  $("#icFuWei").on("click",function(e){
	  wx.startRecord();
  });
 
  function BleSendMessage(Bytes) {
	  var x=senddataBytes(Bytes,C_DEVICEID);
      //alert(Bytes);
      if(x===0){$("#lbInfo").html('x.完成')}
      else {$("#lbInfo").html('x.查询失败')};
  }
  
  function SocketSendMessage(Bytes) {
	  
	  $.ajax({
	        type : "GET",
	        url : "/sendDeviceMessage",
	        data : "msg=" + Bytes,
	        dataType:"text",      
	        success : callback
	  }); 
  }
  
  function uploadData(blob)  {
		var url = "https://localhost/audio/upload";
	  	__log("uploadUrl " + url);
		//alert("uploadUrl " + url);
		var fd = new FormData();
		fd.append("audioData", blob);
		var xhr = new XMLHttpRequest();

		xhr.open("POST", url, true);
		xhr.onload = function () {   
		 alert(xhr.responseText);  
		 __log("result " + xhr.responseText);
		};   
		xhr.send(fd);
}
  
  $("#lightClose").on("click",function(e){
	  wx.stopRecord({
		    success: function (res) {
		        var localId = res.localId;
		        
		        wx.playVoice({
		            localId: localId // 需要播放的音频的本地ID，由stopRecord接口获得
		        });
		        
		        wx.translateVoice({
	        	   localId: localId, // 需要识别的音频的本地Id，由录音相关接口获得
	        	    isShowProgressTips: 1, // 默认为1，显示进度提示
	        	    complete: function (res) {
	        	    	if (res.hasOwnProperty('translateResult')) {
        	            	alert('识别结果：' + res.translateResult);
        	          	} else {
        	          		alert('无法识别');
        	          	}
	        	    }
	        	}); 
		        
		        /* wx.uploadVoice({
		            localId: localId, // 需要上传的音频的本地ID，由stopRecord接口获得
		            isShowProgressTips: 1, // 默认为1，显示进度提示
		                success: function (res) {
		                var serverId = res.serverId; // 返回音频的服务器端ID
		                wx.downloadVoice({
		                    serverId: serverId, // 需要下载的音频的服务器端ID，由uploadVoice接口获得
		                    isShowProgressTips: 1, // 默认为1，显示进度提示
		                    success: function (res) {
		                        var localId = res.localId; // 返回音频的本地ID
		                        alert("download " + localId);
		                    }
		                });
		            }
		        }); */
		    }
		});
  });
  function sendMessageOpen(Bytes) {
	  my_getWXDeviceInfos();
	  alert($("#connectStatus").html());
      if($("#connectStatus").html() == "connected" ) {
	     BleSendMessage(Bytes);
      } else {
     	 SocketSendMessage(Bytes + "open");
      }
  }
  
  function sendMessageClose(Bytes) {
	  my_getWXDeviceInfos();
	  alert($("#connectStatus").html());
      if($("#connectStatus").html() == "connected" ) {
	     BleSendMessage(Bytes);
      } else {
     	 SocketSendMessage(Bytes + "close");
      }
  }
  
  $('#startScan').on("click", function(e){
	  wx.scanQRCode({
		    needResult: 1, // 默认为0，扫描结果由微信处理，1则直接返回扫描结果，
		    scanType: ["qrCode","barCode"], // 可以指定扫二维码还是一维码，默认二者都有
		    success: function (res) {
		    	var result = res.resultStr; // 当needResult 为 1 时，扫码返回的结果
		   	 	//var resultObj = $("#logtext");
		    	//resultObj.html(result);	    
		    	sendMessage("mac-" + result);
	        }
	  });  
  });
   
 });
  
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
                'openWXDeviceLib',
                'closeWXDeviceLib',
                'getWXDeviceInfos',
                'getWXDeviceBindTicket',
                'getWXDeviceUnbindTicket',
                'scanQRCode',
                'startRecord',
                'stopRecord',
                'onVoiceRecordEnd',
                'playVoice',
                'pauseVoice',
                'stopVoice',
                'onVoicePlayEnd',
                'uploadVoice',
                'downloadVoice',
                'translateVoice'
              ]
          });
             alert("初始化库结束");
}
//判断调用jsapi返回状态 true表示成功
wx.error(function (res) {
  alert("调用微信jsapi返回的状态:"+res.errMsg);
});
 
/******************************分割线************************************************/
/*********************************************************
* 打开微信设备
* 作者：wxh 2016-04-04
* my_openWXDeviceLib
* 入口参数：无
* 出口参数：0表示打开成功；1表示打开失败
*********************************************************/
function my_openWXDeviceLib(){
   var x=0; 
   WeixinJSBridge.invoke('openWXDeviceLib', {}, 
   function(res){
       mlog("打开设备返回："+res.err_msg);
      if(res.err_msg=='openWXDeviceLib:ok')
        {
          if(res.bluetoothState=='off')
            {    
              showdialog("太着急啦","亲,使用前请先打开手机蓝牙！");  
              $("#lbInfo").innerHTML="1.请打开手机蓝牙";
              $("#lbInfo").css({color:"red"});
              x=1;
              isOver();
            };
          if(res.bluetoothState=='unauthorized')
            {
              showdialog("出错啦","亲,请授权微信蓝牙功能并打开蓝牙！");    
              $("#lbInfo").html("1.请授权蓝牙功能");
              $("#lbInfo").css({color:"red"});
              x=1;
              isOver();
            }; 
          if(res.bluetoothState=='on')
            {
              //showdialog("太着急啦","亲,请查看您的设备是否打开！");   
              $("#lbInfo").html("1.蓝牙已打开,未找到设备");
              $("#lbInfo").css({color:"red"});
              //$("#lbInfo").attr(("style", "background-color:#000");
              x=0;
              //isOver();
            };      
        }
      else
        {
          $("#lbInfo").html("1.微信蓝牙打开失败");
          x=1; 
          showdialog("微信蓝牙状态","亲,请授权微信蓝牙功能并打开蓝牙！");   
        }
    });
   return x;  //0表示成功 1表示失败
}
 
/**********************************************
* 取得微信设备信息
* 作者：2016-04-04
* my_getWXDeviceInfos
* 入口参数：无
* 出口参数：返回一个已经链接的设备的ID
**********************************************/
function my_getWXDeviceInfos(){
    
    WeixinJSBridge.invoke('getWXDeviceInfos', {}, function(res){
        var len=res.deviceInfos.length;  //绑定设备总数量
        for(i=0; i<=len-1;i++)
         {
           //alert(i + ' ' + res.deviceInfos[i].deviceId + ' ' +res.deviceInfos[i].state); 
           if(res.deviceInfos[i].state==="connected")
            {
              $("#lbdeviceid").html(res.deviceInfos[i].deviceId); 
              C_DEVICEID = res.deviceInfos[i].deviceId;
              $("#lbInfo").html("2.设备已成功连接");
              $("#lbInfo").css({color:"green"});
              $("#connectStatus").html("connected");
              break;   
            }  
         }
        //$("#connectStatus").html("disconnected");
    }); 
  return;    
}
//打印日志
function mlog(m){
    var log=$('#logtext').val();
    //log=log+m;
    log = m;
    $('#logtext').val(log);
}
 
/***************************************************************
 * 显示提示信息
***************************************************************/
function showdialog(DialogTitle,DialogContent){
   var $dialog = $("#Mydialog");
   $dialog.find("#dialogTitle").html(DialogTitle);
   $dialog.find("#dialogContent").html(DialogContent);
   $dialog.show();
   $dialog.find(".weui_btn_dialog").one("click", function(){
        $dialog.hide();
   });
}
 
 
/*******************************************************************
 * senddataBytes
 * author：fanfte
 * params：
 *     cmdBytes: 需要发送的命令字节
 *     selDeviceID: 选择的需要发送设备的ID 
 * return：
 *     return: 0 success；1 failed
 *     如果成功，则接收事件应该能够收到相应的数据
*******************************************************************/
function senddataBytes(cmdBytes,selDeviceID){
  //1. 如果输入的参数长度为零，则直接退出
  if(cmdBytes.length<=0){return 1};
 // alert("向微信发送指令数据");
  //1.1 如果设备ID为空，则直接返回
  if(selDeviceID.length<=0){return 1};
  //2. 发送数据
  var x=0;
  WeixinJSBridge.invoke('sendDataToWXDevice', {
            "deviceId":selDeviceID, 
            "base64Data":bytes_array_to_base64(cmdBytes)
            //"base64Data":"/s8AAQAMIAEAAAAA"
            }, function(res){
                //alert("向微信发送指令数据返回的状态"+res.err_msg);
            if(res.err_msg=='sendDataToWXDevice:ok')
               {
                 x=0;
                 alert("数据发送成功");
               }  
            else
               {
                 x=1; 
                 alert("数据发送失败");
               } 
        });  
  return x;      
}
 
/*********************************************************
* 接收到数据事件
* 
* my_onReceiveDataFromWXDevice
* 入口参数：无
* 出口参数：无
*********************************************************/ 
function my_onReceiveDataFromWXDevice(){
      
    WeixinJSBridge.on('onReceiveDataFromWXDevice', function(argv) {
     var unicode= BASE64.decoder(argv.base64Data);//返回会解码后的unicode码数组。
     alert(unicode);
    //mlog("接收的数据-->"+argv.base64Data);
    mlog("接收的数据-->"+argv.base64Data + unicode);
 });
}
 
function stringToBytes( str ) {  
	  var ch, st, re = [];  
	  for (var i = 0; i < str.length; i++ ) {  
	    ch = str.charCodeAt(i);  // get char   
	    st = [];                 // set up "stack"  
	    do {  
	      st.push( ch & 0xFF );  // push byte to stack  
	      ch = ch >> 8;          // shift value down by 1 byte  
	    }    
	    while ( ch );  
	    // add stack contents to result  
	    // done because chars have "wrong" endianness  
	    re = re.concat( st.reverse() );  
	  }  
	  // return an array of bytes  
	  return re;  
	} 
      
    function CheckBalance(){
     var Bytes=new Array();
        /* Bytes[0]=0x2A;
        Bytes[1]=0x00;
        Bytes[2]=0x1B;
        Bytes[3]=0xCF;
        Bytes[4]=0xFE; */
        Bytes[0]=0xFE;
        
        Bytes[1]=0xCF;
        Bytes[2]=0x1B;
          
        Bytes[3]=0x00;
        Bytes[4]=0x2A; 
       // Bytes[5]=0x00;
        //Bytes[6]=0x00; 
      return Bytes;
      
  }
    
    function CheckBalance2(){
        var Bytes=new Array();
         
           /* Bytes[0]=0x2A;
             
           Bytes[1]=0x00;
           Bytes[2]=0x1B;
             
           Bytes[3]=0xCF;
           Bytes[4]=0xFE; */
           Bytes[0]=0xFE;
           
           Bytes[1]=0xCF;
           Bytes[2]=0x1C;
             
           Bytes[3]=0x00;
           Bytes[4]=0x2D; 
          // Bytes[5]=0x00;
           //Bytes[6]=0x00; 
         return Bytes;
         
     }
   
  /**
 *  Byte数组转Base64字符,原理同上 
 * @Param [0x00,0x00]
 * @return Base64字符串
 **/
function bytes_array_to_base64(array) {
    if (array.length == 0) {
        return "";
    }
    var b64Chars = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/';
    var result = "";
    // 给末尾添加的字符,先计算出后面的字符
    var d3 = array.length % 3;
    var endChar = "";
    if (d3 == 1) {
        var value = array[array.length - 1];
        endChar = b64Chars.charAt(value >> 2);
        endChar += b64Chars.charAt((value << 4) & 0x3F);
        endChar += "==";
    } else if (d3 == 2) {
        var value1 = array[array.length - 2];
        var value2 = array[array.length - 1];
        endChar = b64Chars.charAt(value1 >> 2);
        endChar += b64Chars.charAt(((value1 << 4) & 0x3F) + (value2 >> 4));
        endChar += b64Chars.charAt((value2 << 2) & 0x3F);
        endChar += "=";
    }
  
    var times = array.length / 3;
    var startIndex = 0;
    // 开始计算
    for (var i = 0; i < times - (d3 == 0 ? 0 : 1); i++) {
        startIndex = i * 3;
  
        var S1 = array[startIndex + 0];
        var S2 = array[startIndex + 1];
        var S3 = array[startIndex + 2];
  
        var s1 = b64Chars.charAt(S1 >> 2);
        var s2 = b64Chars.charAt(((S1 << 4) & 0x3F) + (S2 >> 4));
        var s3 = b64Chars.charAt(((S2 & 0xF) << 2) + (S3 >> 6));
        var s4 = b64Chars.charAt(S3 & 0x3F);
        // 添加到结果字符串中
        result += (s1 + s2 + s3 + s4);
    }
  
    return result + endChar;
  }
  
  
</script>
</html>