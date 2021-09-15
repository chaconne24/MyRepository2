package com.xzsj.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xzsj.student.IStudentDao;
import com.xzsj.student.StudentDaoImp;

/**
 * 	添加学生信息处理程序
 */
public class AddStuServlet extends HttpServlet {
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
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String sex = request.getParameter("sex");
		IStudentDao studao = new StudentDaoImp();
		if(studao.addStuInfo(id, name, age, sex)>0) {
			//添加成功返回
			response.sendRedirect("addStu.jsp?info=success");
		} else {
			//添加失败返回
			response.sendRedirect("addStu.jsp?info=fail");
		}
		
	}

}
