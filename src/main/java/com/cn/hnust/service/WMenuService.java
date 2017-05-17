package com.cn.hnust.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.kit.kit.WeixinBasicKit;
import com.cn.hnust.model.WeixinFinalValue;
import com.cn.hnust.model.WeixinMenuDto;
import com.cn.hnust.util.JsonUtil;

@Service("wMenuService")
public class WMenuService implements IWMenuService{

	@Resource
	private IWeixinMenuService weixinMenuService;
	
	@Override
	public void publishMenu() {
		String url = WeixinBasicKit.replaceAccessTokenUrl(WeixinFinalValue.MENU_ADD);
		System.out.println("service url"  + url);
		List<WeixinMenuDto> wmds = weixinMenuService.gengrateWeixinMenuDto();
		Map<String, List<WeixinMenuDto>> maps = new HashMap<String, List<WeixinMenuDto>>();
		maps.put("button", wmds);
		String rel = WeixinBasicKit.sendJsonPost(url, JsonUtil.getInstance().obj2Json(maps));
		System.out.println(JsonUtil.getInstance().obj2Json(maps));
		if(!WeixinBasicKit.checkRequestSucc(rel)) {
			throw new RuntimeException("´´½¨²Ëµ¥Ê§°Ü" + WeixinBasicKit.getRequestMsg(rel));
		}
	}

	public String queryMenu() {
		String url = WeixinBasicKit.replaceAccessTokenUrl(WeixinFinalValue.MENU_QUERY);
		return WeixinBasicKit.sendGet(url);
	}

}
