package com.cn.hnust.service.sat;

import java.util.List;

import com.cn.hnust.model.sat.SatArticleShare;

public interface ISatArticleShareService {
	
	public void insert(SatArticleShare s);
	
	public void update(SatArticleShare s);
	
	public void insertOrUprate(String openid, String articleId);
	
	public SatArticleShare load(String openid, String articleId);
	
	public List<SatArticleShare> listByOpenid(String openid);
}
