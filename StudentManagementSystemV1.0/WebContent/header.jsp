<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="layui-header">
        <div class="layui-logo layui-hide-xs layui-bg-black">学生管理系统 v1.0</div>
        <!-- 头部区域（可配合layui 已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item layui-hide-xs"><a href="index.jsp">首页</a></li>
            <li class="layui-nav-item layui-hide-xs"><a href="download.jsp">资源下载</a></li>
            <li class="layui-nav-item layui-hide-xs"><a href="upload.jsp">资源上传</a></li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item layui-hide layui-show-md-inline-block">
                <a href="javascript:;">
                    <img src="layui/image/user.jpg" class="layui-nav-img">
                    <em class="name2">${sessionScope.current.name}</em>
                    <em class="grant" style="display:none">${sessionScope.current.grant}</em>
                    <em class="age" style="display:none">${sessionScope.current.age}</em>
                    <em class="sex" style="display:none">${sessionScope.current.sex}</em>
                    <em class="address" style="display:none">${sessionScope.current.address}</em>
                    <em class="phone" style="display:none">${sessionScope.current.phone}</em>
                </a>
                <dl class="layui-nav-child">
                    <dd lay-header-event="notice"><a href="#">管理员信息</a></dd>
                    <dd><a href="#">设置</a></dd>
                    <dd><a href="LoginOutServlet">安全退出</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item" lay-header-event="menuRight" lay-unselect>
                <a href="javascript:;">
                    <i class="layui-icon layui-icon-more-vertical"></i>
                </a>
            </li>
        </ul>
    </div>
</body>
</html>