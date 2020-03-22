<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 导入标签库 （描述文件）-->
    <%@taglib uri="http://www.atguigu.com/mytag/core" prefix="atguigu" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<atguigu:readerFile src="/WEB-INF/note.txt"/>	
<br>
	<atguigu:max num2="${param.a }" num1="${param.b }"/>
	<br>
	<atguigu:hello value="${param.name }" count="10"/>
</body>
</html>