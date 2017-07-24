package com.cn.hnust.htmlparser;

import java.util.List;

import com.cn.hnust.kit.kit.WeixinBasicKit;
import com.cn.hnust.model.json.sat.ArticleJson;
import com.cn.hnust.model.json.sat.MobileArticleJson;
import com.cn.hnust.util.JsonUtil;

public class GetNewsMessage {
	public static void main(String[] args) {
		String postResult = WeixinBasicKit.sendGet("https://api.wallstreetcn.com/v2/mobile-articles");
		System.out.println(postResult);
		
		MobileArticleJson obj = (MobileArticleJson) JsonUtil.getInstance().json2Obj(postResult, MobileArticleJson.class);
		List<ArticleJson> results = obj.getResults();
		
		for(int i = 0; i < results.size() ;i++) {
			System.out.println(results.get(i).getId());
			
		}
		
		
	}
}
