package com.cn.hnust.controller.sat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.hnust.model.sat.SatAdvertisement;
import com.cn.hnust.service.sat.ISatAdService;

@Controller("advertisementController")
@RequestMapping("ad")
public class AdvertisementController {
	
	@Autowired
	private ISatAdService satAdService;
	
	@RequestMapping("/list/{openid}")
	public String adList(@PathVariable("openid") String openid, Model model ) {
		System.out.println("list ad openid" + openid);
		List<SatAdvertisement> adList = satAdService.getAdsByUserId(openid);
		model.addAttribute("adList", adList);
		return "sat/mobile/html/guanggaowei.jsp";
	}
	
	@RequestMapping("/detail/{adId}")
	public String adDetail(@PathVariable("adId") String adId, Model model) {
		SatAdvertisement ad = satAdService.load(adId);
		System.out.println(ad.getDescription());
		model.addAttribute("ad", ad);
		return "sat/mobile/html/guanggaoxq.jsp";
	}
	
	
}
