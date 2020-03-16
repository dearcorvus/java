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
		//1.获取name
		
		String name = request.getParameter("name");
		
		if(name != null && name.trim().equals("")){
			out.print("Hello:"+name);
			
			Cookie cookie = new Cookie("name",name);
			
			cookie.setMaxAge(30);
			
			response.addCookie(cookie);
		}else{
			Cookie [] cookies = request.getCookies();
			if(cookies != null && cookies.length > 0){
				
				for(Cookie cookie : cookies){
					
					String cookieName = cookie.getName();
					
					if("name".equals(cookieName)){
						String val = cookie.getValue();
						name = val;
						
					}
										
				}			
				
			}
		}
	
		if(name != null && !name.trim().equals("")){
			out.print("Hello:" + name);
		}else{
			//若没有参数,也没有cookie返回login.jsp
			//response.sendRedirect("login.jsp");
		}
	
	%>
</body>
</html>