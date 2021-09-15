package com.xzsj.student;

import java.util.ArrayList;

public interface IStudentDao {
	//获取学生对象
	public abstract Student getStu(int id,String name);
	//获取学生对象的集合
	public abstract ArrayList<Student> getStuList();
	//向数据库里添加学生信息
	public abstract int addStuInfo(int id,String name,int age,String sex);
	//向数据库里添加学生成绩
	public abstract int addStuScore(int id,String name,int java,int python,int sql,int linux);
	//删除学生
	public abstract int delStu(int id,String name);
	//修改学生基本信息
	public abstract int altStuInfo(int id,String name,int age,String sex);
}
