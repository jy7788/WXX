package com.cn.hnust.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.IFiveBookUserDao;
import com.cn.hnust.exception.WXException;
import com.cn.hnust.model.FiveBookUser;

@Service("fiveBookUserService")
public class FiveBookUserService implements IFiveBookUserService{

	@Resource
	private IFiveBookUserDao fiveBookUserDao;
	
	@Override
	public FiveBookUser load(int id) {
		return fiveBookUserDao.findById(FiveBookUser.class, id);
	}

	@Override
	public void add(FiveBookUser u) {
		fiveBookUserDao.add(u);
	}

	@Override
	public void delete(int id) {
		fiveBookUserDao.delete(FiveBookUser.class, id);
	}

	@Override
	public void update(FiveBookUser u) {
		fiveBookUserDao.update(u);
	}

	@Override
	public FiveBookUser login(String username, String password) {
		FiveBookUser user = fiveBookUserDao.loadByUsername(username);
		if(user == null) {
			throw new WXException("该用户不存在");
		}
		if(!user.getPassword().equals(password)) {
			throw new WXException("用户名密码错误");
		}
		return user;
	}
	
	public List<FiveBookUser> list() {
		return fiveBookUserDao.list();
	}

	@Override
	public FiveBookUser loadByOpenId(String id) {
		return fiveBookUserDao.loadByOpenId(id);
	}

	@Override
	public FiveBookUser loadByUserName(String username) {
		return fiveBookUserDao.loadByUsername(username);
	}

}
