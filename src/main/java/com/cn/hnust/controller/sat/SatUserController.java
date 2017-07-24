package com.cn.hnust.controller.sat;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		try{
	        System.out.println("获取的code: :"+request.getParameter("code"));
	        String openid = ExchangeCode2OpenId.exchange(request.getParameter("code"));
//	        String openid = WeixinUtil.getWeChat(request.getParameter("code"));
	        System.out.println("网页授权获取到的openid:"+openid);
	        WUser wechatUser = WeixinUserUtil.getWechatUser(openid);
	        System.out.println(wechatUser.getProvince());
	        request.getSession().setAttribute("wechatUser", wechatUser); 
	        model.addAttribute("mUser", satUserService.loadByOpenId(openid));
	        }catch(Exception e){
	            e.printStackTrace();
	            System.out.println("调用网页授权异常："+e);
	        }
	        return "satuser/signin";
	}
	/**
	 * 签到数据入库
	 * @author fanfte
	 * 
	 * @param pAUser
	 * @param request
	 * @param response
	 * @return
	 * 2017年6月26日
	 */
	@RequestMapping(value="/signin", method = RequestMethod.POST)
	public String bindUser(PAUser pAUser, HttpServletRequest request,HttpServletResponse response) {
		
		WUser wUser = (WUser) request.getSession().getAttribute("wechatUser");
		if(wUser != null) {
			SatUser mSatUser = new SatUser();
			SatUser user = satUserService.loadByPhoneNum(pAUser.getPhoneNum());
			//数据库有值，没绑定
			if(user != null) {
				System.out.println("sasdasds" + pAUser.getPhoneNum());
				mSatUser.setId(user.getId());
				mSatUser.setBind(1);
				mSatUser.setUsername(pAUser.getUsername());
				mSatUser.setImgUrl(wUser.getHeadimgurl());
				mSatUser.setOpenid(wUser.getOpenid());
				mSatUser.setNickname(wUser.getNickname());
				mSatUser.setSex(wUser.getSex());
				mSatUser.setPhoneNum(pAUser.getPhoneNum());
				mSatUser.setEmail(pAUser.getEmail());
//				System.out.println(wUser.getCountry() + "-" + wUser.getProvince() + "-" + wUser.getCity());
				mSatUser.setArea(wUser.getCountry() + "-" + wUser.getProvince() + "-" + wUser.getCity());
				mSatUser.setOrganization(pAUser.getOrganization());
				satUserService.update(mSatUser);
			}else {
				//数据库中没有该用户
				mSatUser.setBind(1);
				mSatUser.setUsername(pAUser.getUsername());
				mSatUser.setImgUrl(wUser.getHeadimgurl());
				mSatUser.setOpenid(wUser.getOpenid());
				mSatUser.setNickname(wUser.getNickname());
				mSatUser.setSex(wUser.getSex());
				mSatUser.setPhoneNum(pAUser.getPhoneNum());
				mSatUser.setEmail(pAUser.getEmail());
//				System.out.println(wUser.getCountry() + "-" + wUser.getProvince() + "-" + wUser.getCity());
				mSatUser.setArea(wUser.getCountry() + "-" + wUser.getProvince() + "-" + wUser.getCity());
				mSatUser.setOrganization(pAUser.getOrganization());
				satUserService.add(mSatUser);
			}
		} else {
			throw new WXException("系统错误!");
		}
		return "redirect:/satuser/goUserList";
	}
	
	@RequestMapping("/goUserList")
	public String goUserList() {
		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + WeixinFinalValue.APPID +"&redirect_uri=" + WeixinFinalValue.SERVER_URL + "pauser/list&response_type=code&scope=snsapi_base&state=1#wechat_redirect";;
		return "redirect:" + url;
	}
	
}
