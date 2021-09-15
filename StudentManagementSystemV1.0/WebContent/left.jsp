<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="layui-side layui-bg-black">
       <div class="layui-side-scroll">
           <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
       <ul class="layui-nav layui-nav-tree" lay-filter="test">
           <li class="layui-nav-item">
               <a class="" href="javascript:;">学生信息管理</a>
               <dl class="layui-nav-child">
                   <dd><a class="add" href="addStu.jsp">添加学生</a></dd>
                   <dd><a href="findStu.jsp">查找学生基本信息</a></dd>
                   <dd><a class="alt" href="AltStuServlet?flag=0">更新学生基本信息</a></dd>
                   <dd><a class="del" href="delStu.jsp">删除学生</a></dd>
               </dl>
           </li>
           <li class="layui-nav-item">
               <a href="javascript:;">学生成绩管理</a>
               <dl class="layui-nav-child">
                   <dd><a class="addScore" href="addStuScore.jsp">录入学生各门成绩</a></dd>
                   <dd><a href="findStuScore.jsp">查找学生各门成绩</a></dd>
                   <dd><a href="sortStuScore.jsp">学生各门成绩排序</a></dd>
               </dl>
           </li>
       	</ul>
    </div>
   </div>
</body>
</html>