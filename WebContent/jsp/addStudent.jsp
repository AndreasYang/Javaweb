<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/lib/bootstrap/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#name").blur(function(){
			var name = $("#name").val();
			$.post(
			    "${pageContext.request.contextPath}/student?method=CheckName",
				{"name":name},
				function(data){
					if(data.isExist){
						$("#nameInfo").html("该用户已存在");
						$("#nameInfo").css("color","red");
					}else{
						$("#nameInfo").html("该用户可以使用");
						$("#nameInfo").css("color","green");
					}
				},
				"json"
			);
		});	
	});
</script>
</head>
<body>
<%@include file="common/header.jsp"%>
<div class="container">
	<div class="row">
		<div class="col-md-2">
	        <div class="list-group">
	            <a href="${pageContext.request.contextPath}/student?method=PageList" class="list-group-item">学生管理</a>
	            <a href="${pageContext.request.contextPath}/student?method=getSearchPage" class="list-group-item">学生搜索</a>
	            <a href="${pageContext.request.contextPath}/student?method=getAddPage" class="list-group-item  active">添加学生</a>
	        </div>
		</div>
		<div class="col-md-10">
			<ul class="nav nav-tabs">
	                <li>
	                    <a href="${pageContext.request.contextPath}/student?method=PageList">学生列表</a>
	                </li>
	                <li>
	                    <a href="${pageContext.request.contextPath}/student?method=getSearchPage">学生搜索</a>
	                </li>
	                <li class="active">
	                	<a href="${pageContext.request.contextPath}/student?method=getAddPage">添加学生</a>
	                </li>
			</ul>
			<form class="form_border" action="/Java1707web/student?method=AddStudent" method="post">
			    <div class="form-group">
				    <label for="name">姓名</label>
				    <input type="text" class="form-control" name="name" id="name"/>
				    <span id="nameInfo"></span>
			    </div>
			    <div class="form-group">
				    <label for="number">学号</label>
					<input type="text" class="form-control" name="number" id="number" />
				</div>
				<div class="form-group">
					<label for="age">年龄</label>
					<input type="text" class="form-control" name="age"  id="age"/>
				</div>
				<div class="form-group">
					<label for="gender">性别</label>
					<input type="text" class="form-control" name="gender" id="gender"/>
				</div>
				<div class="form-group">
				<label for="address">地址</label>
				<input type="text" class="form-control" name="address" id="address"/>
				</div>
				<div class="form-group">
					<label for="classname">班级</label>
					<select class="form-control" name="banjiId">
						<c:forEach items="${banji}" var="banji">
							<option value="${banji.banjiId}">${banji.classname}</option>
						</c:forEach>
					</select>
				</div>
				<button type="submit" class="btn btn-success btn-lg" >保存</button>
			</form>
		</div>
	</div>
</div>
</body>
</html>