package com.cn.hnust.service;

import java.util.List;

import com.cn.hnust.model.WeixinQr;

public interface IWeixinQrService {
	public void add(WeixinQr wq);
	
	public void delete(int id);
	
	public WeixinQr load(int id);
	
	public void update(WeixinQr wq);
	
	public List<WeixinQr> listBaseQr();
	
	public List<WeixinQr> listTempQr();
	
	public WeixinQr loadBySnum(int snum);
}
