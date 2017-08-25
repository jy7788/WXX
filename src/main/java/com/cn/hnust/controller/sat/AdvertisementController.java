package com.cn.hnust.controller.sat;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.hnust.model.sat.SatAdvertisement;
import com.cn.hnust.service.sat.ISatAdService;

@Controller("advertisementController")
@RequestMapping("ad")
public class AdvertisementController {
	
	@Autowired
	private ISatAdService satAdService;
	/**
	 * 我的广告列表
	 * @author fanfte
	 * @param openid
	 * @param model
	 * @return
	 * 2017年8月25日
	 */
	@RequestMapping("/list/{openid}")
	public String adList(@PathVariable("openid") String openid, Model model ) {
		System.out.println("list ad openid" + openid);
		List<SatAdvertisement> adList = satAdService.getAdsByUserId(openid);
		System.out.println(adList.get(0).getOpenid());
		model.addAttribute("adList", adList);
		model.addAttribute("size", adList.size());
		model.addAttribute("openid", openid);
		return "sat/mobile/html/guanggaowei.jsp";
	}
	/**
	 * 广告详情页面
	 * @author fanfte
	 * @param adId
	 * @param model
	 * @return
	 * 2017年8月25日
	 */
	@RequestMapping("/detail/{adId}")
	public String adDetail(@PathVariable("adId") String adId, Model model) {
		SatAdvertisement ad = satAdService.load(adId);
		System.out.println(ad.getDescription() + "adid " + ad.getId());
		model.addAttribute("ad", ad);
		return "sat/mobile/html/guanggaoxq.jsp";
	}
	
	
	/**
	 * 更新广告
	 * @author fanfte
	 * @param request
	 * @return
	 * 2017年8月25日
	 */
	@RequestMapping("/update")
	@ResponseBody
	public String adUpdate(HttpServletRequest request) {
		String adId = request.getParameter("adId");
		String image = request.getParameter("image");
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String linkUrl = request.getParameter("linkUrl");
		String openid = request.getParameter("openid");
		System.out.println(image + "name " + name + "desc " + description + "link " + linkUrl + "openid " + "adid " + adId) ;
		if(!StringUtils.isEmpty(adId) && !StringUtils.isEmpty(image) && !StringUtils.isEmpty(name)
			&& !StringUtils.isEmpty(description) && !StringUtils.isEmpty(linkUrl)) {
			SatAdvertisement ad = satAdService.load(adId);
			ad.setDescription(description);
			ad.setImgUrl(image);
			ad.setName(name);
			ad.setUpdateTime(new Date());
			ad.setLinkUrl(linkUrl);
			satAdService.updateAd(ad);
			return "update success";
		} else {
			return "";
		}
		//return "redirect:/" + WeixinFinalValue.SERVER_URL + "ad/list/" + openid;
	}
	/**
	 * 进新增广告页面
	 * @author fanfte
	 * 
	 * @param openid
	 * @param model
	 * @return
	 * 2017年8月25日
	 */
	@RequestMapping("/gotoInsert/{openid}")
	public String adAdd(@PathVariable("openid") String openid, Model model) {
		System.out.println("oepnid " + openid);
		if(!StringUtils.isEmpty(openid)) {
			model.addAttribute("openid", openid);
			model.addAttribute("adSize", satAdService.getCount(openid));
			return "sat/mobile/html/addAd.jsp";
		}
		return "sat/mobile/html/addAd.jsp";
	}
	
	@RequestMapping("/insert")
	@ResponseBody
	public String adInsert(HttpServletRequest request) {
		String image = request.getParameter("image");
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String linkUrl = request.getParameter("linkUrl");
		String openid = request.getParameter("openid");
		System.out.println(image + "name " + name + "desc " + description + "link " + linkUrl + "openid ") ;
		if(!StringUtils.isEmpty(image) && !StringUtils.isEmpty(name)
			&& !StringUtils.isEmpty(description) && !StringUtils.isEmpty(linkUrl)) {
			SatAdvertisement ad = new SatAdvertisement();
			ad.setId(UUID.randomUUID().toString());
			ad.setDescription(description);
			ad.setImgUrl(image);
			ad.setName(name);
			ad.setUpdateTime(new Date());
			ad.setCreateTime(new Date());
			ad.setLinkUrl(linkUrl);
			satAdService.insertAd(ad);
			return "insert success";
		} else {
			return "insert failed";
		}
		//return "redirect:/" + WeixinFinalValue.SERVER_URL + "ad/list/" + openid;
	}
	
}
