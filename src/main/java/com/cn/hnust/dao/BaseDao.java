package com.cn.hnust.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;

import com.cn.hnust.model.Pager;
import com.cn.hnust.model.SystemContext;


public class BaseDao<T> implements IBaseDao<T>{
	
	@Resource
	private SqlSession session;
	
	public void add(T obj) {
		session.insert(obj.getClass().getName() + ".add", obj);
	}
	public void update(T obj) {
	    session.update(obj.getClass().getName() + ".update", obj);
	}
	public void delete(Class<T> clz, int id) {
		session.delete(clz.getName() + ".delete", id);
	}
	
	public void deleteByUUID(Class<T> clz, String id) {
		session.delete(clz.getName() + ".deleteByUUID", id);
	}
	
	public List<T> list(Class<T> clz, Map<String, Object> params) {
		System.out.println(clz.getName() + "FindAll");
		return list(clz.getName() + "FindAll", params);
	} 
	
	public List<T> list(String sqlId, Map<String, Object> params) {
		List<T> list = null;
		list = session.selectList(sqlId, params);
		return list;
	} 
	
	public Pager<T> find(Class<T> clz, Map<String, Object> params) {
		return this.find(clz.getName() + ".find", params);
	}
	
	public Pager<T> find(String sqlId, Map<String, Object> params) {
		int pageSize = SystemContext.getSize();
		int offSet = SystemContext.getOffset();
		String order = SystemContext.getOrder();
		String sort = SystemContext.getSort();
		Pager<T> pagers = new Pager<T>();
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
		T t = null;
		t = session.selectOne(clz.getName() + ".load", id);
		return t;
	}
	
	public T loadBySqlId(String sqlId, Map<String, Object> params) {
		T t = null;
		t = session.selectOne(sqlId, params);
		return t;
	}
	
	public T loadBySqlId(String sqlId, Object obj) {
		T t = null;
		t = session.selectOne(sqlId, obj);
		return t;
	}
	@Override
	public void addContent(T obj) {
		session.insert(obj.getClass().getName() + ".addContent", obj);
	}
}	

