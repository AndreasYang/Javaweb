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
					<a
						href="${pageContext.request.contextPath}/student?method=CourseList"
						class="list-group-item">课程列表</a> <a
						href="${pageContext.request.contextPath}/student?method=getSearchCoursePage"
						class="list-group-item active">课程查询</a> <a
						href="${pageContext.request.contextPath}/student?method=getAddCoursePage"
						class="list-group-item">添加课程</a>
				</div>
			</div>

			<!-- 右 -->
			<div class="col-md-10">
				<ul class="nav nav-tabs">
					<li><a
						href="${pageContext.request.contextPath}/student?method=CourseList">课程列表</a>
					</li>
					<li class="active"><a
						href="${pageContext.request.contextPath}/student?method=getSearchCoursePage"
						class="list-group-item">课程查询</a></li>
					<li><a
						href="${pageContext.request.contextPath}/student?method=getAddCoursePage"
						class="list-group-item">添加课程</a></li>
				</ul>

				<form class="form-inline" id="searchForm"
					action="/Java1707web/student?method=searchCourse" method="post">
					姓名：<input type="text" class="form-control" name="name"
						value="${searchCondition.name}" /> 年龄：<input type="text"
						class="form-control" name="age" value="${searchCondition.age}" />
					<input type="submit" class="btn btn-primary" value="搜索" />

				</form>

				<form id="mainForm"
					action="${pageContext.request.contextPath}/student?method=DeleteAll"
					method="post">
					<table
						class="align-center table table-striped table-bordered table-hover table-condensed text-center">

						<tr>
							<td>课程名称</td>
							<td>课程学分</td>

						</tr>

						<c:forEach items="${list}" var="course">
							<tr>
								<td>${course.coursename}</td>
								<td>${course.points}</td>
								<td><a
									href="${pageContext.request.contextPath}/student?method=ToUpdateCourse&name=${course.coursename}">修改</a>
								</td>
								<td><a
									href="${pageContext.request.contextPath}/student?method=DeleteCourse&name=${course.coursename}">删除</a>
								</td>
							</tr>
						</c:forEach>

					</table>
				</form>


			</div>
		</div>
	</div>

</body>
</html>