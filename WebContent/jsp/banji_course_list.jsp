<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="student.pojo.*"%>
<%@page import="java.util.*"%>
<%@page import="vo.PageBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>教务管理</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/lib/bootstrap/js/jquery-3.2.1.min.js"></script>
</head>
<body>
<%@include file="common/banjicourseheader.jsp"%>

<div class="container">
		<div class="row">
			<div class="col-md-2">
				<div class="list-group">
					<a href="${pageContext.request.contextPath}/student?method=BanjiCoursePageList"
						class="list-group-item active">班級课程列表</a>
					<a href="${pageContext.request.contextPath}/student?method=getSearchBanjiCoursePage"
						class="list-group-item">班級课程查询</a> 
					<a href="${pageContext.request.contextPath}/student?method=getAddBanjiCoursePage"
						class="list-group-item">添加班級课程</a>
				</div>
			</div>

			<!-- 右 -->
			<div class="col-md-10">
				<ul class="nav nav-tabs">
					<li class="active"><a
						href="${pageContext.request.contextPath}/student?method=BanjiCoursePageList">班級课程列表</a>
					</li>
					<li><a href="${pageContext.request.contextPath}/student?method=getSearchBanjiCoursePage"
						class="list-group-item">班級课程查询</a>
					</li>
					<li><a href="${pageContext.request.contextPath}/student?method=getAddBanjiCoursePage"
						class="list-group-item">添加班級课程</a>
					</li>
				</ul>

				<table class="align-center table table-striped table-bordered table-hover table-condensed text-center">
					<tr>
						<td>班级</td>
						<td>课程</td>
						<td>学分</td>
						<td>删除</td>
					</tr>
			
					<c:forEach items="${pageBean.list2 }" var="banji">
						<tr>
							<td>${banji.classname}</td>
							<td>${banji.coursename}</td>
							<td>${banji.points}</td>
							<td><a href="${pageContext.request.contextPath}/student?method=DeleteBanjiCourse&bcId=${banji.banji_course_id}">删除</a></td>
						</tr>
					</c:forEach>
				</table>
				
				<!-- 分页 -->
				<nav aria-label="Page navigation" class="pull-right">
				<ul class="pagination">
					<!-- 向前跳转结束 -->
					<c:if test="${pageBean.pageIndex==1}">
						<li class="disabled"><a href="javascript:void(0);"
							aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
						</a></li>
					</c:if>
					<c:if test="${pageBean.pageIndex!=1}">
						<li><a
							href="${pageContext.request.contextPath}/student?method=BanjiCoursePageList&pageIndex=${pageBean.pageIndex-1}"
							aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
						</a></li>
					</c:if>
					<!-- 向前跳转结束 -->


					<c:forEach begin="1" end="${pageBean.totalPage }" var="page">

						<c:if test="${pageBean.pageIndex!=page}">
							<li><a
								href="${pageContext.request.contextPath}/student?method=BanjiCoursePageList&pageIndex=${page}">${page}</a></li>
						</c:if>
						<c:if test="${pageBean.pageIndex==page}">
							<li class="active"><a
								href="${pageContext.request.contextPath}/student?method=BanjiCoursePageList&pageIndex=${page}">${page}</a></li>
						</c:if>
					</c:forEach>


					<!-- 向后跳转开始 -->
					<c:if test="${pageBean.pageIndex == pageBean.totalPage}">
						<li class="disabled"><a href="javascript:void(0);"
							aria-label="Next"> <span aria-hidden="true">&raquo;</span>
						</a></li>
					</c:if>
					<c:if test="${pageBean.pageIndex != pageBean.totalPage}">
						<li><a
							href="${pageContext.request.contextPath}/student?method=BanjiCoursePageList&pageIndex=${pageBean.pageIndex+1}"
							aria-label="Next"> <span aria-hidden="true">&raquo;</span>
						</a></li>
					</c:if>
				</ul>
				</nav>
				<!-- 向后跳转结束 -->
				<!-- 分页 -->
			</div>
		</div>
	</div>
	
</body>
</html>