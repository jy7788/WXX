package com.cn.hnust.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cn.hnust.model.WeixinContext;
import com.cn.hnust.model.WeixinFinalValue;

@Controller
@RequestMapping("weixinRegist")
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
	
}
