<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Object user = session.getAttribute("username");
	
		if(user == null){
			response.sendRedirect("user.jsp");	
		}
	
	%>
	<h4>BB</h4>
	<a href="login.jsp">to login</a>
</body>
</html>