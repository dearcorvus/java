<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 向客户端浏览器写入一个Cookie: cookiePath,cookiePathValue -->
	<%
		Cookie cookie =new Cookie("cookiePath","CookiePathValue");
		//设置Cookie的作用范围	
		//cookie.setPath(request.getContextPath());
		
		response.addCookie(cookie);
		//Cookie的作用范围可以当作当前目录 和 当前目录的子目录但不可以 作用于当前目录的上一级目录
		//可以通过SETPath 方法设置Cookie的作用范围
	%>
	<a href = "../cookie2.jsp">To Read Cookie</a>
</body>
</html>