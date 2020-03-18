package com.atguigu.javaweb;

import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class ProcessStep2Servlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1����ȡ������ name ��address ��cardType , card
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String cardType = request.getParameter("cardType");
		String card = request.getParameter("card");
		
		Customer customer = new Customer(name, address, cardType, card);
		//2. ��������Ϣ����HttpSession ��
		HttpSession session = request.getSession();	
		session.setAttribute("customer", customer);
		//3. �ض���ҳ��confirm��jsp
		
		response.sendRedirect(request.getContextPath()+"/book/confirm.jsp");
	}

}
