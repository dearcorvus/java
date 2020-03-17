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
	<%
		Object username = session.getAttribute("username");
		if(username == null){
			username = "";
		}
	
	%>
	<form action="<%=response.encodeURL("hello.jsp") %>" method="post">
	
		username : <input type="text" name="username" value="<%=username %>"/>

		<input type="submit" value="Submit"/>
	</form>
</body>
</html>