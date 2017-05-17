package com.cn.hnust.service;

import com.cn.hnust.model.WUser;

public interface IWUserService {
	public WUser queryByOpenid(String openid) ;
	public String queryOpenidByCode(String code);
}
