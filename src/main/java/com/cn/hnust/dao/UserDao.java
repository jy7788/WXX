package com.cn.hnust.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cn.hnust.model.SystemContext;
import com.cn.hnust.model.User;


@Repository("userDao")
public class UserDao extends BaseDao<User> implements IUserDao{

	public User loadByUsername(String username) {
		return super.loadBySqlId("loadByUserName", username);
	}

	public User loadByOpenId(String openid) {
		return super.loadBySqlId("loadByOpenId", openid);
	}

	public List<User> list() {
		SystemContext.setSize(15);
		SystemContext.setOffset(0);
		return super.list("UserFindAll", null);
	}

}
