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
	function refreshCode(){
		$("#codeImg").attr("src","/Java1707web/checkImg?"+Math.random());
	}
</script>
</head>
<body>

	<form action="/Java1707web/Login" method="post">
		用户名：<input type="text" name="name" /><br>
		密码：<input type="text" name="password" /><br>
		验证码：<input type="text" name="checkCode" />
		<img id="codeImg" src="/Java1707web/checkImg" onclick="refreshCode();"/>
		<input type="submit" value="登录" />
	</form>
</body>
</html>