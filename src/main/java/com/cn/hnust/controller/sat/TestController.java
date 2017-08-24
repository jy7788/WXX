package com.cn.hnust.controller.sat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("testsat")
public class TestController {
	
	@RequestMapping("/test")
	public String gotoIndex() {
		System.out.println("test controller");
		return "sat/mobile/html/Information.html";
	}
}
