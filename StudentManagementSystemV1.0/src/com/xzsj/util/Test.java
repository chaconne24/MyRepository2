package com.xzsj.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import com.xzsj.student.IStudentDao;
import com.xzsj.student.Student;
import com.xzsj.student.StudentDaoImp;

public class Test {

	public static void main(String[] args) {
		
		IStudentDao studao = new StudentDaoImp();
		ArrayList<Student> stuList = studao.getStuList();
		JsonUtil json = new JsonUtil();
		String str = json.listToJson(stuList);
		File file = new File("C:\\Users\\John\\Desktop\\新建文件夹\\student.json");
		OutputStream out = null;
		BufferedOutputStream bs = null;
		byte[] bys = str.getBytes();
		if(file.exists()) {
			try {
				out = new FileOutputStream(file);
				bs = new BufferedOutputStream(out);
				try {
					bs.write(bys, 0, bys.length);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					bs.close();
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			}
			
			

	}

}
