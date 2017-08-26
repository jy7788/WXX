package com.fanfte.sat.testuser;

import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cn.hnust.dao.sat.ISatArticleShareDao;
import com.cn.hnust.model.sat.SatArticleShare;


@RunWith(SpringJUnit4ClassRunner.class)		
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TestSatArticleShareDao {
	
	@Resource
	private ISatArticleShareDao satArticleShareDao;

	
	@Test
	public void testInsert() {
		SatArticleShare s = new SatArticleShare();
		s.setId(UUID.randomUUID().toString());
		s.setUserId("oNG7At-eteDqJ5rBCwwQ1mIWRrF8");
		s.setArticleId("320905");
		s.setAdvisId("c36a550c-ba7d-4a45-b387-18e642c0b976");
		s.setCreateTime(new Date());
		s.setUpdateTime(new Date());
		satArticleShareDao.add(s);
	}
}
