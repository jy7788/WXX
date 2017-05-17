package com.cn.hnust.service;

import java.util.List;

import com.cn.hnust.model.FiveBookUser;

public interface IFiveBookUserService {
	public FiveBookUser load(int id);
	public void add(FiveBookUser u);
	public void delete(int id);
	public void update(FiveBookUser u);
	public FiveBookUser login(String username, String password);
	public List<FiveBookUser> list();
	public FiveBookUser loadByOpenId(String id);
	public FiveBookUser loadByUserName(String username);
}
