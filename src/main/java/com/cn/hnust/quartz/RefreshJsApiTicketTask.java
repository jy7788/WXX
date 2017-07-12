package com.cn.hnust.quartz;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import com.cn.hnust.json.AccessToken;
import com.cn.hnust.json.ErrorEntity;
import com.cn.hnust.kit.kit.WeixinBasicKit;
import com.cn.hnust.model.JsapiTicket;
import com.cn.hnust.model.WeixinContext;
import com.cn.hnust.model.WeixinFinalValue;
import com.cn.hnust.util.JsonUtil;
import com.cn.hnust.util.PropertiesUtil;

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
        	JsapiTicket ticket = WeixinBasicKit.getJsapiTicket(appId, appsecret); 
        	WeixinContext.getInstance().setTicket(ticket);
        	System.out.println(" ticket " + ticket.getTicket());
        } catch (Exception e){
        	refreshJsapiTicket();
        }
	}
}
