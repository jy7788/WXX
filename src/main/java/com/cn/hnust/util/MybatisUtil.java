package com.cn.hnust.util;

import java.io.IOException;
import java.io.InputStream;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
//	public static SqlSessionFactory factory;
//	static {
//		try {
//			InputStream is = Resources.getResourceAsStream("spring-mybatis.xml");
//			factory = new SqlSessionFactoryBuilder().build(is);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public static SqlSession getSession() {
//		return factory.openSession();
//	}
	
	@Resource(name="sqlSessionTemplate")
    private static SqlSession session;
	
	public static SqlSession getSession() {
		return session;
	}

	public void setSession(SqlSession session) {
		this.session = session;
	}

	public static void closeSession(SqlSession session) {
		if(session != null) {
			session.close();
		}
	}
}
