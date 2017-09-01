package com.cn.hnust.quartz;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.cn.hnust.kit.kit.WeixinBasicKit;
import com.cn.hnust.model.JsapiTicket;
import com.cn.hnust.model.WeixinContext;

@Component
public class RefreshJsApiTicketTask {
	public void refreshJsapiTicket() {
		
		String appId=WeixinContext.getInstance().getAppId();//应用id  
        String appsecret=WeixinContext.getInstance().getAppSecurt();//应用秘钥  
       //1,获取access_token  
//       AccessToken accessToken = WeixinContext.getInstance().get;  
//       String access_token=accessToken.getAccess_token();  
       //2,获取调用微信jsapi的凭证  
        try {
        	if(WeixinContext.getInstance().getAccessToken().getAccess_token() !=null) {
        		JsapiTicket ticket = WeixinBasicKit.getJsapiTicket(appId, appsecret); 
        		WeixinContext.getInstance().setTicket(ticket);
        		System.out.println(" ticket " + ticket.getTicket());
        	} else {
        		Thread.sleep(8000);
        		System.out.println(new Date() + "refresh jsapi ");
        		refreshJsapiTicket();
        	}
        } catch (Exception e){
        	try {
				Thread.sleep(8000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
    		System.out.println(new Date() + "refresh jsapi ");
    		refreshJsapiTicket();
        }
	}
}
