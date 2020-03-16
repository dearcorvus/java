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
		//在JAVAWEB规范中使用Cookie类代表cookie
		//会话级别cookie关闭浏览器就消失了
		//1.创建一个Cookie对象
		//Cookie cookie = new Cookie("name","lijian");
		//2.调用response 的方法把cookie传给客户端
		//response.addCookie(cookie);
		//1.获取cookie 
		Cookie [] cookies = request.getCookies();
		
		if(cookies != null && cookies.length > 0){
			for(Cookie cookie : cookies ){
				//2.获取cookie的name和value
				out.println(cookie.getName() + ":" + cookie.getValue());
							
			}
		}else{
			out.print("没有cookie,正在创建并返回!");	
			//1.创建一个Cookie对象
			Cookie cookie = new Cookie("name","lijian");
			//setMaxAge设置cookie的最大持久化时效,以秒为单位    0为立即删除 负数为不存储  正数为该cookie的存储时间
			cookie.setMaxAge(30);
			//2.调用response 的方法把cookie传给客户端
			response.addCookie(cookie);		
			
		}
		
		
		
	%>
</body>
</html>