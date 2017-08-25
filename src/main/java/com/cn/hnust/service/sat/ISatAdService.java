package com.cn.hnust.service.sat;

import java.util.List;

import com.cn.hnust.model.sat.SatAdvertisement;

public interface ISatAdService {
	public void insertAd(SatAdvertisement ad);
	
	public void updateAd(SatAdvertisement ad);
	
	public List<SatAdvertisement> getAdsByUserId(String userId);
	
	public SatAdvertisement load(String id);
	
	public SatAdvertisement loadArticleAd(String openid, String articleId);
	
	public Integer getCount(String openid); 
}
