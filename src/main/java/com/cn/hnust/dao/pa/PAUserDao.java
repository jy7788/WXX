package com.cn.hnust.dao.pa;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cn.hnust.dao.BaseDao;
import com.cn.hnust.model.SystemContext;
import com.cn.hnust.model.pa.PAUser;


@Repository("pAUserDao")
public class PAUserDao extends BaseDao<PAUser> implements IPAUserDao{

	public PAUser loadByUsername(String username) {
		return super.loadBySqlId("loadByPAUserName", username);
	}

	public PAUser loadByOpenId(String openid) {
		return super.loadBySqlId("loadByPAUserOpenId", openid);
	}

	public List<PAUser> list() {
		SystemContext.setSize(15);
		SystemContext.setOffset(0);
		return super.list("pAUserFindAll", null);
	}

	@Override
	public List<PAUser> listOthers(String openid) {
		return super.list("pAUserFindOthers", null);
	}

	@Override
	public PAUser loadByPhoneNum(String phoneNum) {
		return super.loadBySqlId("loadByPhoneNum", phoneNum);
	}

}
