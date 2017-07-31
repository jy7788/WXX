package com.cn.hnust.controller.sat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cn.hnust.model.sat.SatArticle;
import com.cn.hnust.service.sat.ISatArticleService;
import com.cn.hnust.util.JsonUtil;

@Controller
@RequestMapping("satarticle")
public class SatArticleController {
	
	@Autowired
	private ISatArticleService satArticleServie;
	
	@RequestMapping("/informationCenter")
	public String newsCenter() {
		return "sat/mobile/html/Information.jsp";
	}
	
	@RequestMapping("/list")
	public String listArticles(Model model) {
		List<SatArticle> list = satArticleServie.list();
		String list2json = JsonUtil.getInstance().list2json(list);
		System.out.println(list2json);
		model.addAttribute("articleList", list);
		return "sat/mobile/html/Information.jsp";
	}
	
	@RequestMapping(value="/detail/{id}",method=RequestMethod.GET)
	public String satArticleDetail(@PathVariable String id, Model model) {
//		SatArticle satArticle = satArticleServie.loadArticleById(id);
//		if(satArticle != null) {
//			System.out.println(satArticle.getUrl());
//			model.addAttribute("satArticle", satArticle);
//		}
		SatArticle satArticle = satArticleServie.loadContentById(id);
		if(satArticle != null) {
			model.addAttribute("satArticle", satArticle);
		}
		return "sat/mobile/html/InformationDetail.jsp";
	}
	
	
}
