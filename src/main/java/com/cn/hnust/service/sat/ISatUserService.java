package com.cn.hnust.service.sat;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cn.hnust.model.sat.SatUser;

public interface ISatUserService {
	public SatUser load(int id);
	public void add(SatUser u);
	public void delete(int id);
	public void update(SatUser u);
	public SatUser loadByOpenId(String id);
	public SatUser loadByUserName(String username);
	public List<SatUser> list();
	public List<SatUser> listBinded(String openid);
	public List<SatUser> listBindMe(String openid);
	public List<SatUser> listOthers(String openid);
	public SatUser loadByPhoneNum(String phoneNum);
}
