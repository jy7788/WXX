package com.cn.hnust.dao;

import java.util.List;

import com.cn.hnust.model.User;


public interface IUserDao extends IBaseDao<User>{
	public User loadByUsername(String username);
	public User loadByOpenId(String openid);
	public List<User> list();
}
