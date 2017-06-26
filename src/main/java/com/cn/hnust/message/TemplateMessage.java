package com.cn.hnust.message;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.cn.hnust.model.WeixinContext;
import com.cn.hnust.model.WeixinFinalValue;

public class TemplateMessage {
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
    public static String sendPost(String requrl,String param){
        URL url;
         String sTotalString="";  
       try {
           url = new URL(requrl);
            URLConnection connection = url.openConnection(); 
             
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("Content-Type", "text/xml");
           // connection.setRequestProperty("Content-Length", body.getBytes().length+"");
            connection.setRequestProperty("User-Agent",
                    "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0)");
             
             
               connection.setDoOutput(true);  
               OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "utf-8");  
               out.write(param); //
               out.flush();  
               out.close();  
               String sCurrentLine;  
              
               sCurrentLine = "";  
               sTotalString = "";  
               InputStream l_urlStream;  
               l_urlStream = connection.getInputStream();  
               // 传说中的三层包装阿！  
               BufferedReader l_reader = new BufferedReader(new InputStreamReader(  
                       l_urlStream));  
               while ((sCurrentLine = l_reader.readLine()) != null) {  
                   sTotalString += sCurrentLine + "\r\n";  
          
               }  
                
       } catch (Exception e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }  
           
           System.out.println(sTotalString);  
           return sTotalString;
    }
    /**
     * 发送模板消息
     * @author fanfte
     * 
     * @param openid
     * @param content
     * 2017年6月26日
     */
    public static void sendBindUserTemplate(String mopenId, String openid, String content) {
    	String access_token=WeixinContext.getInstance().getAccessToken().getAccess_token();//有效access_token
        String template_id="vCN7FbsROvt9okgw9a0QYMI_eVOCmC3E0t-0KOzbYjI";//模板id
        String url="https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+access_token;
 //待处理状态
        String linkUrl = WeixinFinalValue.SERVER_URL +"pauser/acceptBind?" + "openid=" + mopenId;
        String params= "{"
                   +"\"touser\":\""+openid+"\""+","
                   +"\"template_id\":\""+template_id+"\""+","
                   +"\"url\":\"" + linkUrl + "\""+","
                   +"\"topcolor\":\"#7B68EE\""+","
                   +"\"data\":{"
                    
                        +"\"first\":{"
                        +"\"value\":\"您好，您有新的绑定业务\\n\""+","
                        +"\"color\":\"#000000\""
                        +"},"
                            
                          + "\"keyword1\":{"
                               +"\"value\":\"绑定请求\""+","
                               +"\"color\":\"#000000\""
                           +"},"
                                
                      + "\"keyword2\":{"
                      +"\"value\":\"" + content + "\""+","
                      +"\"color\":\"#000000\""
                      +"},"
                       
                      + "\"keyword3\":{"
                      +"\"value\":\""+  sdf.format(new Date()) + "\""+","
                      +"\"color\":\"#000000\""
                      +"},"
                                
                               +"\"remark\":{"
                               +"\"value\":\"请点击详情进行处理\""+","
                               +"\"color\":\"#173177\"}}}";
                String data = TemplateMessage.sendPost(url, params);
                System.out.println("发送模板消息返回："+data);
    }
    
    /**
     * 发送接受绑定请求模板消息
     * @author fanfte
     * 
     * @param openid
     * @param content
     * 2017年6月26日
     */
    public static void sendAcceptUserTemplate(String mopenId, String fromopenid, String content) {
    	String access_token=WeixinContext.getInstance().getAccessToken().getAccess_token();//有效access_token
        String template_id="vCN7FbsROvt9okgw9a0QYMI_eVOCmC3E0t-0KOzbYjI";//模板id
        String url="https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+access_token;
 //待处理状态
        String linkUrl = WeixinFinalValue.SERVER_URL + "pauser/show?" + "openid=" + mopenId;
        String params= "{"
                   +"\"touser\":\""+ fromopenid +"\""+","
                   +"\"template_id\":\""+template_id+"\""+","
                   +"\"url\":\"" + linkUrl + "\""+","
                   +"\"topcolor\":\"#7B68EE\""+","
                   +"\"data\":{"
                    
                        +"\"first\":{"
                        +"\"value\":\"您好，您有新的绑定业务\\n\""+","
                        +"\"color\":\"#000000\""
                        +"},"
                            
                          + "\"keyword1\":{"
                               +"\"value\":\"完成\""+","
                               +"\"color\":\"#000000\""
                           +"},"
                                
                      + "\"keyword2\":{"
                      +"\"value\":\"" + mopenId +"\""+","
                      +"\"color\":\"#000000\""
                      +"},"
                       
                      + "\"keyword3\":{"
                      +"\"value\":\""+  sdf.format(new Date()) + "\""+","
                      +"\"color\":\"#000000\""
                      +"},"
                                
                               +"\"remark\":{"
                               +"\"value\":\"绑定用户  "+ content +" 业务完成\""+","
                               +"\"color\":\"#173177\"}}}";
                String data = TemplateMessage.sendPost(url, params);
                System.out.println("发送模板消息返回："+data);
    }

   public static void main(String[] args) {
//	   sendBindUserTemplate("oNG7At-eteDqJ5rBCwwQ1mIWRrF8", "aaa");
       }
}