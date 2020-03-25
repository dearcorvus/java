<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
	//编写一个EncodingFilter,1.读取web.xml文件中配置的web应用的初始化参数encoding
	//指定请求的字符编码为获取到的
	//调用chain.doFilter()方法放行请求
		request.setCharacterEncoding("UTF-8");
	--%>
	hello:${param.username }
</body>
</html>