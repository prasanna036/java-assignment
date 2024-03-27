package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.exception.*;
import com.model.*;
import com.service.*;
import com.util.DBUtil;

public class OrderDetailImpl implements OrderDetailDao {

	@Override
	public int calculateSubTotal(int id) throws SQLException {
		Connection conn=DBUtil.getDBConn();
		
		String sql="SELECT SUM(o.total_amount) AS amount FROM orders o WHERE o.customer_id = ?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		int idd=0;
		ResultSet rst=pstmt.executeQuery();
		if(rst.next()) {
			idd=rst.getInt("amount");
		}
		
		DBUtil.dbClose();
		return idd;
		
	}

	@Override
	public List<OrderDetail> getOrderDetailsInfo() throws SQLException {
		Connection conn = DBUtil.getDBConn();
		List<OrderDetail> list = new ArrayList<>();
		String sql = "select * from order_details";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		while (rst.next()) {
			int id=rst.getInt("id");
			int quantity = rst.getInt("quantity");
			int orders_id=rst.getInt("orders_id");
			int product_id = rst.getInt("product_id");
			
			OrderDetail od=new OrderDetail();
			od.setId(id);
			od.setQuantity(quantity);
			od.setOrders_id(orders_id);
			od.setProduct_id(product_id);
			list.add(od);
		}
		DBUtil.dbClose();
		return list;
	}

	@Override
	public void updateOrder(int id,int quantity, int orders_id, int product_id) throws SQLException {
		Connection conn=DBUtil.getDBConn();
		
		String sql="update order_details set quantity = ?,orders_id =?,product_id=? where id =?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		
		pstmt.setInt(1,quantity);
		pstmt.setInt(2,orders_id);
		pstmt.setInt(3,product_id);
		pstmt.setInt(4, id);
		pstmt.executeUpdate();
		DBUtil.dbClose();
		
	}

}
