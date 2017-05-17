package com.cn.hnust.kit.kit;

import com.cn.hnust.model.WUser;
import com.cn.hnust.model.WeixinContext;
import com.cn.hnust.util.JsonUtil;

public class WeixinUserUtil {
	public static WUser getWechatUser(String openid) {

        String token = WeixinContext.getInstance().getAccessToken().getAccess_token();
        String URL = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
        URL = URL.replace("OPENID", openid).replace("ACCESS_TOKEN", token);
        String JsonResult = WeixinBasicKit.sendGet(URL);
        System.out.println(JsonResult);
        WUser u = null;
        u = (WUser) JsonUtil.getInstance().json2Obj(JsonResult, WUser.class);
        return u;
    }
}
