package com.lijian.mvcapp.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lijian.mvcapp.dao.CriteriaCustomer;
import com.lijian.mvcapp.dao.CustomerDAO;
import com.lijian.mvcapp.dao.impl.CustomerDAOXMLImpl;
import com.lijian.mvcapp.domain.Customer;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/customerServlet")
public class CustomerServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
//	private CustomerDAO customerDAO = new CustomerDAOJdbclmpl();
	private CustomerDAO customerDAO = new CustomerDAOXMLImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	//	url
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String method = request.getParameter("method");
//		
//		switch(method) {
//			case "add" : add(request,response);break;
//			case "query" : query(request,response);break;
//			case "delete" : delete(request,response);break;
//		}
//	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String servletPath =  req.getServletPath();
		String methodName = servletPath.substring(1);
		methodName = methodName.substring(0, methodName.length() - 3);

		try {
			Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			
			method.invoke(this,req,resp);
		} catch (Exception e) {
//			e.printStackTrace();
			resp.sendRedirect("error.jsp");
		}
	}
	
	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forwardPath = "/error.jsp";
		
		//1.��ȡ������� �� id �� name�� address��phone��oldName
		String idStr = request.getParameter("id");
		int id = -1;
		
		System.out.print(idStr);
		//���name�Ƿ�ռ�ã��ȱȽ�name �� oldName�Ƿ���ͬ ������ͬ˵��name����
		//����CustomerDAO��getCountWithName(String name) ��ȡname�����ݿ����Ƿ����
		try {
			//2.����CustomerDAO��customerDAO.get(id);��ȡ��customer��Ӧ�Ķ���customer
			Customer customer = customerDAO.get(Integer.parseInt(idStr));
			
			if(customer != null) {
				forwardPath = "updatecustomer.jsp";
				//3.��customer ����request��
				request.setAttribute("customer", customer);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		//4.��Ӧupdatecustomer��jsp ҳ�棺ת��
		
		request.getRequestDispatcher(forwardPath).forward(request, response);
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//1.��ȡ������� �� id �� name�� address��phone��oldName
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String oldName = request.getParameter("oldName");


//		if(!oldName.equals(name)) {
		if(!oldName.equalsIgnoreCase(name)) {
			
			long count = customerDAO.getCountWithName(name);
			
			if(count > 0) {
				
				request.setAttribute("message", "�û���"+name+"�Ѿ���ռ�ã�");
				
				request.getRequestDispatcher("/updatecustomer.jsp").forward(request, response);
				return;
			}
			
		}
		
		Customer customer = new Customer(name, address, phone);
			
		customer.setId(Integer.parseInt(id));
		
			
		customerDAO.update(customer);
		
		response.sendRedirect("query.do");
		//4.��Ӧupdatecustomer��jsp ҳ�棺ת��
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		int id = 0;
		//try ... catch �����÷�ֹidStr ����תΪ int ����
		//�������תID����0���޷������κεĲ���
		try {
			id = Integer.parseInt(idStr);
			customerDAO.delete(id);
			
		} catch (Exception e) {}
		
		response.sendRedirect("query.do");
	}

	private void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡģ����ѯ���������
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		
		//�����������װΪһ��CriteriaCustomer����
		CriteriaCustomer cc = new CriteriaCustomer(name, address, phone);
		
		
		
		//1.����CustomerDAO��getAll() �õ�Customer�ļ��� (����DAO �� getForListWithCriteriaCustomer)
		
//		List<Customer> customers = customerDAO.getAll();
		
		List<Customer> customers = customerDAO.getForListWithCriteriaCustomer(cc);
		//2.��Customer���Ϸ���request��
		
		request.setAttribute("customers", customers);
		
		//3��ת��ҳ�浽index��jsp(����ʹ���ض���)
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	private void addCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1�� ��ȡ��������name,address,phone
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
			//����name�Ƿ�Ϊռ��  getCountWithName(String name)��ȡname�����ݿ����Ƿ����
		
		long count = customerDAO.getCountWithName(name);
			//������ֵ����0���򷵻�newcustomer.jspҳ��:
			//ͨ��ת���ķ�ʽ����Ӧnewcustomer��jsp��Ӧ
		if(count > 0) {
			//Ҫ��newcustomer��jspҳ��name�Ƿ�ռ��������ѡ��
			//��request �з���һ������message:�û���name�Ѿ���ռ�ã�������ѡ����ҳ����ͨ��request��getAttribute('message')�ķ�ʽ��ʾ
			request.setAttribute("message", "�û���" + name + "�Ѿ���ռ�ã�������ѡ��");
			//newcustomer��jsp�ı�ֵ���Ի���
			// value="<%= request.getParameter("name") == null ? "" : request.getParameter("name") %>"
			//��ʵ�ֻ���
			//���� �� return
			request.getRequestDispatcher("newcustomer.jsp").forward(request, response);
			return;
		}
		
		
		//2������֤ͨ������У� ����������װΪһ��Customer ���� customer
		Customer customer = new Customer(name,address,phone);
			
		//3������CustomerDAO ��save��Customer custoemr��ִ�б������
		customerDAO.save(customer);
		//4���ض���SUCCESS��jspҳ��:ʹ���ض�����Ա�������ظ��ύ����
		
//		request.getRequestDispatcher("/newcustomer.jsp").forward(request, response);
		response.sendRedirect("success.jsp");
	}
		

}
