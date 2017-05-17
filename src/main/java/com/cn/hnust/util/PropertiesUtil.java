package com.cn.hnust.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	private static Properties jdbcProp;
	private static Properties prop;
	private static PropertiesUtil pu;
	
	public static void main(String[] args) {
		Properties load = getInstance().load("weixin_basic.properties");
	}
	public static PropertiesUtil getInstance() {
		if(pu == null) {
			pu = new PropertiesUtil();
		}
		return pu;
	}
	
	public static Properties getProperties() {
		if(prop == null) {
			prop = new Properties();
		}
		return prop;
	}
	
	public static Properties getJdbcProp() {
		try {
			if(jdbcProp==null) {
				jdbcProp = new Properties();
				jdbcProp.load(PropertiesUtil.class.getClassLoader().getResourceAsStream("jdbc.properties"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jdbcProp;
	}
	
	
	public Properties load(String file) {
		prop = getProperties();
		InputStream path =Thread.currentThread().getContextClassLoader()
				.getResourceAsStream(file);//获取路径并转换成流
		try {
			prop.load(path);
			return prop;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(path != null) {
				try {
					path.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return prop;
	}
}
