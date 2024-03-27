package com.dao;

import java.util.List;
import java.sql.SQLException;
import com.service.*;
import com.exception.CustomerNotFoundException;
import com.model.*;

public interface CustomerDao {

	public List<Customer> getCustomerDetails() throws SQLException;

	public void updateCustomer(int id,String email, String phone, String address) throws SQLException;

	

	public List<Order> calculateTotalOrders(int id) throws SQLException;

	public Customer validateCustomer(int id) throws SQLException,CustomerNotFoundException;
		
	

}
