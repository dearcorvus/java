<%@page import="com.lijian.mvcapp.domain.Customer"%>
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
		Object msg = request.getAttribute("message");
		
		if(msg != null){
	%>
		<br>
		<font color="red"><%= msg %></font>
		<br>
		<br>
	<%
		}
		
		Customer customer = (Customer)request.getAttribute("customer");
	%>
	
	<form action="update.do" method="post">
		<table>
			<tr>
				<td>CustomerName:</td>
				<td><input type="text" name="name" value="<%= customer.getName() %>"></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><input type="text" name="address"  value="<%= customer.getAddress() %>"></td>
			</tr>
			<tr>
				<td>Phone:</td>
				<td><input type="text" name="phone" value="<%= customer.getPhone() %>"></td>
			</tr>
			<tr>
				<td colspan="2" ><input type="submit" value="submit" /></td>
			</tr>
		</table>
		</form>
</body>
</html>