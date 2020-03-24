<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${requestScope.message != null }">
		<br>
		<font color="red">${requestScope.message }</font>
		<br>
		<br>
	</c:if>
	
	<form action="addCustomer.do" method="post">
		<table>
			<tr>
				<td>CustomerName:</td>
				<td><input type="text" name="name" value="${requestScope.name }"></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><input type="text" name="address"  value="${requestScope.address }"></td>
			</tr>
			<tr>
				<td>Phone:</td>
				<td><input type="text" name="phone" value="${requestScope.phone }"></td>
			</tr>
			<tr>
				<td colspan="2" ><input type="submit" value="submit" /></td>
			</tr>
		</table>
		</form>
</body>
</html>