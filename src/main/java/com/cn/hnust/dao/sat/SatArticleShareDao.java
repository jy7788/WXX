package com.cn.hnust.dao.sat;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cn.hnust.dao.BaseDao;
import com.cn.hnust.model.sat.SatArticleShare;


@Repository("satArticleShareDao")
public class SatArticleShareDao extends BaseDao<SatArticleShare> implements ISatArticleShareDao{

	@Override
	public void insertNewShareArticle(SatArticleShare s) {
		super.add(s);
	}

	@Override
	public void updateSatShareArticle(SatArticleShare s) {
		super.update(s);
	}

	@Override
	public SatArticleShare loadByUserIdAndArticleId(String openid, String articleId) {
		HashMap<String, Object> params = new HashMap<>();
		params.put("openid", openid);
		params.put("articleId", articleId);
		return super.loadBySqlId("loadByUserIdAndArticleId", params);
	}

	@Override
	public List<SatArticleShare> listByOpenid(String openid) {
		HashMap<String, Object> params = new HashMap<>();
		params.put("openid", openid);
		return super.list("listSharesByOpenid", params);
	}

}
