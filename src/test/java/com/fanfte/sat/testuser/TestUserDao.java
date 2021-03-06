package com.fanfte.sat.testuser;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cn.hnust.dao.sat.ISatUserDao;
import com.cn.hnust.model.sat.SatUser;
import com.cn.hnust.service.sat.ISatUserService;


@RunWith(SpringJUnit4ClassRunner.class)		
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TestUserDao {
	
	@Resource
	private ISatUserDao satUserDao;

	@Resource
	private ISatUserService satUserService;
	
	@Test
	public void testInsert() {
		SatUser satUser = new SatUser();
		satUser.setArea("上海");
		satUser.setBind(1);
		satUser.setEmail("854016433@qq.com");
		satUser.setImgUrl("aaa");
		satUser.setNickname("fanfte");
		satUser.setOpenid("openid");
		satUser.setOrganization("平安");
		satUser.setPassword("123456");
		satUser.setPhoneNum("18017468453");
		satUser.setQrCode("aasd");
		satUser.setSex(1);
		satUser.setSignature("fanfte22");
		satUser.setStatus(1);
		satUser.setTrade("银行");
		satUser.setUsername("fanfte222");
		satUser.setBirthday((new Date()).toString());
		satUserDao.insertOrUpdate(satUser);
	}
	
	@Test
	public void testLoadByOpenId() {
		SatUser satUser = satUserDao.loadByOpenId("oNG7At-eteDqJ5rBCwwQ1mIWRrF8");
		System.out.println(satUser.getSignature());
	}
	
	@Test
	public void testloadService() {
		SatUser satUser = satUserService.loadByOpenId("oNG7At-eteDqJ5rBCwwQ1mIWRrF8");
		System.out.println(satUser.getPhoneNum());
	}

}
