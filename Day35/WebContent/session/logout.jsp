<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	SessionID:	<%=session.getId() %>
	<br>
	IsNew: <%= session.isNew() %>
	<br>
	MaxInactiveInterval : <%=session.getMaxInactiveInterval() %>
	<br>
	CreateTime : <%= session.getCreationTime() %>
	<br>
	ListTime : <%=session.getLastAccessedTime() %>
	<br>
	Bye:<%= session.getAttribute("username") %>
	<br>
	<a href="login.jsp">重新登录</a>
	<%
		session.invalidate();
	
	%>
</body>
</html>