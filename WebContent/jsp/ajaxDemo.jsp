<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/lib/bootstrap/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	function fn1(){
		var xmlHttpRequest = new XMLHttpRequest();
		xmlHttpRequest.onreadystatechange = function(){
			if (xmlHttpRequest.readyState == 4 
					&& xmlHttpRequest.status == 200){
				var result = xmlHttpRequest.responseText;
				alert(result);
		}
		xmlHttpRequest.open("GET","${pageContext.request.contextPath}/ajax?name=zhangsan");
		xmlHttpRequest.send();
	}
	
</script>
</head>
<body>
	<input type="button" value="get方式访问服务器" onclick="fn1()"/><br/>
	<input type="button" value="post方式访问服务器" onclick="fn2()"/><br/>
	
</body>
</html>