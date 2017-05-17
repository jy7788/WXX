package com.cn.hnust.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DeviceController {
	
	@RequestMapping("deviceControl")
	public String deviceList() {
		return "bluetooth/deviceControl";
	}
	
	@RequestMapping("deviceOper")
	public void deviceOp(String operation) {
		if(operation.equals("open")) {
			
		}
		if(operation.equals("close")) {
			
		}
	}
	
	@RequestMapping("deviceList")
	public void getDeviceList(String openId) {
		
	}
}
