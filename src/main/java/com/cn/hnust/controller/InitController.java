package com.cn.hnust.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.hnust.pojo.User;

@Controller("initController")
public class InitController {
	
	@RequestMapping("/init")
	public String toIndex(HttpServletRequest request,Model model){
		return "init";
	}
}
