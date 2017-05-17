package com.cn.hnust.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/class")
public class ClassController {
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String classList() {
		return "/class/list";
	}
	
	@RequestMapping(value="/steam", method=RequestMethod.GET)
	public String classSteam() {
		return "/class/steam";
	}
}
