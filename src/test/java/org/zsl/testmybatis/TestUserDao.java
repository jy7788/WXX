package org.zsl.testmybatis;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cn.hnust.dao.IPersonDao;
import com.cn.hnust.dao.IUserDao;
import com.cn.hnust.dao.pa.IPAUserRequestDao;
import com.cn.hnust.model.User;
import com.cn.hnust.model.pa.PAUserRequest;

@RunWith(SpringJUnit4ClassRunner.class)		//琛ㄧず缁ф壙浜哠pringJUnit4ClassRunner绫�
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})

public class TestUserDao {
	private static Logger logger = Logger.getLogger(TestUserDao.class);
//	private ApplicationContext ac = null;
	
	@Resource
	private IPersonDao personDao;
	
	@Resource
	private IUserDao userDao;
//	@Before
//	public void before() {
//		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		userService = (IUserService) ac.getBean("userService");
//	}

	public static Logger getLogger() {
		return logger;
	}

	public static void setLogger(Logger logger) {
		TestUserDao.logger = logger;
	}
	
	@Test
	public void testAdd() {
		User u = new User();
		u.setUsername("fanfte3");
		u.setPassword("123");
		u.setNickname("fff");
		u.setOpenid("");
		u.setSex(1);
		u.setStatus(0);
		u.setImgUrl("");
		userDao.add(u);
	}
	
	@Test
	public void testLoad() {
		User user = userDao.findById(User.class, 1);
		System.out.println(user.getNickname());
	}
	
	@Test
	public void testLoadByOpenId() {
		User user = userDao.loadByOpenId("2");
		System.out.println(user.getNickname());
		
	}
	
	@Test
	public void testLoadByUserName() {
		User user = userDao.loadByUsername("fanfte");
		System.out.println(user.getNickname());
		
	}
	
	@Test
	public void testUpdateUser() {
		User u = userDao.findById(User.class,1);
		u.setNickname("fanfteeeeee");
		userDao.update(u);
	}
	
	@Test
	public void testFindAll() {
		List<User> list = userDao.list();
		for(User u:list) {
			System.out.println(u.getOpenid());
		} 
	}
	
	
	
}
