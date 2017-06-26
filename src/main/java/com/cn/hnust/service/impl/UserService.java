package com.cn.hnust.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.IUserDao;
import com.cn.hnust.exception.WXException;
import com.cn.hnust.model.User;
import com.cn.hnust.service.IUserService;

@Service("userService")
public class UserService implements IUserService{

	@Resource
	private IUserDao userDao;
	
	@Override
	public User load(int id) {
		return userDao.findById(User.class, id);
	}

	@Override
	public void add(User u) {
		userDao.add(u);
	}

	@Override
	public void delete(int id) {
		userDao.delete(User.class, id);
	}

	@Override
	public void update(User u) {
		userDao.update(u);
	}

	@Override
	public User login(String username, String password) {
		User user = userDao.loadByUsername(username);
		if(user == null) {
			throw new WXException("用户为空");
		}
		if(!user.getPassword().equals(password)) {
			throw new WXException("用户名或密码错误");
		}
		return user;
	}
	
	public List<User> list() {
		return userDao.list();
	}

	@Override
	public User loadByOpenId(String id) {
		return userDao.loadByOpenId(id);
	}

}
