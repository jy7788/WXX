package com.cn.hnust.dao.sat;

import java.util.List;

import com.cn.hnust.dao.IBaseDao;
import com.cn.hnust.model.sat.SatUser;


public interface ISatUserDao extends IBaseDao<SatUser>{
	public SatUser loadByUsername(String username);
	public SatUser loadByOpenId(String openid);
	public List<SatUser> list();
	public SatUser loadByPhoneNum(String phoneNum);
	public List<SatUser> listOthers(String openid);
	public void insertOrUpdate(SatUser u); 
}
