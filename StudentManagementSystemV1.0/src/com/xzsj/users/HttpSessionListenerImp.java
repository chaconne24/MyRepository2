package com.xzsj.users;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 	统计当前在线人数
 * @author John
 *
 */
public class HttpSessionListenerImp implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		HttpSession session = arg0.getSession();
		//通过session获取上下文对象
		ServletContext context = session.getServletContext();
		Integer count = (Integer)context.getAttribute("onlineNum");
		if(count == null) {
			context.setAttribute("onlineNum", 1); //第一个人登录
		} else {
			context.setAttribute("onlineNum", count+1); //之后每登录一个人，count加一
		}
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		HttpSession session = arg0.getSession();
		ServletContext context = session.getServletContext();
		Integer count = (Integer)context.getAttribute("onlineNum");
		context.setAttribute("onlineNum", count-1);  //每退出一个人减一
	}

}
