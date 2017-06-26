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
	
	private String SERVER_URL = "115.159.194.138";
	
	private String MY_SERVER = "11.240.94.56";
	
	private String SERVER_PORT = "8888";
	
	private String TEST_MAC = "B0B448CB6206";

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
       Map<String,String> map = WeixinBasicKit.sign(ticket.getTicket(), WeixinFinalValue.SERVER_URL + "jsapi");  
      
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
	
	public void sendMessage(byte[] msg) {
		Socket socket = null;
		DataInputStream in = null;
		DataOutputStream out = null;
		try {
			socket  = new Socket(SERVER_URL, Integer.parseInt(SERVER_PORT));
			in = new DataInputStream(socket.getInputStream());
			out = new DataOutputStream(socket.getOutputStream());
			out.write(msg);
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
			if(TEST_MAC.equals(mac[1])) {
				sendMessage(mac[1]);
				System.out.println("send server");
			}
			
		}
		
		if(mssg.contains("open")) {
			System.out.println("open");
			byte[] bytes = new byte[5];
			bytes[0]=(byte) 0xfe;
	        
			bytes[1]=(byte) 0xCF;
			bytes[2]=0x1B;
	          
			bytes[3]=0x00;
			bytes[4]=0x2A; 
			sendMessage(bytes);
		}
		if(mssg.contains("close")) {
			System.out.println("close");
			byte[] bytes = new byte[5];
			bytes[0]=(byte) 0xFE;
	           
			bytes[1]=(byte) 0xCF;
			bytes[2]=0x1C;
	             
			bytes[3]=0x00;
			bytes[4]=0x2D; 
			sendMessage(bytes);
		}
		
		try {
            response.setContentType("text/json;charset=utf-8");
            PrintWriter pw = response.getWriter();
            StringBuilder builder = new StringBuilder();
//            builder.append("<message>");
            if(bufs!= null && bufs.length != 0) {
            	builder.append(new String(bufs));
            }
            pw.write(builder.toString());
            System.out.println("seng back " + builder.toString());
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
