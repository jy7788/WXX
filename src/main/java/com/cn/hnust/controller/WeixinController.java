package com.cn.hnust.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cn.hnust.kit.kit.BasicKit;
import com.cn.hnust.kit.kit.SecurityKit;
import com.cn.hnust.kit.kit.WeixinMessageKit;
import com.cn.hnust.model.WeixinContext;

@Controller
public class WeixinController {
	
	public static final String TOKEN = "fanfte";

	@RequestMapping(value="/wget",method=RequestMethod.GET)
	public void wget(HttpServletRequest req,HttpServletResponse resp) throws IOException {
//		signature	微信加密签名，signature结合了开发�?�填写的token参数和请求中的timestamp参数、nonce参数�?
//		timestamp	时间�?
//		nonce	随机�?
//		echostr
		String signature = req.getParameter("signature");
		String timestamp = req.getParameter("timestamp");
		String nonce = req.getParameter("nonce");
		String echostr = req.getParameter("echostr");
		System.out.println(signature);
		String[] arr = {WeixinContext.getInstance().getToken(),timestamp,nonce};
		Arrays.sort(arr);
		StringBuffer sb = new StringBuffer();
		for(String a:arr) {
			sb.append(a);
		}
		String sha1Msg = SecurityKit.sha1(sb.toString());
		if(signature.equals(sha1Msg)) {
			resp.getWriter().write(echostr);
		}
	}
	
	@RequestMapping(value="/wget",method=RequestMethod.POST)
	public void handlerPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/xml;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		String rel = WeixinMessageKit.handlerReceiveMsg(request);
		System.out.println("--------rel:"+rel);
		if(!BasicKit.isEmpty(rel)) {
			response.getWriter().write(rel);
		}
		 // 将请求、响应的编码均设置为UTF-8（防止中文乱码）
//        request.setCharacterEncoding("UTF-8");
//        response.setCharacterEncoding("UTF-8");
//        String respMessage = null;
//        try{
//        //xml请求解析
//        Map<String, String> requestMap = MessageUtil.parseXml(request);//接收微信发过来的xml格式
//        //发送方帐号(open_id)
//        String fromUserName = requestMap.get("FromUserName");
//        //公众帐号
//        String toUserName = requestMap.get("ToUserName");
//        //消息类型
//        String msgType = requestMap.get("MsgType");
//        //消息创建时间
//        String createTime = requestMap.get("CreateTime");
//        //微信服务器post过来的内容
//        String weixinContent = requestMap.get("Content");
//        System.out.println("公众号用户发送过来的文本消息内容："+weixinContent);
//        //接下来我们用上一章节自己封装好的工具类
//        if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {//文本类型 用户回复 “hh” 微信自动回复此条消息
//        //回复换行的文本消息
//        TextMessage textMessage = new TextMessage();
//        textMessage.setToUserName(fromUserName);
//        textMessage.setFromUserName(toUserName);
//        textMessage.setCreateTime(new Date().getTime());
//        textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
//        textMessage.setFuncFlag(0);
//         
//        StringBuffer buffer = new StringBuffer();
//        buffer.append("欢迎访问").append("\n");
//        buffer.append("<a href=\"http://1d6289976g.imwork.net/bluetooth\">微信jsapi测试界面</a>").append("\n\n");
//        textMessage.setContent(buffer.toString());
//        respMessage = MessageUtil.textMessageToXml(textMessage);//转换成xml格式
//         
//        }
//         
//        // 响应回复消息
//        PrintWriter out = response.getWriter();
//        out.print(respMessage);
//        out.close();
//         }catch(Exception e){
//          e.printStackTrace();
//         }
//    }
	}
	
}