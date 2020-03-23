<%@page import="com.atlijian.javaweb.Customer"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>c:out</h4>
	
	<%
		request.setAttribute("name", "<<java>>");
	%>
	${requestScope.name}
	<br>
	<c:out value="${requestScope.name}" ></c:out>
		<br>
	<c:out value="${requestScope.name}" escapeXml="false" ></c:out>
	<br>
	<!-- 页面输出 -->
	<c:out value="${param.name}"></c:out><br>
	
	<h4>c:set</h4>
	<!-- 修改数据 -->
	<c:set var="name" value="lijian" scope="session"></c:set>
	<c:out value="${sessionScope.name }"></c:out>
	<br>
	<c:set var="name" value="${param.name }" scope="session"></c:set>
	<c:out value="${sessionScope.name }"></c:out>
	<br>
	<h4>remove</h4>
	<c:set var="date" value="1991" scope="session"></c:set>
	<c:out value="${sessionScope.date }"></c:out>
	<c:remove var="date" scope="session"/>
	<c:out value="${sessionScope.date }"></c:out>
	<h4>if</h4>
	<!-- 没有else -->
	<c:set var="age" value="20" scope="request"></c:set>
	<c:if test="${requestScope.age > 18 }">成年了</c:if>
	
	<c:if test="${requestScope.age > 19 }" var="isAge" scope="request"></c:if>
	
	<c:out value="${requestScope.isAge }"></c:out>
	<br>
	<h4>choose when otherwise :可以实现if else</h4>
	<br>
	<c:choose>
		<c:when test="${param.age > 40 }">老年人</c:when>
		<c:when test="${param.age > 20 }">成年人</c:when>
		<c:otherwise>儿童</c:otherwise>		
	</c:choose>
	<br>
	<h4>c:forEach 可以对数组，collection集合Map进行遍历: items var begin end step begin 是从0开始的   varStatus 属性 index , count ,first,last</h4>
	
	<c:forEach begin="1" end="10" step="3" var="i">
		${i }	
	</c:forEach>
	
	<br>
	
	<%
		List<Customer> customers = new ArrayList<Customer>();
	
		customers.add(new Customer(1,"A")); //index 0
		customers.add(new Customer(2,"B"));//index 1
		customers.add(new Customer(3,"C"));
		customers.add(new Customer(4,"D"));
		
		request.setAttribute("customers", customers);
	
	%>
	<!-- 遍历数组，collection -->
	<c:forEach  items="${requestScope.customers }" var="items" begin="1" varStatus="status">
		<br>
		${status.index }--${status.count }--${status.first }--${status.last }--${items.id }--${items.name }
	</c:forEach>
	
	
	<%

		Map<String,Customer> customersMap = new HashMap<String,Customer>();
	
	customersMap.put("a",new Customer(1,"A")); //index 0
	customersMap.put("b",new Customer(2,"B"));//index 1
	customersMap.put("c",new Customer(3,"C"));
	customersMap.put("d",new Customer(4,"D"));
		
		request.setAttribute("customersMap", customersMap);
	
	%>
	<br>	
	
	<c:forEach items="${requestScope.customersMap }" var="cust">
		${cust.key } - ${cust.value }--${cust.value.id }--${cust.value.name }<br>
	</c:forEach>
	
	<br>
	<%
	
		String [] names = new String[]{"AA","BB","CC"};
		request.setAttribute("names",names);
	%>
	<br>
	<c:forEach var="name" items="${names }">
	
		${name }--<br>
	
	</c:forEach>
	
	<br>
	
	<c:forEach items="${pageContext.session.attributeNames }" var="attrName">${attrName }</c:forEach>
	
	<h4>c:forTokens:处理字符窜，类似String的split()方法</h4>
	<c:set value="a,b,c,d.e.f.j" var="test" scope="request"></c:set>
	<c:forTokens items="${requestScope.test }" delims="." var="s">
		${s }--<br>
	</c:forTokens>
	<h4>c:import 可以包含任何页面到当前页面</h4>
	
	<c:import url="http://www.baidu.com"></c:import>
	<h4>redirect是当前页面重定向到指定页面</h4>
	
	<%--<c:redirect url="el.jsp"></c:redirect> --%>
	<h4>forward是当前页面转发到指定页面</h4>
	<%-- <jsp:forward page="/el.jsp"></jsp:forward> --%>
	<!-- /代表当前WEB应用的更目录  -->
	<!-- response.sendRedirect() 代表WEB站点的根目录 -->
	
	
	<!-- 给服务器解析当前应用的根目录 给浏览器解析是指站点的根目录 -->
	<h4>
		c:url 产生一个url地址 可以Cookie 是否可以来智能的重写url,对get请求的参数进行编码
		可以把产生的URL存储在域对象的属性中
		还可以使用c:param为url添加参数 c:url会对参数进行自动转码
		value的/代表当前WEB应用的根目录
	</h4>

	<c:url value="el.jsp" var="testurl" scope="page">
		<c:param name="name" value="尚硅谷"></c:param>
	</c:url>
	
	url:${testurl}
</body>
</html>