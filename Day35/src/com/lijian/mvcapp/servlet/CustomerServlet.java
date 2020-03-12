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
		
		//1.获取请求参数 ： id ， name， address，phone，oldName
		String idStr = request.getParameter("id");
		int id = -1;
		
		System.out.print(idStr);
		//检查name是否被占用：先比较name 和 oldName是否相同 若不相同说明name可用
		//调用CustomerDAO的getCountWithName(String name) 获取name在数据库中是否存在
		try {
			//2.调用CustomerDAO的customerDAO.get(id);获取和customer对应的对象customer
			Customer customer = customerDAO.get(Integer.parseInt(idStr));
			
			if(customer != null) {
				forwardPath = "updatecustomer.jsp";
				//3.将customer 放入request中
				request.setAttribute("customer", customer);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		//4.响应updatecustomer。jsp 页面：转发
		
		request.getRequestDispatcher(forwardPath).forward(request, response);
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//1.获取请求参数 ： id ， name， address，phone，oldName
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String oldName = request.getParameter("oldName");


//		if(!oldName.equals(name)) {
		if(!oldName.equalsIgnoreCase(name)) {
			
			long count = customerDAO.getCountWithName(name);
			
			if(count > 0) {
				
				request.setAttribute("message", "用户名"+name+"已经被占用！");
				
				request.getRequestDispatcher("/updatecustomer.jsp").forward(request, response);
				return;
			}
			
		}
		
		Customer customer = new Customer(name, address, phone);
			
		customer.setId(Integer.parseInt(id));
		
			
		customerDAO.update(customer);
		
		response.sendRedirect("query.do");
		//4.响应updatecustomer。jsp 页面：转发
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStr = request.getParameter("id");
		int id = 0;
		//try ... catch 的作用防止idStr 不能转为 int 类型
		//如果不能转ID等于0，无法进行任何的操作
		try {
			id = Integer.parseInt(idStr);
			customerDAO.delete(id);
			
		} catch (Exception e) {}
		
		response.sendRedirect("query.do");
	}

	private void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取模糊查询的请求参数
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		
		//把请求参数分装为一个CriteriaCustomer对象
		CriteriaCustomer cc = new CriteriaCustomer(name, address, phone);
		
		
		
		//1.调用CustomerDAO的getAll() 得到Customer的集合 (调用DAO 的 getForListWithCriteriaCustomer)
		
//		List<Customer> customers = customerDAO.getAll();
		
		List<Customer> customers = customerDAO.getForListWithCriteriaCustomer(cc);
		//2.把Customer集合放入request中
		
		request.setAttribute("customers", customers);
		
		//3、转发页面到index。jsp(不能使用重定向)
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	private void addCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1、 获取表单参数：name,address,phone
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
			//检验name是否为占用  getCountWithName(String name)获取name在数据库中是否存在
		
		long count = customerDAO.getCountWithName(name);
			//若返回值大于0，则返回newcustomer.jsp页面:
			//通过转发的方式来响应newcustomer。jsp响应
		if(count > 0) {
			//要求newcustomer。jsp页面name是否被占用请重新选择
			//在request 中放入一个属性message:用户名name已经被占用，请重新选择！在页面上通过request。getAttribute('message')的方式显示
			request.setAttribute("message", "用户名" + name + "已经被占用，请重新选择！");
			//newcustomer。jsp的表单值可以回显
			// value="<%= request.getParameter("name") == null ? "" : request.getParameter("name") %>"
			//来实现回显
			//结束 ： return
			request.getRequestDispatcher("newcustomer.jsp").forward(request, response);
			return;
		}
		
		
		//2、若验证通过则进行， 报表单参数封装为一个Customer 对象 customer
		Customer customer = new Customer(name,address,phone);
			
		//3、调用CustomerDAO 的save（Customer custoemr）执行保存操作
		customerDAO.save(customer);
		//4、重定向到SUCCESS。jsp页面:使用重定向可以避免表单的重复提交问题
		
//		request.getRequestDispatcher("/newcustomer.jsp").forward(request, response);
		response.sendRedirect("success.jsp");
	}
		

}
