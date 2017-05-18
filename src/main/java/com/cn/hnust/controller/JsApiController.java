package com.cn.hnust.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cn.hnust.kit.kit.WeixinBasicKit;
import com.cn.hnust.model.JsapiTicket;
import com.cn.hnust.model.WeixinContext;
import com.cn.hnust.model.WeixinFinalValue;

@Controller
public class JsApiController {
	
	@RequestMapping(value="/jsapi")  
	public ModelAndView jsapi(HttpServletRequest request,HttpServletResponse resp){
		String appId=WeixinContext.getInstance().getAppId();//应用id  
        String appsecret=WeixinContext.getInstance().getAppSecurt();//应用秘钥  
       //1,获取access_token  
//       AccessToken accessToken = WeixinContext.getInstance().get;  
//       String access_token=accessToken.getAccess_token();  
       //2,获取调用微信jsapi的凭证  
       JsapiTicket ticket = WeixinContext.getInstance().getTicket(); 
       System.out.println("ticket " + ticket.getTicket());
       Map<String,String> map = WeixinBasicKit.sign(ticket.getTicket(), WeixinFinalValue.WEB_URL);  
      
   request.setAttribute("timestamp", map.get("timestamp"));  
   request.setAttribute("nonceStr", map.get("nonceStr"));  
   request.setAttribute("signature", map.get("signature"));  
   request.setAttribute("appId", appId);  
      
   System.out.println("apiticket " + ticket.getTicket() );
   System.out.println("nonceStr " + map.get("nonceStr"));
   System.out.println("timeStamp " + map.get("timestamp")); 
   System.out.println("appId " + appId);
   System.out.println("url " + map.get("url"));
   System.out.println("signature " +  map.get("signature"));
   return new ModelAndView("bluetooth/ble");  
   }
	
	@RequestMapping("/sendDeviceMessage")
	public void sendDeviceMessage(HttpServletRequest request, HttpServletResponse response) {
		Socket socket = null;
		DataInputStream in = null;
		DataOutputStream out = null;
		try {
			socket  = new Socket("192.168.1.121", 9090);
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
			out.write("daaa".getBytes("utf-8"));
			out.flush();
			byte[] buf = new byte[10000];
			StringBuffer result = null;
			int totalLen = 0, len = 0;
			if((len = in.read(buf, totalLen, 1000)) != -1) {
				totalLen += len;
			}
			System.out.println(new String(buf));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if(in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if(socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		try {
            response.setContentType("text/xml;charset=utf-8");
            PrintWriter pw = response.getWriter();
            String msg = request.getParameter("message");
            System.out.println("msg" + msg);
            StringBuilder builder = new StringBuilder();
            builder.append("<message>");
            builder.append(msg).append("</message>");
            pw.write(builder.toString());
            pw.flush();
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
//	@RequestMapping("/bluetooth/ble")
//	public String getBBlue() {
//		return "bluetooth/ble";
//	}
	
}
