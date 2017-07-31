package com.cn.hnust.dao.sat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cn.hnust.dao.BaseDao;
import com.cn.hnust.model.sat.SatArticle;


@Repository("satArticleDao")
public class SatArticleDao extends BaseDao<SatArticle> implements ISatArticleDao{

	@Override
	public List<SatArticle> listBySatArticleTitle(String title) {
		return super.list("satUserFindOthers", null);
	}

	@Override
	public List<SatArticle> listSatArticlesByOpenId(String openid) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("openid", openid);
		return super.list("listBySatUserOpenId", params);
	}

	@Override
	public SatArticle loadContentById(String id) {
		return super.loadBySqlId("loadArticleContent", id);
	}

	@Override
	public void insert(SatArticle article) {
		super.add(article);
	}
	
	@Override
	public void deleteByUUID(String id) {
		super.deleteByUUID(SatArticle.class, id);
	}

	@Override
	public SatArticle loadArticleById(String id) {
		return super.loadBySqlId("loadArticleById", id);
	}

	@Override
	public void insertContent(SatArticle article) {
		super.addContent(article);
	}

	@Override
	public List<SatArticle> list() {
		return super.list("listSatArticles", null);
	}
	
}
