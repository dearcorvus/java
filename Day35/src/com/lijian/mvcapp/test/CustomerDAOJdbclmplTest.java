package com.lijian.mvcapp.test;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.lijian.mvcapp.dao.CriteriaCustomer;
import com.lijian.mvcapp.dao.CustomerDAO;
import com.lijian.mvcapp.dao.impl.CustomerDAOJdbclmpl;
import com.lijian.mvcapp.domain.Customer;

class CustomerDAOJdbclmplTest {

	private CustomerDAO customerDAO = 
			new CustomerDAOJdbclmpl();
	@Test
	void testGetForListWithCriteriaCustomer() {
		CriteriaCustomer cc = new CriteriaCustomer("l", null, null);
		List<Customer> customers =customerDAO.getForListWithCriteriaCustomer(cc);
		
		System.out.println(customers);
	}
	
	@Test
	void testGetAll() {
		List<Customer> customers = customerDAO.getAll();
		System.out.println(customers);
	}

	@Test
	void testSave() {
		Customer coustomer = new Customer();
		coustomer.setAddress("Guangzhou");
		coustomer.setName("Leehua");
		coustomer.setPhone("15383412866");
		
		customerDAO.save(coustomer);
	}

	@Test
	void testGetInteger() {
		Customer cust = customerDAO.get(1);
		System.out.println(cust);
	}

	@Test
	void testDelete() {
		customerDAO.delete(1);
	
	}

	@Test
	void testGetCountWithName() {
		long count = customerDAO.getCountWithName("Jerry");
		
		System.out.println(count);
	
	}

}
