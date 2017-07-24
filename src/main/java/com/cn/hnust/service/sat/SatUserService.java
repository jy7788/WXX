package com.cn.hnust.service.sat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.sat.ISatUserDao;
import com.cn.hnust.model.sat.SatUser;

@Service("satUserService")
public class SatUserService implements ISatUserService{

	@Resource
	private ISatUserDao satUserDao;
	
	@Override
	public SatUser load(int id) {
		return satUserDao.findById(SatUser.class, id);
	}

	@Override
	public void add(SatUser u) {
		satUserDao.add(u);
	}

	@Override
	public void delete(int id) {
		satUserDao.delete(SatUser.class, id);
	}

	@Override
	public void update(SatUser u) {
		satUserDao.update(u);
	}
	
	public List<SatUser> list() {
		return satUserDao.list();
	}

	@Override
	public SatUser loadByOpenId(String id) {
		return satUserDao.loadByOpenId(id);
	}

	@Override
	public SatUser loadByUserName(String username) {
		return satUserDao.loadByUsername(username);
	}

	@Override
	public List<SatUser> listBinded(String openid) {
		Map<String, Object> params = new HashMap<>();
		params.put("openid", openid);
		return satUserDao.list("satUserFindBinded", params);
	}
	@Override
	public List<SatUser> listBindMe(String openid) {
		Map<String, Object> params = new HashMap<>();
		params.put("openid", openid);
		List<SatUser> list = satUserDao.list("satUserFindBindMe", params);
		return list;
	}

	@Override
	public List<SatUser> listOthers(String openid) {
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("openid", openid);
		List<SatUser> list = satUserDao.list("satUserFindOthers", params);
		return list;
	}
	
	public SatUser loadByPhoneNum(String phoneNum) {
		return satUserDao.loadByPhoneNum(phoneNum);
	}

}
