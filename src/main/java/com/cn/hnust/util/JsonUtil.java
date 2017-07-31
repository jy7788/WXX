package com.cn.hnust.util;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
	private static JsonUtil ju;
	private static JsonFactory jf;
	private static ObjectMapper mapper;
	private JsonUtil() {
		
	}
	
	public static JsonUtil getInstance() {
		if(ju == null) ju = new JsonUtil();
		return ju;
	}
	
	public static ObjectMapper getMapper() {
		if(mapper == null){
			mapper  = new ObjectMapper();
		}
		return mapper;
	}
	
	public static JsonFactory getFactory() {
		if(jf == null) jf = new JsonFactory();
		return jf;
	}
	
	public String obj2Json(Object obj) {
		JsonGenerator jg = null;
		StringWriter sw = new StringWriter();
		try {
			jg = getFactory().createGenerator(sw);
			getMapper().writeValue(jg, obj);
			return sw.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(jg != null)
			try {
				jg.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public Object json2Obj(String json, Class<?> clz) {
		try {
			return getMapper().readValue(json, clz);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String list2json(List<?> list) {  
        StringBuilder json = new StringBuilder();  
        json.append("[");  
        if (list != null && list.size() > 0) {  
          for (Object obj : list) {  
            json.append(obj2Json(obj));  
            json.append(",");  
          }  
          json.setCharAt(json.length() - 1, ']');  
        } else {  
          json.append("]");  
        }  
        return json.toString();  
}  
}
