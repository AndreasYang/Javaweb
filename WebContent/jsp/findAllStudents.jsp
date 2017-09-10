<%@page import="student.pojo.*"%>
<%@page import="java.util.*"%>
<%@page import="vo.PageBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" session="true"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>所有学生信息</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/lib/bootstrap/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	function selectAlls() {
		$("input[name=selectNames]").prop("checked",
				$("#selectAll").is(":checked"));
	};
	function deleteAll() {
		var isDel = confirm("是否要删除？");
		if (isDel) {
			$("mainForm")
					.attr("action",
							"${pageContext.request.contextPath}/student?method=DeleteAll");
			$("mainForm").submit();
		}
	}
</script>

</head>
<body>
	<%@include file="common/header.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-2">
				<div class="list-group">
					<a
						href="${pageContext.request.contextPath}/student?method=PageList"
						class="list-group-item active">学生管理</a> <a
						href="${pageContext.request.contextPath}/student?method=getSearchPage"
						class="list-group-item">学生搜索</a> <a
						href="${pageContext.request.contextPath}/student?method=getAddPage"
						class="list-group-item">添加学生</a>
				</div>
			</div>

			<!-- 右 -->
			<div class="col-md-10">
				<ul class="nav nav-tabs">
					<li class="active"><a
						href="${pageContext.request.contextPath}/student?method=PageList">学生列表</a>
					</li>
					<li><a
						href="${pageContext.request.contextPath}/student?method=getSearchPage">学生搜索</a>
					</li>
					<li><a
						href="${pageContext.request.contextPath}/student?method=getAddPage">添加学生</a>
					</li>
				</ul>

				<form id="mainForm"
					action="${pageContext.request.contextPath}/student?method=DeleteAll"
					method="post">
					<table
						class="align-center table table-striped table-bordered table-hover table-condensed text-center">
						<tr>
							<td colspan="9">所有学生信息</td>
						</tr>
						<tr>
							<td><input type="checkbox" id="selectAll"
								onClick="selectAlls();" /></td>
							<td>id</td>
							<td>学号</td>
							<td>姓名</td>
							<td>年龄</td>
							<td>性别</td>
							<td>家庭所在地</td>
							<td>修改</td>
							<td>删除</td>
						</tr>

						<c:forEach items="${pageBean.list }" var="student">
							<tr>
								<td><input type="checkbox" name="selectNames"
									value="${student.name }" /></td>
								<td>${student.id}</td>
								<td>${student.number}</td>
								<td>${student.name}</td>
								<td>${student.age}</td>
								<td>${student.gender}</td>
								<td>${student.address}</td>
								<td><a
									href="${pageContext.request.contextPath}/student?method=ToUpdateStudent&searchname=${student.name}">修改</a></td>
								<td><a
									href="${pageContext.request.contextPath}/student?method=DeleteByName&name=${student.name}">删除</a></td>
							</tr>
						</c:forEach>

					</table>
					<input type="submit" class="btn btn-danger" onClick="deleteAll();"
						value="批量删除" />
				</form>

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
							href="${pageContext.request.contextPath}/student?method=PageList&pageIndex=${pageBean.pageIndex-1}"
							aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
						</a></li>
					</c:if>
					<!-- 向前跳转结束 -->


					<c:forEach begin="1" end="${pageBean.totalPage }" var="page">

						<c:if test="${pageBean.pageIndex!=page}">
							<li><a
								href="${pageContext.request.contextPath}/student?method=PageList&pageIndex=${page}">${page}</a></li>
						</c:if>
						<c:if test="${pageBean.pageIndex==page}">
							<li class="active"><a
								href="${pageContext.request.contextPath}/student?method=PageList&pageIndex=${page}">${page}</a></li>
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
							href="${pageContext.request.contextPath}/student?method=PageList&pageIndex=${pageBean.pageIndex+1}"
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