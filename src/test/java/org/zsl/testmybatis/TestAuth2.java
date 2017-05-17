package org.zsl.testmybatis;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.cn.hnust.dao.IPersonDao;
import com.cn.hnust.json.TemplateMsg;
import com.cn.hnust.kit.kit.MessageCreateKit;
import com.cn.hnust.kit.kit.WeixinBasicKit;
import com.cn.hnust.kit.kit.WeixinMessageKit;
import com.cn.hnust.model.ModelMsgData;
import com.cn.hnust.model.Pager;
import com.cn.hnust.model.Person;
import com.cn.hnust.model.SystemContext;
import com.cn.hnust.model.WeixinContext;
import com.cn.hnust.model.WeixinFinalValue;
import com.cn.hnust.pojo.User;
import com.cn.hnust.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)		//琛ㄧず缁ф壙浜哠pringJUnit4ClassRunner绫�
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})

public class TestAuth2 {
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


	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
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
	public void testAuth() throws UnsupportedEncodingException {
		String url = WeixinFinalValue.AUTH_URL;
		url = url.replace("APPID", "wxc8544caaedbd00df");
		url = url.replace("STATE", "123");
		url = url.replace("REDIRECT_URI", URLEncoder.encode("http://1d6289976g.imwork.net", "utf-8"));
		String string = WeixinBasicKit.sendGet(url);
		System.out.println(string);
	}
	
	@Test
	public void testSendTemplateMessage() {
		TemplateMsg tm = new TemplateMsg();
		tm.setTouser("oNG7At-ll5mq7ecCch_hanzLmkVs");
		tm.setTemplate_id("q2CcBBHM9R0uwcd7rUESrPKYd95KNiICcR39e9Q9WPw");
		tm.setTopcolor("FF0000");
		tm.setUrl("http://1d6289976g.imwork.net/wx/wbsy.html");
		Map<String, Object> data = new HashMap<String,Object>();
		data.put("num", new ModelMsgData("111", "00ff00"));
		tm.setData(data);
		String string = MessageCreateKit.postTemplateMsg(tm);
		System.out.println(string);
	}
	
	@Test
	public void testxml() {
		String a = "<xml><ToUserName><![CDATA[gh_4e668de48ad1]]></ToUserName><FromUserName><![CDATA[oNG7At-eteDqJ5rBCwwQ1mIWRrF8]]></FromUserName><CreateTime>1484203457</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[鍥綸]></Content><MsgId>6374605308846400350</MsgId></xml>";
		try {
			Map<String,String> maps = new HashMap<String, String>();
			Document document = DocumentHelper.parseText(a);
			Element root = document.getRootElement();
			List<Element> eles = root.elements();
			for(Element e:eles) {
				maps.put(e.getName(), e.getTextTrim());
			}
			Set<String> keySet = maps.keySet();
			Iterator<String> iterator = keySet.iterator();
			while(iterator.hasNext()) {
				System.out.println(maps.get(iterator.next()));
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
}
