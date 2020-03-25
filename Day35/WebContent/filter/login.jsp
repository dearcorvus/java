<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<font color="red">${message }</font>
	
	<br><br>

	<form action="hello.jsp" method="post">
		
		username:<input type="text" name="username" value="${param.username }"/>
		
		passworld:<input type="passworld" name="passworld"/>

		<input type="submit" value="Submit"/>		
	</form>
</body>
</html>