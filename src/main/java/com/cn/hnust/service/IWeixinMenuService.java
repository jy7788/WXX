package com.cn.hnust.service;

import java.util.List;

import com.cn.hnust.model.WeixinMenu;
import com.cn.hnust.model.WeixinMenuDto;

public interface IWeixinMenuService {
	public void add(WeixinMenu wm);
	public void delete(int id);
	public void update(WeixinMenu wm);
	public WeixinMenu load(int id);
	public List<WeixinMenu> listAll();
	public WeixinMenu loadByKey(String key);
	public List<WeixinMenuDto> gengrateWeixinMenuDto();
}
