package com.cn.hnust.kit.kit;

import java.util.HashMap;
import java.util.Map;

import com.cn.hnust.json.TemplateMsg;
import com.cn.hnust.model.WeixinFinalValue;
import com.cn.hnust.util.JsonUtil;

public class MessageCreateKit {

	public static Map<String, Object> createTextMsg(Map<String, String> msgMap,
			String content) {
		Map<String,Object > tm = new HashMap<String,Object>();
		tm.put("ToUserName", msgMap.get("FromUserName"));
		tm.put("FromUserName", msgMap.get("ToUserName"));
		tm.put("CreateTime", System.currentTimeMillis()+"");
		tm.put("MsgType", "text");
		tm.put("Content", content);
		return tm;
	}
	
	public static String postTemplateMsg(TemplateMsg tm) {
		String url = WeixinFinalValue.SEND_TEMPLATE_MSG;
		url = url.replace("ACCESS_TOKEN", "F3dxkM741O-h7OP5Y96Z0pqZLsizkQcuBM_KG8cUERo32voghnz2rU5Il_hn9AwbvvHLO9GtpHVJCtiY2Nur9kkwT1atQR64t-obdRxrONExF4URMLtYA3zVk8nWLbT2EKQfAAAQWC");
		String jsonResult = WeixinBasicKit.sendJsonPost(url, JsonUtil.getInstance().obj2Json(tm));
		return jsonResult;
	} 

}
