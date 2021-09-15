<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="layui/css/layui.css">
    <script src="./js/div.js"></script>
</head>
<body>
	<form class="layui-form" action="">
	
	  <div class="layui-form-item">
	    <label class="layui-form-label">输入框</label>
	    <div class="layui-input-block">
	      <input type="text" name="title" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
	    </div>
	  </div>
	  
	  <div class="layui-form-item">
	    <label class="layui-form-label">密码框</label>
	    <div class="layui-input-inline">
	      <input type="password" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
	    </div>
	    <div class="layui-form-mid layui-word-aux">辅助文字</div>
	  </div>
	  
	  <div class="layui-form-item">
	    <label class="layui-form-label">复选框</label>
	    <div class="layui-input-block">
	      	<input type="checkbox" name="" title="写作" checked>
			<input type="checkbox" name="" title="发呆"> 
			<input type="checkbox" name="" title="禁用" disabled> 
	    </div>
	  </div>
	    
	  <div class="layui-form-item">
	    <div class="layui-input-block">
	      <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
	      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
	    </div>
	  </div>
</form>
 
<script>
	//Demo
	layui.use('form', function(){
	  var form = layui.form;
	  
	  //监听提交
	  form.on('submit(formDemo)', function(data){
	    layer.msg(JSON.stringify(data.field));
	    return false;
	  });
	});
</script>
</body>
</html>