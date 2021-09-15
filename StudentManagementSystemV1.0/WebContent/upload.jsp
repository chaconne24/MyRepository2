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
            	<div class="layui-upload">
					  <button type="button" class="layui-btn layui-btn-normal" id="testList">选择多文件</button> 
					  <div class="layui-upload-list" style="max-width: 1000px;">
					    	<table class="layui-table">
					      		<colgroup>
					        		<col>
					        		<col width="150">
					        		<col width="260">
					        		<col width="150">
					      		</colgroup>
					      		<thead>
					        		<tr>
					        		<th>文件名</th>
					        		<th>大小</th>
							        <th>上传进度</th>
							        <th>操作</th>
					      			</tr>
					      		</thead>
					      		<tbody id="demoList"></tbody>
					    	</table>
					  </div>
					  <button type="button" class="layui-btn" id="testListAction">开始上传</button>
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
        
      //演示多文件列表
      layui.use(['upload', 'element', 'layer'], function(){
  		var $ = layui.jquery
  		,upload = layui.upload
  		,element = layui.element
  		,layer = layui.layer;
  	
        var uploadListIns = upload.render({
          elem: '#testList'
          ,elemList: $('#demoList') //列表元素对象
          ,url: 'UploadServlet'
          ,accept: 'file'
          ,multiple: true
          ,number: 3
          ,auto: false
          ,bindAction: '#testListAction'
          ,choose: function(obj){   
            var that = this;
            var files = this.files = obj.pushFile(); //将每次选择的文件追加到文件队列
            //读取本地文件
            obj.preview(function(index, file, result){
              var tr = $(['<tr id="upload-'+ index +'">'
                ,'<td>'+ file.name +'</td>'
                ,'<td>'+ (file.size/1014).toFixed(1) +'kb</td>'
                ,'<td><div class="layui-progress" lay-filter="progress-demo-'+ index +'"><div class="layui-progress-bar" lay-percent=""></div></div></td>'
                ,'<td>'
                  ,'<button class="layui-btn layui-btn-xs demo-reload layui-hide">重传</button>'
                  ,'<button class="layui-btn layui-btn-xs layui-btn-danger demo-delete">删除</button>'
                ,'</td>'
              ,'</tr>'].join(''));
              
              //单个重传
              tr.find('.demo-reload').on('click', function(){
                obj.upload(index, file);
              });
              
              //删除
              tr.find('.demo-delete').on('click', function(){
                delete files[index]; //删除对应的文件
                tr.remove();
                uploadListIns.config.elem.next()[0].value = ''; //清空 input file 值，以免删除后出现同名文件不可选
              });
              
              that.elemList.append(tr);
              element.render('progress'); //渲染新加的进度条组件
            });
          }
          ,done: function(res, index, upload){ //成功的回调
            var that = this;
            //if(res.code == 0){ //上传成功
              var tr = that.elemList.find('tr#upload-'+ index)
              ,tds = tr.children();
              tds.eq(3).html(''); //清空操作
              delete this.files[index]; //删除文件队列已经上传成功的文件
              return;
            //}
            this.error(index, upload);
          }
          ,allDone: function(obj){ //多文件上传完毕后的状态回调
            console.log(obj)
          }
          ,error: function(index, upload){ //错误回调
            var that = this;
            var tr = that.elemList.find('tr#upload-'+ index)
            ,tds = tr.children();
            tds.eq(3).find('.demo-reload').removeClass('layui-hide'); //显示重传
          }
          ,progress: function(n, elem, e, index){ //注意：index 参数为 layui 2.6.6 新增
            element.progress('progress-demo-'+ index, n + '%'); //执行进度条。n 即为返回的进度百分比
          }
        });
      });
    </script>
</body>

</html>