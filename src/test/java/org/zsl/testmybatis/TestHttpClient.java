package org.zsl.testmybatis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cn.hnust.json.AccessToken;
import com.cn.hnust.model.WeixinFinalValue;
import com.cn.hnust.model.WeixinMenu;
import com.cn.hnust.quartz.RefreshAccessTokenTask;
import com.cn.hnust.util.JsonUtil;
import com.cn.hnust.util.PropertiesUtil;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TestHttpClient {
	
	@Test
	public void test() throws ClientProtocolException, IOException {
		Properties prop = PropertiesUtil.getInstance().load("weixin_basic.properties");
		
		CloseableHttpClient client = HttpClients.createDefault();
		String url = prop.getProperty("access_token_url").replaceAll("APPID", prop.getProperty("appId"));
		url = url.replaceAll("APPSECRET", prop.getProperty("appsecret"));
		HttpGet get = new HttpGet(url);
		CloseableHttpResponse resp = client.execute(get);
		int statusCode = resp.getStatusLine().getStatusCode();
		if(statusCode>=200 && statusCode < 300) {
			HttpEntity entity = resp.getEntity();
			String content = EntityUtils.toString(entity);
			System.out.println(content);
			AccessToken at = (AccessToken) JsonUtil.getInstance().json2Obj(content, AccessToken.class);
			System.out.println(at.getAccess_token() + "," + at.getExpires_in()); 
		}
	}
	
	@Test
	public void testMenu() throws ClientProtocolException, IOException {
		List<WeixinMenu> wms = new ArrayList<WeixinMenu>();
		WeixinMenu wm1 = new WeixinMenu();
		wm1.setId(1);
		wm1.setName("我的课堂ww");
		wm1.setType("view");
		wm1.setUrl("http://www.baidu.com");
		wms.add(wm1);
		WeixinMenu wm2 = new WeixinMenu();
		wm2.setName("第二菜单");
		List<WeixinMenu> wm2Sub = new ArrayList<WeixinMenu>();
//		wm1 = new WeixinMenu();
//		wm1.setId(2);
//		wm1.setName("点击测试");
//		wm1.setType("click");
//		wm1.setKey("A0001");
//		wm2Sub.add(wm1);
//		wm1 = new WeixinMenu();
//		wm1.setId(2);
//		wm1.setName("图片测试");
//		wm1.setType("pic_sysphoto");
//		wm1.setKey("rselfmenu_1_0");
//		wm2Sub.add(wm1);
//		wm2.setSub_button(wm2Sub);
//		wms.add(wm2);
		Map<String, List<WeixinMenu>> maps = new HashMap<String, List<WeixinMenu>>();
		maps.put("button", wms);
		System.out.println(JsonUtil.getInstance().obj2Json(maps));
		String json = JsonUtil.getInstance().obj2Json(maps);
		
		CloseableHttpClient client = HttpClients.createDefault();
		String url = WeixinFinalValue.MENU_ADD;
		url = url.replace("ACCESS_TOKEN", RefreshAccessTokenTask.at);
		System.out.println(url);
		HttpPost post = new HttpPost(url);
		post.addHeader("Content-Type","application/json");
		StringEntity entity = new StringEntity(json, 
				ContentType.create("application/json", "utf-8"));
		post.setEntity(entity);
		CloseableHttpResponse resp = client.execute(post);
		int sc = resp.getStatusLine().getStatusCode();
		if(sc>=200&&sc<300) {
			System.out.println(EntityUtils.toString(resp.getEntity()));
		}
	}
}
