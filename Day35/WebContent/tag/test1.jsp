<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.atlijian.javaweb.Customer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="atguigu" uri="http://www.atguigu.com/mytags/core" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<atguigu:testJspFragment>HelloWorld</atguigu:testJspFragment>
	
	<atguigu:testJspFragment>${param.name}</atguigu:testJspFragment>
	
	hello:<%= request.getParameter("name") %>
	
	<br>
	
	<atguigu:printUpper time="10">asd</atguigu:printUpper>
	
	<br>
	<%
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(new Customer(1,"AAA"));
		customers.add(new Customer(2,"BBB"));
		customers.add(new Customer(3,"CCC"));
		customers.add(new Customer(4,"DDD"));
		request.setAttribute("customers", customers);

		Map<String,Customer> customerMap = new HashMap<String,Customer>();
		
		customerMap.put("a",customers.get(0));
		customerMap.put("b",customers.get(1));
		customerMap.put("c",customers.get(2));
		customerMap.put("d",customers.get(3));

		
		request.setAttribute("customerMap", customerMap);
	%>
	
	<c:forEach items="${customerMap }" var="cust">
		--${pageScope.cust.key } -- ${cust.value.id } -- ${cust.value.name}<br>
	</c:forEach>
	
	<c:forEach items="${requestScope.customers }" var="cust">
		${cust.id }--${cust.name }--<br>
	</c:forEach>
	
	<atguigu:forEach items="${requestScope.customers }" var="cust">
		${cust.id }--${cust.name }--<br>
	</atguigu:forEach>
	<br>
	
	
	
	<!-- 父标签打印name到控制台 -->
	<atguigu:parentTag>
		<!-- 子标签以父标签的标签体纯在。子标签吧父标签的name属性打印到JSP页面上 -->
		<atguigu:sonTag/>
	</atguigu:parentTag>
	
	<br>
	<c:choose>
		<c:when test="${param.age > 24}">大学毕业</c:when>
		<c:when test="${param.age > 20}">高中毕业</c:when>
		<c:otherwise>高中以下。。。</c:otherwise>
	</c:choose>
	
	<br>
	
	<atguigu:choose>
		<atguigu:when test="${param.age > 24}">大学毕业</atguigu:when>
		<atguigu:when test="${param.age > 20}">高中毕业</atguigu:when>
		<atguigu:otherwise>高中以下。。。</atguigu:otherwise>
	</atguigu:choose>
	
</body>
</html>