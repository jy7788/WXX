package com.cn.hnust.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cn.hnust.exception.WXException;
import com.cn.hnust.kit.kit.ExchangeCode2OpenId;
import com.cn.hnust.kit.kit.WeixinUserUtil;
import com.cn.hnust.model.FiveBookUser;
import com.cn.hnust.model.WUser;
import com.cn.hnust.model.WeixinContext;
import com.cn.hnust.model.WeixinFinalValue;
import com.cn.hnust.service.IFiveBookUserService;

@Controller
@RequestMapping("fiveBookUser")
public class FiveBookUserController {
	
	@Resource
	private IFiveBookUserService fiveBookUserService;
	
	@InitBinder
	protected void initBinder(HttpServletRequest request,
	            ServletRequestDataBinder binder) throws Exception {
//	    DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	    CustomDateEditor dateEditor = new CustomDateEditor(format, true);
	    binder.registerCustomEditor(Date.class, dateEditor);
	}
	
	@RequestMapping(value="/adminLogin", method = RequestMethod.GET)
	public String adminLogin(){
		return "fiveBookUser/adminLogin";
	}
	
	@RequestMapping(value="/adminLogin", method = RequestMethod.POST)
	public String adminLogin(@ModelAttribute("fiveBookUser")FiveBookUser u, HttpServletRequest request,Model model){
		FiveBookUser user = this.fiveBookUserService.login(u.getUsername(), u.getPassword());
		request.getSession().setAttribute("fiveBookUser", user);
		model.addAttribute("fiveBookUsers", fiveBookUserService.list());
		if(user.getStatus()!= 1) {
			throw new WXException("��û�и�Ȩ��");
		}
		return "/fiveBookUser/list";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public void login(FiveBookUser u, HttpServletRequest request,Model model, HttpServletResponse resp) throws IOException{
		resp.setCharacterEncoding("UTF-8");
		PrintWriter writer = resp.getWriter();
		System.out.println(u.getUsername() + u.getPassword());
		FiveBookUser user = this.fiveBookUserService.login(u.getUsername(), u.getPassword());
		request.getSession().setAttribute("fiveBookUser", user);
		if(user != null) {
			if(user.getRole() == 1) {
				writer.write("teacher");
			}
			if(user.getRole() == 2) {
				writer.write("student");
			}
			if(user.getRole() == 3) {
				writer.write("other");
			}
		} 
//		return "redirect:/fiveBookUser/manage";
	}
	
	@RequestMapping(value="/manage", method = RequestMethod.GET)
	public String manage(Model model){
		return "/fiveBookUser/manage";
	}
	
	@RequestMapping(value="/bindUser", method=RequestMethod.GET)
	public void bindUser(HttpServletRequest request, HttpServletResponse resp) throws IOException {
		resp.setCharacterEncoding("UTF-8");
		PrintWriter writer = resp.getWriter();
		WUser wUser = (WUser) request.getSession().getAttribute("wUser");
		FiveBookUser user = (FiveBookUser) request.getSession().getAttribute("fiveBookUser");
		if(wUser != null) {
			FiveBookUser byOpenId = fiveBookUserService.loadByOpenId(wUser.getOpenid());
			if(byOpenId != null) {
				writer.write("binded wechat");
				return;
			}
		}
		if(user != null && user.getBind() == 1) {
			System.out.println("binded");
			writer.write("binded");
		}
		if(wUser != null && user.getBind() == 0) {
			user.setNickname(wUser.getNickname());
			user.setImgUrl(wUser.getHeadimgurl());
			user.setOpenId(wUser.getOpenid());
			user.setBind(1);
			user.setArea(wUser.getCountry() +"-" + wUser.getProvince() 
			+ "-" +  wUser.getCity() );
			System.out.println("success");
			fiveBookUserService.update(user);
			writer.write("bind success");
		} else {
			writer.write("bind failed");
		}
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(HttpServletRequest request,Model model) {
		String CODE = request.getParameter("code");
        String APPID = WeixinContext.getInstance().getAppId();
        String SECRET = WeixinContext.getInstance().getAppSecurt();
        WUser user = getWechatUser(CODE, request.getSession());
        request.getSession().setAttribute("wUser", user);
		return "fiveBookUser/login";
	}
	
	private WUser getWechatUser(String code, HttpSession session) {
	    String openid = "";
	    WUser wechatUser = null;
	    WUser wechatUserInSession = (WUser) session.getAttribute("wUser");
	    // �ȿ�session
	    if (null != wechatUserInSession) {
	        wechatUser = wechatUserInSession;
	        System.out.println("session�����û���Ϣ");
	    } else {// session��û�� ȥ��ȡ
	        System.out.println("�õ���code:" + code);
	        if (code == null || "".equals(code)) {
	            return null;
	        }else{
	            openid = ExchangeCode2OpenId.exchange(code);
	            if (code == null || "".equals(code)) {
	                return null;
	            }
	        }
	        System.out.println("�õ���openid:" + openid);
	        // ����ʹ�õ�����ͨ�ӿڣ��û�������ȡ�û�������Ϣ��
	        wechatUser = WeixinUserUtil.getWechatUser(openid);
	        String headImgurl = wechatUser.getHeadimgurl();
	        // 132*132��ͷ��
	        if (wechatUser.getHeadimgurl() !=null && !wechatUser.getHeadimgurl().equals("")) {
	            headImgurl = headImgurl.substring(0, headImgurl.length() - 1);
	            headImgurl += "132";
	            wechatUser.setHeadimgurl(headImgurl);
	        } else {
	            headImgurl = "";
	        }
	        wechatUser.setHeadimgurl(headImgurl);
	        System.out.println("�õ����û���Ϣ:" + wechatUser);
	    }
	    return wechatUser;
	}
	
	@RequestMapping(value="/list" , method=RequestMethod.GET)
	public String userList(HttpServletRequest request,Model model) {
		model.addAttribute("fiveBookUsers", fiveBookUserService.list());
		for(FiveBookUser u : fiveBookUserService.list()) {
			System.out.println(u.getImgUrl());
		}
		return "fiveBookUser/list";
	}
	
	@RequestMapping(value="/regist", method=RequestMethod.GET)
	public String userRegist(HttpServletRequest request,Model model) {
		System.out.println("regist");
		//�õ�code
        String CODE = request.getParameter("code");
        String APPID = WeixinContext.getInstance().getAppId();
        String SECRET = WeixinContext.getInstance().getAppSecurt();
        System.out.println("code "  + CODE);
		return "/fiveBookUser/regist";
	}
	
	@RequestMapping(value="/regist", method=RequestMethod.POST)
	public void userRegist(HttpServletResponse resp,FiveBookUser fiveBookUser,
			HttpServletRequest request,Model model) throws UnsupportedEncodingException {
		resp.setCharacterEncoding("UTF-8");
		System.out.println("username " +  fiveBookUser.getUsername());
		System.out.println("regist post" + fiveBookUser.getRole());
		FiveBookUser u = fiveBookUserService.loadByUserName(fiveBookUser.getUsername());
		if(u != null) {
			try {
				resp.getWriter().write("���û��Ѿ�����");
			} catch (IOException e) {
				e.printStackTrace();
			}
			throw new WXException("���û��Ѿ�����");
		} 
		fiveBookUserService.add(fiveBookUser);
		model.addAttribute("fiveBookUser", fiveBookUser);
		request.getSession().setAttribute("fiveBookUser", fiveBookUser);
		try {
			resp.getWriter().write("success");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="/registResult", method=RequestMethod.GET)
	public String userRegistResult(HttpServletRequest request,Model model) {
		System.out.println("regist result");
		model.addAttribute("fiveBookUser", request.getSession().getAttribute("fiveBookUser"));
		return "fiveBookUser/registResult";
	}
	
	@RequestMapping(value="/redirect", method=RequestMethod.GET)
	public String bindWechat() {
		String path = "http://1d6289976g.imwork.net/fiveBookUser/login";
		String uri = WeixinFinalValue.AUTH_URL;
		try {
			uri = uri.replace("APPID", WeixinContext.getInstance().getAppId())
			   .replace("REDIRECT_URI",URLEncoder.encode(path, "UTF-8"))
			   .replace("SCOPE", "snsapi_base")
			   .replace("STATE", "1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println("redirect " + uri);
		return "redirect:" + uri;
	}
	
//	@RequestMapping(value="/registResultMap", method=RequestMethod.GET)
//	public String userRegistResult(HttpServletRequest request,Model model) {
//		System.out.println("regist result");
//		model.addAttribute("fiveBookUser", request.getSession().getAttribute("fiveBookUser"));
//		String path = "http://1d6289976g.imwork.net/wx/fiveBookUser/registResult";
//		String uri = WeixinFinalValue.AUTH_URL;
//		try {
//			uri = uri.replace("APPID", WeixinContext.getInstance().getAppId())
//			   .replace("REDIRECT_URI",URLEncoder.encode(path, "UTF-8"))
//			   .replace("SCOPE", "snsapi_userinfo")
//			   .replace("STATE", "1");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		System.out.println("redirect " + uri);
//		return "redirect:" + uri;
//	}
	
}
