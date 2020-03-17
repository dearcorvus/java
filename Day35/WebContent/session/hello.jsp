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
	Hello:<%= request.getParameter("username") %>
	<%
	
		session.setAttribute("username", request.getParameter("username"));
	
	%>
	<br>
	<a href="<%=response.encodeURL("login.jsp") %>">重新登录</a>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="<%=response.encodeURL("logout.jsp") %>">注销</a>
</body>
</html>
