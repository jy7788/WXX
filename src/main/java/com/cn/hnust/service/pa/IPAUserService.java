package com.cn.hnust.service.pa;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cn.hnust.model.pa.PAUser;

@Service
public interface IPAUserService {
	public PAUser load(int id);
	public void add(PAUser u);
	public void delete(int id);
	public void update(PAUser u);
	public PAUser loadByOpenId(String id);
	public PAUser loadByUserName(String username);
	public List<PAUser> list();
}
