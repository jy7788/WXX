package com.fanfte.sat.testuser;

import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cn.hnust.dao.sat.ISatAdvertisementDao;
import com.cn.hnust.dao.sat.ISatArticleDao;
import com.cn.hnust.model.sat.SatAdvertisement;
import com.cn.hnust.model.sat.TSatAdvertisement;


@RunWith(SpringJUnit4ClassRunner.class)		
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TestSatArticleAdvertisementMapper {
	
	@Resource
	private ISatArticleDao satArticleDao;
	@Resource
	private ISatAdvertisementDao satAdvertisementDao;
	@Test
	public void testInsert() {
		TSatAdvertisement ad = new TSatAdvertisement();
		ad.setId("asds");
		ad.setOpenId("asdasd");
		ad.setDesc("asdasd");
		ad.setImgUrl("asdasd");
		ad.setUpdateTime(new Date());
		ad.setCreateTime(new Date());
	}
	
	@Test
	public void testLoad() {
		SatAdvertisement loadById = satAdvertisementDao.loadById("aa");
		System.out.println(loadById);
	}
	
	@Test
	public void testInsert2() {
		SatAdvertisement ad = new SatAdvertisement();
		ad.setId(UUID.randomUUID().toString());
		ad.setCreateTime(new Date());
		ad.setDescription("asdasd");
		ad.setImgUrl("sadasd");
		ad.setLinkUrl("aasdasd");
		ad.setOpenid("asfas");
		ad.setUpdateTime(new Date());
		satAdvertisementDao.add(ad);
	} 
	@Test
	public void testDelete(){
		satAdvertisementDao.deleteByUUID(SatAdvertisement.class, "adcddc98-3010-4e72-a21b-4d0421165214");
	}
	
	@Test
	public void testUpdate() {
		SatAdvertisement loadById = satAdvertisementDao.loadById("cbe68caa-2b7e-4847-9958-334664db8ac9");
		loadById.setDescription("description");
		satAdvertisementDao.update(loadById);
	}
	
	@Test
	public void testSelectCount() {
		int count = satAdvertisementDao.selectCount("oNG7At-eteDqJ5rBCwwQ1mIWRrF8");
		System.out.println(count);
	}
}
