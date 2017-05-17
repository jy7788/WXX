package com.cn.hnust.service;

import java.util.List;

import com.cn.hnust.model.User;

public interface IUserService {
	public User load(int id);
	public void add(User u);
	public void delete(int id);
	public void update(User u);
	public User login(String username, String password);
	public List<User> list();
	public User loadByOpenId(String id);
}
