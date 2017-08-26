package com.cn.hnust.service.sat;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.hnust.dao.sat.ISatArticleShareDao;
import com.cn.hnust.model.sat.SatArticleShare;

@Service("satArticleShareService")
public class SatArticleShareService implements ISatArticleShareService{
	
	@Resource
	private ISatArticleShareDao satArticleShareDao;

	@Override
	public void insert(SatArticleShare s) {
		satArticleShareDao.add(s);
	}

	@Override
	public void update(SatArticleShare s) {
		satArticleShareDao.update(s);
	}

	@Override
	public void insertOrUprate(String openid, String articleId) {
		SatArticleShare share = satArticleShareDao.loadByUserIdAndArticleId(openid, articleId);
	}

	@Override
	public SatArticleShare load(String openid, String articleId) {
		return satArticleShareDao.loadByUserIdAndArticleId(openid, articleId);
	}

	
}
