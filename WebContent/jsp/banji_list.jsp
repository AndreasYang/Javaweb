<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="student.pojo.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>班级管理</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/lib/bootstrap/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	function selectAlls() {
		$("input[name=selectClassnames]").prop("checked",
				$("#selectAll").is(":checked"));
	};
	function deleteAll() {
		var isDel = confirm("是否要删除？");
		if (isDel) {
			$("mainForm")
					.attr("action",
							"${pageContext.request.contextPath}/student?method=DeleteAllBanji");
			$("mainForm").submit();
		}
	}
</script>
</head>
<body>
	<%@include file="common/banjiheader.jsp"%>

	<div class="container">
		<div class="row">
			<div class="col-md-2">
				<div class="list-group">
					<a href="${pageContext.request.contextPath}/student?method=BanjiList"
						class="list-group-item active">班級列表</a> 
					<a href="${pageContext.request.contextPath}/student?method=getAddBanjiPage"
						class="list-group-item">添加班級</a>
				</div>
			</div>

			<!-- 右 -->
			<div class="col-md-10">
				<ul class="nav nav-tabs">
					<li class="active"><a
						href="${pageContext.request.contextPath}/student?method=BanjiList">班級列表</a>
					</li>
					<li><a
						href="${pageContext.request.contextPath}/student?method=getAddBanjiPage">添加班级</a>
					</li>
				</ul>

				<form id="mainForm"
					action="${pageContext.request.contextPath}/student?method=DeleteAllBanji"
					method="post">
					<table class="align-center table table-striped table-bordered table-hover table-condensed text-center">
						<tr>
							<td><input type="checkbox" id="selectAll"
								onClick="selectAlls();" /></td>
							<td>班级</td>
							<td>删除</td>
						</tr>

						<c:forEach items="${list}" var="banji">
							<tr>
								<td><input type="checkbox" name="selectClassnames"
									value="${banji.classname}" /></td>
								<td>${banji.classname}</td>
								<td><a
									href="${pageContext.request.contextPath}/student?method=DeleteBanjie&name=${banji.classname}">删除</a></td>
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