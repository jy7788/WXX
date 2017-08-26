package com.cn.hnust.dao.sat;

import java.util.List;

import com.cn.hnust.dao.IBaseDao;
import com.cn.hnust.model.sat.SatArticle;
import com.cn.hnust.model.sat.SatUser;


public interface ISatArticleDao extends IBaseDao<SatArticle>{
	public List<SatArticle> listBySatArticleTitle(String title);
	public List<SatArticle> listSatArticlesByOpenId(String openid);
	public SatArticle loadContentById(String i);
	public SatArticle loadArticleById(String id);
	public void insert(SatArticle article);
	public void update(SatArticle article);
	public void deleteByUUID(String id);
	public void insertContent(SatArticle article);
	public List<SatArticle> list();
	public List<SatArticle> listMyArticles(String articleId, String openid);
	public SatArticle loadMyArticle(String articleId, String openid);
	public List<SatArticle> listNewsLike(String content);
	public void deleteByIds(String id, String openid);
	public SatArticle loadMyArticleContent(String id);
	public List<SatArticle> listArticleByClassifyId(String classifyId);
	public List<SatArticle> listArticleByClassifyName(String classifyName);
	public void collectArticle(String userId, String articleId);
	
	public List<SatArticle> listMyCollections(String openid); 
	
	public List<SatArticle> listArticlesLike(String str);
}
