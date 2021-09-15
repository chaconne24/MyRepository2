package com.xzsj.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 	文件下载处理程序
 */
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String dir;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//获取下载链接的文件名和路径
		String displayname = request.getParameter("displayname");
		String path = request.getParameter("path");
		//下载文件所在的目录
		dir = this.getServletContext().getRealPath(path);
		//建立下载的目标文件
		File target = new File(dir+"/"+displayname);
		InputStream input = null;
		ServletOutputStream output = null;
		if(target.exists()) { //文件存在
			input = new FileInputStream(target);
			//设置文件临时存储的缓冲区
			byte []datas = new byte[10240];
			int count = 0;
			//设置响应头内容
			response.setHeader("content-disposition", 
				"attachment;filename="+URLEncoder.encode(target.getName(), "utf-8"));
			//获取响应给客户端的文件输出流
			output = response.getOutputStream();
			//读取文件到缓冲区，响应发送输出流到客户端浏览器
			while((count = input.read(datas,0,datas.length))>0) {
				output.write(datas, 0, count);
			}
			//关闭流
			output.flush();
			output.close();
			input.close();
		} else {
			response.sendRedirect("tip.jsp"); //定位到提示页面
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
