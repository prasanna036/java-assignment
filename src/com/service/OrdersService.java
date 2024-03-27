package com.service;

import java.sql.SQLException;
import java.util.List;
import com.model.*;
import com.dao.*;
import com.model.Product;
import com.dao.*;
public class OrdersService {
	OrdersDao ordersDao=new OrdersDaoImpl();
	public List<Order> getOrderDetails() throws SQLException{
		return ordersDao.getOrderDetails();
	}
	public void updateOrder(int id, String order_date, int total_amount, int customer_id) throws SQLException {
		ordersDao.updateOrder(id,order_date, total_amount, customer_id);
		
	}
	public void cancelOrder(int id)throws SQLException{
		ordersDao.cancelOrder(id);
		
	}

}
