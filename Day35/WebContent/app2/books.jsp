<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>Books Page</h4>
	<a href="book.jsp?book=JavaWeb">Java Web</a>
	<a href="book.jsp?book=Java">Java</a>
	<a href="book.jsp?book=Oracle">Oracle</a>
	<a href="book.jsp?book=Ajax">Ajax</a>
	<a href="book.jsp?book=status">status</a>
	<a href="book.jsp?book=JavaScript">JavaScript</a>
	<a href="book.jsp?book=Spring">Spring</a>
	
	<br>
	
	<%
		//显示最近浏览的5本书
		Cookie [] cookies = request.getCookies();
		//获取Cookie
		//筛选出符合条件的
		//显示cookieValue
		if(cookies != null && cookies.length > 0){
			for(Cookie c: cookies){
				String cookieName = c.getName();
				
				if(cookieName.startsWith("ATGUIGU_BOOK_")){
					out.println(c.getValue());
					out.print("<br>");
				}
			}
		}
	
	
	
	%>
</body>
</html>