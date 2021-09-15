package com.xzsj.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xzsj.student.IStudentDao;
import com.xzsj.student.StudentDaoImp;

/**
 * 	录入学生成绩处理程序
 */
public class AddStuScoreServlet extends HttpServlet {
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
		int java = Integer.parseInt(request.getParameter("java"));
		int python = Integer.parseInt(request.getParameter("python"));
		int sql = Integer.parseInt(request.getParameter("sql"));
		int linux = Integer.parseInt(request.getParameter("linux"));
		IStudentDao studao = new StudentDaoImp();
		if(studao.addStuScore(id, name, java, python, sql, linux)>0) {
			//添加成功返回
			response.sendRedirect("addStuScore.jsp?info=success");
		} else {
			//添加失败返回
			response.sendRedirect("addStuScore.jsp?info=fail");
		}
		
	}

}
