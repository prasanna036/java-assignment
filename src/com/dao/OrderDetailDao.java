package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.OrderDetail;

public interface OrderDetailDao {

	int calculateSubTotal(int id) throws SQLException;

	List<OrderDetail> getOrderDetailsInfo() throws SQLException;

	void updateOrder(int id,int quantity, int orders_id, int product_id) throws SQLException;

}
