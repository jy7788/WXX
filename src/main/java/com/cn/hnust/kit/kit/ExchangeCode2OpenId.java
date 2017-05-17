package com.cn.hnust.kit.kit;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cn.hnust.json.OpenIdResult;
import com.cn.hnust.model.WeixinContext;
import com.cn.hnust.util.JsonUtil;

public class ExchangeCode2OpenId {
    private static Logger logger = LoggerFactory.getLogger(ExchangeCode2OpenId.class);

    public static String exchange(String code) {
        String openid = "";
        String appId = WeixinContext.getInstance().getAppId();
        String appSecret = WeixinContext.getInstance().getAppSecurt();
        // 换取access_token 其中包含了openid
        // 这里通过code换取的是一个特殊的网页授权access_token,与基础支持中的access_token（该access_token用于调用其他接口）不同。
        String URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code"
                .replace("APPID", appId).replace("SECRET", appSecret).replace("CODE", code);
        String string = WeixinBasicKit.sendGet(URL);
        OpenIdResult openidResult = (OpenIdResult) JsonUtil.getInstance().json2Obj(string, OpenIdResult.class);
        System.out.println(openidResult.getOpenid());
        return openidResult.getOpenid();
    }
}