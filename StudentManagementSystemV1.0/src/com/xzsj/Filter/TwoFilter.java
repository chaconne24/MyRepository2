package com.xzsj.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 	阻止用户重复登录
 * @author John
 *
 */
public class TwoFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		HttpSession session = req.getSession(false);
		if(session == null) { //用户未登录，允许登录
			chain.doFilter(req, res);
		} else {
			if(session.getAttribute("current") != null) { //用户已经登录，阻止登录，定向到主页
				String rewriteURL = res.encodeURL("index.jsp");
				res.sendRedirect(rewriteURL);
			} else { //用户未登录或session过期，允许登录
				chain.doFilter(req, res);
			}
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
