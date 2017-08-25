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

import com.cn.hnust.dao.sat.ISatAdvertisementDao;
import com.cn.hnust.dao.sat.ISatArticleDao;
import com.cn.hnust.htmlparser.HtmlParser;
import com.cn.hnust.json.ArticleContentJson;
import com.cn.hnust.kit.kit.WeixinBasicKit;
import com.cn.hnust.model.json.sat.ArticleJson;
import com.cn.hnust.model.json.sat.MobileArticleJson;
import com.cn.hnust.model.sat.SatAdvertisement;
import com.cn.hnust.model.sat.SatArticle;
import com.cn.hnust.util.JsonUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


@RunWith(SpringJUnit4ClassRunner.class)		
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TestSatAdDao {
	
	@Resource
	private ISatAdvertisementDao satAdvertisementDao;

	@Test
	public void testloadByparams() {
		SatAdvertisement ad = satAdvertisementDao.loadByArticleIdAndOpenId("oNG7At-eteDqJ5rBCwwQ1mIWRrF8", "320828");
		System.out.println(ad.getDescription());
	}
	
	@Test
	public void testInsert() {
		SatAdvertisement ad = new SatAdvertisement();
		ad.setId(UUID.randomUUID().toString());
		ad.setDescription("guagngao ");
		ad.setName("吃的");
		ad.setOpenid("oNG7At-eteDqJ5rBCwwQ1mIWRrF8");
		ad.setCreateTime(new Date());
		ad.setUpdateTime(new Date());
		ad.setLinkUrl("http://www.baidu.com");
		satAdvertisementDao.add(ad);
	}
	
	@Test
	public void listMyAds() {
		List<SatAdvertisement> list = satAdvertisementDao.listByOpenid("oNG7At-eteDqJ5rBCwwQ1mIWRrF8");
		System.out.println(list.size());
		for(SatAdvertisement a: list) {
			System.out.println(a.getName());
		}
	}
	
}
