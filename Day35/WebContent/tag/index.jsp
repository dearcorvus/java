<%@page import="com.atguigu.javaweb.Customer"%>
<%@page import="java.util.*"%>
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
	
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(new Customer("lijian","beijing","18636151606","12"));
		customers.add(new Customer("lijian1","beijing1","18636151606","12"));
		customers.add(new Customer("lijian2","beijing2","18636151606","12"));
		customers.add(new Customer("lijian3","beijing3","18636151606","12"));
		request.setAttribute("customers", customers);
	%>
	<jsp:forward page="testtag.jsp"></jsp:forward>
	<a href="testtag.jsp">to tag</a>
</body>
</html>