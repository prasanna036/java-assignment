package com.service;
import java.sql.SQLException;
import java.util.List;

import com.dao.*;
import com.model.OrderDetail;
public class OrderDetailService {
	OrderDetailDao orderdetail=new OrderDetailImpl();
	public int calculateSubTotal(int id) throws SQLException {
		return orderdetail.calculateSubTotal(id);
	}
	public List<OrderDetail> getOrderDetailsInfo() throws SQLException {
		return orderdetail.getOrderDetailsInfo();
	}
	public void updateOrder(int id,int quantity, int orders_id, int product_id) throws SQLException {
		orderdetail.updateOrder(id,quantity,orders_id,product_id);
		
	}

}
