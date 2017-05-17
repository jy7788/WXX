package com.cn.hnust.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cn.hnust.model.WeixinMenu;

@Repository("weixinMenuDao")
public class WeixinMenuDao extends BaseDao<WeixinMenu> implements IWeixinMenuDao{

	public WeixinMenu loadByKey(String key) {
		return super.loadBySqlId("selectMenuByKey", key);
	}

	public List<WeixinMenu> listAll() {
		Map<String, Object> params = new HashMap<String, Object>();
		return super.list("WeixinMenu", params);
	} 

}
