package com.xzsj.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xzsj.student.IStudentDao;
import com.xzsj.student.StudentDaoImp;

/**
 * 	更新学生基本信息
 */
public class AltStuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int flag = Integer.parseInt(request.getParameter("flag"));
		if(flag == 0) { //先查找所有学生信息
			IStudentDao studentdao = new StudentDaoImp();
			request.setAttribute("stuList", studentdao.getStuList());
			request.getRequestDispatcher("altStu.jsp").forward(request, response);
		}
	}
}


