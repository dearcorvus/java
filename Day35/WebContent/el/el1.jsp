<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%= request.getContextPath()%>/el/el1.jsp">
		user:<input type="text" name="username"/>
		<input type="submit" value="Submit"/>
	</form>

	<%
	
		String name = request.getParameter("username");
	
		System.out.println(name);
	
	%>
	<jsp:useBean id="customer" class="com.atguigu.javaweb.Customer" scope="session"></jsp:useBean>
	<jsp:setProperty property="address" value="12" name="customer" ></jsp:setProperty>
	age : <jsp:getProperty property="address" name="customer"/>
	<a href="<%= request.getContextPath()%>/el/el2.jsp">el2</a>
	<a href="el2.jsp?score=123&name=A&name=B&name=C">el2</a>
</body>
</html>