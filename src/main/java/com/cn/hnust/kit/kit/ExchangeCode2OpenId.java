package com.cn.hnust.kit.kit;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cn.hnust.json.OpenIdResult;
import com.cn.hnust.model.WeixinContext;
import com.cn.hnust.util.JsonUtil;

public class ExchangeCode2OpenId {
    private static Logger logger = LoggerFactory.getLogger(ExchangeCode2OpenId.class);

    public static String exchange(String code) {
    	try{
	    	if(code != null) {
	    		String openid = "";
	            String appId = WeixinContext.getInstance().getAppId();
	            String appSecret = WeixinContext.getInstance().getAppSecurt();
	            // ��ȡaccess_token ���а�����openid
	            // ����ͨ��code��ȡ����һ���������ҳ��Ȩaccess_token,�����֧���е�access_token����access_token���ڵ��������ӿڣ���ͬ��
	            String URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code"
	                    .replace("APPID", appId).replace("SECRET", appSecret).replace("CODE", code);
	            String string = WeixinBasicKit.sendGet(URL);
	            OpenIdResult openidResult = (OpenIdResult) JsonUtil.getInstance().json2Obj(string, OpenIdResult.class);
	            System.out.println(openidResult.getOpenid());
	            return openidResult.getOpenid();
	    	}else {
	    		return "";
	    	}
    	} catch (Exception e) {
    		return null;
    	}
    }
}