<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 7.EL 关系运算符 -->

	${param.score > 60 ? "及格":"不及格" }

	<%
		List<String> names = new ArrayList<String>();
	
		request.setAttribute("names", names);
		names.add("123");
	
	%>
	<br>
	<!-- empty 可以作用于一个集合,若该集合不存在或集合中没有元素,其结果为true -->
	name is empty:
	${requestScope.names }
	${empty requestScope.names }
	<br>

	<!-- 6.其他隐含对象 : pageContext等(cookie,header,initParam) -->
	
	pageContext:pageContext即为pageContext类型,只要能读取属性就可以一直读下去
	<br>
	pageContext:${pageContext.request.contextPath }
	<br>
	session:${pageContext.session.id }
	<br>
	attributeNames:${pageContext.session.attributeNames }
	<br>
	Accept-Language:${header["Accept-Language"]} 
	<br>
	JSESSIONID:${cookie.JSESSIONID.name } -- ${cookie.JSESSION.value }

	<br>
	
	initParam : ${initParam.init }
	
</body>
</html>