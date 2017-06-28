package com.cn.hnust.dao.pa;

import java.util.List;

import com.cn.hnust.dao.IBaseDao;
import com.cn.hnust.model.pa.PAUserRequest;


public interface IPAUserRequestDao extends IBaseDao<PAUserRequest>{
	public PAUserRequest loadByOpenids(String rOpenid, String aOpenid);
	//public void insert();
//	public PAUser loadByUsername(String username);
//	public PAUser loadByOpenId(String openid);
//	public List<PAUser> list();
//	public List<PAUser> listOthers();
//	public PAUser loadByPhoneNum(String phoneNum);
	public List<PAUserRequest> listByOpenIds(String rOpenid, String aOpenid);
}
