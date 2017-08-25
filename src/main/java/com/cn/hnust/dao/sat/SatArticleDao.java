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

	@Override
	public List<SatArticle> listMyArticles(String articleId, String openid) {
		HashMap<String, Object> params = new HashMap<>();
		params.put("id", articleId);
		params.put("openid", openid);
		return super.list("listMyArticles", params);
	}

	@Override
	public SatArticle loadMyArticle(String articleId, String openid) {
		HashMap<String, Object> params = new HashMap<>();
		params.put("id", articleId);
		params.put("openid", openid);
		return super.loadBySqlId("loadMyArticle", params);
	}

	@Override
	public List<SatArticle> listNewsLike(String content) {
		HashMap<String, Object> params = new HashMap<>();
		params.put("content", "%" + content + "%");
		return super.list("listNewsLike", params);
	}

	@Override
	public void deleteByIds(String id, String openid) {
		HashMap<String, Object> params = new HashMap<>();
		params.put("id", id);
		params.put("openid", openid);
		super.deleteByParams("deleteByIds", params);
	}

	@Override
	public SatArticle loadMyArticleContent(String id) {
		HashMap<String, Object> params = new HashMap<>();
		params.put("articleId", id);
		//params.put("openid", openid);
		return super.loadBySqlId("loadMyArticleContent", params);
	}

	@Override
	public List<SatArticle> listArticleByClassifyId(String classifyId) {
		HashMap<String, Object> params = new HashMap<>();
		params.put("classifyId", classifyId);
		return super.list("listArticlesByClassifyId", params);
	}
	
	@Override
	public List<SatArticle> listArticleByClassifyName(String classifyName) {
		HashMap<String, Object> params = new HashMap<>();
		params.put("classifyName", classifyName);
		return super.list("listArticlesByclassifyName", params);
	}

	@Override
	public void collectArticle(String userId, String articleId) {
		Map<String, Object > params = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put("articleId", articleId);
		super.add("collectArticle", params);
	}

	@Override
	public List<SatArticle> listMyCollections(String openid) {
		Map<String, Object > params = new HashMap<String, Object>();
		params.put("openid", openid);
		return super.list("listMyCollections", params);
	}
}
