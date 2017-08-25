package com.cn.hnust.dao.sat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cn.hnust.dao.BaseDao;
import com.cn.hnust.model.sat.SatAdvertisement;
import com.cn.hnust.model.sat.SatArticle;


@Repository("satAdvertisementDao")
public class SatAdvertisementDao extends BaseDao<SatAdvertisement> implements ISatAdvertisementDao{

	@Override
	public SatAdvertisement loadById(String id) {
		return super.loadBySqlId("selectById", id);
	}

	@Override
	public void insert(SatAdvertisement ad) {
		super.add(ad);
	}

	@Override
	public List<SatAdvertisement> listByOpenid(String openid) {
		HashMap<String, Object> params = new HashMap<>();
		params.put("openid", openid);
		return super.list("listByOpenid", params);
	}

	@Override
	public void deleteById(String adId) {
		super.deleteByUUID(SatAdvertisement.class, adId);
	}

	@Override
	public void update(SatAdvertisement ad) {
		super.update(ad);
	}

	@Override
	public SatAdvertisement loadByArticleIdAndOpenId(String openid, String articleId) {
		HashMap<String, Object> params = new HashMap<>();
		params.put("openid", openid);
		params.put("articleId", articleId);
		return super.loadBySqlId("loadByArticleIdAndOpenId", params);
	}

	@Override
	public int selectCount(String openid) {
		HashMap<String, Object> params = new HashMap<>();
		params.put("openid", openid);
		return super.selectCount("selectCount", params);
	}
	
	
	
}
