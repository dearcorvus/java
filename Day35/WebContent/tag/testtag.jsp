<%@page import="com.atguigu.javaweb.Customer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${requestScope.customers }" var="customer">
		--${customer.name },${customer.address }<br>
	</c:forEach>
	<%--

		List<Customer> customers = (List<Customer>) request.getAttribute("customers");
	
		if(customers != null){
			for(Customer customer:customers){
	%>
			<%=customer.getName() %>,<%=customer.getAddress() %><br>
			
	<%
			}
		}
	--%>
</body>
</html>