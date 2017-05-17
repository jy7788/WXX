package com.cn.hnust.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cn.hnust.model.FiveBookUser;
import com.cn.hnust.model.SystemContext;
import com.cn.hnust.model.User;


@Repository("fiveBookUserDao")
public class FiveBookUserDao extends BaseDao<FiveBookUser> implements IFiveBookUserDao{

	public FiveBookUser loadByUsername(String username) {
		return super.loadBySqlId("loadByFiveBookUserName", username);
	}

	public FiveBookUser loadByOpenId(String openid) {
		return super.loadBySqlId("loadByFiveBookOpenId", openid);
	}

	public List<FiveBookUser> list() {
		SystemContext.setSize(15);
		SystemContext.setOffset(0);
		return super.list("FiveBookUserFindAll", null);
	}

}
