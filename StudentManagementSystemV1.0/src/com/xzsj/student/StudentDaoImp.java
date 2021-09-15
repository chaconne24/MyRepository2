package com.xzsj.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.xzsj.util.JDBCUtils;

public class StudentDaoImp implements IStudentDao {
	
	private ArrayList<Student> stuList = new ArrayList<>();
	
	//重写获取学生对象的方法
	@Override
	public Student getStu(int id,String name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Student stu = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "SELECT id,NAME,sex,age,java,python,student.SQL,Linux "
					+ "FROM student WHERE id=? AND NAME=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				stu = new Student();
				stu.setId(rs.getInt("id"));
				stu.setName(rs.getString("NAME"));
				stu.setSex(rs.getString("sex"));
				stu.setAge(rs.getInt("age"));
				stu.setJava(rs.getInt("java"));
				stu.setPython(rs.getInt("python"));
				stu.setSql(rs.getInt("student.SQL"));
				stu.setLinux(rs.getInt("Linux"));
				stu.setSum(rs.getInt("java"), rs.getInt("python"), rs.getInt("student.SQL"), rs.getInt("Linux"));
				stu.setAverage(stu.getSum());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(rs, pstmt, conn);
		}
		return stu;
	}

	//重写获取学生对象集合的方法
	@Override
	public ArrayList<Student> getStuList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Student stu = null;
		try {
			conn = JDBCUtils.getConnection();
			String sql = "SELECT id,NAME,sex,age,java,python,student.SQL,Linux FROM student";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				stu = new Student();
				stu.setId(rs.getInt("id"));
				stu.setName(rs.getString("NAME"));
				stu.setSex(rs.getString("sex"));
				stu.setAge(rs.getInt("age"));
				stu.setJava(rs.getInt("java"));
				stu.setPython(rs.getInt("python"));
				stu.setSql(rs.getInt("student.SQL"));
				stu.setLinux(rs.getInt("Linux"));
				stu.setSum(rs.getInt("java"), rs.getInt("python"), rs.getInt("student.SQL"), rs.getInt("Linux"));
				stu.setAverage(stu.getSum());
				stuList.add(stu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.close(rs, pstmt, conn);
		}
		return stuList;
	}
	
	//添加学生
	@Override
	public int addStuInfo(int id, String name, int age, String sex) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rows = 0;//返回影响的行数
		try {
			conn = JDBCUtils.getConnection();
			String sql = "INSERT INTO student(id,NAME,sex,age) VALUES(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, sex);
			pstmt.setInt(4, age);
			rows = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return rows;
	}

	//录入学生各门成绩
	@Override
	public int addStuScore(int id, String name, int java, int python, int sql, int linux) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rows = 0;//返回影响的行数
		try {
			conn = JDBCUtils.getConnection();
			String sql2 = "UPDATE student SET java=?,python=?,student.SQL=?,Linux=? "
					+ "WHERE id=? AND NAME=?" ;
			pstmt = conn.prepareStatement(sql2);
			pstmt.setInt(1, java);
			pstmt.setInt(2, python);
			pstmt.setInt(3, sql);
			pstmt.setInt(4, linux);
			pstmt.setInt(5, id);
			pstmt.setString(6, name);
			rows = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return rows;
	}

	//删除学生
	@Override
	public int delStu(int id, String name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rows = 0;//返回影响的行数
		try {
			conn = JDBCUtils.getConnection();
			String sql = "DELETE FROM student WHERE id=? AND NAME=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			rows = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return rows;
	}
	
	//更新学生基本信息
	@Override
	public int altStuInfo(int id, String name, int age, String sex) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rows = 0;//返回影响的行数
		try {
			conn = JDBCUtils.getConnection();
			String sql = "UPDATE student SET sex=?,age=? WHERE id=? AND NAME=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sex);
			pstmt.setInt(2, age);
			pstmt.setInt(3, id);
			pstmt.setString(4, name);
			rows = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return rows;
	}
	
	
	

}
