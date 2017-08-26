package com.cn.hnust.service.sat;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cn.hnust.dao.sat.ISatArticleDao;
import com.cn.hnust.model.sat.SatArticle;

@Service("satArticleService")
public class SatArticleService implements ISatArticleService{
	
	@Resource
	private ISatArticleDao satArticleDao;

	@Override
	public List<SatArticle> listBySatArticleTitle(String title) {
		return satArticleDao.listBySatArticleTitle(title);
	}

	@Override
	public List<SatArticle> listSatArticlesByOpenId(String openid) {
		return satArticleDao.listSatArticlesByOpenId(openid);
	}

	@Override
	public SatArticle loadContentById(String id) {
		return satArticleDao.loadContentById(id);
	}

	@Override
	public SatArticle loadArticleById(String id) {
		return satArticleDao.loadArticleById(id);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void insert(SatArticle article) {
		satArticleDao.add(article);
		satArticleDao.addContent(article);
	}

	@Override
	public void update(SatArticle article) {
		satArticleDao.update(article);
	}

	@Override
	public void deleteByUUID(String id) {
		satArticleDao.deleteByUUID(id);
	}

	@Override
	public void insertContent(SatArticle article) {
		satArticleDao.addContent(article);
	}

	@Override
	public List<SatArticle> list() {
		return satArticleDao.list();
	}

	@Override
	public SatArticle loadMyArticleContent(String id) {
		return satArticleDao.loadMyArticleContent(id);
	}

	@Override
	public List<SatArticle> listByClassifyName(String name) {
		return satArticleDao.listArticleByClassifyName(name);
	}

	@Override
	public List<SatArticle> listSatArticleLike(String title) {
		return satArticleDao.listArticlesLike(title);
	}
}
