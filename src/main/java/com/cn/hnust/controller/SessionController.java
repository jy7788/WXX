package com.cn.hnust.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.hnust.model.FiveBookUser;
import com.cn.hnust.util.JsonUtil;

@Controller
@RequestMapping("/session")
public class SessionController {
	
	@RequestMapping("/getUser")
	public void returnsessionUser(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("get User");
		resp.setContentType("text/html;charset=utf-8");
		FiveBookUser user = (FiveBookUser) req.getSession().getAttribute("fiveBookUser");
		try {
			resp.getWriter().write(JsonUtil.getInstance().obj2Json((FiveBookUser)req.getSession().getAttribute("fiveBookUser")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("/getWUser")
	public void returnSessionWUser(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("get WUser");
		resp.setContentType("text/html;charset=utf-8");
		FiveBookUser user = (FiveBookUser) req.getSession().getAttribute("wUser");
		try {
			resp.getWriter().write(JsonUtil.getInstance().obj2Json((FiveBookUser)req.getSession().getAttribute("fiveBookUser")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
