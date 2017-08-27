package com.fanfte.sat.testuser;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.cn.hnust.dao.sat.ISatArticleDao;
import com.cn.hnust.htmlparser.HtmlParser;
import com.cn.hnust.json.ArticleContentJson;
import com.cn.hnust.kit.kit.WeixinBasicKit;
import com.cn.hnust.model.json.sat.ArticleJson;
import com.cn.hnust.model.json.sat.MobileArticleJson;
import com.cn.hnust.model.sat.SatArticle;
import com.cn.hnust.util.JsonUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@RunWith(SpringJUnit4ClassRunner.class)		
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TestSatArticleDao {
	
	@Resource
	private ISatArticleDao satArticleDao;

	@Test
	public void testInsert() {
		SatArticle article = new SatArticle();
		article.setId(UUID.randomUUID().toString());
		article.setContent("aaa");
		article.setCreateTime(new Date());
//		article.setOpenid("asdsa");
//		article.setSelfCreated(0);
		article.setShares(22);
		article.setStars(33);
		article.setTitle("title");
		article.setUpdateTime(new Date());
		article.setWatches(100);
		satArticleDao.insert(article);
	}
	
	@Test
	public void testLoadByOpenId() {
		SatArticle satArticle = satArticleDao.loadArticleById("f5968b01-b38b-48e3-b786-c2ce9fd69a86");
		//System.out.println(satArticle.getOpenid());
		
	}
	
	@Test
	public void testDelete() {
		satArticleDao.deleteByUUID("de7c4401-b80e-45d6-9dea-32401f767c98");
	}
	
	@Test
	public void testUpdate() {
		SatArticle satArticle = satArticleDao.loadArticleById("f5968b01-b38b-48e3-b786-c2ce9fd69a86");
		satArticle.setStars(99);
		satArticle.setUpdateTime(new Date());
		satArticleDao.update(satArticle);
	}
	
	@Test
	public void listByOpenid() {
		List<SatArticle> list = satArticleDao.listSatArticlesByOpenId("asdsa");
		System.out.println(list.size());
		for(SatArticle s : list) {
			System.out.println(s.getUpdateTime());
		}
	}
	
	@Test
//	@Transactional(rollbackFor=Exception.class)
	public void testParseHtml() {
		String html = HtmlParser.parseHTML("http://mp.weixin.qq.com/s/Nf93qMQ-poMGswecEGDIYA");
		
		SatArticle article = new SatArticle();
		article.setId(UUID.randomUUID().toString());
		article.setContent(html);
//		article.setOpenid("fanfte");
//		article.setSelfCreated(1);
		article.setShares(111);
		article.setTitle("title11");
		article.setStars(222);
		article.setUpdateTime(new Date());
		article.setCreateTime(new Date());
		article.setWatches(2333);
		satArticleDao.add(article);
		satArticleDao.addContent(article);
	}

	@Test
	//@Transactional(rollbackFor=Exception.class)
	public void testGetArticleMessage() {
		String urlPosst = "https://api.wallstreetcn.com/v2/posts/";
		String postResult = WeixinBasicKit.sendGet("https://api.wallstreetcn.com/v2/mobile-articles");
		System.out.println(postResult);
		
		MobileArticleJson obj = (MobileArticleJson) JsonUtil.getInstance().json2Obj(postResult, MobileArticleJson.class);
		List<ArticleJson> results = obj.getResults();
		
		for(int i = 0; i < results.size() ;i++) {
			ArticleJson articleJson = results.get(i);
			String url = articleJson.getImg().getUrl();
			System.out.println(articleJson.getId());
			
			SatArticle article = satArticleDao.loadArticleById(articleJson.getId() + "");
			if(article == null) {
				String html = HtmlParser.parseHTML(articleJson.getUrl());
				SatArticle mArticle = new SatArticle();
				mArticle.setId(articleJson.getId() + "");
				mArticle.setCreateTime(new Date(articleJson.getCreatedAt() * 1000));
				mArticle.setUpdateTime(new Date(articleJson.getCreatedAt() * 1000));
				mArticle.setShares(0);
//				mArticle.setSelfCreated(0);
				mArticle.setUrl(articleJson.getUrl());
				mArticle.setStars(0);
				mArticle.setWatches(0);
				mArticle.setTitle(articleJson.getTitle());
				mArticle.setDescImgUrl(articleJson.getImg().getUrl());
				String content = WeixinBasicKit.sendGet(urlPosst + articleJson.getId());
				ArticleContentJson articleContentJson = (ArticleContentJson) JsonUtil.getInstance().json2Obj(content, ArticleContentJson.class);
				//System.out.println(articleContentJson.getContent());
				mArticle.setContent(articleContentJson.getContent());
				mArticle.setArticleId(articleJson.getId() + "");
				add(mArticle);
			}
		}
	}
	@Transactional(rollbackFor=Exception.class)
	public void add(SatArticle mArticle) {
		try{
			satArticleDao.add(mArticle);
			satArticleDao.insertContent(mArticle);
		} catch (Exception e) {
			return;
		}
	}
	
	@Test
	public void testList() {
		PageHelper.startPage(1, 3);
		List<SatArticle> list  = satArticleDao.list();
		PageInfo<SatArticle> page = new PageInfo<SatArticle>(list);
		for(SatArticle a : list) {
			System.out.println(a.getCreateTime());
		}
		
		PageHelper.startPage(2, 3);
		List<SatArticle> list2  = satArticleDao.list();
		PageInfo<SatArticle> page2 = new PageInfo<SatArticle>(list2);
		System.out.println(page2.getNextPage());
		System.out.println(page2.getLastPage());
		
	}
	
	@Test
	public void loadArticleContent() {
		SatArticle satArticle = satArticleDao.loadContentById(316681 + "");
		System.out.println(satArticle.getContent());
		System.out.println(satArticle.getTitle());
	}
	
	@Test
	public void testLoadMyArticles() {
		List<SatArticle> myArticles = satArticleDao.listMyArticles("316681", "oNG7At-eteDqJ5rBCwwQ1mIWRrF8");
		for(SatArticle a: myArticles) {
			System.out.println(a.getDescImgUrl());
		}
	}
	@Test
	public void testLoadMyArticle() {
		SatArticle loadMyArticle = satArticleDao.loadMyArticle("316681", "oNG7At-eteDqJ5rBCwwQ1mIWRrF8");
		//System.out.println(loadMyArticle.getOpenid());
	}
	@Test
	public void testLoadMyArticleLike() {
		List<SatArticle> newsLike = satArticleDao.listNewsLike("日");
		for(SatArticle a : newsLike) {
			System.out.println(a.getTitle());
		}
	}
	
	@Test
	public void testDeleteByIds() {
		satArticleDao.deleteByIds("316681", "oNG7At-eteDqJ5rBCwwQ1mIWRrF8");
	}
	@Test
	public void loadMyArticleContent() {
		SatArticle satArticle = satArticleDao.loadMyArticleContent("320931");
		System.out.println(satArticle.getContent());
	} 
	
	@Test
	public void testListByCId() {
		List<SatArticle> list = satArticleDao.listArticleByClassifyId("1");
		System.out.println(list.size());
		for(SatArticle a : list ) {
			System.out.println(a.getTitle());
		} 
	}
	
	@Test
	public void testListByCName() {
		List<SatArticle> list = satArticleDao.listArticleByClassifyName("体育");
		System.out.println(list.size());
		for(SatArticle a : list ) {
			System.out.println(a.getTitle());
		} 
	}
	
	@Test
	public void testCollect() {
		satArticleDao.collectArticle("8785c7c3-19b9-41d5-8126-2c5a1530a70b", "320828");
	}
	
	@Test
	public void testMyCollections() {
		List<SatArticle> myCollections = satArticleDao.listMyCollections("8785c7c3-19b9-41d5-8126-2c5a1530a70b");
		for(SatArticle a : myCollections) {
			System.out.println(a.getDescImgUrl());
		}
	}
	
	@Test
	public void testCollections() {
		List<SatArticle> myCollections = satArticleDao.listCollectArticles("oNG7At-eteDqJ5rBCwwQ1mIWRrF8", "320931");
		System.out.println(myCollections.size());
		for(SatArticle a : myCollections) {
			System.out.println(a.getDescImgUrl());
		}
	}
	
	@Test
	public void testListMyArticles() {
		List<SatArticle> list = satArticleDao.listSatArticlesByOpenId("oNG7At-eteDqJ5rBCwwQ1mIWRrF8");
		for(SatArticle a : list) {
			System.out.println(a.getDescImgUrl());
		}
	}
	
	@Test
	public void testListMyLike() {
		List<SatArticle> list = satArticleDao.listArticlesLike("的");
		for(SatArticle a : list) {
			System.out.println(a.getDescImgUrl());
		}
	}
	
	@Test
	public void testdeleteMyCollection() {
		satArticleDao.deleteMyCollection("oNG7At-eteDqJ5rBCwwQ1mIWRrF8", "320908");
	}
}
