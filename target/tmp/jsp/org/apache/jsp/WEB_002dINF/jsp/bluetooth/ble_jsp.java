/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: jetty/9.2.8.v20150217
 * Generated at: 2017-06-12 12:20:14 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.bluetooth;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class ble_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/D:/maven/repository/jstl/jstl/1.2/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153356282000L));
    _jspx_dependants.put("file:/D:/maven/repository/jstl/jstl/1.2/jstl-1.2.jar", Long.valueOf(1463391026228L));
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\n');
      out.write('\n');

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
session.setAttribute("basePath",basePath);

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html class=\"ie\"><!--<![endif]-->\n");
      out.write("<head>\n");
      out.write("<meta charset=\"utf-8\">\n");
      out.write("  <title>微信蓝牙设备</title>\n");
      out.write("  <style type=\"text/css\">/*<![CDATA[*/\n");
      out.write("\tbody{margin:0;padding:0;font-family:Times New Roman, serif}\n");
      out.write("\tp{margin:0;padding:0}\n");
      out.write("\thtml,body{\n");
      out.write("\t    width:100%;\n");
      out.write("\t    height:100%;\n");
      out.write("\t}\n");
      out.write("\t#map_container{height:100%; border: 1px solid #999;height:300px;}\n");
      out.write("\t\n");
      out.write("\t@media print{\n");
      out.write("\t  #notes{display:none}\n");
      out.write("\t  #map_container{margin:0}\n");
      out.write("\t}\n");
      out.write("  /*]]>*/</style>\n");
      out.write("  \n");
      out.write("  <meta name=\"viewport\" content=\"width=320.1,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no\">\n");
      out.write("  \n");
      out.write("  <link rel=\"stylesheet\" href=\"");
      out.print(basePath );
      out.write("resource/device/weui.min.css?what=0\">\n");
      out.write("  <script src=\"http://libs.baidu.com/jquery/2.0.0/jquery.js\"></script>\n");
      out.write("  <script src=\"http://res.wx.qq.com/open/js/jweixin-1.1.0.js\"> </script>\n");
      out.write("  <script type=\"text/javascript\" src=\"js/base64.js\"></script>\n");
      out.write("  <script src=\"http://api.map.baidu.com/api?v=2.0&ak=5oX8kCKjSuBebgQGEAe8M2mjWkcGHGyK\" type=\"text/javascript\"></script>\n");
      out.write("</head>\n");
      out.write("<body ontouchstart>\n");
      out.write("<!--标题行-->\n");
      out.write("<h2 style=\"color: white;background-color: green;text-align: center;background-position: center;\">蓝牙设备</h2>\n");
      out.write("  <div class=\"page\">\n");
      out.write("    <div class=\"bd spacing\">\n");
      out.write("        <div class=\"weui_cells weui_cells_form\">\n");
      out.write("                \n");
      out.write("            <div class=\"weui_cell\">\n");
      out.write("                <div class=\"weui_cell_hd\"><label class=\"weui_label\" style=\"width: auto;\">当前设备:&nbsp</label></div>\n");
      out.write("                <div class=\"weui_cell_bd weui_cell_primary\">\n");
      out.write("                   <label id=\"lbdeviceid\" class=\"weui_label\" style=\"width: auto;\"></label>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"weui_cell\">\n");
      out.write("                <div class=\"weui_cell_hd\"><label class=\"weui_label\" style=\"width: auto;\">状态信息:&nbsp</label></div>\n");
      out.write("                <div class=\"weui_cell_bd weui_cell_primary\">\n");
      out.write("                    <label id=\"lbInfo\" class=\"weui_label\" style=\"width: auto;\"></label>\n");
      out.write("                </div>\n");
      out.write("            </div> \n");
      out.write("            <div class=\"weui_cell\" >\n");
      out.write("                <div class=\"weui_cell_hd\"><label class=\"weui_label\">日志:  </label></div>\n");
      out.write("                <div class=\"weui_cell_bd weui_cell_primary\">\n");
      out.write("                    <textarea id=\"logtext\" class=\"weui_textarea\" placeholder=\"日志\" rows=\"5\"></textarea>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("  \n");
      out.write("        </div>\n");
      out.write(" \n");
      out.write("        <div class=\"weui_btn_area weui\">\n");
      out.write("             \n");
      out.write("            <!-- <input type=\"text\" value=\"115.159.194.138\" id=\"ip\" /> -->\n");
      out.write("            <button class=\"weui_btn weui_btn weui_btn_warn\" id=\"CallGetWXrefresh\">获取设备</button><br>\n");
      out.write("            <button class=\"weui_btn  weui_btn_primary\" id=\"icFuWei\" >开灯</button>\n");
      out.write("            <button class=\"weui_btn  weui_btn_primary\" id=\"lightClose\" >关灯</button>\n");
      out.write("\t\t\t<button class=\"weui_btn  weui_btn_primary\" id=\"startScan\" >扫一扫</button>\n");
      out.write("  \t\t\t<!-- <input type=\"text\" value=\"connectStatus\" id=\"connectStatus\"/> -->\n");
      out.write("  \t\t\t<label id=\"connectStatus\" class=\"weui_label\" style=\"width: auto;\">connectStatus</label>\n");
      out.write("        </div>\n");
      out.write("  \n");
      out.write("    </div>\n");
      out.write(" \n");
      out.write("    <div class=\"weui_dialog_alert\" id=\"Mydialog\" style=\"display: none;\">\n");
      out.write("    <div class=\"weui_mask\"></div>\n");
      out.write("    <div class=\"weui_dialog\">\n");
      out.write("        <div class=\"weui_dialog_hd\" id=\"dialogTitle\"><strong class=\"weui_dialog_title\">着急啦</strong></div>\n");
      out.write("        <div class=\"weui_dialog_bd\" id=\"dialogContent\">亲,使用本功能,请先打开手机蓝牙！</div>\n");
      out.write("        <div class=\"weui_dialog_ft\">\n");
      out.write("            <a href=\"#\" class=\"weui_btn_dialog primary\">确定</a>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    </div>\n");
      out.write("     \n");
      out.write("     \n");
      out.write("    <!--BEGIN toast-->\n");
      out.write("    <div id=\"toast\" style=\"display: none;\">\n");
      out.write("        <div class=\"weui_mask_transparent\"></div>\n");
      out.write("        <div class=\"weui_toast\">\n");
      out.write("            <i class=\"weui_icon_toast\"></i>\n");
      out.write("            <p class=\"weui_toast_content\" id=\"toast_msg\">已完成</p>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <!--end toast-->\n");
      out.write(" \n");
      out.write("    <!-- loading toast -->\n");
      out.write("    <div id=\"loadingToast\" class=\"weui_loading_toast\" style=\"display:none;\">\n");
      out.write("        <div class=\"weui_mask_transparent\"></div>\n");
      out.write("        <div class=\"weui_toast\">\n");
      out.write("            <div class=\"weui_loading\">\n");
      out.write("                <div class=\"weui_loading_leaf weui_loading_leaf_0\"></div>\n");
      out.write("                <div class=\"weui_loading_leaf weui_loading_leaf_1\"></div>\n");
      out.write("                <div class=\"weui_loading_leaf weui_loading_leaf_2\"></div>\n");
      out.write("                <div class=\"weui_loading_leaf weui_loading_leaf_3\"></div>\n");
      out.write("                <div class=\"weui_loading_leaf weui_loading_leaf_4\"></div>\n");
      out.write("                <div class=\"weui_loading_leaf weui_loading_leaf_5\"></div>\n");
      out.write("                <div class=\"weui_loading_leaf weui_loading_leaf_6\"></div>\n");
      out.write("                <div class=\"weui_loading_leaf weui_loading_leaf_7\"></div>\n");
      out.write("                <div class=\"weui_loading_leaf weui_loading_leaf_8\"></div>\n");
      out.write("                <div class=\"weui_loading_leaf weui_loading_leaf_9\"></div>\n");
      out.write("                <div class=\"weui_loading_leaf weui_loading_leaf_10\"></div>\n");
      out.write("                <div class=\"weui_loading_leaf weui_loading_leaf_11\"></div>\n");
      out.write("            </div>\n");
      out.write("            <p class=\"weui_toast_content\" id=\"loading_toast_msg\">数据加载中</p>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <!-- End loading toast -->\n");
      out.write("     \n");
      out.write("    <!--BEGIN dialog1-->\n");
      out.write("    <div class=\"weui_dialog_confirm\" id=\"dialog1\" style=\"display: none;\">\n");
      out.write("        <div class=\"weui_mask\"></div>\n");
      out.write("        <div class=\"weui_dialog\">\n");
      out.write("            <div class=\"weui_dialog_hd\"><strong class=\"weui_dialog_title\">弹窗标题</strong></div>\n");
      out.write("            <div class=\"weui_dialog_bd\">自定义弹窗内容，居左对齐显示，告知需要确认的信息等</div>\n");
      out.write("            <div class=\"weui_dialog_ft\">\n");
      out.write("                <a href=\"javascript:;\" class=\"weui_btn_dialog default\" id=\"qxBtn\">取消</a>\n");
      out.write("                <a href=\"javascript:;\" class=\"weui_btn_dialog primary\" id=\"okBtn\">确定</a>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <!--END dialog1-->\n");
      out.write("    <!--BEGIN dialog2-->\n");
      out.write("    <div class=\"weui_dialog_alert\" id=\"dialog2\" style=\"display: none;\">\n");
      out.write("        <div class=\"weui_mask\"></div>\n");
      out.write("        <div class=\"weui_dialog\">\n");
      out.write("            <div class=\"weui_dialog_hd\"><strong class=\"weui_dialog_title\">弹窗标题</strong></div>\n");
      out.write("            <div class=\"weui_dialog_bd\">弹窗内容，告知当前页面信息等</div>\n");
      out.write("            <div class=\"weui_dialog_ft\">\n");
      out.write("                <a href=\"javascript:;\" class=\"weui_btn_dialog primary\">确定</a>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <!--END dialog2-->\n");
      out.write("    \n");
      out.write("    <!-- 百度地图 -->\n");
      out.write("    <div id=\"searchBox\"></div>\n");
      out.write("\t<div id=\"map_container\"></div>\n");
      out.write("\t<div id=\"test_container\">\n");
      out.write("\t检索类型\n");
      out.write("\t<select id=\"selectType\" name=\"\">\n");
      out.write("\t    <option value=\"1\">周边检索</option>\n");
      out.write("\t    <option value=\"2\">公交检索</option>\n");
      out.write("\t    <option value=\"3\">驾车检索</option>\n");
      out.write("\t    </select>\n");
      out.write("\t</div>\n");
      out.write("\t\n");
      out.write("\t<div id=\"allmap\"></div>\n");
      out.write("\t<div id=\"r-result\">\n");
      out.write("\t\t经度: <input id=\"longitude\" type=\"text\" style=\"width:100px; margin-right:10px;\" />\n");
      out.write("\t\t纬度: <input id=\"latitude\" type=\"text\" style=\"width:100px; margin-right:10px;\" />\n");
      out.write("\t\t<input type=\"button\" value=\"查询\" onclick=\"theLocation()\" />\n");
      out.write("\t</div>\n");
      out.write("</div>\n");
      out.write(" \n");
      out.write("<div id=\"myparams\" style=\"display: none\">\n");
      out.write(" <span id=\"timestamp\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${timestamp }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</span>\n");
      out.write(" <span id=\"nonceStr\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${nonceStr }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</span>\n");
      out.write(" <span id=\"signature\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${signature }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</span>\n");
      out.write(" <span id=\"appId\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${appId }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</span>\n");
      out.write("  \n");
      out.write("</div>\n");
      out.write(" \n");
      out.write("</body> \n");
      out.write("<script type=\"text/javascript\">\n");
      out.write(" jQuery(document).ready(function(){\n");
      out.write("  //初始化库 \n");
      out.write(" loadXMLDoc();\n");
      out.write(" //初始化库结束\n");
      out.write(" //点击获取设备按钮的函数 开始\n");
      out.write(" $(\"#CallGetWXrefresh\").on(\"click\",function(e){  \n");
      out.write("     //1. 打开微信设备 \n");
      out.write("     my_openWXDeviceLib();\n");
      out.write("     //2. 获取设备信息\n");
      out.write("     my_getWXDeviceInfos();\n");
      out.write("     //3. 接收设备数据\n");
      out.write("     my_onReceiveDataFromWXDevice();\n");
      out.write(" });\n");
      out.write(" \n");
      out.write("/*  $(\"#sendMessage\").on(\"click\", function(e) {\n");
      out.write("\t $.ajax({\n");
      out.write("        type : \"GET\",\n");
      out.write("        url : \"/sendDeviceMessage\",\n");
      out.write("        data : \"message=\" + \"msggg\",\n");
      out.write("        dataType : \"xml\",\n");
      out.write("        success : callback\n");
      out.write("     }); \n");
      out.write(" }); */\n");
      out.write(" \n");
      out.write(" function callback(data) {\n");
      out.write("\t alert(\"success\" + data);\n");
      out.write("    var resultObj = $(\"#logtext\");\n");
      out.write("    resultObj.html(data);\n");
      out.write(" }\n");
      out.write(" //点击获取设备按钮的函数 结束 \n");
      out.write("  \n");
      out.write(" /***\n");
      out.write("   * \n");
      out.write("   */\n");
      out.write("  $(\"#icFuWei\").on(\"click\",function(e){\n");
      out.write("         //alert(\"设备名称： \"+C_DEVICEID);\n");
      out.write("         var Bytes=CheckBalance();\n");
      out.write("         sendMessage(Bytes);\n");
      out.write("         /* var x=senddataBytes(Bytes,C_DEVICEID);\n");
      out.write("         //alert(Bytes);\n");
      out.write("         if(x===0){$(\"#lbInfo\").html('x.完成')}\n");
      out.write("         else {$(\"#lbInfo\").html('x.查询失败')}; */\n");
      out.write("  });\n");
      out.write(" \n");
      out.write("  function BleSendMessage(Bytes) {\n");
      out.write("\t  var x=senddataBytes(Bytes,C_DEVICEID);\n");
      out.write("      //alert(Bytes);\n");
      out.write("      if(x===0){$(\"#lbInfo\").html('x.完成')}\n");
      out.write("      else {$(\"#lbInfo\").html('x.查询失败')};\n");
      out.write("  }\n");
      out.write("  \n");
      out.write("  function SocketSendMessage(Bytes) {\n");
      out.write("\t  \n");
      out.write("\t  $.ajax({\n");
      out.write("\t        type : \"GET\",\n");
      out.write("\t        url : \"/sendDeviceMessage\",\n");
      out.write("\t        data : \"msg=\" + Bytes,\n");
      out.write("\t        dataType:\"text\",      \n");
      out.write("\t        success : callback\n");
      out.write("\t  }); \n");
      out.write("  }\n");
      out.write("  \n");
      out.write("  $(\"#lightClose\").on(\"click\",function(e){\n");
      out.write("      //alert(\"设备名称： \"+C_DEVICEID);\n");
      out.write("      var Bytes=CheckBalance2();\n");
      out.write("      sendMessage(Bytes);\n");
      out.write("  });\n");
      out.write("  function sendMessage(Bytes) {\n");
      out.write("\t  my_getWXDeviceInfos();\n");
      out.write("\t  alert($(\"#connectStatus\").html());\n");
      out.write("      if($(\"#connectStatus\").html() == \"connected\" ) {\n");
      out.write("\t     BleSendMessage(Bytes);\n");
      out.write("      } else {\n");
      out.write("     \t SocketSendMessage(Bytes);\n");
      out.write("      }\n");
      out.write("  }\n");
      out.write("  \n");
      out.write("  $('#startScan').on(\"click\", function(e){\n");
      out.write("\t  wx.scanQRCode({\n");
      out.write("\t\t    needResult: 1, // 默认为0，扫描结果由微信处理，1则直接返回扫描结果，\n");
      out.write("\t\t    scanType: [\"qrCode\",\"barCode\"], // 可以指定扫二维码还是一维码，默认二者都有\n");
      out.write("\t\t    success: function (res) {\n");
      out.write("\t\t    \tvar result = res.resultStr; // 当needResult 为 1 时，扫码返回的结果\n");
      out.write("\t\t   \t \t//var resultObj = $(\"#logtext\");\n");
      out.write("\t\t    \t//resultObj.html(result);\t    \n");
      out.write("\t\t    \tsendMessage(\"mac-\" + result);\n");
      out.write("\t        }\n");
      out.write("\t  });  \n");
      out.write("  });\n");
      out.write("   \n");
      out.write(" });\n");
      out.write("  \n");
      out.write(" //初始化 微信硬件jsapi库\n");
      out.write("function loadXMLDoc()\n");
      out.write("{\n");
      out.write("    var appId =jQuery(\"#appId\").text();\n");
      out.write("    var timestamp=jQuery(\"#timestamp\").text();\n");
      out.write("    var nonceStr =jQuery(\"#nonceStr\").text();\n");
      out.write("    var signature=jQuery(\"#signature\").text();\n");
      out.write("    wx.config({\n");
      out.write("             beta: true,\n");
      out.write("              debug: false,// 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。\n");
      out.write("              appId: appId, \n");
      out.write("              timestamp: timestamp,\n");
      out.write("              nonceStr: nonceStr,\n");
      out.write("              signature: signature,\n");
      out.write("              jsApiList: [\n");
      out.write("                'openWXDeviceLib',\n");
      out.write("                'closeWXDeviceLib',\n");
      out.write("                'getWXDeviceInfos',\n");
      out.write("                'getWXDeviceBindTicket',\n");
      out.write("                'getWXDeviceUnbindTicket',\n");
      out.write("                'startScanWXDevice',\n");
      out.write("                'stopScanWXDevice',\n");
      out.write("                'connectWXDevice',\n");
      out.write("                'disconnectWXDevice',\n");
      out.write("                'sendDataToWXDevice',\n");
      out.write("                'onWXDeviceBindStateChange',\n");
      out.write("                'onWXDeviceStateChange',\n");
      out.write("                'onScanWXDeviceResult',\n");
      out.write("                'onReceiveDataFromWXDevice',\n");
      out.write("                'onWXDeviceBluetoothStateChange',\n");
      out.write("                'scanQRCode'\n");
      out.write("              ]\n");
      out.write("          });\n");
      out.write("             alert(\"初始化库结束\");\n");
      out.write("}\n");
      out.write("//判断调用jsapi返回状态 true表示成功\n");
      out.write("wx.error(function (res) {\n");
      out.write("  alert(\"调用微信jsapi返回的状态:\"+res.errMsg);\n");
      out.write("});\n");
      out.write(" \n");
      out.write("/******************************分割线************************************************/\n");
      out.write("/*********************************************************\n");
      out.write("* 打开微信设备\n");
      out.write("* 作者：wxh 2016-04-04\n");
      out.write("* my_openWXDeviceLib\n");
      out.write("* 入口参数：无\n");
      out.write("* 出口参数：0表示打开成功；1表示打开失败\n");
      out.write("*********************************************************/\n");
      out.write("function my_openWXDeviceLib(){\n");
      out.write("   var x=0; \n");
      out.write("   WeixinJSBridge.invoke('openWXDeviceLib', {}, \n");
      out.write("   function(res){\n");
      out.write("       mlog(\"打开设备返回：\"+res.err_msg);\n");
      out.write("      if(res.err_msg=='openWXDeviceLib:ok')\n");
      out.write("        {\n");
      out.write("          if(res.bluetoothState=='off')\n");
      out.write("            {    \n");
      out.write("              showdialog(\"太着急啦\",\"亲,使用前请先打开手机蓝牙！\");  \n");
      out.write("              $(\"#lbInfo\").innerHTML=\"1.请打开手机蓝牙\";\n");
      out.write("              $(\"#lbInfo\").css({color:\"red\"});\n");
      out.write("              x=1;\n");
      out.write("              isOver();\n");
      out.write("            };\n");
      out.write("          if(res.bluetoothState=='unauthorized')\n");
      out.write("            {\n");
      out.write("              showdialog(\"出错啦\",\"亲,请授权微信蓝牙功能并打开蓝牙！\");    \n");
      out.write("              $(\"#lbInfo\").html(\"1.请授权蓝牙功能\");\n");
      out.write("              $(\"#lbInfo\").css({color:\"red\"});\n");
      out.write("              x=1;\n");
      out.write("              isOver();\n");
      out.write("            }; \n");
      out.write("          if(res.bluetoothState=='on')\n");
      out.write("            {\n");
      out.write("              //showdialog(\"太着急啦\",\"亲,请查看您的设备是否打开！\");   \n");
      out.write("              $(\"#lbInfo\").html(\"1.蓝牙已打开,未找到设备\");\n");
      out.write("              $(\"#lbInfo\").css({color:\"red\"});\n");
      out.write("              //$(\"#lbInfo\").attr((\"style\", \"background-color:#000\");\n");
      out.write("              x=0;\n");
      out.write("              //isOver();\n");
      out.write("            };      \n");
      out.write("        }\n");
      out.write("      else\n");
      out.write("        {\n");
      out.write("          $(\"#lbInfo\").html(\"1.微信蓝牙打开失败\");\n");
      out.write("          x=1; \n");
      out.write("          showdialog(\"微信蓝牙状态\",\"亲,请授权微信蓝牙功能并打开蓝牙！\");   \n");
      out.write("        }\n");
      out.write("    });\n");
      out.write("   return x;  //0表示成功 1表示失败\n");
      out.write("}\n");
      out.write(" \n");
      out.write("/**********************************************\n");
      out.write("* 取得微信设备信息\n");
      out.write("* 作者：2016-04-04\n");
      out.write("* my_getWXDeviceInfos\n");
      out.write("* 入口参数：无\n");
      out.write("* 出口参数：返回一个已经链接的设备的ID\n");
      out.write("**********************************************/\n");
      out.write("function my_getWXDeviceInfos(){\n");
      out.write("    \n");
      out.write("    WeixinJSBridge.invoke('getWXDeviceInfos', {}, function(res){\n");
      out.write("        var len=res.deviceInfos.length;  //绑定设备总数量\n");
      out.write("        for(i=0; i<=len-1;i++)\n");
      out.write("         {\n");
      out.write("           //alert(i + ' ' + res.deviceInfos[i].deviceId + ' ' +res.deviceInfos[i].state); \n");
      out.write("           if(res.deviceInfos[i].state===\"connected\")\n");
      out.write("            {\n");
      out.write("              $(\"#lbdeviceid\").html(res.deviceInfos[i].deviceId); \n");
      out.write("              C_DEVICEID = res.deviceInfos[i].deviceId;\n");
      out.write("              $(\"#lbInfo\").html(\"2.设备已成功连接\");\n");
      out.write("              $(\"#lbInfo\").css({color:\"green\"});\n");
      out.write("              $(\"#connectStatus\").html(\"connected\");\n");
      out.write("              break;   \n");
      out.write("            }  \n");
      out.write("         }\n");
      out.write("        //$(\"#connectStatus\").html(\"disconnected\");\n");
      out.write("    }); \n");
      out.write("  return;    \n");
      out.write("}\n");
      out.write("//打印日志\n");
      out.write("function mlog(m){\n");
      out.write("    var log=$('#logtext').val();\n");
      out.write("    //log=log+m;\n");
      out.write("    log = m;\n");
      out.write("    $('#logtext').val(log);\n");
      out.write("}\n");
      out.write(" \n");
      out.write("/***************************************************************\n");
      out.write(" * 显示提示信息\n");
      out.write("***************************************************************/\n");
      out.write("function showdialog(DialogTitle,DialogContent){\n");
      out.write("   var $dialog = $(\"#Mydialog\");\n");
      out.write("   $dialog.find(\"#dialogTitle\").html(DialogTitle);\n");
      out.write("   $dialog.find(\"#dialogContent\").html(DialogContent);\n");
      out.write("   $dialog.show();\n");
      out.write("   $dialog.find(\".weui_btn_dialog\").one(\"click\", function(){\n");
      out.write("        $dialog.hide();\n");
      out.write("   });\n");
      out.write("}\n");
      out.write(" \n");
      out.write(" \n");
      out.write("/*******************************************************************\n");
      out.write(" * 发送数据函数\n");
      out.write(" * 作者：V型知识库 www.vxzsk.com 2016-04-04\n");
      out.write(" * 入口参数：\n");
      out.write(" *     cmdBytes: 需要发送的命令字节\n");
      out.write(" *     selDeviceID: 选择的需要发送设备的ID \n");
      out.write(" * 出口参数：\n");
      out.write(" *     返回: 0表示发送成功；1表示发送失败\n");
      out.write(" *     如果成功，则接收事件应该能够收到相应的数据\n");
      out.write("*******************************************************************/\n");
      out.write("function senddataBytes(cmdBytes,selDeviceID){\n");
      out.write("  //1. 如果输入的参数长度为零，则直接退出\n");
      out.write("  if(cmdBytes.length<=0){return 1};\n");
      out.write(" // alert(\"向微信发送指令数据\");\n");
      out.write("  //1.1 如果设备ID为空，则直接返回\n");
      out.write("  if(selDeviceID.length<=0){return 1};\n");
      out.write("  //2. 发送数据\n");
      out.write("  var x=0;\n");
      out.write("  WeixinJSBridge.invoke('sendDataToWXDevice', {\n");
      out.write("            \"deviceId\":selDeviceID, \n");
      out.write("            \"base64Data\":bytes_array_to_base64(cmdBytes)\n");
      out.write("            //\"base64Data\":\"/s8AAQAMIAEAAAAA\"\n");
      out.write("            }, function(res){\n");
      out.write("                //alert(\"向微信发送指令数据返回的状态\"+res.err_msg);\n");
      out.write("            if(res.err_msg=='sendDataToWXDevice:ok')\n");
      out.write("               {\n");
      out.write("                 x=0;\n");
      out.write("                 alert(\"数据发送成功\");\n");
      out.write("               }  \n");
      out.write("            else\n");
      out.write("               {\n");
      out.write("                 x=1; \n");
      out.write("                 alert(\"数据发送失败\");\n");
      out.write("               } \n");
      out.write("        });  \n");
      out.write("  return x;      \n");
      out.write("}\n");
      out.write(" \n");
      out.write("/*********************************************************\n");
      out.write("* 接收到数据事件\n");
      out.write("* \n");
      out.write("* my_onReceiveDataFromWXDevice\n");
      out.write("* 入口参数：无\n");
      out.write("* 出口参数：无\n");
      out.write("*********************************************************/ \n");
      out.write("function my_onReceiveDataFromWXDevice(){\n");
      out.write("      \n");
      out.write("    WeixinJSBridge.on('onReceiveDataFromWXDevice', function(argv) {\n");
      out.write("     var unicode= BASE64.decoder(argv.base64Data);//返回会解码后的unicode码数组。\n");
      out.write("    //mlog(\"接收的数据-->\"+argv.base64Data);\n");
      out.write("    mlog(\"接收的数据-->\"+argv.base64Data + unicode);\n");
      out.write(" });\n");
      out.write("}\n");
      out.write(" \n");
      out.write("function stringToBytes( str ) {  \n");
      out.write("\t  var ch, st, re = [];  \n");
      out.write("\t  for (var i = 0; i < str.length; i++ ) {  \n");
      out.write("\t    ch = str.charCodeAt(i);  // get char   \n");
      out.write("\t    st = [];                 // set up \"stack\"  \n");
      out.write("\t    do {  \n");
      out.write("\t      st.push( ch & 0xFF );  // push byte to stack  \n");
      out.write("\t      ch = ch >> 8;          // shift value down by 1 byte  \n");
      out.write("\t    }    \n");
      out.write("\t    while ( ch );  \n");
      out.write("\t    // add stack contents to result  \n");
      out.write("\t    // done because chars have \"wrong\" endianness  \n");
      out.write("\t    re = re.concat( st.reverse() );  \n");
      out.write("\t  }  \n");
      out.write("\t  // return an array of bytes  \n");
      out.write("\t  return re;  \n");
      out.write("\t} \n");
      out.write("      \n");
      out.write("    function CheckBalance(){\n");
      out.write("     var Bytes=new Array();\n");
      out.write("        /* Bytes[0]=0x2A;\n");
      out.write("        Bytes[1]=0x00;\n");
      out.write("        Bytes[2]=0x1B;\n");
      out.write("        Bytes[3]=0xCF;\n");
      out.write("        Bytes[4]=0xFE; */\n");
      out.write("        Bytes[0]=0xFE;\n");
      out.write("        \n");
      out.write("        Bytes[1]=0xCF;\n");
      out.write("        Bytes[2]=0x1B;\n");
      out.write("          \n");
      out.write("        Bytes[3]=0x00;\n");
      out.write("        Bytes[4]=0x2A; \n");
      out.write("       // Bytes[5]=0x00;\n");
      out.write("        //Bytes[6]=0x00; \n");
      out.write("      return Bytes;\n");
      out.write("      \n");
      out.write("  }\n");
      out.write("    \n");
      out.write("    function CheckBalance2(){\n");
      out.write("        var Bytes=new Array();\n");
      out.write("         \n");
      out.write("           /* Bytes[0]=0x2A;\n");
      out.write("             \n");
      out.write("           Bytes[1]=0x00;\n");
      out.write("           Bytes[2]=0x1B;\n");
      out.write("             \n");
      out.write("           Bytes[3]=0xCF;\n");
      out.write("           Bytes[4]=0xFE; */\n");
      out.write("           Bytes[0]=0xFE;\n");
      out.write("           \n");
      out.write("           Bytes[1]=0xCF;\n");
      out.write("           Bytes[2]=0x1C;\n");
      out.write("             \n");
      out.write("           Bytes[3]=0x00;\n");
      out.write("           Bytes[4]=0x2D; \n");
      out.write("          // Bytes[5]=0x00;\n");
      out.write("           //Bytes[6]=0x00; \n");
      out.write("         return Bytes;\n");
      out.write("         \n");
      out.write("     }\n");
      out.write("   \n");
      out.write("  /**\n");
      out.write(" *  Byte数组转Base64字符,原理同上 \n");
      out.write(" * @Param [0x00,0x00]\n");
      out.write(" * @return Base64字符串\n");
      out.write(" **/\n");
      out.write("function bytes_array_to_base64(array) {\n");
      out.write("    if (array.length == 0) {\n");
      out.write("        return \"\";\n");
      out.write("    }\n");
      out.write("    var b64Chars = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/';\n");
      out.write("    var result = \"\";\n");
      out.write("    // 给末尾添加的字符,先计算出后面的字符\n");
      out.write("    var d3 = array.length % 3;\n");
      out.write("    var endChar = \"\";\n");
      out.write("    if (d3 == 1) {\n");
      out.write("        var value = array[array.length - 1];\n");
      out.write("        endChar = b64Chars.charAt(value >> 2);\n");
      out.write("        endChar += b64Chars.charAt((value << 4) & 0x3F);\n");
      out.write("        endChar += \"==\";\n");
      out.write("    } else if (d3 == 2) {\n");
      out.write("        var value1 = array[array.length - 2];\n");
      out.write("        var value2 = array[array.length - 1];\n");
      out.write("        endChar = b64Chars.charAt(value1 >> 2);\n");
      out.write("        endChar += b64Chars.charAt(((value1 << 4) & 0x3F) + (value2 >> 4));\n");
      out.write("        endChar += b64Chars.charAt((value2 << 2) & 0x3F);\n");
      out.write("        endChar += \"=\";\n");
      out.write("    }\n");
      out.write("  \n");
      out.write("    var times = array.length / 3;\n");
      out.write("    var startIndex = 0;\n");
      out.write("    // 开始计算\n");
      out.write("    for (var i = 0; i < times - (d3 == 0 ? 0 : 1); i++) {\n");
      out.write("        startIndex = i * 3;\n");
      out.write("  \n");
      out.write("        var S1 = array[startIndex + 0];\n");
      out.write("        var S2 = array[startIndex + 1];\n");
      out.write("        var S3 = array[startIndex + 2];\n");
      out.write("  \n");
      out.write("        var s1 = b64Chars.charAt(S1 >> 2);\n");
      out.write("        var s2 = b64Chars.charAt(((S1 << 4) & 0x3F) + (S2 >> 4));\n");
      out.write("        var s3 = b64Chars.charAt(((S2 & 0xF) << 2) + (S3 >> 6));\n");
      out.write("        var s4 = b64Chars.charAt(S3 & 0x3F);\n");
      out.write("        // 添加到结果字符串中\n");
      out.write("        result += (s1 + s2 + s3 + s4);\n");
      out.write("    }\n");
      out.write("  \n");
      out.write("    return result + endChar;\n");
      out.write("  }\n");
      out.write("  \n");
      out.write("  \n");
      out.write("//创建地图对象并初始化\n");
      out.write("var mp = new BMap.Map(\"map_container\",{\n");
      out.write("    enableHighResolution: true //是否开启高清\n");
      out.write("});\n");
      out.write("var point = new BMap.Point(116.404, 39.915);\n");
      out.write("mp.centerAndZoom(point, 14); //初始化地图\n");
      out.write("mp.enableInertialDragging(); //开启关系拖拽\n");
      out.write("mp.enableScrollWheelZoom();  //开启鼠标滚动缩放\n");
      out.write("\n");
      out.write("// 添加定位控件\n");
      out.write("var geoCtrl = new BMap.GeolocationControl({\n");
      out.write("    showAddressBar       : true //是否显示\n");
      out.write("    , enableAutoLocation : false //首次是否进行自动定位\n");
      out.write("    , offset             : new BMap.Size(0,25) \n");
      out.write("    //, locationIcon     : icon //定位的icon图标\n");
      out.write("});\n");
      out.write("\n");
      out.write("//监听定位成功事件\n");
      out.write("geoCtrl.addEventListener(\"locationSuccess\",function(e){\n");
      out.write("        console.log(e);\n");
      out.write("});\n");
      out.write("\n");
      out.write("//监听定位失败事件\n");
      out.write("geoCtrl.addEventListener(\"locationError\",function(e){\n");
      out.write("        console.log(e);\n");
      out.write("});\n");
      out.write("\n");
      out.write("// 将定位控件添加到地图\n");
      out.write("mp.addControl(geoCtrl);\n");
      out.write("\n");
      out.write("//检索类型\n");
      out.write("var type = \"\";\n");
      out.write("type = LOCAL_SEARCH ;   //周边检索\n");
      out.write("//type = TRANSIT_ROUTE; //公交检索\n");
      out.write("//type = DRIVING_ROUTE; //驾车检索\n");
      out.write("\n");
      out.write("//创建鱼骨控件\n");
      out.write("var navCtrl = new BMap.NavigationControl({\n");
      out.write("        anchor: BMAP_ANCHOR_TOP_LEFT //设置鱼骨控件的位置\n");
      out.write("});\n");
      out.write("// 将鱼骨添加到地图当中\n");
      out.write("mp.addControl(navCtrl);\n");
      out.write("\n");
      out.write("\n");
      out.write("//创建检索控件\n");
      out.write("var searchControl = new BMapLib.SearchControl({\n");
      out.write("    container : \"searchBox\" //存放检索控件的容器\n");
      out.write("    , map     : mp          //检索的关联地图\n");
      out.write("    , type    : type        //检索类型\n");
      out.write("});\n");
      out.write("\n");
      out.write("document.getElementById(\"selectType\").onchange = function () {\n");
      out.write("    searchControl.setType(this.value);\n");
      out.write("};\n");
      out.write("\n");
      out.write("  \n");
      out.write("//添加路况控件\n");
      out.write("var ctrl = new BMapLib.TrafficControl({\n");
      out.write("   showPanel: false //是否显示路况提示面板\n");
      out.write("});      \n");
      out.write("mp.addControl(ctrl);\n");
      out.write("ctrl.setAnchor(BMAP_ANCHOR_TOP_RIGHT);\n");
      out.write("    \n");
      out.write("</script>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
