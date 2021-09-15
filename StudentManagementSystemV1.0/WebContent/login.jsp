<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>login</title>
    <link rel="stylesheet" href="./css/iconfont.css">
    <link rel="stylesheet" href="./css/login.css">
</head>
<body>
    <div class="login-box">
        <h1>登录</h1>
        <form action="UserServlet" method="post" class="input-box">
        	<c:choose>
        		<c:when test="${cookie['logininfo'] ne null}">
        			<c:forTokens items="${cookie['logininfo'].value}" delims="|" varStatus="sta">
        				<c:if test="${sta.count eq 1}">
        					<div class="input-text">
                				<span class='iconfont icon-mine'></span>
                				<input type="text" placeholder="用户名" name="name" value="${sta.current}">
            				</div>
        				</c:if>
        				<c:if test="${sta.count eq 2}">
        					<div class="input-text">
                				<span class='iconfont icon-lock'></span>
                				<input type="password" placeholder="密码" name="password" value="${sta.current}">
            				</div>
        				</c:if>
        			</c:forTokens>
        		</c:when>
        		<c:otherwise>
        			<div class="input-text">
                		<span class='iconfont icon-mine'></span>
                		<input type="text" placeholder="用户名" name="name" value="">
            		</div>
            		<div class="input-text">
                		<span class='iconfont icon-lock'></span>
                		<input type="password" placeholder="密码" name="password" value="">
            		</div>
        		</c:otherwise>
        	</c:choose>
            <div class="input-text">
            	<input type="checkbox" name="savepwd" checked="checked">
				<span>&nbsp;记住密码</span>
            </div>
            <input type="submit" value="登录" class="input-btn">
            <div class="sign-up">
                	还没账户？<a href="#">立即注册</a>
            </div>
        </form>
        
        <!-- 用户或密码错误的提示 -->
		<c:if test="${not empty param.loginfail and param.loginfail eq 'error'}">
			<label style="color:red">系统提示：用户名不存在或密码错误</label>
		</c:if>
		<!-- 用户未登录的提示 -->
		<c:if test="${not empty param.nologin and param.nologin eq 'no'}">
			<label style="color:red">系统提示：请先登录</label>
		</c:if>
    </div>
</body>
</html>