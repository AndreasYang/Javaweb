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
	<%@include file="common/banjicourseheader.jsp"%>
	<div class="container">
		<div class="row">
				<div class="col-md-2">
					<div class="list-group">
						<a href="${pageContext.request.contextPath}/student?method=BanjiCoursePageList"
							class="list-group-item">班級课程列表</a>
						<a href="${pageContext.request.contextPath}/student?method=getSearchBanjiCoursePage"
							class="list-group-item">班級课程查询</a> 
						<a href="${pageContext.request.contextPath}/student?method=getAddBanjiCoursePage"
							class="list-group-item active">添加班級课程</a>
					</div>
				</div>
	
				<!-- 右 -->
				<div class="col-md-10">
					<ul class="nav nav-tabs">
						<li><a
							href="${pageContext.request.contextPath}/student?method=BanjiCoursePageList">班級课程列表</a>
						</li>
						<li><a href="${pageContext.request.contextPath}/student?method=getSearchBanjiCoursePage"
							class="list-group-item">班級课程查询</a>
						</li>
						<li class="active"><a href="${pageContext.request.contextPath}/student?method=getAddBanjiCoursePage"
							class="list-group-item">添加班級课程</a>
						</li>
					</ul>
									
					<form class="form-group col-md-3" action="/Java1707web/student?method=AddBanjiCourse" method="post">
						<div class="form-group">
							<select class="form-control" name="banjiId">
								<c:forEach items="${banji}" var="banji">
									<option value="${banji.banjiId}">${banji.classname}</option>
								</c:forEach>
							</select>
						</div>
						
						<div class="form-group center-block">
							<span class="glyphicon glyphicon-arrow-up"></span>
						</div>
						
						<div class="form-group">
							<select class="form-control" name="courseId">
								<c:forEach items="${course}" var="course">
									<option value="${course.courseId}">${course.coursename}</option>
								</c:forEach>
							</select>
						</div>
						<button type="submit" class="btn btn-success " >添加</button>
					</form>
					
				</div>
		</div>
	</div>

</body>
</html>