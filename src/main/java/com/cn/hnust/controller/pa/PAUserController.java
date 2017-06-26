package com.cn.hnust.controller.pa;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cn.hnust.exception.WXException;
import com.cn.hnust.kit.kit.ExchangeCode2OpenId;
import com.cn.hnust.kit.kit.WeixinUserUtil;
import com.cn.hnust.message.TemplateMessage;
import com.cn.hnust.model.WUser;
import com.cn.hnust.model.WeixinFinalValue;
import com.cn.hnust.model.pa.PAUser;
import com.cn.hnust.service.pa.IPAUserService;

@Controller
@RequestMapping("pauser")
public class PAUserController {
	
	@Resource
	private IPAUserService pAUserService;
	
	@RequestMapping("/list")
	public String userList() {
		return "PAUser/list";
	}
	
	@RequestMapping("/signin")
	public String bindUserInput() {
		System.out.println("auth");
		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxc8544caaedbd00df&redirect_uri=" + WeixinFinalValue.SERVER_URL + "pauser/goauth&response_type=code&scope=snsapi_base&state=1#wechat_redirect";
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
				mPAUser.setImgUrl(wUser.getHeadimgurl());
				mPAUser.setOpenid(wUser.getOpenid());
				mPAUser.setNickname(wUser.getNickname());
				mPAUser.setSex(wUser.getSex());
				mPAUser.setPhoneNum(pAUser.getPhoneNum());
				mPAUser.setEmail(pAUser.getEmail());
//				System.out.println(wUser.getCountry() + "-" + wUser.getProvince() + "-" + wUser.getCity());
				mPAUser.setArea(wUser.getCountry() + "-" + wUser.getProvince() + "-" + wUser.getCity());
				pAUserService.update(mPAUser);
			}else {
				//数据库中没有该用户
				mPAUser.setBind(1);
				mPAUser.setImgUrl(wUser.getHeadimgurl());
				mPAUser.setOpenid(wUser.getOpenid());
				mPAUser.setNickname(wUser.getNickname());
				mPAUser.setSex(wUser.getSex());
				mPAUser.setPhoneNum(pAUser.getPhoneNum());
				mPAUser.setEmail(pAUser.getEmail());
//				System.out.println(wUser.getCountry() + "-" + wUser.getProvince() + "-" + wUser.getCity());
				mPAUser.setArea(wUser.getCountry() + "-" + wUser.getProvince() + "-" + wUser.getCity());
				pAUserService.add(mPAUser);
			}
		} else {
			throw new WXException("系统错误!");
		}
		return "redirect:/pauser/goUserList";
	}
	
	@RequestMapping("/goUserList")
	public String goUserList() {
		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxc8544caaedbd00df&redirect_uri=" + WeixinFinalValue.SERVER_URL + "pauser/list&response_type=code&scope=snsapi_base&state=1#wechat_redirect";;
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
		Model pausers = model.addAttribute("PAUsers", pAUserService.list());
		String openid = ExchangeCode2OpenId.exchange(request.getParameter("code"));
		System.out.println("网页授权获取到的openid:"+openid);//接收用户的Openid
		request.getSession().setAttribute("mopenid", openid);
		model.addAttribute("mUser", pAUserService.loadByOpenId(openid));
		return "PAUser/list";
	}
	
	@RequestMapping(value="/show")
	public String showUser(@RequestParam("openid")  String openid, Model model) {
		model.addAttribute("pAUser", pAUserService.loadByOpenId(openid));
		return "PAUser/show";
	}
	/**
	 * 发送绑定用户请求
	 * @author fanfte
	 * @param openid
	 * 2017年6月26日
	 */
	@RequestMapping(value="/bindUser/{openid}", method = RequestMethod.GET)
	public String bindUser(@PathVariable String openid, HttpServletRequest request,HttpServletResponse response) {
		String mopenid = (String) request.getSession().getAttribute("mopenid");
		System.out.println("mopenid" + mopenid);
		System.out.println("openid" + openid);
		TemplateMessage.sendBindUserTemplate(mopenid, openid, "绑定请求");
		return "PAUser/sendBindResult";
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
		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxc8544caaedbd00df&redirect_uri=" + WeixinFinalValue.SERVER_URL + "pauser/sendAcceptMessage&response_type=code&scope=snsapi_base&state=1#wechat_redirect";
		System.out.println("accept " + openid);
		request.getSession().setAttribute("fromOpenid", openid);
		return "redirect:" + url;
	}
	
	
	@RequestMapping("/sendAcceptMessage")
	public void sendAcceptMessage(HttpServletRequest request) throws Exception{
		String openid = ExchangeCode2OpenId.exchange(request.getParameter("code"));
//        String openid = WeixinUtil.getWeChat(request.getParameter("code"));
        System.out.println("网页授权获取到的openid:"+openid);//接收用户的Openid
        
		String fromOpenid = (String) request.getSession().getAttribute("fromOpenid");
		System.out.println("from openid " + fromOpenid);
		PAUser user = pAUserService.loadByOpenId(fromOpenid);//请求绑定用户
		PAUser muser = pAUserService.loadByOpenId(openid);//接收用户
		System.out.println("to " + muser.getOpenid());
		if(user != null) {
			System.out.println("from " + fromOpenid);
			TemplateMessage.sendAcceptUserTemplate(fromOpenid, openid, user.getNickname());
			TemplateMessage.sendAcceptUserTemplate(openid, fromOpenid, muser.getNickname());
		}
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
	public String acceptBind(@RequestParam("openid")  String openid, Model model) {
		PAUser u = pAUserService.loadByOpenId(openid);
		System.out.println("nickname" + u.getNickname());
		model.addAttribute("pAUser", u);
		return "PAUser/show";
	}
}
