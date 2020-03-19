<%@page import="java.util.Date"%>
<%@page import="com.atguigu.javaweb.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 5.与输入有关的隐含对象：param，paramValue -->
	score : ${param.score}
	<br>
	score : <%=request.getParameter("score") %>
	<br>
	names:${paramValues.name[0]["class"]["name"]}
	<br>
	<%= request.getParameterValues("name")[0].getClass().getName()%>
	
	
	<br>
	<!-- 4.隐含对象与范围相关：pageScope，requestScope，sessionScop，applicationScope -->
	time: ${applicationScope.time.time}
	time: ${time}
	<br>
	<!-- 3.el 可以自动进行类型转化 -->
	score : ${param.score + 11 }
	<br>
	score: <%=request.getParameter("score") + 11 %>
	<!-- 2.EL 中的隐含对象 -->
	<%
		Customer customer2 = new Customer();
	
		customer2.setAddress("123");
		request.setAttribute("customer", customer2);
	%>

	age : ${customer.address } 
	<br>
	age : ${sessionScope.customer.address } 
	<!-- 1.EL的。或【】运算符 -->
	<%
		//Customer customers =(Customer)session.getAttribute("customer");
	
		//out.print(customers.getAddress());
		
		Customer customer = new Customer();
		customer.setName("ATGUIGU");
		session.setAttribute("com.at", customer);
		
	%>
	name : ${sessionScope["com.at"].name}
	<%
		application.setAttribute("time", new Date());
	%>
</body>
</html>