package com.cn.hnust.dao.sat;

import java.util.List;

import com.cn.hnust.dao.IBaseDao;
import com.cn.hnust.model.sat.SatAdvertisement;


public interface ISatAdvertisementDao extends IBaseDao<SatAdvertisement>{
	public SatAdvertisement loadById(String id);
	
	public void insert(SatAdvertisement ad) ;
	
	public List<SatAdvertisement> listByOpenid(String openid);
	
	public void deleteById(String adId);
	
	public void update(SatAdvertisement ad);
}
