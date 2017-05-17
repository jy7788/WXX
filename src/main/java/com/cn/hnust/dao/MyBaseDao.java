package com.cn.hnust.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;

import com.cn.hnust.model.Pager;
import com.cn.hnust.model.SystemContext;
import com.cn.hnust.util.MybatisUtil;


public class MyBaseDao<T> {
	
	 @Resource
	 private SqlSessionTemplate session;
	 
	public void add(T obj) {
		session.insert(obj.getClass().getName() + ".add", obj);
	}
	public void update(T obj) {
		SqlSession session = null;
		try{
			session = MybatisUtil.getSession();
		    session.update(obj.getClass().getName() + ".update", obj);
		    session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
	}
	public void delete(Class<T> clz, int id) {
		SqlSession session = null;
		try{
			session = MybatisUtil.getSession();
		    session.delete(clz.getName() + ".delete", id);
		    session.commit();
		} finally {
			session.close();
		}
	}
	
	public List<T> list(Class<T> clz, Map<String, Object> params) {
		return list(clz.getName() + "findAll", params);
	} 
	
	public List<T> list(String sqlId, Map<String, Object> params) {
		List<T> list = null;
		SqlSession session = null;
		try {
			session = MybatisUtil.getSession();
			list = session.selectList(sqlId, params);
		} finally {
			MybatisUtil.closeSession(session);
		}
		return list;
	} 
	
	public Pager<T> findAll(Class<T> clz, Map<String, Object> params) {
		return findAll(clz.getName() + ".findAll", params);
	}
	
	public Pager<T> findAll(String sqlId, Map<String, Object> params) {
		int pageSize = SystemContext.getSize();
		int offSet = SystemContext.getOffset();
		String order = SystemContext.getOrder();
		String sort = SystemContext.getSort();
		Pager<T> pagers = new Pager<T>();
		SqlSession session = null;
		session = MybatisUtil.getSession();
		if(params == null) params = new HashMap<String, Object>();
		params.put("pageSize", pageSize);
		params.put("offSet", offSet);
		params.put("order", order);
		params.put("sort", sort);
		List<T> ts = session.selectList(sqlId, params);
		pagers.setDatas(ts);
		pagers.setOffset(offSet);
		pagers.setSize(pageSize);
		int total = session.selectOne(sqlId + "_count", params);
		pagers.setTotal(total);
		return pagers;
	}
	public T findById(Class<T> clz, int id) {
		SqlSession session = null;
		T t = null;
		try{
			session = MybatisUtil.getSession();
			t = session.selectOne(clz.getName() + ".load", id);
		} finally {
			MybatisUtil.closeSession(session);
		}
		return t;
	}
	
	public T loadBySqlId(String sqlId, Map<String, Object> params) {
		SqlSession session = null;
		T t = null;
		try{
			session = MybatisUtil.getSession();
			t = session.selectOne(sqlId, params);
		} finally {
			MybatisUtil.closeSession(session);
		}
		return t;
	}
	
	public T loadBySqlId(String sqlId, Object obj) {
		SqlSession session = null;
		T t = null;
		try{
			session = MybatisUtil.getSession();
			t = session.selectOne(sqlId, obj);
		} finally {
			MybatisUtil.closeSession(session);
		}
		return t;
	}
}	

