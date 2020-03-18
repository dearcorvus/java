package com.atguigu.javaweb;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ProcessStep1Servlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1 获取选中的图书信息
		
		String [] books = request.getParameterValues("book");

		//把图书信息存入session
		request.getSession().setAttribute("books", books);

		//2重定向页面到book/step-2.jsp
		System.out.print(request.getContextPath() + "/book/step-2.jsp");
		response.sendRedirect(request.getContextPath() + "/book/step-2.jsp");
		
	}

}
