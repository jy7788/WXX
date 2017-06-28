package com.cn.hnust.service.pa;


import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.cn.hnust.dao.pa.IPAUserRequestDao;
import com.cn.hnust.model.pa.PAUserRequest;

@Service("pAUserRequestService")
public class PAUserRequestService implements IPAUserRequestService{

	@Resource
	private IPAUserRequestDao pAUserRequestDao;
	
	@Override
	public PAUserRequest load(int id) {
		return pAUserRequestDao.findById(PAUserRequest.class, id);
	}

	@Override
	public void add(PAUserRequest u) {
		pAUserRequestDao.add(u);
	}

	@Override
	public void delete(int id) {
		pAUserRequestDao.delete(PAUserRequest.class, id);
	}

	@Override
	public void update(PAUserRequest u) {
		pAUserRequestDao.update(u);
	}

	@Override
	public PAUserRequest loadByOpenIds(String rOpenid, String aOpenid) {
		return pAUserRequestDao.loadByOpenids(rOpenid, aOpenid);
	}

	@Override
	public List<PAUserRequest> listByOpenIds(String rOpenid, String aOpenid) {
		return pAUserRequestDao.listByOpenIds(rOpenid, aOpenid);
	}
	
}
