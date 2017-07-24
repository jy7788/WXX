package com.cn.hnust.dao;

import java.util.List;
import java.util.Map;

import com.cn.hnust.model.Pager;

public interface IBaseDao<T> {
	public void add(T obj);

	public void update(T obj);

	public void delete(Class<T> clz, int id);
	
	public void deleteByUUID(Class<T> clz, String id);

	public List<T> list(Class<T> clz, Map<String, Object> params);

	public List<T> list(String sqlId, Map<String, Object> params);

	public Pager<T> find(Class<T> clz, Map<String, Object> params);

	public Pager<T> find(String sqlId, Map<String, Object> params);

	public T findById(Class<T> clz, int id);

	public T loadBySqlId(String sqlId, Map<String, Object> params);

	public T loadBySqlId(String sqlId, Object obj);
	
	public void addContent(T obj);

}
