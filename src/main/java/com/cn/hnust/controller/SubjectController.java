package com.cn.hnust.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cn.hnust.kit.kit.WeixinBasicKit;
import com.cn.hnust.model.JsapiTicket;
import com.cn.hnust.model.WeixinContext;
import com.cn.hnust.util.Sign;

@Controller
@RequestMapping("/subject")
public class SubjectController {
	
	@RequestMapping(value="/steam", method=RequestMethod.GET)
	public void classSteam(HttpServletRequest request, HttpServletResponse response) {
		 JsapiTicket jt=WeixinBasicKit.getJsapiTicket(WeixinContext.getInstance().getAppId(),
				                                      WeixinContext.getInstance().getAppSecurt());
		 System.out.println("jsapi ");
		 String ticket=jt.getTicket();
		 StringBuffer url=request.getRequestURL();
		 Map<String, String> t= Sign.sign(ticket, url.toString());
		 request.setAttribute("sign",t);
		 try {
			request.getRequestDispatcher("/class/steam").forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
