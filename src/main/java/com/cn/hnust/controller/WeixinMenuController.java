package com.cn.hnust.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cn.hnust.model.WeixinMenu;
import com.cn.hnust.service.IWMenuService;
import com.cn.hnust.service.IWeixinMenuService;

@Controller
@RequestMapping("/weixinMenu")
public class WeixinMenuController {
	
	@Resource
	private IWeixinMenuService weixinMenuService;
	
	@Resource
	private IWMenuService wMenuService;
	
	@RequestMapping("/list")
	public String list(Model model) {
		 List<WeixinMenu> all = weixinMenuService.listAll();
		 for(WeixinMenu m : all) {
			 System.out.println(m.getContent());
			 System.out.println("menuKey" + m.getMenuKey());
		 }
		model.addAttribute("menus", weixinMenuService.listAll());
		model.addAttribute("wmds", weixinMenuService.gengrateWeixinMenuDto());
		return "weixinMenu/list.jsp";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(Model model) {
		model.addAttribute("menu", new WeixinMenu());
		return "weixinMenu/add.jsp";
	}
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(WeixinMenu menu) {
		weixinMenuService.add(menu);
		return "redirect:/weixinMenu/list";
	}
	
	@RequestMapping(value="/update/{id}",method=RequestMethod.GET)
	public String update(@PathVariable int id,Model model) {
		model.addAttribute("menu", weixinMenuService.load(id));
		return "weixinMenu/update.jsp";
	}
	
	@RequestMapping(value="/update/{id}",method=RequestMethod.POST)
	public String update(@PathVariable int id, WeixinMenu menu) {
		WeixinMenu twm = weixinMenuService.load(id);
		twm.setContent(menu.getContent());
		twm.setMenuKey(menu.getMenuKey());
		twm.setName(menu.getName());
		twm.setRespType(menu.getRespType());
		twm.setType(menu.getType());
		twm.setUrl(menu.getUrl());
		twm.setPid(menu.getPid());
		weixinMenuService.update(twm);
		return "redirect:/weixinMenu/list";
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public String delete(@PathVariable int id, Model model) {
		System.out.println("id " +  id);
		weixinMenuService.delete(id);
		return "redirect:/weixinMenu/list";
	}
	
	@RequestMapping("/queryMenu")
	public String queryMenu(Model model) {
		model.addAttribute("ms", wMenuService.queryMenu());
		return "weixinMenu/queryMenu.jsp";
	}
	
	@RequestMapping("/publish")
	public String publishMenu() {
		wMenuService.publishMenu();
		return "redirect:/weixinMenu/queryMenu";
	}
}
