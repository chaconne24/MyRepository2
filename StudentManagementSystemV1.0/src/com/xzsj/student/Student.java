package com.xzsj.student;

/**
 * 	学生类
 * @author John
 *
 */
public class Student {
	private int id;
	private String name;
	private String sex;
	private int age;
	private int java;
	private int python;
	private int sql;
	private int linux;
	private int sum;
	private double average;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getJava() {
		return java;
	}
	public void setJava(int java) {
		this.java = java;
	}
	public int getPython() {
		return python;
	}
	public void setPython(int python) {
		this.python = python;
	}
	public int getSql() {
		return sql;
	}
	public void setSql(int sql) {
		this.sql = sql;
	}
	public int getLinux() {
		return linux;
	}
	public void setLinux(int linux) {
		this.linux = linux;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int java,int python,int sql,int linux) {
		this.sum = java + python + sql + linux;
	}
	public double getAverage() {
		return average;
	}
	public void setAverage(int sum) {
		this.average = sum/4;
	}
}
