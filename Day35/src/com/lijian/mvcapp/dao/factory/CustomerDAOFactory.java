package com.lijian.mvcapp.dao.factory;

import java.util.HashMap;
import java.util.Map;

import com.lijian.mvcapp.dao.CustomerDAO;
import com.lijian.mvcapp.dao.impl.CustomerDAOJdbclmpl;
import com.lijian.mvcapp.dao.impl.CustomerDAOXMLImpl;

public class CustomerDAOFactory {
	
	private Map<String, CustomerDAO> daos = new HashMap<String,CustomerDAO>();
		
	private CustomerDAOFactory() {
		daos.put("jdbc", new CustomerDAOJdbclmpl());
		daos.put("xml",new CustomerDAOXMLImpl());
	}
	
	private static CustomerDAOFactory instance = new CustomerDAOFactory();
	
	public static CustomerDAOFactory getInstance() {
		
		return instance;
		
	}
	
	private String type = null;
	
	public void setType(String type) {
		this.type = type;
	}
	public CustomerDAO getCustomerDAO() {
		
		return daos.get(type);
		
	}
	
	
}
