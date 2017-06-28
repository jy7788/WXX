package org.zsl.testmybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cn.hnust.dao.pa.IPAUserDao;
import com.cn.hnust.dao.pa.IPAUserRequestDao;
import com.cn.hnust.model.pa.PAUser;
import com.cn.hnust.model.pa.PAUserRequest;

@RunWith(SpringJUnit4ClassRunner.class)		//琛ㄧず缁ф壙浜哠pringJUnit4ClassRunner绫�
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TestPAUserDao {
	private static Logger logger = Logger.getLogger(TestPAUserDao.class);
	
	@Resource
	private IPAUserDao pAUserDao;
	
	@Resource
	private IPAUserRequestDao pAUserRequestDao;
	@Test
	public void testAdd() {
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("openid", "oNG7At-eteDqJ5rBCwwQ1mIWRrF8");
		List<PAUser> list = pAUserDao.list("pAUserFindOthers", params);
		for(PAUser a : list) {
			System.out.println(a.getNickname());
		}
	}
	@Test
	public void testFindAuthed() {
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("openid", "%" + "oNG7At-eteDqJ5rBCwwQ1mIWRrF8" + "%");
		List<PAUser> list = pAUserDao.list("pAUserFindBinded", params);
		for(PAUser a:list) {
			System.out.println(a.getNickname());
		}
	}
	
	@Test
	public void testLoadByOpenids() {
		PAUserRequest userRequest = pAUserRequestDao.loadByOpenids("oNG7At-eteDqJ5rBCwwQ1mIWRrF8", "oNG7At75hSI0Qg6Wf_j41Va87UTQ");
		System.out.println(userRequest.getId());
	}
	
	@Test
	public void testfindBinded() {
//		Map<String, Object> params = new HashMap<>();
//		params.put("openid", "oNG7At-eteDqJ5rBCwwQ1mIWRrF8");
//		List<PAUser> list = pAUserDao.list("pAUserFindBinded", params);
//		for(PAUser u :list) {
//				System.out.println(u.getNickname());
//		}
	}
	
	@Test
	public void testfindBindMe() {
//		Map<String, Object> params = new HashMap<>();
//		params.put("openid", "oNG7At-eteDqJ5rBCwwQ1mIWRrF8");
//		List<PAUser> list = pAUserDao.list("pAUserFindBindMe", params);
//		for(PAUser u :list) {
//			System.out.println(u.getNickname());
//		}
	}
}
