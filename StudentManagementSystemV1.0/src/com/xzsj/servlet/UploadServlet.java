package com.xzsj.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * 	文件上传处理程序
 */
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String uploadSaveDir;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//上传文件保存的目录
		uploadSaveDir = this.getServletContext().getRealPath("/WEB-INF/files/");
		//创建默认属性设置的磁盘文件项工厂对象
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//构造ServletFileUpload组件
		ServletFileUpload fileUpload = new ServletFileUpload();
		//设置使用的FileItemFactory
		fileUpload.setFileItemFactory(factory);
		//设置相关属性
		fileUpload.setFileSizeMax(1024*1024);
		fileUpload.setSizeMax(1024*1024*100);
		fileUpload.setHeaderEncoding("utf-8");
		//获取FileItemFactory所有文件项FileItem
		List<FileItem> itemList = null;
		try {
			itemList = fileUpload.parseRequest(request);
			for(FileItem item:itemList) {
				//判断是普通表单字段还是文件对象或者文件组件
				boolean bool = item.isFormField();
				if(!bool) { //如果是文件对象则保存到磁盘
					String fileName = item.getName(); //获取上传文件的名称
					System.out.println("文件名称 "+fileName);
					System.out.println("字段名称 "+item.getFieldName());
					System.out.println("文件大小 "+item.getSize());
					System.out.println("文件类型 "+item.getContentType());
					File target = new File(uploadSaveDir+new Date().getTime()+fileName);
					item.write(target);
				}
				item.delete(); //释放item内容主体
			}
		} catch (Exception e) {
			e.printStackTrace();
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
