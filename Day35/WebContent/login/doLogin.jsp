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
	
		//1.获取登录信息
		
		String username = request.getParameter("username");
	
		if(username != null && !username.trim().equals("")){
			session.setAttribute("username", username);
			response.sendRedirect("login.jsp");
		}else{
			response.sendRedirect("user.jsp");
		}
		
	
	%>
</body>
</html>