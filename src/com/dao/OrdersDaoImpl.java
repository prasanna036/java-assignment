package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.service.*;
import com.controller.*;
import com.model.*;
import com.exception.*;
import com.util.DBUtil;

import com.model.*;
public class OrdersDaoImpl implements OrdersDao {

	@Override
	public List<Order> getOrderDetails() throws SQLException {
		Connection conn = DBUtil.getDBConn();
		List<Order> list = new ArrayList<>();
		String sql = "select * from orders";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		while (rst.next()) {
			int id=rst.getInt("id");
			String order_date = rst.getString("order_date");
			int total_amount=rst.getInt("total_amount");
			int customer_id = rst.getInt("customer_id");
			
			Order o=new Order();
			o.setId(id);
			o.setOrder_date(order_date);
			o.setTotal_amount(total_amount);
			o.setCustomer_id(customer_id);
			list.add(o);
		}
		DBUtil.dbClose();
		return list;
	}

	@Override
	public void updateOrder(int id, String order_date, int total_amount, int customer_id) throws SQLException{
		Connection conn=DBUtil.getDBConn();
		
		String sql="update orders set order_date = ?,total_amount =?,customer_id=? where id =?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		
		pstmt.setString(1, order_date);
		pstmt.setInt(2, total_amount);
		pstmt.setInt(3, customer_id);
		pstmt.setInt(4, id);
		pstmt.executeUpdate();
		DBUtil.dbClose();
		
	}

	@Override
	public void cancelOrder(int id) throws SQLException {
		Connection conn=DBUtil.getDBConn();
		
		String sql="DELETE FROM orders where id=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		
		pstmt.setInt(1,id);
		pstmt.executeUpdate();
		DBUtil.dbClose();
	}

	
	
}
