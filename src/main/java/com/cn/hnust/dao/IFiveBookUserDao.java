package com.cn.hnust.dao;

import java.util.List;

import com.cn.hnust.model.FiveBookUser;


public interface IFiveBookUserDao extends IBaseDao<FiveBookUser>{
	public FiveBookUser loadByUsername(String username);
	public FiveBookUser loadByOpenId(String openid);
	public List<FiveBookUser> list();
}
