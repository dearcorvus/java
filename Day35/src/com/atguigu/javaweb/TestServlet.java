package com.atguigu.javaweb;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;     

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<String> citeis = Arrays.asList("北京","上海","广州");
	
		request.setAttribute("cities", citeis);
		
		request.getRequestDispatcher("/path/b.jsp").forward(request, response);
		
	}


}
