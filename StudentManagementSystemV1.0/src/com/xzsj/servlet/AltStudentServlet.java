package com.xzsj.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xzsj.student.IStudentDao;
import com.xzsj.student.StudentDaoImp;

/**
 * Servlet implementation class AltStudentServlet
 */
public class AltStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//设置响应字符集
		response.setHeader("Content-type", "text/html;charset=GBK");
		response.setCharacterEncoding("GBK");
		//表单提交要修改的数据
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String sex = request.getParameter("sex");
		IStudentDao studentdao = new StudentDaoImp();
		if(studentdao.altStuInfo(id, name, age, sex)>0) {
			response.getWriter().print("修改成功，3秒后自动跳转");
			response.setHeader("refresh", "3,url=index.jsp");
		} else {
			response.getWriter().print("修改失败，3秒后自动跳转");
			response.setHeader("refresh", "3,url=index.jsp");
		}
		
	}

}
