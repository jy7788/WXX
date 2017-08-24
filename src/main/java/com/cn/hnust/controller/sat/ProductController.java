package com.cn.hnust.controller.sat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("productController")
@RequestMapping("product")
public class ProductController {
	
	
	@RequestMapping("/list")
	public String productCenter() {
		return "sat/mobile/html/chanpincenter.jsp";
	}
}
