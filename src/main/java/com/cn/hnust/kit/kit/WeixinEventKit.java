package com.cn.hnust.kit.kit;

import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;

import com.cn.hnust.model.FiveBookUser;
import com.cn.hnust.model.User;
import com.cn.hnust.model.WUser;
import com.cn.hnust.model.WeixinMenu;
import com.cn.hnust.service.IFiveBookUserService;
import com.cn.hnust.service.IUserService;
import com.cn.hnust.service.IWUserService;
import com.cn.hnust.service.IWeixinMenuService;
import com.cn.hnust.web.servlet.BeanFactoryContext;


public class WeixinEventKit {

	
	@Resource
	private static IWeixinMenuService weixinMenuService;
	
	public static String handlerEventMsg(Map<String, String> msgMap) throws IOException {
		String event = msgMap.get("Event");
		System.out.println(event);
		if("CLICK".equals(event)) {
			return handlerClickEvent(msgMap);
		} else if("subscribe".equals(event)) {
			return handleSubscribeEvent(msgMap);
		} else if("unsubscribe".equals(event)) {
			return handlerUnsubscribeEvent(msgMap);
		}
		return null;
	}
	
	private static String handleSubscribeEvent(Map<String, String> msgMap) throws IOException {
		String openId = msgMap.get("FromUserName");
		System.out.println(openId);
		IFiveBookUserService userService = (IFiveBookUserService) BeanFactoryContext.getService("fiveBookUserService");
		FiveBookUser user = userService.loadByOpenId(openId);
//		if(user==null) {
//			IWUserService wUserService = (IWUserService) BeanFactoryContext.getService("wUserService");
//			WUser wUser = wUserService.queryByOpenid(openId);
//			user = wUser.getUser();
//			userService.add(user);
//		} else {
//			user.setStatus(1);
//			userService.update(user);
//		}
		if(user == null) {
			String bindUrl = "http://1d6289976g.imwork.net/weixinRegist/redirect";
			return WeixinMessageKit.map2xml(MessageCreateKit.createTextMsg(msgMap, "<a href=\"" + bindUrl +  "\">点击绑定用户</a>"));
		}
		if(user.getBind() ==0) {
			String bindUrl = "http://1d6289976g.imwork.net/weixinRegist/redirect";
			return WeixinMessageKit.map2xml(MessageCreateKit.createTextMsg(msgMap, "<a href=\"" + bindUrl +  "\">点击绑定用户</a>"));
		} else {
			String bindUrl = "http://1d6289976g.imwork.net/fiveBookUser/login";
			return WeixinMessageKit.map2xml(MessageCreateKit.createTextMsg(msgMap, "<a href=\"" + bindUrl +  "\">已经绑定，点击登录</a>"));
		}
	}

	private static User getUser(Map<String, String> msgMap) {
		String openid = msgMap.get("FromUserName");
		IUserService userService = (IUserService)BeanFactoryContext.getService("userService");
		User u = userService.loadByOpenId(openid);
		return u;
	}

	private static String handlerUnsubscribeEvent(Map<String, String> msgMap) {
		User u = getUser(msgMap);
		IUserService userService = (IUserService)BeanFactoryContext.getService("userService");
		if(u!=null) {
			u.setStatus(0);
			userService.update(u);
		}
		return null;
	}

	private static String getSence(Map<String,String> msgMap,boolean subscribe) {
		String key = msgMap.get("EventKey");
		if(key==null||"".equals(key)) return null;
		if(subscribe)
			return key.split("_")[1];
		else 
			return key;
	}
	
	private static String handlerClickEvent(Map<String, String> msgMap) throws IOException {
		String keyCode = msgMap.get("EventKey");
		IWeixinMenuService weixinMenuService = (IWeixinMenuService)BeanFactoryContext.getService("weixinMenuService");
		System.out.println("keyCode" + keyCode);
		WeixinMenu wm = weixinMenuService.loadByKey(keyCode);
		if(wm!=null&&wm.getRespType()==1) {
			Map<String,Object> map = MessageCreateKit.createTextMsg(msgMap, wm.getContent());
			return WeixinMessageKit.map2xml(map);
		}
		return null;
	}

}
