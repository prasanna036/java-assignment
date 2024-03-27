package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.model.*;

public interface OrdersDao {

	public List<Order> getOrderDetails() throws SQLException;

	public void updateOrder(int id, String order_date, int total_amount, int customer_id) throws SQLException;

	public void cancelOrder(int id)throws SQLException;

}
