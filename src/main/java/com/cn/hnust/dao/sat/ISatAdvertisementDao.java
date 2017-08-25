package com.cn.hnust.dao.sat;

import java.util.List;
import java.util.Map;

import com.cn.hnust.dao.IBaseDao;
import com.cn.hnust.model.sat.SatAdvertisement;


public interface ISatAdvertisementDao extends IBaseDao<SatAdvertisement>{
	public SatAdvertisement loadById(String id);
	
	public void insert(SatAdvertisement ad) ;
	
	public List<SatAdvertisement> listByOpenid(String openid);
	
	public void deleteById(String adId);
	
	public void update(SatAdvertisement ad);
	
	public SatAdvertisement loadByArticleIdAndOpenId(String openid, String articleId);
	
	public int selectCount(String openid);
}
