package com.cn.hnust.controller.sat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.hnust.model.sat.SatArticle;
import com.cn.hnust.model.sat.SatArticleShare;
import com.cn.hnust.service.sat.ISatAdService;
import com.cn.hnust.service.sat.ISatArticleService;
import com.cn.hnust.service.sat.ISatArticleShareService;
import com.cn.hnust.service.sat.ISatUserService;
import com.cn.hnust.util.SatUtil;

@Controller
@RequestMapping("statistics")
public class StatisticController {
	
	@Autowired
	private ISatArticleService satArticleService;
	@Autowired
	private ISatArticleShareService satArticleShareService;
	
	/**
	 * 得到统计数据
	 */
	@RequestMapping(value="/getData", method=RequestMethod.POST)
	@ResponseBody
	public String getCount(HttpServletRequest request) {
		String openid = request.getParameter("openid");
		System.out.println("/getData" + openid);
		int shares = 0 , watches = 0, adClicks = 0;
		if(!StringUtils.isEmpty(openid)) {
			List<SatArticleShare> list = satArticleShareService.listByOpenid(openid);
			for(SatArticleShare a : list) {
				shares += a.getShares();
				watches += a.getWatches();
				adClicks += a.getAdvisClickCount();
			}
			Map<String, Object> map = new HashMap<>();
			map.put("shares", shares);
			map.put("watches", watches);
			map.put("adClicks", adClicks);
			String result = SatUtil.getJSONString(map);
			System.out.println(result);
			return result;
		}else {
			return "get failed";
		}
	}
}
