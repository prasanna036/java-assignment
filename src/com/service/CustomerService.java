package com.service;
import java.sql.SQLException;
import java.util.List;
import com.model.*;
import com.dao.*;
import com.model.Customer;
import com.exception.*;
import com.util.*;
public class CustomerService {

	CustomerDao customerDao=new CustomerDaoImpl();

	public List<Customer> getCustomerDetails() throws SQLException{
		
		return customerDao.getCustomerDetails();
	}


	public void updateCustomer(int id,String email, String phone, String address) throws SQLException {
		
		customerDao.updateCustomer(id,email,phone,address);
		
	}

	
	public List<Order> calculateTotalOrders(int id) throws SQLException {
		return customerDao.calculateTotalOrders(id);
		
	}


	public Customer validateCustomer(int id) throws SQLException, CustomerNotFoundException {
		return customerDao.validateCustomer(id);
	}
}
