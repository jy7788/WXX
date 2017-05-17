/*package org.zsl.testmybatis;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.cn.hnust.dao.IPersonDao;
import com.cn.hnust.model.Pager;
import com.cn.hnust.model.Person;
import com.cn.hnust.model.SystemContext;
import com.cn.hnust.pojo.User;
import com.cn.hnust.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)		//琛ㄧず缁ф壙浜哠pringJUnit4ClassRunner绫�
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})

public class TestMyBatis {
	private static Logger logger = Logger.getLogger(TestMyBatis.class);
//	private ApplicationContext ac = null;
	@Resource
	private IUserService userService = null;
	
	@Resource
	private IPersonDao personDao;
	
//	@Before
//	public void before() {
//		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		userService = (IUserService) ac.getBean("userService");
//	}

	public static Logger getLogger() {
		return logger;
	}

	public static void setLogger(Logger logger) {
		TestMyBatis.logger = logger;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	@Test
	public void test1() {
		User user = userService.getUserById(1);
		// System.out.println(user.getUserName());
		// logger.info("鍊硷細"+user.getUserName());
		logger.info(JSON.toJSONString(user));
	}
	
	@Test
	public void testUpdate() {
		User u  = userService.getUserById(1);
		u.setPassword("lllllll");
		userService.updateUser(u);
	}
	
	@Test
	public void testDelete() {
		userService.deleteUserById(1);
	}
	
	@Test
	public void testInsert() {
		User u = new User();
		u.setPassword("aaa");
		u.setUserName("aaa");
		u.setAge(22);
//		User user = userService.getUserByUsername("马叔叔");
//		if(u.getUserName().equals(user.getUserName())) {
//			throw new MyException("用户已经存在");
//		}
		userService.insertUser(u);
//		ud.insert(u);
	}
	@Test
	public void testAdd() {
		Person p = new Person();
		p.setNickName("马叔叔");
		p.setPersonName("马叔叔");
		personDao.add(p);
	}
	
	@Test
	public void testSelect() {
		Person p = personDao.load(1);
		System.out.println(p.getNickName());
	}
	
	@Test
	public void testUpdatePerson() {
		Person p = personDao.load(1);
		p.setNickName("fanfte");
		Person np = new Person();
		np.setNickName(p.getNickName());
		np.setPersonName(p.getPersonName());
		personDao.update(p);
	}
	
	@Test
	public void testDeletePerson() {
		personDao.delete(1);
	}
	
	@Test
	public void testFindAll() {
		SystemContext.setSize(15);
		SystemContext.setOffset(0);
		SystemContext.setOrder("desc");
		SystemContext.setSort("nickName");
		System.out.println("aaa");
		Pager<Person> pager = personDao.find("马");
		List<Person> datas = pager.getDatas();
		for(Person p:datas) {
			System.out.println(p.getNickName());
		}
	}
}
*/