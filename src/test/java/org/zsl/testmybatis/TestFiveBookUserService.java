package org.zsl.testmybatis;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cn.hnust.dao.IPersonDao;
import com.cn.hnust.dao.IUserDao;
import com.cn.hnust.model.FiveBookUser;
import com.cn.hnust.model.User;
import com.cn.hnust.service.IFiveBookUserService;

@RunWith(SpringJUnit4ClassRunner.class) // 琛ㄧず缁ф壙浜哠pringJUnit4ClassRunner绫�
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })

public class TestFiveBookUserService {
	private static Logger logger = Logger.getLogger(TestFiveBookUserService.class);
	// private ApplicationContext ac = null;

	@Resource
	private IPersonDao personDao;

	@Resource
	private IUserDao userDao;

	@Resource
	private IFiveBookUserService fiveBookUserService;
	// @Before
	// public void before() {
	// ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	// userService = (IUserService) ac.getBean("userService");
	// }

	public static Logger getLogger() {
		return logger;
	}

	public static void setLogger(Logger logger) {
		TestFiveBookUserService.logger = logger;
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
		User u = userDao.findById(User.class, 1);
		u.setNickname("fanfteeeeee");
		userDao.update(u);
	}

	@Test
	public void testFindAll() {
		List<User> list = userDao.list();
		for (User u : list) {
			System.out.println(u.getOpenid());
		}
	}

	@Test
	public void testAddFiveBookUser() {
		FiveBookUser u = new FiveBookUser();
		u.setUsername("fanfte");
		u.setNickname("fanfte");
		u.setArea("shanghai");
		u.setBind(0);
		u.setBirthday(new Date());
		u.setEmail("asdasd@123.com");
		u.setPassword("123");
		u.setOpenId("asdasd");
		u.setPhoneNum("123213511");
		u.setSex(1);
		fiveBookUserService.add(u);
	}

	@Test
	public void testFiveBookUserload() {
		FiveBookUser u = fiveBookUserService.load(1);
		System.out.println(u.getArea() + u.getBind() + u.getImgUrl() + u.getNickname() + u.getPassword()
				+ u.getPhoneNum() + u.getUsername() + u.getBirthday());
	}
	
	@Test
	public void testLoadAll() {
		List<FiveBookUser> list = fiveBookUserService.list();
		for(FiveBookUser u : list) {
			System.out.println(u.getArea() + u.getBind() + u.getImgUrl() + u.getNickname() + u.getPassword()
			+ u.getPhoneNum() + u.getUsername() + u.getBirthday());
		}
	}
	
	@Test
	public void testLoadFIveBookUser() {
		FiveBookUser user = fiveBookUserService.loadByOpenId("asdasd");
		System.out.println(user.getNickname());
	}
	
	@Test
	public void testLoadFIveBook() {
		FiveBookUser user = fiveBookUserService.load(1);
		System.out.println(user.getNickname());
	}
	
	@Test
	public void testLoadFIveBookUsername() {
		FiveBookUser user = fiveBookUserService.load(1);
		System.out.println(user.getNickname());
	}
}
