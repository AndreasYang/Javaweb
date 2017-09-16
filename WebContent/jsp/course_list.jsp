<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>课程管理</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/lib/bootstrap/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	function selectAlls() {
		$("input[name=selectCoursenames]").prop("checked",
				$("#selectAll").is(":checked"));
	};
	function deleteAll() {
		var isDel = confirm("是否要删除？");
		if (isDel) {
			$("mainForm")
					.attr("action",
							"${pageContext.request.contextPath}/student?method=DeleteAllCourse");
			$("mainForm").submit();
		}
	}
</script>
</head>
<body>
	<%@include file="common/courseheader.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-2">
				<div class="list-group">
					<a href="${pageContext.request.contextPath}/student?method=CourseList"
						class="list-group-item active">课程列表</a>
					<a href="${pageContext.request.contextPath}/student?method=getSearchCoursePage"
						class="list-group-item">课程查询</a> 
					<a href="${pageContext.request.contextPath}/student?method=getAddCoursePage"
						class="list-group-item">添加课程</a>
				</div>
			</div>

			<!-- 右 -->
			<div class="col-md-10">
				<ul class="nav nav-tabs">
					<li class="active"><a
						href="${pageContext.request.contextPath}/student?method=CourseList">课程列表</a>
					</li>
					<li><a href="${pageContext.request.contextPath}/student?method=getSearchCoursePage"
						class="list-group-item">课程查询</a>
					</li>
					<li><a href="${pageContext.request.contextPath}/student?method=getAddCoursePage"
						class="list-group-item">添加课程</a>
					</li>
				</ul>

				<form id="mainForm"
					action="${pageContext.request.contextPath}/student?method=DeleteAllCourse"
					method="post">
					<table class="align-center table table-striped table-bordered table-hover table-condensed text-center">
						<tr>
							<td><input type="checkbox" id="selectAll"
								onClick="selectAlls();" /></td>
							<td>课程</td>
							<td>学分</td>
							<td>修改</td>
							<td>删除</td>
						</tr>

						<c:forEach items="${list}" var="course">
							<tr>
								<td><input type="checkbox" name="selectCoursenames"
									value="${course.coursename}" /></td>
								<td>${course.coursename}</td>
								<td>${course.points}</td>
								<td>
									<a href="${pageContext.request.contextPath}/student?method=ToUpdateCourse&name=${course.coursename}">修改</a>
								</td>
								<td>
									<a href="${pageContext.request.contextPath}/student?method=DeleteCourse&name=${course.coursename}">删除</a>
								</td>
							</tr>
						</c:forEach>

					</table>
					<input type="submit" class="btn btn-danger" onClick="deleteAll();"
						value="批量删除" />
				</form>
			</div>
		</div>
	</div>

</body>
</html>