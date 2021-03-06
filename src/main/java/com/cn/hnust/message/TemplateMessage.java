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
    public static boolean sendBindUserTemplate(String mopenId, String openid, String content) {
    	boolean isSendOk = false;
    	String access_token=WeixinContext.getInstance().getAccessToken().getAccess_token();//有效access_token
//    	String access_token="nKwLdBGoAUxM2SllQdDj3LkJl5Tu743cuSER31LZhu4XQH6FRYeV3kpx0DviAT8dSavxUWCz4mA_TQ2kzMw9IJVE8f7NenSUaO-_tn0JpGMSV0sHpUeHP93-6-YNFxbEEUMeAJAKAS";//有效access_token
        String template_id="kJdZ_WFqJmFhjKtei4JFRJPrueKLGY1zpDTuOQ8GyKk";//模板id
        String url="https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+access_token;
 //待处理状态
        String linkUrl = WeixinFinalValue.SERVER_URL +"pauser/acceptBind?" + "mopenid=" + mopenId + "&aopenid=" + openid;//发送者mopenid
        String params= "{"
                   +"\"touser\":\""+openid+"\""+","
                   +"\"template_id\":\""+template_id+"\""+","
                   +"\"url\":\"" + linkUrl + "\""+","
                   +"\"topcolor\":\"#7B68EE\""+","
                   +"\"data\":{"
                    
                        +"\"first\":{"
                        +"\"value\":\"" +"您有一笔待处理的消息," +  content + "希望与您互动"+"\\n\""+","
                        +"\"color\":\"#000000\""
                        +"},"
                            
                          + "\"name\":{"
                               +"\"value\":\"绑定请求\""+","
                               +"\"color\":\"#000000\""
                           +"},"
//                                
                      + "\"time\":{"
                      +"\"value\":\"" + sdf.format(new Date()) + "\""+","
                      +"\"color\":\"#000000\""
                      +"},"
//                       
//                      + "\"keyword3\":{"
//                      +"\"value\":\""+  sdf.format(new Date()) + "\""+","
//                      +"\"color\":\"#000000\""
//                      +"},"
                                
                               +"\"remark\":{"
                               +"\"value\":\">>>点击详情\""+","
                               +"\"color\":\"#173177\"}}}";
                String data = TemplateMessage.sendPost(url, params);
                System.out.println("发送模板消息返回："+data);
          isSendOk = true;
        return isSendOk;
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
//    	String access_token=WeixinContext.getInstance().getAccessToken().getAccess_token();//有效access_token
    	String access_token=WeixinContext.getInstance().getAccessToken().getAccess_token();//有效access_token
        String template_id="voMYtzAs-vv_XIJDQ1wdiiwe6DbGqw3Di6uPAIhixbM";//模板id,授权受理通知id
        String url="https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+access_token;
 //待处理状态
        String linkUrl = WeixinFinalValue.SERVER_URL + "pauser/show?" + "mopenid=" + mopenId + "&aopenid=" + fromopenid;
        String params= "{"
                   +"\"touser\":\""+ fromopenid +"\""+","
                   +"\"template_id\":\""+template_id+"\""+","
                   +"\"url\":\"" + linkUrl + "\""+","
                   +"\"topcolor\":\"#7B68EE\""+","
                   +"\"data\":{"
                    
                        +"\"first\":{"
                        +"\"value\":\"您的授权已受理，可以在签到列表查看联系电话\\n\""+","
                        +"\"color\":\"#000000\""
                        +"},"
                            
                          + "\"name1\":{"
                               +"\"value\":\"" + "\""+","
                               +"\"color\":\"#000000\""
                           +"},"
//                                
                      + "\"name2\":{"
                      +"\"value\":\"" + content +"\""+","
                      +"\"color\":\"#000000\""
                      +"},"
//                       
                      + "\"time\":{"
                      +"\"value\":\""+  sdf.format(new Date()) + "\""+","
                      +"\"color\":\"#000000\""
                      +"},"
                                
                               +"\"remark\":{"
                               +"\"value\":\">>>点击详情\""+","
                               +"\"color\":\"#173177\"}}}";
                String data = TemplateMessage.sendPost(url, params);
                System.out.println("发送模板消息返回："+data);
    }

   public static void main(String[] args) {
	   sendBindUserTemplate("oa3zmw237e8jFMeTDxDFQ7sbk8ws", "oa3zmw237e8jFMeTDxDFQ7sbk8ws", "fanfte");
       }
}