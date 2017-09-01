package com.cn.hnust.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cn.hnust.kit.kit.WeixinBasicKit;
import com.cn.hnust.model.JsapiTicket;
import com.cn.hnust.model.WeixinContext;
import com.cn.hnust.model.WeixinFinalValue;
import com.cn.hnust.model.voice.SpeechMessage;
import com.cn.hnust.util.JsonUtil;
import com.cn.hnust.web.audiorecognize.RecognizeUtil;
import com.iflytek.msp.cpdb.lfasr.model.Message;

@Controller
@RequestMapping("audio")
public class AudioController {
	private String uploadPath = System.getProperty("user.dir") + "/test.wav"; // 上传文件的目录 
	File tempPathFile; 
	int byteSum = 0;
	int byteCount = 0;
	Message m = null;
	@RequestMapping("/upload")
	@ResponseBody
	public String uploadAudio(@RequestParam("audioData") MultipartFile file,HttpServletRequest request) {
		
		System.out.println("upload path " + uploadPath);
		try {
			System.out.println("upload path " + uploadPath);
			InputStream inputStream = file.getInputStream();
			FileOutputStream   outputStream = new FileOutputStream(uploadPath);
			byte[] bytes = new byte[1024*1024];
			long size = file.getSize();
			System.out.println("size "  + size);
			while ((byteCount = inputStream.read(bytes)) != -1)
			{
				byteSum += byteCount;
				outputStream.write(bytes, 0, byteCount);
			    outputStream.flush();
			    System.out.println("byte count " + byteCount);
			}
			System.out.println(byteSum);
			inputStream.close();
			outputStream.close();
			m = RecognizeUtil.recognizeSpeech(uploadPath);
			//SpeechMessage message = (SpeechMessage) JsonUtil.getInstance().json2Obj(m.getData(), SpeechMessage.class);
			String data = m.getData();
			String oneBest = data.substring(data.indexOf("onebest") + 10, data.indexOf("si") - 3);
			System.out.println("MESSAGE "  + oneBest);
			return oneBest;
			//String filepath = userSitessService.uploadAvatar(properties, content);
			} catch (Exception ex) {

			}
			if(m != null) {
				return m.toString();
			} else {
				return null;
			}
		}
	
	
	@RequestMapping("/login")
	public String voiceLogin() {
		System.out.println(System.getProperty("user.dir") + "/upload" );
		return "voice/login";
	}
	
	@RequestMapping(value="/jsapi")  
	public ModelAndView jsapi(HttpServletRequest request,HttpServletResponse resp){
		String appId=WeixinContext.getInstance().getAppId();//应用id  
        String appsecret=WeixinContext.getInstance().getAppSecurt();//应用秘钥  
       //1,获取access_token  
//       AccessToken accessToken = WeixinContext.getInstance().get;  
//       String access_token=accessToken.getAccess_token();  
       //2,获取调用微信jsapi的凭证  
       JsapiTicket ticket = WeixinContext.getInstance().getTicket(); 
       System.out.println("ticket " + ticket.getTicket());
       Map<String,String> map = WeixinBasicKit.sign(ticket.getTicket(), WeixinFinalValue.SERVER_URL + "audio/jsapi");  
      
	   request.setAttribute("timestamp", map.get("timestamp"));  
	   request.setAttribute("nonceStr", map.get("nonceStr"));  
	   request.setAttribute("signature", map.get("signature"));  
	   request.setAttribute("appId", appId);  
	      
	   System.out.println("apiticket " + ticket.getTicket() );
	   System.out.println("nonceStr " + map.get("nonceStr"));
	   System.out.println("timeStamp " + map.get("timestamp")); 
	   System.out.println("appId " + appId);
	   System.out.println("url " + map.get("url"));
	   System.out.println("signature " +  map.get("signature"));
	   return new ModelAndView("voice/audio");  
   }
	
}
