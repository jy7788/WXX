package com.cn.hnust.service.pa;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cn.hnust.model.pa.PAUserRequest;

@Service
public interface IPAUserRequestService {
	public PAUserRequest load(int id);
	public void add(PAUserRequest r);
	public void delete(int id);
	public void update(PAUserRequest r);
	public PAUserRequest loadByOpenIds(String rOpenid, String aOpenid);
	public List<PAUserRequest> listByOpenIds(String rOpenid, String aOpenid);
//	public List<PAUserRequest> list();
}
