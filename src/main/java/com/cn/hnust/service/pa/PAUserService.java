package com.cn.hnust.service.pa;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.pa.IPAUserDao;
import com.cn.hnust.model.pa.PAUser;

@Service("pAUserService")
public class PAUserService implements IPAUserService{

	@Resource
	private IPAUserDao pAUserDao;
	
	@Override
	public PAUser load(int id) {
		return pAUserDao.findById(PAUser.class, id);
	}

	@Override
	public void add(PAUser u) {
		pAUserDao.add(u);
	}

	@Override
	public void delete(int id) {
		pAUserDao.delete(PAUser.class, id);
	}

	@Override
	public void update(PAUser u) {
		pAUserDao.update(u);
	}
	
	public List<PAUser> list() {
		return pAUserDao.list();
	}

	@Override
	public PAUser loadByOpenId(String id) {
		return pAUserDao.loadByOpenId(id);
	}

	@Override
	public PAUser loadByUserName(String username) {
		return pAUserDao.loadByUsername(username);
	}

}
