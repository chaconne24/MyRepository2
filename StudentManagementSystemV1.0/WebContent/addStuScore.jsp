<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>layout 管理系统大布局 - Layui</title>
    <link rel="stylesheet" href="layui/css/layui.css">
    <script src="./js/div.js"></script>
</head>

<body>
	<!-- 用户未登录就跳转到登录页面 -->
	<c:if test="${sessionScope.current eq null}">
		<c:redirect url="login.jsp?nologin=no"></c:redirect>
	</c:if>
	
	<!-- 页面内容 -->
    <div class="layui-layout layui-layout-admin">
    
        <jsp:include page="header.jsp"></jsp:include>

        <jsp:include page="left.jsp"></jsp:include>

        <div class="layui-body">
            <!-- 内容主体区域 -->
            <div class="layui-card" style="margin-top: 20px;margin-left: 10px;">
                <form class="layui-form" action="AddStuScoreServlet">
					<div class="layui-form-item">
				    	<label class="layui-form-label">学生的id</label>
				    	<div class="layui-input-block">
				      		<input type="text" name="id" required placeholder="此处只能输入数字" lay-verify="required" autocomplete="off" class="layui-input">
				    	</div>
				  	</div>
				  	<div class="layui-form-item">
				    	<label class="layui-form-label">学生的姓名</label>
				    	<div class="layui-input-inline">
				      		<input type="text" name="name" required lay-verify="required" autocomplete="off" class="layui-input">
				    	</div>
				  	</div>
				  	<div class="layui-form-item">
				    	<label class="layui-form-label">Java成绩</label>
				    	<div class="layui-input-inline">
				      		<input type="text" name="java" required placeholder="此处只能输入数字" lay-verify="required" autocomplete="off" class="layui-input">
				    	</div>
				  	</div>
				  	<div class="layui-form-item">
				    	<label class="layui-form-label">Python成绩</label>
				    	<div class="layui-input-inline">
				      		<input type="text" name="python" required placeholder="此处只能输入数字" lay-verify="required" autocomplete="off" class="layui-input">
				    	</div>
				  	</div>
				  	<div class="layui-form-item">
				    	<label class="layui-form-label">SQL成绩</label>
				    	<div class="layui-input-inline">
				      		<input type="text" name="sql" required placeholder="此处只能输入数字" lay-verify="required" autocomplete="off" class="layui-input">
				    	</div>
				  	</div>
				  	<div class="layui-form-item">
				    	<label class="layui-form-label">Linux成绩</label>
				    	<div class="layui-input-inline">
				      		<input type="text" name="linux" required placeholder="此处只能输入数字" lay-verify="required" autocomplete="off" class="layui-input">
				    	</div>
				    	<div class="layui-form-mid layui-word-aux">以上项目必需填写</div>
				  	</div>		
				  	<div class="layui-form-item">
				    	<div class="layui-input-block">			    		
				     		<button class="layui-btn" lay-submit lay-filter="formDemo">录入成绩</button>
				      		<button type="reset" class="layui-btn layui-btn-primary">重置</button>
				    	</div>
				  	</div>
				</form>
				<div class="layui-card">
  					<div class="layui-card-header"><h2>系统提示</h2></div>
  					<c:if test="${param.info eq null}">
  						<div class="layui-card-body">请录入学生成绩</div>
  					</c:if>
  					<c:if test="${param.info ne null and param.info eq 'success'}">
  						<div class="layui-card-body">成绩录入成功</div>
  					</c:if>
  					<c:if test="${param.info ne null and param.info eq 'fail'}">
						<div class="layui-card-body">成绩录入失败</div>
					</c:if>
				</div>
            </div>
        </div>

        <jsp:include page="footer.jsp"></jsp:include>

    </div>

    <script src="layui/layui.js"></script>
    <script>
		//判断用户有修改学生信息功能
		var add = document.querySelector(".add");
		var alt = document.querySelector(".alt");
		var del = document.querySelector(".del");
		var addScore = document.querySelector(".addScore");
		var grant = document.querySelector(".grant");
		var name2 = document.querySelector(".name2");
		var sex = document.querySelector(".sex");
		var age = document.querySelector(".age");
		var address = document.querySelector(".address");
		var phone = document.querySelector(".phone");
		//变量
		var a = grant.innerHTML=="1"?"可以添加学生、删除学生及修改学生信息及成绩和查看学生信息及成绩":"可以查看学生信息及成绩";
		var online = document.querySelector(".online");
		add.onclick=function(){
			if(grant.innerHTML=="0"){
				alert("该用户无权限");
				add.href = "#";
			} 
		}
		alt.onclick=function(){
			if(grant.innerHTML=="0"){
				alert("该用户无权限");
				alt.href = "#";
			} 
		}
		del.onclick=function(){
			if(grant.innerHTML=="0"){
				alert("该用户无权限");
				del.href = "#";
			} 
		}
		addScore.onclick=function(){
			if(grant.innerHTML=="0"){
				alert("该用户无权限");
				addScore.href = "#";
			} 
		}
    
        //JS 
        layui.use(['element', 'layer', 'util'], function () {
            var element = layui.element
                , layer = layui.layer
                , util = layui.util
                , $ = layui.$;

            //头部事件
            util.event('lay-header-event', {
                //左侧菜单事件
                menuLeft: function (othis) {
                    layer.msg('展开左侧菜单的操作', { icon: 0 });
                }
                , menuRight: function () {
                    layer.open({
                        type: 1
                        , content: '<div style="padding: 15px;">当前在线'+online.innerHTML+'人</div>'
                        , area: ['260px', '100%']
                        , offset: 'rt' //右上角
                        , anim: 5
                        , shadeClose: true
                    });
                }
                , notice:function() {
                	layer.open({
                		title: '管理员信息'
                		,content: '姓名：'+name2.innerHTML+'<br>'
		        				+'性别：'+sex.innerHTML+'<br>'
		        				+'年龄：'+age.innerHTML+'<br>'
		        				+'家庭地址：'+address.innerHTML+'<br>'
		        				+'联系电话：'+phone.innerHTML+'<br>'
		        				+'权限：'+a+'<br>'
                		,area: ['500px', '300px']
                		,btn: ['朕知道了']
                	});   
                }
            });

        });

        //注意：折叠面板 依赖 element 模块，否则无法进行功能性操作
        layui.use('element', function () {
            var element = layui.element;

            //…
        });
    </script>
</body>

</html>