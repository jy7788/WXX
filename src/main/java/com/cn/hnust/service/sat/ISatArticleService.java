package com.cn.hnust.service.sat;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cn.hnust.model.sat.SatArticle;
import com.cn.hnust.model.sat.SatUser;

public interface ISatArticleService {
	public List<SatArticle> listBySatArticleTitle(String title);
	public List<SatArticle> listSatArticlesByOpenId(String openid);
	public SatArticle loadContentById(String id);
	public SatArticle loadArticleById(String id);
	public void insert(SatArticle article);
	public void update(SatArticle article);
	public void deleteByUUID(String id);
	public void insertContent(SatArticle article);
	public List<SatArticle> list();
	public SatArticle loadMyArticleContent(String id, String openid);
	public List<SatArticle> listByClassifyName(String name);
}
