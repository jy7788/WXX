package com.cn.hnust.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.hnust.model.FiveBookUser;




public class AuthFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest)req;
		HttpServletResponse httpResp = (HttpServletResponse)resp;
		String url = httpReq.getRequestURI();
		System.out.println(url);
//		if(url.indexOf("weixinMenu")>0 || url.indexOf("fiveBookUser/list") > 0) {
//			FiveBookUser u = (FiveBookUser) httpReq.getSession().getAttribute("fiveBookUser");
//			if(u==null || u.getStatus() != 1) {
//				httpResp.sendRedirect(httpReq.getContextPath()+"/fiveBookUser/adminLogin");
//			}
//			return;
//		if(url.indexOf("resources")>0||url.indexOf("login")>0||url.indexOf("/wget")>0) {
//			chain.doFilter(httpReq, httpResp);
//			return;
//		} else {
//			FiveBookUser u = (FiveBookUser) httpReq.getSession().getAttribute("fiveBookUser");
//			if(u==null) {
//				httpResp.sendRedirect(httpReq.getContextPath()+"/fiveBookUser/login");
//				return;
//			}
//			chain.doFilter(httpReq, httpResp);
//		}
		chain.doFilter(httpReq, httpResp);
	}

	@Override
	public void init(FilterConfig cfg) throws ServletException {
		
	}

}
