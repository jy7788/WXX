package com.cn.hnust.dao.pa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cn.hnust.dao.BaseDao;
import com.cn.hnust.model.Pager;
import com.cn.hnust.model.SystemContext;
import com.cn.hnust.model.pa.PAUser;
import com.cn.hnust.model.pa.PAUserRequest;


@Repository("pAUserRequestDao")
public class PAUserRequestDao extends BaseDao<PAUserRequest> implements IPAUserRequestDao{

	@Override
	public PAUserRequest loadByOpenids(String rOpenid, String aOpenid) {
		Map<String ,Object> params = new HashMap<>();
		params.put("rOpenid", rOpenid);
		params.put("aOpenid", aOpenid);
		return super.loadBySqlId("loadByOpenids", params);
	}

	@Override
	public List<PAUserRequest> listByOpenIds(String rOpenid, String aOpenid) {
		Map<String ,Object> params = new HashMap<>();
		params.put("rOpenid", rOpenid);
		params.put("aOpenid", aOpenid);
		return super.list("listByOpenids", params);
	}



}
