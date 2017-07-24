package com.cn.hnust.controller;

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
@RequestMapping("pic")
public class UploadController {

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
       Map<String,String> map = WeixinBasicKit.sign(ticket.getTicket(), WeixinFinalValue.SERVER_URL + "pic/jsapi");  
      
       request.getSession().setAttribute("redisUser", "fanfte1111");
       
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
   return new ModelAndView("pic/upload");  
   }
}
