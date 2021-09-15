package com.xzsj.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xzsj.Resource.IResourceDao;
import com.xzsj.Resource.ResourceDaoImp;
import com.xzsj.student.IStudentDao;
import com.xzsj.student.StudentDaoImp;
import com.xzsj.users.IUserDao;
import com.xzsj.users.User;
import com.xzsj.users.UserDaoImp;

/**
 * 	用户登录处理程序
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//获取用户提交的请求参数
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		//获取复选框状态
		String savepwd = request.getParameter("savepwd");
		//新建用户对象
		User current = new User(name,password);
		IUserDao userdao = new UserDaoImp();
		//从数据库读取用户数据
		current = userdao.vaildataLogin(current); 
		//获取session对象
		HttpSession session = request.getSession();
		//获取上下文对象
		ServletContext context = session.getServletContext();
		//从数据库读取文件资源数据,并存在context对象中
		IResourceDao resourcedao = new ResourceDaoImp();
		context.setAttribute("resList", resourcedao.getResourceList());
		//从数据库获取学生列表,并存在context对象中
		IStudentDao studentdao = new StudentDaoImp();
		context.setAttribute("stuList", studentdao.getStuList());
		
		if(current != null) {
			//将用户对象存储在session中
			session.setAttribute("current", current);	
			
			//获取用户未过期的cookie
			Cookie[] cookies = request.getCookies();
			if(cookies != null && cookies.length != 0) { //存在cookie
				int count = 0;
				for(int i=0;i<cookies.length;i++) { //遍历cookies数组，查找目标cookie
					if(cookies[i].getName().equals("logininfo")) { //存在目标cookie
						if(savepwd == null) { //用户未勾选记住密码，则清除目标cookie
							cookies[i].setMaxAge(0);
							response.addCookie(cookies[i]); 
						} //否则什么都不做
					count++;
					}
				}
				if(count == 0) { //没有目标cookie，如果用户勾选记住密码，则新建目标cookie
					if(savepwd != null && savepwd.equals("on")) {
						Cookie newcookie = new Cookie("logininfo",name+"|"+password);
						//设置cookie有效期为7天
						newcookie.setMaxAge(3600*24*7);
						response.addCookie(newcookie);
					}		
				}
			} else {	//没有任何cookie，如果用户勾选记住密码，则新建目标cookie
				if(savepwd != null && savepwd.equals("on")) {
					Cookie newcookie = new Cookie("logininfo",name+"|"+password);
					//设置cookie有效期为7天
					newcookie.setMaxAge(3600*24*7);
					response.addCookie(newcookie);
				}		
			}
			//重写URL，如果session没到期，关闭浏览器再打开，任可以连接到此会话
			String rewriteURL = response.encodeURL("index.jsp");
			//登录成功，重定向到index页面
			response.sendRedirect(rewriteURL);
		} else {
			//登录失败，返回登录页
			response.sendRedirect("login.jsp?loginfail=error");
		}
	}

}
