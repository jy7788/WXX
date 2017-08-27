package com.cn.hnust.kit.kit;

import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;

import com.cn.hnust.model.User;
import com.cn.hnust.model.WeixinFinalValue;
import com.cn.hnust.model.WeixinMenu;
import com.cn.hnust.model.pa.PAUser;
import com.cn.hnust.model.sat.SatUser;
import com.cn.hnust.service.IUserService;
import com.cn.hnust.service.IWeixinMenuService;
import com.cn.hnust.service.pa.IPAUserService;
import com.cn.hnust.service.sat.ISatUserService;
import com.cn.hnust.web.servlet.BeanFactoryContext;


public class WeixinEventKit {

	
	@Resource
	private static IWeixinMenuService weixinMenuService;
	
//	@Resource
//	private static IPAUserService pAUserService;
	@Resource
	private static ISatUserService satUserService;
	
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
		System.out.println("openid" + openId);
		System.out.println(msgMap);
		SatUser user = satUserService.loadByOpenId(openId);
		if(user != null) {
			
		} else {
			
		}
		//未绑定去绑定用户
		if(user == null || user.getBind() == 0) {
			String bindUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + WeixinFinalValue.APPID + "&redirect_uri=" + WeixinFinalValue.SERVER_URL +"pauser/goauth&response_type=code&scope=snsapi_base&state=1#wechat_redirect";
			return WeixinMessageKit.map2xml(MessageCreateKit.createTextMsg(msgMap, "<a href=\"" + bindUrl +  "\">点击绑定用户</a>"));
		} 
		
		//绑定过
		if(user != null && user.getBind() == 1){
			String bindUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + WeixinFinalValue.APPID + "&redirect_uri=" + WeixinFinalValue.SERVER_URL + "pauser/goauth&response_type=code&scope=snsapi_base&state=1#wechat_redirect";
//			return WeixinMessageKit.map2xml(MessageCreateKit.createTextMsg(msgMap, "<a href=\"" + bindUrl +  "\">已经绑定，点击登录</a>"));
			return WeixinMessageKit.map2xml(MessageCreateKit.createTextMsg(msgMap, "已经签到"));
		}
		return WeixinMessageKit.map2xml(MessageCreateKit.createTextMsg(msgMap, "已经签到"));
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
