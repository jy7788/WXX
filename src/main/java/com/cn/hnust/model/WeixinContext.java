package com.cn.hnust.model;

import com.cn.hnust.json.AccessToken;

public class WeixinContext {
	private String appId;
	private String appSecurt;
	private String baseUrl;
	private String token;
	private AccessToken accessToken;
	private JsapiTicket ticket;
	private static WeixinContext wc;
	
	public JsapiTicket getTicket() {
		return ticket;
	}
	public void setTicket(JsapiTicket ticket) {
		this.ticket = ticket;
	}
	private WeixinContext(){}
	public static WeixinContext getInstance() {
		if(wc==null) wc = new WeixinContext();
		return wc;
	}
	
	
	public AccessToken getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(AccessToken accessToken) {
		this.accessToken = accessToken;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getAppSecurt() {
		return appSecurt;
	}
	public void setAppSecurt(String appSecurt) {
		this.appSecurt = appSecurt;
	}
	public String getBaseUrl() {
		return baseUrl;
	}
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
}
