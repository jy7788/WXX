package com.cn.hnust.dao.pa;

import java.util.List;

import com.cn.hnust.dao.IBaseDao;
import com.cn.hnust.model.pa.PAUser;


public interface IPAUserDao extends IBaseDao<PAUser>{
	public PAUser loadByUsername(String username);
	public PAUser loadByOpenId(String openid);
	public List<PAUser> list();
	public List<PAUser> listOthers();
	public PAUser loadByPhoneNum(String phoneNum);
}
