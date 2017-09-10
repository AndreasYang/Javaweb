<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="student.pojo.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新学生信息</title>
<link rel="stylesheet"  type="text/css"  href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.css"/>
</head>
<body>
	
	<form class="col-md-2 col-md-offset-5" action="/Java1707web/student?method=UpdateStudent" method="post">
	
<c:forEach items="${list }" var="student">
	<div class="form-group">
		<label>学号</label>
		<input type="text" class="form-control" name="number" value="${student.number}"><br/>
	</div>
	<div class="form-group">
		<label>姓名</label>
		<input type="text" class="form-control" name="name" value="${student.name}"><br/>
	</div>
	<div class="form-group">
		<label>年龄</label>
		<input type="text" class="form-control" name="age" value="${student.age}"><br/>
	</div>
	<div class="form-group">
		<label>性别</label>
		<input type="text" class="form-control" name="gender" value="${student.gender}"><br/>
	</div>
	<div class="form-group">
		<label>地址</label>
		<input type="text" class="form-control" name="address" value="${student.address}"><br/>
	</div>
	
		<input type="submit" class="btn btn-primary btn-block" value="修改"/>
	
	</c:forEach>
	</form>
</body>
</html>