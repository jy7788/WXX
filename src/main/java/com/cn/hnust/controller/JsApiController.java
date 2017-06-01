package com.cn.hnust.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cn.hnust.kit.kit.WeixinBasicKit;
import com.cn.hnust.model.JsapiTicket;
import com.cn.hnust.model.WeixinContext;
import com.cn.hnust.model.WeixinFinalValue;

@Controller
public class JsApiController {
	
	private byte[] bufs;
	
	private String SERVER_URL = "192.168.1.124";
	
	private String SERVER_PORT = "8888";

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
	
	public void sendMessage(String msg) {
		Socket socket = null;
		DataInputStream in = null;
		DataOutputStream out = null;
		try {
			socket  = new Socket(SERVER_URL, Integer.parseInt(SERVER_PORT));
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
			out.write(msg.getBytes("utf-8"));
			out.flush();
			bufs = new byte[10000];
			StringBuffer result = null;
			int totalLen = 0, len = 0;
			if((len = in.read(bufs, totalLen, 1000)) != -1) {
				totalLen += len;
			}
			System.out.println(new String(bufs));
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
	}
	
	@RequestMapping(value="/sendDeviceMessage" ,method={RequestMethod.GET})
	@ResponseBody  
	public void sendDeviceMessage(HttpServletRequest request, HttpServletResponse response) {
//		System.out.println("size " + map.size());
//		System.out.println("json" + json.get(0).getMsg() + json.get(0).getIp());
		String mssg = request.getParameter("msg");
		System.out.println(mssg);
		if(mssg.contains("mac")) {
			String[] mac = mssg.split("-");
			sendMessage(mac[0]);
		}else {
			sendMessage(mssg);
		}
		
		try {
            response.setContentType("text/json;charset=utf-8");
            PrintWriter pw = response.getWriter();
            StringBuilder builder = new StringBuilder();
            builder.append("<message>");
            if(bufs!= null && bufs.length != 0) {
            	builder.append(new String(bufs)).append("</message>");
            }
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
