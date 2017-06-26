package com.cn.hnust.service.impl;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.cn.hnust.kit.kit.WeixinBasicKit;
import com.cn.hnust.model.WUser;
import com.cn.hnust.model.WeixinContext;
import com.cn.hnust.model.WeixinFinalValue;
import com.cn.hnust.service.IWUserService;
import com.cn.hnust.util.JsonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;

@Service("wUserService")
public class WUserService implements IWUserService {

	@Override
	public WUser queryByOpenid(String openid) {
		String url = WeixinBasicKit.replaceAccessTokenUrl(WeixinFinalValue.USER_QUERY);
		url = url.replace("OPENID", openid);
		String sendGet = WeixinBasicKit.sendGet(url);
		return (WUser)JsonUtil.getInstance().json2Obj(sendGet, WUser.class);
	}

	@Override
	public String queryOpenidByCode(String code)  {
		try {
			String url = WeixinFinalValue.AUTH_GET_OID;
			url = url.replace("APPID", WeixinContext.getInstance().getAppId())
			   .replace("SECRET",WeixinContext.getInstance().getAppSecurt())
			   .replace("CODE", code);
			String json = WeixinBasicKit.sendGet(url);
			String openid = JsonUtil.getMapper().readTree(json).get("openid").asText();
			return openid;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
