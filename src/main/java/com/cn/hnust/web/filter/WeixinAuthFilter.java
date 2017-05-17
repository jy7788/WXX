package com.cn.hnust.web.filter;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.hnust.model.FiveBookUser;
import com.cn.hnust.model.User;
import com.cn.hnust.model.WeixinContext;
import com.cn.hnust.model.WeixinFinalValue;
import com.cn.hnust.service.IFiveBookUserService;
import com.cn.hnust.service.IUserService;
import com.cn.hnust.service.IWUserService;
import com.cn.hnust.web.servlet.BeanFactoryContext;


public class WeixinAuthFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hRequest = (HttpServletRequest)request;
		HttpServletResponse hResponse = (HttpServletResponse)response;
		
		String path = hRequest.getRequestURL().toString();
		if(path.contains("/wget")) {
			System.out.println("wgetpath" + path);
			chain.doFilter(hRequest, hResponse);
			return;
		}
		String agent2 = hRequest.getHeader("User-Agent");
		System.out.println("agent" + agent2);
		
		User tu = (User)hRequest.getSession().getAttribute("user");
		if(tu==null) {
			String agent = hRequest.getHeader("User-Agent");
//			if(agent!=null&&agent.toLowerCase().indexOf("micromessenger")>=0) {
			if(agent!=null&&!agent.toLowerCase().contains("windows")) {
				String code = request.getParameter("code");
				String state = request.getParameter("state");
				System.out.println("code " + code);
				System.out.println("state" + state);
				if(code!=null&&state!=null&&state.equals("1")) {
					//ͨ��Code��ȡopenid��������Ȩ
					IWUserService wUserService = (IWUserService)BeanFactoryContext.getService("wUserService");
					String openid = wUserService.queryOpenidByCode(code);
					System.out.println("openid" + openid);
					if(openid!=null) {
						IFiveBookUserService userService = (IFiveBookUserService)BeanFactoryContext.getService("fiveBookUserService");
						FiveBookUser u = userService.loadByOpenId(openid);
						if(u==null) {
							u = wUserService.queryByOpenid(openid).getUser();
							userService.add(u);
						} else {
							if(u.getStatus()==0) {
								u.setStatus(1);
								userService.update(u);
							}
						}
						hRequest.getSession().setAttribute("fiveBookUser", u);
					}
				} else {
//					String query = hRequest.getQueryString();
//					if(query!=null) {
//						path = path+"?"+query;
//					}
//					path = "http://1d6289976g.imwork.net/wx/user_regist.jsp";
					System.out.println("auth" + path);
					String uri = WeixinFinalValue.AUTH_URL;
					uri = uri.replace("APPID", WeixinContext.getInstance().getAppId())
					   .replace("REDIRECT_URI",URLEncoder.encode(path, "UTF-8"))
					   .replace("SCOPE", "snsapi_base")
					   .replace("STATE", "1");
					hResponse.sendRedirect(uri);
					System.out.println(uri);
					return;
				}
			}
		}
		chain.doFilter(hRequest, hResponse);
	}

	@Override
	public void destroy() {

	}

}
