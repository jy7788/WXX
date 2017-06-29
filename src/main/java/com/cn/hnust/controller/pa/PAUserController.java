package com.cn.hnust.controller.pa;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.hnust.exception.WXException;
import com.cn.hnust.json.ValidResult;
import com.cn.hnust.json.YzmResult;
import com.cn.hnust.kit.kit.ExchangeCode2OpenId;
import com.cn.hnust.kit.kit.WeixinBasicKit;
import com.cn.hnust.kit.kit.WeixinUserUtil;
import com.cn.hnust.message.TemplateMessage;
import com.cn.hnust.model.WUser;
import com.cn.hnust.model.WeixinFinalValue;
import com.cn.hnust.model.pa.PAUser;
import com.cn.hnust.model.pa.PAUserRequest;
import com.cn.hnust.service.pa.IPAUserRequestService;
import com.cn.hnust.service.pa.IPAUserService;
import com.cn.hnust.util.JsonUtil;

@Controller
@RequestMapping("pauser")
public class PAUserController {
	
	@Resource
	private IPAUserService pAUserService;
	
	@Resource
	private IPAUserRequestService pAUserRequestService;
	
	@RequestMapping("/list")
	public String userList() {
		return "PAUser/list";
	}
	@RequestMapping("/getYzm")//获取验证码
	@ResponseBody
	public String getYzm(HttpServletRequest request) {
		String phoneNum = request.getParameter("phoneNum");
		String url = "http://smea.pingan.com.cn/smelp_core/a/customer/scf/customerInfo/getPhoneValidCode4json";
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
		String validurl = "http://smea.pingan.com.cn/smelp_core/a/customer/scf/customerInfo/checkPhoneValidCode4json";
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
	public PAUser loadPAUser(HttpServletRequest request) {
		String phoneNum = request.getParameter("phoneNum");
		PAUser pAUser = pAUserService.loadByPhoneNum(phoneNum);
		if(pAUser != null) {
			System.out.println(pAUser.getNickname());
		}
		return pAUser;
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
	        model.addAttribute("mUser", pAUserService.loadByOpenId(openid));
	        }catch(Exception e){
	            e.printStackTrace();
	            System.out.println("调用网页授权异常："+e);
	        }
	        return "PAUser/signin";
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
			PAUser mPAUser = new PAUser();
			//数据库有值，没绑定
			if(pAUserService.loadByOpenId(wUser.getOpenid()) != null) {
				mPAUser.setBind(1);
				mPAUser.setUsername(pAUser.getUsername());
				mPAUser.setImgUrl(wUser.getHeadimgurl());
				mPAUser.setOpenid(wUser.getOpenid());
				mPAUser.setNickname(wUser.getNickname());
				mPAUser.setSex(wUser.getSex());
				mPAUser.setPhoneNum(pAUser.getPhoneNum());
				mPAUser.setEmail(pAUser.getEmail());
//				System.out.println(wUser.getCountry() + "-" + wUser.getProvince() + "-" + wUser.getCity());
				mPAUser.setArea(wUser.getCountry() + "-" + wUser.getProvince() + "-" + wUser.getCity());
				mPAUser.setPosition(pAUser.getPosition());
				mPAUser.setOrganization(pAUser.getOrganization());
				pAUserService.update(mPAUser);
			}else {
				//数据库中没有该用户
				mPAUser.setBind(1);
				mPAUser.setUsername(pAUser.getUsername());
				mPAUser.setImgUrl(wUser.getHeadimgurl());
				mPAUser.setOpenid(wUser.getOpenid());
				mPAUser.setNickname(wUser.getNickname());
				mPAUser.setSex(wUser.getSex());
				mPAUser.setPhoneNum(pAUser.getPhoneNum());
				mPAUser.setEmail(pAUser.getEmail());
//				System.out.println(wUser.getCountry() + "-" + wUser.getProvince() + "-" + wUser.getCity());
				mPAUser.setArea(wUser.getCountry() + "-" + wUser.getProvince() + "-" + wUser.getCity());
				mPAUser.setPosition(pAUser.getPosition());
				mPAUser.setOrganization(pAUser.getOrganization());
				pAUserService.add(mPAUser);
			}
		} else {
			throw new WXException("系统错误!");
		}
		return "redirect:/pauser/goUserList";
	}
	
	@RequestMapping("/goUserList")
	public String goUserList() {
		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + WeixinFinalValue.APPID +"&redirect_uri=" + WeixinFinalValue.SERVER_URL + "pauser/list&response_type=code&scope=snsapi_base&state=1#wechat_redirect";;
		return "redirect:" + url;
	}
	
	/**
	 * 获取用户列表,返回列表页面，需要获取发送请求者的openid
	 * @author fanfte
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * 2017年6月26日
	 */
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public String pAUserList(HttpServletRequest request,HttpServletResponse response, Model model) {
		String openid = ExchangeCode2OpenId.exchange(request.getParameter("code"));
		System.out.println("网页授权获取到的openid:"+openid);//接收用户的Openid
		request.getSession().setAttribute("mopenid", openid);
		
		//找到除去自己以外的用户，设置绑定和不绑定,设置到status字段中
		List<PAUser> binded = pAUserService.listBinded(openid);//我绑定的用户
		List<PAUser> bindMeList = pAUserService.listBindMe(openid);//绑定我的用户
		List<PAUser> others = pAUserService.listOthers(openid);
		System.out.println("binded " + binded.size());
		System.out.println("others " + others.size());
		if(others != null && others.size() > 0) {
			for(PAUser user : others) {
				if(binded != null && binded.size() > 0) {
					for(PAUser bind : binded) {
						if(user.getOpenid().equals(bind.getOpenid())) {
							System.out.println("binded id  " + bind.getNickname());
							user.setStatus(1);
						}
					}
					
				}
				if(bindMeList != null) {
					for(PAUser bindMe : bindMeList) {
						if(user.getOpenid().equals(bindMe.getOpenid())) {
							System.out.println("binded id  " + bindMe.getNickname());
							user.setStatus(1);
						}
					}
				}
//				System.out.println("phone " + user.getPhoneNum());
				System.out.println("position " + user.getPosition());
			}
			model.addAttribute("PAUsers", others);//
		}
		PAUser paUser = pAUserService.loadByOpenId(openid);//本用户
		model.addAttribute("mUser", paUser);//本用户存入
		return "PAUser/list";
	}
	
	@RequestMapping(value="/show")
	public String showUser(@RequestParam("mopenid")  String mopenid, @RequestParam("aopenid")  String aopenid, Model model, HttpServletRequest request) {
//		String mopenid = ExchangeCode2OpenId.exchange(request.getParameter("code"));
//		System.out.println("网页授权获取到的openid:"+mopenid);//接收用户的Openid
		PAUser pAUser = pAUserService.loadByOpenId(mopenid);//请求者的openid
		if(isBinded(mopenid, aopenid)) {
			pAUser.setStatus(1);
		}
		model.addAttribute("pAUser", pAUser);
		return "PAUser/show";
	}
	
	public boolean isBinded(String ropenid, String  aopenid) {
		boolean binded = false;
		//判断是否绑定过本用户
		List<PAUser> listBinded = pAUserService.listBinded(ropenid);//我绑定的用户列表
		List<PAUser> bindMe = pAUserService.listBindMe(ropenid);//绑定我的用户列表
		if(listBinded != null) {
			for(PAUser u:listBinded) {
				if(u.getOpenid().equals(aopenid)) {
					binded = true;
				}
			}
		}
		
		if(bindMe != null) {
			for(PAUser u:bindMe) {
				if(u.getOpenid().equals(aopenid)) {
					binded = true;
				}
			}
		}
		return binded;
	}
	/**
	 * 发送绑定用户请求
	 * @author fanfte
	 * @param openid
	 * 2017年6月26日
	 */
	@RequestMapping(value="/bindUser", method = RequestMethod.GET)
	public void bindUser(@RequestParam("openid")  String openid, HttpServletRequest request,HttpServletResponse response) {
		String mopenid = (String) request.getSession().getAttribute("mopenid");
		System.out.println("mopenid" + mopenid);//请求发送者openid
		System.out.println("openid" + openid);//请求接受者的openid, aopenid
		TemplateMessage.sendBindUserTemplate(mopenid, openid, "绑定请求");
		PAUserRequest paUserRequest = pAUserRequestService.loadByOpenIds(mopenid, openid);
		if(paUserRequest == null) {
			PAUserRequest pAUserRequest = new PAUserRequest();
			pAUserRequest.setOpenid(openid);
			pAUserRequest.setRequesterOpenid(mopenid);
			pAUserRequest.setRequestStatus(1);//1表示请求发送成功  2为接收请求  3拒绝请求
			pAUserRequestService.add(pAUserRequest);
		}
		try {
			response.getWriter().write("success");
		} catch (IOException e) {
			e.printStackTrace();
		}
//		return "PAUser/sendBindResult";
	}
	/**
	 * 绑定请求接受,需要页面授权获取自身openId
	 * @author fanfte
	 * 
	 * @param openid
	 * @param model
	 * @return
	 * 2017年6月26日
	 */
	@RequestMapping(value="/accept/{openid}",method=RequestMethod.GET)
	public String bind(@PathVariable String openid, Model model,HttpServletRequest request) {
		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + WeixinFinalValue.APPID +"&redirect_uri=" + WeixinFinalValue.SERVER_URL + "pauser/sendAcceptMessage&response_type=code&scope=snsapi_base&state=1#wechat_redirect";
		System.out.println("accept " + openid);
		request.getSession().setAttribute("fromOpenid", openid);
		return "redirect:" + url;
	}
	
	
	@RequestMapping("/sendAcceptMessage")
	public String sendAcceptMessage(HttpServletRequest request) throws Exception{
		String openid = ExchangeCode2OpenId.exchange(request.getParameter("code"));
//        String openid = WeixinUtil.getWeChat(request.getParameter("code"));
        System.out.println("网页授权获取到的openid:"+openid);//接收用户的openid
        
		String fromOpenid = (String) request.getSession().getAttribute("fromOpenid");
		System.out.println("from openid " + fromOpenid);//发送请求者的openid
		PAUser user = pAUserService.loadByOpenId(fromOpenid);//请求绑定用户
		PAUser muser = pAUserService.loadByOpenId(openid);//接收用户
		System.out.println("to " + muser.getOpenid());
		if(user != null) {
			System.out.println("from " + fromOpenid);
			TemplateMessage.sendAcceptUserTemplate(fromOpenid, openid, user.getUsername());
			TemplateMessage.sendAcceptUserTemplate(openid, fromOpenid, muser.getUsername());
		}
		PAUserRequest paUserRequest = pAUserRequestService.loadByOpenIds(fromOpenid, openid);
		if(paUserRequest != null) {//更行状态为接收过请求
//			PAUserRequest userRequest = new PAUserRequest();
			paUserRequest.setRequestStatus(2);//1发送请求  2接收请求  3拒绝请求
			pAUserRequestService.update(paUserRequest);
		} else {
			//没有请求数据新增？
		}
		String linkUrl = WeixinFinalValue.SERVER_URL + "pauser/show?" + "mopenid=" + fromOpenid + "&aopenid=" + openid;
		return "redirect:" + linkUrl;
	}
	
	
	/**
	 * 点击模板消息进入接受用户请求
	 * @author fanfte
	 * 
	 * @param openid
	 * @param model
	 * @return
	 * 2017年6月26日
	 */
	@RequestMapping(value="/acceptBind",method=RequestMethod.GET)
	public String acceptBind(@RequestParam("mopenid")  String mopenid,@RequestParam("aopenid")  String aopenid, Model model) {
		PAUser u = pAUserService.loadByOpenId(mopenid);
		System.out.println("nickname" + u.getNickname());
		System.out.println("binded " + isBinded(mopenid, aopenid));
		if(isBinded(mopenid, aopenid)) {
			u.setStatus(1);
		}
		model.addAttribute("pAUser", u);
		return "PAUser/show";
	}
}
