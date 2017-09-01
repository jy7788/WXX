package com.cn.hnust.kit.kit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.UnsupportedCharsetException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Date;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.cn.hnust.model.JsapiTicket;
import com.cn.hnust.model.WeixinContext;
import com.cn.hnust.util.JsonUtil;
import com.cn.hnust.util.PropertiesUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

public class WeixinBasicKit {
	public static void setWeixinContext() {
		Properties prop = PropertiesUtil.getInstance().load("weixin_basic.properties");
		WeixinContext.getInstance().setAppId(prop.getProperty("appId"));
		WeixinContext.getInstance().setAppSecurt(prop.getProperty("appsecret"));
		WeixinContext.getInstance().setBaseUrl(prop.getProperty("base_url"));
		WeixinContext.getInstance().setToken(prop.getProperty("weixin_token"));
		System.out.println(WeixinContext.getInstance().getToken());
	}
	
	public final static String js_api_ticket_url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";
	
	//access_token httprequest方法不再说明
	public static JsapiTicket getJsapiTicket(String appid, String appsecret){
			JsapiTicket ticket=new JsapiTicket();
			String requestUrl = js_api_ticket_url.replace("ACCESS_TOKEN",WeixinContext.getInstance().getAccessToken().getAccess_token());
			System.out.println("get ticket url  " + requestUrl);
			String sendGet = WeixinBasicKit.sendGet(requestUrl);
			System.out.println(sendGet + new Date());
			System.out.println("get ticket start " + new Date());
			JsapiTicket json2Obj = (JsapiTicket) JsonUtil.getInstance().json2Obj(sendGet, JsapiTicket.class);
			//JSONObject jsonObject =WeixinUtil.httpRequest(requestUrl, "GET", null);
//			if(jsonObject.getString("errcode").equals("0")){
//				ticket.setTicket(jsonObject.getString("ticket"));
//				ticket.setExpiresIn(jsonObject.getString("expires_in"));
//			}else{
//				System.out.println("erroe");
//			}
			return json2Obj;
		}
	
	
	/*** 
     * 获取界面调用jsapi的所需参数 
     * @param jsapi_ticket 凭据 
     * @param url 界面请求地址 
     * @return 
     */  
    public static Map<String, String> sign(String jsapi_ticket, String url) {  
        Map<String, String> ret = new HashMap<String, String>();  
        String nonce_str = create_nonce_str();  
        String timestamp = create_timestamp();  
        String string1;  
        String signature = "";  
   
        String[] paramArr = new String[] { "jsapi_ticket=" + jsapi_ticket,
				"timestamp=" + timestamp, "noncestr=" + nonce_str, "url=" + url };
		Arrays.sort(paramArr);
		// 将排序后的结果拼接成一个字符串
		String content = paramArr[0].concat("&"+paramArr[1]).concat("&"+paramArr[2])
				.concat("&"+paramArr[3]);
		System.out.println("拼接之后的content为:"+content);
        //注意这里参数名必须全部小写，且必须有序  
        string1 = "jsapi_ticket=" + jsapi_ticket +  
                  "&noncestr=" + nonce_str + 
                  "&timestamp=" + timestamp + 
                  "&url=" + url;  
        System.out.println(string1);  
   
        try  
        {  
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");  
            crypt.reset();  
            crypt.update(string1.getBytes("UTF-8"));  
            signature = byteToHex(crypt.digest());  
        }  
        catch (NoSuchAlgorithmException e)  
        {  
            e.printStackTrace();  
        }  
        catch (UnsupportedEncodingException e)  
        {  
            e.printStackTrace();  
        }  
   
        ret.put("url", url);  
        ret.put("jsapi_ticket", jsapi_ticket);  
        ret.put("nonceStr", nonce_str);  
        ret.put("timestamp", timestamp);  
        ret.put("signature", signature);  
   
        return ret;  
    }  
       
    private static String byteToHex(final byte[] hash) {  
        Formatter formatter = new Formatter();  
        for (byte b : hash)  
        {  
            formatter.format("%02x", b);  
        }  
        String result = formatter.toString();  
        formatter.close();  
        return result;  
    }  
   
    private static String create_nonce_str() {  
        return UUID.randomUUID().toString();  
    }  
   
    private static String create_timestamp() {  
        return Long.toString(System.currentTimeMillis() / 1000);  
    }  
      
	
	public static String replaceAccessTokenUrl(String url) {
		return url.replace("ACCESS_TOKEN", WeixinContext.getInstance().getAccessToken().getAccess_token());
	}
	
	/**
	 * �?查请求是否成�?
	 * @return
	 */
	public static boolean checkRequestSucc(String content) {
		try {
			JsonNode jn = JsonUtil.getMapper().readTree(content);
			if(!jn.has("errcode")) return true;
			if(jn.get("errcode").asInt()==0) return true;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static int getRequestCode(String content) {
		try {
			JsonNode jn = JsonUtil.getMapper().readTree(content);
			if(jn.has("errcode")) return jn.get("errcode").asInt();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public static String getRequestMsg(String content) {
		try {
			JsonNode jn = JsonUtil.getMapper().readTree(content);
			if(jn.has("errcode")) return jn.get("errmsg").asText();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String sendGet(String url) {
		HttpGet get = null;
		CloseableHttpResponse resp = null;
		CloseableHttpClient client = null;
		try {
			client = HttpClients.createDefault();
			get = new HttpGet(url);
			resp = client.execute(get);
			int statusCode = resp.getStatusLine().getStatusCode();
			if(statusCode>=200&&statusCode<300) {
				HttpEntity entity = resp.getEntity();
				String content = EntityUtils.toString(entity,"utf-8");
				return content;
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(resp!=null) resp.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if(client!=null) client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static String sendJsonPost(String url,String content) {
		return sendPost(url, content, "application/json");
	}
	
	public static String sendXmlPost(String url,String content) {
		return sendPost(url, content, "application/xml");
	}
	
	public static String sendPost(String url,String content,String type) {
		CloseableHttpClient client = null;
		CloseableHttpResponse resp = null;
		try {
			client = HttpClients.createDefault();
			HttpPost post = new HttpPost(url);
			post.addHeader("Content-type",type);
			StringEntity entity = new StringEntity(content, ContentType.create(type, "UTF-8"));
			post.setEntity(entity);
			resp = client.execute(post);
			int statusCode = resp.getStatusLine().getStatusCode();
			if(statusCode>=200&&statusCode<300) {
				String str = EntityUtils.toString(resp.getEntity(),"utf-8");
				return str;
			}
		} catch (UnsupportedCharsetException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(client!=null) client.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				if(resp!=null) resp.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	/**
     * 向指定 URL 发送POST方法的请求
     * 
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPostUrl(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }    
}
