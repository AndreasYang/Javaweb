<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.css" />
</head>
<body>
	<%@include file="common/courseheader.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-2">
				<div class="list-group">
					<a href="${pageContext.request.contextPath}/student?method=CourseList"
						class="list-group-item">课程列表</a>
					<a href="${pageContext.request.contextPath}/student?method=getSearchCoursePage"
						class="list-group-item">课程查询</a> 
					<a href="${pageContext.request.contextPath}/student?method=getAddCoursePage"
						class="list-group-item active">添加课程</a>
				</div>
			</div>

			<!-- 右 -->
			<div class="col-md-10">
				<ul class="nav nav-tabs">
					<li><a
						href="${pageContext.request.contextPath}/student?method=CourseList"
						class="list-group-item">课程列表</a>
					</li>
					<li><a href="${pageContext.request.contextPath}/student?method=getSearchCoursePage"
						class="list-group-item">课程查询</a>
					</li>
					<li class="active"><a href="${pageContext.request.contextPath}/student?method=getAddCoursePage"
						class="list-group-item">添加课程</a>
					</li>
				</ul>

				<form class="form_border col-md-3" action="/Java1707web/student?method=AddCourse" method="post">
					<div class="form-group">
						<label for="name">课程名称</label>
						<input type="text" class="form-control" name="coursename" />
					</div>
					<div class="form-group">
						<label for="name">学分</label>
						<input type="text" class="form-control" name="points" />
					</div>
					<input type="submit" class="btn btn-success btn-lg" value="添加"/>
				</form>
			</div>
		</div>
	</div>




</body>
</html>