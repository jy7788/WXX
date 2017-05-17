package com.cn.hnust.dao;

import java.util.List;

import com.cn.hnust.model.WeixinMenu;

public interface IWeixinMenuDao extends IBaseDao<WeixinMenu>{
	public WeixinMenu loadByKey(String key);
	public List<WeixinMenu> listAll();
}
