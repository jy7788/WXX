package com.cn.hnust.service.sat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.hnust.dao.sat.ISatAdvertisementDao;
import com.cn.hnust.model.sat.SatAdvertisement;

@Service("satAdService")
public class SatAdService implements ISatAdService{
	
	@Autowired
	private ISatAdvertisementDao satAdvertisementDao;

	@Override
	public void insertAd(SatAdvertisement ad) {
		satAdvertisementDao.add(ad);
	}

	@Override
	public void updateAd(SatAdvertisement ad) {
		satAdvertisementDao.update(ad);;
	}

	@Override
	public List<SatAdvertisement> getAdsByUserId(String userId) {
		return satAdvertisementDao.listByOpenid(userId);
	}

	@Override
	public SatAdvertisement load(String id) {
		SatAdvertisement satAdvertisement = satAdvertisementDao.loadById(id);
		return satAdvertisement;
	}

	@Override
	public SatAdvertisement loadArticleAd(String openid, String articleId) {
		SatAdvertisement advertisement = satAdvertisementDao.loadByArticleIdAndOpenId(openid, articleId);
		return advertisement;
	}

	@Override
	public Integer getCount(String openid) {
		return satAdvertisementDao.selectCount(openid);
	}
	
	

}
