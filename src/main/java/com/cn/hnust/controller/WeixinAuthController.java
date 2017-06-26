package com.cn.hnust.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cn.hnust.kit.kit.ExchangeCode2OpenId;
import com.cn.hnust.kit.kit.WeixinUserUtil;
import com.cn.hnust.model.WUser;
import com.cn.hnust.model.WeixinContext;
import com.cn.hnust.model.WeixinFinalValue;

@Controller
@RequestMapping("weixinAuth")
public class WeixinAuthController {

	@RequestMapping(value="/redirect" ,method=RequestMethod.GET)
	public String weixinRedirect(HttpServletResponse resp) throws IOException {
		System.out.println("redirect regist");
		String path = "http://1d6289976g.imwork.net/wx/fiveBookUser/regist";
		String uri = WeixinFinalValue.AUTH_URL;
		uri = uri.replace("APPID", WeixinContext.getInstance().getAppId())
		   .replace("REDIRECT_URI",URLEncoder.encode(path, "UTF-8"))
//		   .replace("REDIRECT_URI",path)
		   .replace("SCOPE", "snsapi_base")
		   .replace("STATE", "1");
		System.out.println("redirect:" + uri);
		return "redirect:" + uri;
	}
	
	/*@RequestMapping(value="/goauth" ,method=RequestMethod.GET)
	public String weixinAuth(HttpServletRequest request,HttpServletResponse response) {
		try{
	        System.out.println("获取的code: :"+request.getParameter("code"));
	        System.out.println("开始调用网页授权");
	        String openid = ExchangeCode2OpenId.exchange(request.getParameter("code"));
//	        String openid = WeixinUtil.getWeChat(request.getParameter("code"));
	        System.out.println("网页授权获取到的openid:"+openid);
	        WUser wechatUser = WeixinUserUtil.getWechatUser(openid);
	        System.out.println(wechatUser.getProvince());
	        }catch(Exception e){
	            e.printStackTrace();
	            System.out.println("调用网页授权异常："+e);
	        }
	        return "PAUser/signin";
	}*/
	
}
