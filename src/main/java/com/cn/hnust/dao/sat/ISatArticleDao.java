package com.cn.hnust.dao.sat;

import java.util.List;

import com.cn.hnust.dao.IBaseDao;
import com.cn.hnust.model.sat.SatArticle;
import com.cn.hnust.model.sat.SatUser;


public interface ISatArticleDao extends IBaseDao<SatArticle>{
	public List<SatArticle> listBySatArticleTitle(String title);
	public List<SatArticle> listSatArticlesByOpenId(String openid);
	public SatArticle loadContentById(String id);
	public SatArticle loadArticleById(String id);
	public void insert(SatArticle article);
	public void update(SatArticle article);
	public void deleteByUUID(String id);
	public void insertContent(SatArticle article);
	public List<SatArticle> list();
}
