package com.cn.hnust.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cn.hnust.model.User;
import com.cn.hnust.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource
	private IUserService userService;
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String toIndex(@ModelAttribute("user")User u, HttpServletRequest request,Model model){
		User user = this.userService.login(u.getUsername(), u.getPassword());
		request.getSession().setAttribute("user", user);
		model.addAttribute("users", userService.list());
		return "user/list";
	}
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		return "user/login";
	}
	
	@RequestMapping(value="/list" , method=RequestMethod.GET)
	public String userList(HttpServletRequest request,Model model) {
		model.addAttribute("users", userService.list());
		return "user/list";
	}
	
	
}
