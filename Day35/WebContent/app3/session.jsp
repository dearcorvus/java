<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//并不是关闭浏览器就销毁了session
	
		HttpSession session = request.getSession(true);
	
		out.print(session.getId());
		//设置过期时间
		session.setMaxInactiveInterval(5);

		
		//销毁session
		//session.invalidate();
	%>
</body>
</html>