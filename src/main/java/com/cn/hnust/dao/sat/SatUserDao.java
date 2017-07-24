package com.cn.hnust.dao.sat;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.cn.hnust.dao.BaseDao;
import com.cn.hnust.model.SystemContext;
import com.cn.hnust.model.sat.SatUser;


@Repository("satUserDao")
public class SatUserDao extends BaseDao<SatUser> implements ISatUserDao{

	public SatUser loadByUsername(String username) {
		return super.loadBySqlId("loadBySatUserName", username);
	}

	public SatUser loadByOpenId(String openid) {
		return super.loadBySqlId("loadBySatUserOpenId", openid);
	}

	public List<SatUser> list() {
		SystemContext.setSize(15);
		SystemContext.setOffset(0);
		return super.list("satUserFindAll", null);
	}

	@Override
	public List<SatUser> listOthers(String openid) {
		return super.list("satUserFindOthers", null);
	}

	@Override
	public SatUser loadByPhoneNum(String phoneNum) {
		return super.loadBySqlId("loadByPhoneNum", phoneNum);
	}

	@Override
	public void insertOrUpdate(SatUser u) {
		if(u.getOpenid() != null) {
			SatUser satUser = loadByOpenId(u.getOpenid());
			if(satUser != null) {
				satUser.setArea(u.getArea());
				satUser.setBind(u.getBind());
				satUser.setBirthday(u.getBirthday());
				satUser.setEmail(u.getEmail());
				satUser.setImgUrl(u.getImgUrl());
				satUser.setNickname(u.getNickname());
				satUser.setOrganization(u.getOrganization());
				satUser.setPassword(u.getPassword());
				satUser.setPhoneNum(u.getPhoneNum());
				satUser.setQrCode(u.getQrCode());
				satUser.setSex(u.getSex());
				satUser.setSignature(u.getSignature());
				satUser.setStatus(u.getStatus());
				satUser.setTrade(u.getTrade());
				satUser.setUsername(u.getUsername());
				super.update(satUser);
			} else {
				super.add(u);
			}
		} 
	}
	
	

}
