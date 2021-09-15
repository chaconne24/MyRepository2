package com.xzsj.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xzsj.student.IStudentDao;
import com.xzsj.student.StudentDaoImp;

/**
 * 	查找学生成绩
 */
public class FindStuScoreServlet extends HttpServlet {
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
		//获取findStuScore.jsp页面传来的请求参数
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		IStudentDao studao = new StudentDaoImp();
		request.setAttribute("stuScoreinfo", studao.getStu(id, name));
		//将设置的请求对象属性传回findStu.jsp页面
		request.getRequestDispatcher("findStuScore.jsp").forward(request, response);
	}

}
