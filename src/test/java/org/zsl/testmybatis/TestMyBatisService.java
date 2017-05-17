package org.zsl.testmybatis;

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
import com.cn.hnust.model.WeixinMenu;
import com.cn.hnust.pojo.User;
import com.cn.hnust.service.IUserService;
import com.cn.hnust.service.IWeixinMenuService;

@RunWith(SpringJUnit4ClassRunner.class)		//琛ㄧず缁ф壙浜哠pringJUnit4ClassRunner绫�
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})

public class TestMyBatisService {
	private static Logger logger = Logger.getLogger(TestMyBatisService.class);
//	private ApplicationContext ac = null;
	@Resource
	private IUserService userService = null;
	
	@Resource
	private IPersonDao personDao;
	
	@Resource
	private IWeixinMenuService weixinMenuService;
	
//	@Before
//	public void before() {
//		ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		userService = (IUserService) ac.getBean("userService");
//	}

	public static Logger getLogger() {
		return logger;
	}

	public static void setLogger(Logger logger) {
		TestMyBatisService.logger = logger;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
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
	
	@Test
	public void testWeixinMenuListAll() {
		SystemContext.setSize(15);
		SystemContext.setOffset(0);
		SystemContext.setOrder("desc");
		
		List<WeixinMenu> list = weixinMenuService.listAll();
		for(WeixinMenu menu: list) {
			System.out.println(menu.getContent());
		}
	}
	
	@Test
	public void testLoadMenuByKey() {
		WeixinMenu loadByKey = weixinMenuService.loadByKey("yssq");
		System.out.println(loadByKey.getName());
	}
}
