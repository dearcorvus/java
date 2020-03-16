<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>Book Detail Page</h4>
	Book:<%= request.getParameter("book") %>
	<br>
	<br>
	<a href = "books.jsp">Return</a>
	
	<%
		String book = request.getParameter("book");
		//把书的信息以Cookie方式传送回给浏览器，删除一个Cookie
		
		//1.确定要删除的Cookie是哪一个
		Cookie [] cookies = request.getCookies();
		//保存所有的ATGUIGU_BOOK_开头的Cookie
		List<Cookie> bookCookies = new ArrayList<Cookie>();
		//用来保存和books.jsp传入的book 匹配的那个Cookie 
		Cookie tempCookie = null;
		
		if(cookies != null && cookies.length > 0){
			for(Cookie c:cookies){
				String cookieName = c.getName();
				
				if(cookieName.startsWith("ATGUIGU_BOOK_")){
					bookCookies.add(c);
					
					if(c.getValue().equals(book)){
						tempCookie = c;
					}
				}
			}
		}
		
		if(bookCookies.size() >= 5 && tempCookie == null){
			tempCookie = bookCookies.get(0);
			
		}
		
		if(tempCookie != null){
			tempCookie.setMaxAge(0);
			response.addCookie(tempCookie);
		}
		
		//2.把books.jsp传入book作为一个Cookie返回
		
		Cookie cookie =new Cookie("ATGUIGU_BOOK_"+book,book);
		
		response.addCookie(cookie);
	
	%>
</body>
</html>