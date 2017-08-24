package com.cn.hnust.controller.erweima;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.hnust.constants.sat.SatConstants;
import com.cn.hnust.exception.WXException;
import com.cn.hnust.json.ValidResult;
import com.cn.hnust.json.YzmResult;
import com.cn.hnust.kit.kit.ExchangeCode2OpenId;
import com.cn.hnust.kit.kit.WeixinBasicKit;
import com.cn.hnust.kit.kit.WeixinUserUtil;
import com.cn.hnust.model.JsapiTicket;
import com.cn.hnust.model.WUser;
import com.cn.hnust.model.WeixinContext;
import com.cn.hnust.model.WeixinFinalValue;
import com.cn.hnust.model.pa.PAUser;
import com.cn.hnust.model.sat.SatUser;
import com.cn.hnust.service.pa.IPAUserRequestService;
import com.cn.hnust.service.sat.ISatUserService;
import com.cn.hnust.util.JsonUtil;

@Controller
@RequestMapping("loan")
public class LoanController {
	
	
	@RequestMapping("/test")
	public String userList() {
		return "erweima/erweima.jsp";
	}
	
	
}
