package com.cn.hnust.dao.sat;

import com.cn.hnust.dao.IBaseDao;
import com.cn.hnust.model.sat.SatArticleShare;


public interface ISatArticleShareDao extends IBaseDao<SatArticleShare>{
	public void insertNewShareArticle(SatArticleShare s);
	
	public void updateSatShareArticle(SatArticleShare s);
	
	public SatArticleShare loadByUserIdAndArticleId(String openid, String articleId);
}
