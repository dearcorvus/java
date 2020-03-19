<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="Iutf-8">
<title>Insert title here</title>
</head>
<body>
	<h4>BBB Page</h4>
	
	<br>
cities:<%= request.getAttribute("cities") %>
<br>
<a href="c.jsp">To C Page</a>
</body>
</html>