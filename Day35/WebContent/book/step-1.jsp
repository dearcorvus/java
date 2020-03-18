<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>选项要购买的图书</h4>
	
	<form action="<%=request.getContextPath() %>/processStep1" method="post">
		<table border="1" "10" cellspacing = "0">
			<tr>
				<th>书名</th>
				<th>购买</th>
			</tr>		
			<tr>
				<td>Java</td>
				<td><input type="checkbox" name="book" value="Java"/></td>
			</tr>
			<tr>
				<td>Oracle</td>
				<td><input type="checkbox" name="book" value="Oracle"/></td>
			</tr>
			<tr>
				<td>Struts</td>
				<td><input type="checkbox" name="book" value="Struts"/></td>
			</tr>
			<tr>
				<td>JavaCC</td>
				<td><input type="checkbox" name="book" value="JavaCC"/></td>
			</tr>
			<tr>
				<td>C++</td>
				<td><input type="checkbox" name="book" value="C++"/></td>
			</tr>
			<tr>
				<td colspan="2" ><input type="submit"  value="Submit"/></td>
			</tr>			
		</table>
	</form>
</body>
</html>