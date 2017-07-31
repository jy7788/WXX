package com.cn.hnust.controller.sat;

import java.util.Date;

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
import com.cn.hnust.model.WUser;
import com.cn.hnust.model.WeixinFinalValue;
import com.cn.hnust.model.pa.PAUser;
import com.cn.hnust.model.sat.SatUser;
import com.cn.hnust.service.pa.IPAUserRequestService;
import com.cn.hnust.service.sat.ISatUserService;
import com.cn.hnust.util.JsonUtil;

@Controller
@RequestMapping("satuser")
public class SatUserController {
	
	@Resource
	private ISatUserService satUserService;
	
	@Resource
	private IPAUserRequestService pAUserRequestService;
	
	@RequestMapping("/list")
	public String userList() {
		return "satuser/list";
	}
	
	@RequestMapping("/personalCenter")
	public String personalCenter(HttpServletRequest request) {
		System.out.println(request.getContextPath());
		return "sat/mobile/html/PersonalCenter.jsp";
	}
	
	@RequestMapping("/detail/{openid}")
	public String userDetail(@PathVariable String openid, Model model) {
		SatUser satUser = satUserService.loadByOpenId(openid);
		if(satUser != null) {
			System.out.println(satUser.getUsername());
			model.addAttribute("satUser", satUser);
		}
		return "sat/mobile/html/PersonalData.jsp";
	}
	
	
	@RequestMapping(value="/update",  method = RequestMethod.POST)
	public String userUpdate(SatUser satUser) {
		SatUser user = satUserService.loadByOpenId(satUser.getOpenid());
		System.out.println(satUser.getOpenid());
		System.out.println(satUser.getTrade());
		System.out.println(satUser.getBirthday());
		if(user != null) {
			user.setBirthday(satUser.getBirthday());
			user.setOrganization(satUser.getOrganization());
			user.setQrCode(satUser.getQrCode());
			user.setSex(satUser.getSex());
			user.setSignature(satUser.getSignature());
			user.setTrade(satUser.getTrade());
			user.setUpdateDate(new Date());
			System.out.println(user.getTrade());
			satUserService.update(user);
		}
		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + WeixinFinalValue.APPID +"&redirect_uri=" + WeixinFinalValue.SERVER_URL + "satuser/goauth&response_type=code&scope=snsapi_base&state=1#wechat_redirect";
		return "redirect:" + url;
	}
	
	@RequestMapping("/getYzm")//获取验证码
	@ResponseBody
	public String getYzm(HttpServletRequest request) {
		String phoneNum = request.getParameter("phoneNum");
		String url = SatConstants.REQUEST_VALID_KEY_URL;
		String json = "{\"userNum\":\"" + phoneNum + "\",\"verfType\":\"4\"}";
		System.out.println(json);
		String postResult = WeixinBasicKit.sendPostUrl(url, "data=" + json);
		YzmResult yzmResult = (YzmResult) JsonUtil.getInstance().json2Obj(postResult, YzmResult.class);
		System.out.println("validid" + yzmResult.getValidId());
		if(yzmResult != null) {
			request.getSession().setAttribute("validid", yzmResult.getValidId());
		}
		return postResult;
	} 
	@RequestMapping("/valid")//获取验证码
	@ResponseBody
	public String valid(HttpServletRequest request) {
		String phoneNum = request.getParameter("phoneNum");
		String validCode = request.getParameter("validCode");
		String validid = (String) request.getSession().getAttribute("validid");
		String json = "{\"validId\":\"" + validid + "\",\"userNum\":\"" + phoneNum + "\",\"inputValidCode\":\"" + validCode +"\"}";
		System.out.println(json);
		String validurl = SatConstants.CHECK_VALID_KEY_URL;
		String postResult = WeixinBasicKit.sendPostUrl(validurl, "data=" + json);
		ValidResult result = (ValidResult) JsonUtil.getInstance().json2Obj(postResult, ValidResult.class);
		System.out.println("resultCode " + result.getResultCode());
		if(result.getResultCode().equals("1")) {
			return "valid success";
		}else {
			return "failed";
		}
	}
	
	@RequestMapping("/signin")
	public String bindUserInput() {
		System.out.println("auth");
		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + WeixinFinalValue.APPID +"&redirect_uri=" + WeixinFinalValue.SERVER_URL + "pauser/goauth&response_type=code&scope=snsapi_base&state=1#wechat_redirect";
		return "redirect:" + url;
	}
	
	@RequestMapping("/load")
	@ResponseBody
	public SatUser loadSatUser(HttpServletRequest request) {
		String phoneNum = request.getParameter("phoneNum");
		SatUser satUser = satUserService.loadByOpenId(phoneNum);
		if(satUser != null && satUser.getUsername() != null) {
			satUser.setUsername(satUser.getUsername().substring(0, 1) + "* * ");
			System.out.println(satUser.getNickname());
		}
		return satUser;
	}
	@RequestMapping("/gotolist")
	public String gotoPAUserList() {
		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + WeixinFinalValue.APPID +"&redirect_uri=" + WeixinFinalValue.SERVER_URL + "pauser/list&response_type=code&scope=snsapi_base&state=1#wechat_redirect";
		return "redirect:" + url;
	}
	
	@RequestMapping("/gotoUserCenter")
	public String gotoUserCenter() {
		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + WeixinFinalValue.APPID +"&redirect_uri=" + WeixinFinalValue.SERVER_URL + "satuser/goauth&response_type=code&scope=snsapi_base&state=1#wechat_redirect";
		return "redirect:" + url;
	}
	
	/**
	 * 进入签到页面
	 * @author fanfte
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * 2017年6月26日
	 */
	@RequestMapping(value="/goauth" ,method=RequestMethod.GET)
	public String weixinAuth(HttpServletRequest request,HttpServletResponse response, Model model) {
		String code = request.getParameter("code");
		if(code != null) {
			System.out.println("获取的code: "+ code);
	        String openid = ExchangeCode2OpenId.exchange(code);
	        if(openid != null) {
	        	System.out.println("网页授权获取到的openid: "+openid);
	        	WUser wechatUser = WeixinUserUtil.getWechatUser(openid);
	        	System.out.println(wechatUser.getProvince());
	        	System.out.println(wechatUser.getHeadimgurl());
	        	request.getSession().setAttribute("wechatUser", wechatUser);
	        	SatUser satUser = satUserService.loadByOpenId(openid);
	        	if(satUser != null) {
	        		model.addAttribute("mUser", satUser);
	        		return "sat/mobile/html/PersonalCenter.jsp";
	        	} else {
	        		model.addAttribute("mUser", satUser);
	        		return "sat/mobile/html/SatUserRegist.jsp";
	        	}
	        }else {
	        	model.addAttribute("mUser", null);
	        	return "sat/mobile/html/PersonalCenter.jsp";
	        }
		}else {
        	model.addAttribute("mUser", null);
        	return "/gotoUserCenter";
        }
	}
	/**
	 * 用户注册接口
	 * @author fanfte
	 * 
	 * @param pAUser
	 * @param request
	 * @param response
	 * @return
	 * 2017年6月26日
	 */
	@RequestMapping(value="/regist", method = RequestMethod.POST)
	public String bindUser(SatUser satUser, HttpServletRequest request,HttpServletResponse response) {
		
		WUser wUser = (WUser) request.getSession().getAttribute("wechatUser");
		System.out.println("username " + satUser.getUsername() + " "  + satUser.getTrade() + " " + satUser.getOrganization());
		if(wUser != null) {
			SatUser mSatUser = new SatUser();
			SatUser user = satUserService.loadByOpenId(wUser.getOpenid());
			if(user == null) {
				mSatUser.setOpenid(wUser.getOpenid());
				mSatUser.setArea(wUser.getCountry() + "-" + wUser.getProvince() + "-" + wUser.getCity());
				mSatUser.setCreateDate(new Date());
				mSatUser.setUpdateDate(new Date());
				mSatUser.setImgUrl(wUser.getHeadimgurl());
				mSatUser.setUsername(satUser.getUsername());
				mSatUser.setPhoneNum(satUser.getPhoneNum());
				mSatUser.setTrade(satUser.getTrade());
				mSatUser.setOrganization(satUser.getOrganization());
				mSatUser.setSex(wUser.getSex());
				satUserService.add(mSatUser);
			} else {
				throw new WXException("已经注册过");
			}
		} else {
			throw new WXException("系统错误!");
		}
		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + WeixinFinalValue.APPID +"&redirect_uri=" + WeixinFinalValue.SERVER_URL + "satuser/goauth&response_type=code&scope=snsapi_base&state=1#wechat_redirect";
		return "redirect:" + url;
	}
	
	@RequestMapping("/goUserList")
	public String goUserList() {
		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + WeixinFinalValue.APPID +"&redirect_uri=" + WeixinFinalValue.SERVER_URL + "pauser/list&response_type=code&scope=snsapi_base&state=1#wechat_redirect";;
		return "redirect:" + url;
	}
	
}
