package com.cn.hnust.quartz;

import java.io.IOException;
import java.util.Date;

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
import com.cn.hnust.model.WeixinContext;
import com.cn.hnust.model.WeixinFinalValue;
import com.cn.hnust.util.JsonUtil;
import com.cn.hnust.util.PropertiesUtil;

@Component
public class RefreshAccessTokenTask {
	public static final String at = "Bp2r8wnsvNpsjuB-bqVnxxScJaK29pVdexpfBKTxJUV-nBOJjaI8VVA10_PYPYt6hhi3BuXJilfCaMdSOHjSxfWq2vRlVwx_TQvK8n8rcRIIp721l37TZkYAYB7K9HtbWWDjAHASSZ";
	public void refreshToken() {
		
		String url = PropertiesUtil.getProperties().getProperty("access_token_url");
		url = url.replaceAll("APPID", WeixinContext.getInstance().getAppId());
		url = url.replaceAll("APPSECRET", WeixinContext.getInstance().getAppSecurt());
		
		String content = WeixinBasicKit.sendGet(url);
		if(WeixinBasicKit.checkRequestSucc(content)) {
			
			AccessToken at = (AccessToken)JsonUtil.getInstance().json2Obj(content, AccessToken.class);
			WeixinContext.getInstance().setAccessToken(at);
			System.out.println("token " + at.getAccess_token());
		} else {
			try {
				Thread.sleep(8000);
				System.out.println(new Date() + "refresh token ");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			refreshToken();
		}
	}
}
